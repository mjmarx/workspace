//Madeline Marx
//http://mc5142010s2.googlecode.com/svn/Threads/osp/Threads/ThreadCB.java

package osp.Threads;

import java.util.ArrayList;

import osp.Utilities.*;
import osp.IFLModules.*;
import osp.Tasks.*;
import osp.Hardware.*;
import osp.Devices.*;
import osp.Memory.*;
import osp.Resources.*;

public class ThreadCB extends IflThreadCB {
	private static ArrayList<ThreadCB> listThreads;

	public ThreadCB() {
		super();
	}


	public static void init() {
		listThreads = new ArrayList<ThreadCB>();
	}

	public static ThreadCB do_create(TaskCB task) {

		if (task.getThreadCount() >= MaxThreadsPerTask) {
			dispatch();
			return null;
		}

		ThreadCB newThreadCB = new ThreadCB();

		newThreadCB.setPriority(task.getPriority());
		newThreadCB.setStatus(GlobalVariables.ThreadReady);

		newThreadCB.setTask(task);
		if (task.addThread(newThreadCB) != GlobalVariables.SUCCESS) {
			dispatch();
			return null;
		}

		listThreads.add(newThreadCB);

		dispatch();
		return newThreadCB;
	}


	public void do_kill() {
		TaskCB task = getTask();

		if (getStatus() == GlobalVariables.ThreadReady) {
			if (listThreads.remove(this) == false) {
				return;
			}
		}
		if(getStatus() == GlobalVariables.ThreadRunning)
		{
			MMU.getPTBR().getTask().setCurrentThread(null);
		}
		if (task.removeThread(this) != GlobalVariables.SUCCESS) {
			return;
		}
		
		setStatus(GlobalVariables.ThreadKill);

		for (int i = 0; i < Device.getTableSize(); i++) {
			Device.get(i).cancelPendingIO(this);
		}

		ResourceCB.giveupResources(this);
		
		dispatch();

		if (task.getThreadCount() == 0) {
			task.kill();
		}
	}

	void do_suspend(Event event) {
		int currentStatus = this.getStatus();

		if (currentStatus == GlobalVariables.ThreadRunning) 
		{
			setStatus(GlobalVariables.ThreadWaiting);
			this.getTask().setCurrentThread(null);
		}
		else if(currentStatus >= GlobalVariables.ThreadWaiting)
		{
			setStatus(currentStatus + 1);
		}
		listThreads.remove(this);
		event.addThread(this);

		dispatch();
	}


	public void do_resume() {
		int currentStatus = getStatus();
		if (currentStatus == GlobalVariables.ThreadWaiting) {
			setStatus(GlobalVariables.ThreadReady);
			listThreads.add(this);
		} else {
			setStatus(currentStatus - 1);
		}

		dispatch();
	}

	public static int do_dispatch() {
		TaskCB currentTaskCB = null;
		ThreadCB currentThreadCB = null;
		ThreadCB newThreadCB = null;

		try {
			currentTaskCB = MMU.getPTBR().getTask();
			currentThreadCB = currentTaskCB.getCurrentThread();
		} catch (Exception e) {
		}

		if (currentThreadCB != null) {
			currentTaskCB.setCurrentThread(null);
			currentThreadCB.setStatus(ThreadReady);
			MMU.setPTBR(null);
			listThreads.add(currentThreadCB);
		}
		if (listThreads.size() > 0) {
			newThreadCB = listThreads.remove(0);
			MMU.setPTBR(newThreadCB.getTask().getPageTable());
			newThreadCB.getTask().setCurrentThread(newThreadCB);

			newThreadCB.setStatus(ThreadRunning);

			HTimer.set(100);

			return GlobalVariables.SUCCESS;
		}
		MMU.setPTBR(null);
		return GlobalVariables.FAILURE;

	}

	public static void atError() {

	}


	public static void atWarning() {

	}

}