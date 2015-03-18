//Madeline Marx
//http://mc5142010s2.googlecode.com/svn/Memory/osp/Memory/PageTableEntry.java

package osp.Memory;

import osp.Threads.*;
import osp.Devices.*;
import osp.Utilities.*;
import osp.IFLModules.*;

public class PageTableEntry extends IflPageTableEntry
{
	boolean pageFaulted = false;

		
    public PageTableEntry(PageTable ownerPageTable, int pageNumber)
    {
        super(ownerPageTable, pageNumber);
    }

    public int do_lock(IORB iorb)
    {
    	ThreadCB thread = iorb.getThread();
    	
    	
    	if(!isValid())
	    {
	    	if(getValidatingThread() == null)
	    	{
	    		PageFaultHandler.handlePageFault(thread, GlobalVariables.MemoryLock, this);
	    	}
	    	else
	    	{
	    		if(getValidatingThread() != thread)
	            {
	            	thread.suspend(this);
	            	if(thread.getStatus() == GlobalVariables.ThreadKill)
	                {
	                	return GlobalVariables.FAILURE;
	                }
	            }
	    	}
    	}
        
    	getFrame().incrementLockCount();
    	return GlobalVariables.SUCCESS;
    	
    }


    public void do_unlock()
    {
    	getFrame().decrementLockCount();
    }
}