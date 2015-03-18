//Madeline Marx
//http://mc5142010s2.googlecode.com/svn/Threads/osp/Threads/TimerInterruptHandler.java

package osp.Threads;

import osp.IFLModules.*;

public class TimerInterruptHandler extends IflTimerInterruptHandler
{

    public void do_handleInterrupt()
    {
    	 ThreadCB.dispatch();
    }

}