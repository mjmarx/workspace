//Madeline Marx
//http://mc5142010s2.googlecode.com/svn/Memory/osp/Memory/PageTable.java

package osp.Memory;

import java.lang.Math;
import osp.Tasks.*;
import osp.IFLModules.*;

public class PageTable extends IflPageTable
{
    public PageTable(TaskCB ownerTask)
    {
    	super(ownerTask);
    	int numberOfPages = (int)Math.pow(2, MMU.getPageAddressBits());
    	
    	pages = new PageTableEntry[numberOfPages];
    	
    	for(int i = 0; i < numberOfPages; i++)
    	{
    		pages[i] = new PageTableEntry(this, i);
    	}
    }


    public void do_deallocateMemory()
    {
        TaskCB task = getTask();
        
        for(int i = 0; i < MMU.getFrameTableSize(); i++)
        {
        	FrameTableEntry tempFrameTableEntry = MMU.getFrame(i);
        	PageTableEntry tempPageTableEntry = tempFrameTableEntry.getPage();
        	if(tempPageTableEntry != null && tempPageTableEntry.getTask() == task)
        	{
        		tempFrameTableEntry.setPage(null);
        		tempFrameTableEntry.setDirty(false);
        		tempFrameTableEntry.setReferenced(false);
        		if(tempFrameTableEntry.getReserved() == task)
        			tempFrameTableEntry.setUnreserved(task);
        	}
        }
    }



}