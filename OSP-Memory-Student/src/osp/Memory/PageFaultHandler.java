//Madeline Marx

//http://mc5142010s2.googlecode.com/svn/Memory/osp/Memory/PageFaultHandler.java

package osp.Memory;

import osp.Threads.*;
import osp.Tasks.*;
import osp.IFLModules.*;
import osp.Utilities.*;

public class PageFaultHandler extends IflPageFaultHandler
{
    public static int do_handlePageFault(ThreadCB thread, 
					 int referenceType,
					 PageTableEntry page)
    {
 	    	
    	TaskCB Task = thread.getTask();
    	if(page.isValid())
    	{
    		return FAILURE;
    	}
    	    	
    	FrameTableEntry newFrame = null;
    	
    	newFrame = GetNewFrame();
    	
    	if(newFrame == null)
    	{
    		return NotEnoughMemory;
    	}
    	
    	Event event = new SystemEvent("PageFaultHappened");
    	thread.suspend(event);
    	
    	
    	page.setValidatingThread(thread);
    	newFrame.setReserved(thread.getTask());
    	if(newFrame.getPage() != null)
    	{
    		PageTableEntry newPage = newFrame.getPage();
    		if(newFrame.isDirty())
    		{
    			SwapOut(thread, newFrame);
    			
    			if(thread.getStatus() == GlobalVariables.ThreadKill)
    			{
    				page.notifyThreads();
    				event.notifyThreads();
    				ThreadCB.dispatch();
    				return FAILURE;
    			}
    			newFrame.setDirty(false);
    		}
    		newFrame.setReferenced(false);
    		newFrame.setPage(null);
    		newPage.setValid(false);
    		newPage.setFrame(null);
    	}
    	
    	page.setFrame(newFrame);
    	SwapIn(thread, page);
    	
    	if(thread.getStatus() == ThreadKill)
    	{
    		if(newFrame.getPage() != null)
    		{
    			if(newFrame.getPage().getTask() == thread.getTask())
    			{
	    			newFrame.setPage(null);
	    		}
    		}
    		page.notifyThreads();
    		page.setValidatingThread(null);
    		page.setFrame(null);
    		event.notifyThreads();
    		ThreadCB.dispatch();
    		return FAILURE;
    	}

    	newFrame.setPage(page);
    	page.setValid(true);
    	    
    	
    	if(newFrame.getReserved() == Task)
    	{
    		newFrame.setUnreserved(Task);    		
    	}
    	

    	page.setValidatingThread(null);
    	page.notifyThreads();
    	event.notifyThreads();
    	ThreadCB.dispatch();
    	return SUCCESS;
    }
    
    private static FrameTableEntry GetNewFrame()
    {
    	FrameTableEntry newFrame = null;
    	for(int i = 0; i < MMU.getFrameTableSize(); i++)
    	{
    		newFrame = MMU.getFrame(i);
    		if((newFrame.getPage() == null) && (!newFrame.isReserved()) && (newFrame.getLockCount() == 0))
    		{
    			return newFrame;
    		}
    	}
    	
    	for(int i = 0; i < MMU.getFrameTableSize(); i++)
    	{
    		newFrame = MMU.getFrame(i);
    		if((!newFrame.isDirty()) && (!newFrame.isReserved()) && (newFrame.getLockCount() == 0))
    		{
    			return newFrame; 
    		}
    	}

    	for(int i = 0; i < MMU.getFrameTableSize(); i++)
    	{
    		newFrame = MMU.getFrame(i);
    		if((!newFrame.isReserved()) && (newFrame.getLockCount() == 0))
    		{
    			return newFrame; 
    		}
    	}
    	return MMU.getFrame(MMU.getFrameTableSize() - 1);
    }
    
    public static void SwapIn(ThreadCB thread, PageTableEntry page)
    {
    	TaskCB newTask = page.getTask();
    	newTask.getSwapFile().read(page.getID(), page, thread);
    }
    
    public static void SwapOut(ThreadCB thread, FrameTableEntry frame)
    {
    	PageTableEntry newPage = frame.getPage();
    	TaskCB newTask = newPage.getTask();
    	newTask.getSwapFile().write(newPage.getID(), newPage, thread);
    }

	public static void init() {

	}
	
	static void StarvationAvoid(ThreadCB thread)
	{
		FrameTableEntry frame = GetNewFrame();
		if(frame == null)
		{
			return;
		}
		else
		{
			if(frame.getPage() != null)
			{
				TaskCB task = frame.getPage().getTask();
				
				task.getSwapFile().write(frame.getPage().getID(), frame.getPage(), thread);
				frame.setDirty(false);
			}
		}
	}
    
    

}