//Madeline Marx
//http://mc5142010s2.googlecode.com/svn/Memory/osp/Memory/MMU.java

package osp.Memory;

import osp.Hardware.CPU;
import osp.IFLModules.*;
import osp.Interrupts.InterruptVector;
import osp.Threads.*;

import osp.Utilities.*;


public class MMU extends IflMMU
{
    public static void init()
    {
    	for(int i = 0; i < MMU.getFrameTableSize(); i++)
    	{
        	setFrame(i, new FrameTableEntry(i));
        }
    }

    static public PageTableEntry do_refer(int memoryAddress,
					  int referenceType, ThreadCB thread)
    {
        int pageNumber = memoryAddress / (int)Math.pow(2.0, getVirtualAddressBits() - getPageAddressBits());
		
		PageTableEntry tempPageTableEntry = getPTBR().pages[pageNumber];
		
		if(tempPageTableEntry.isValid())
		{
			tempPageTableEntry.getFrame().setReferenced(true);
			if(referenceType == GlobalVariables.MemoryWrite)
			{
				tempPageTableEntry.getFrame().setDirty(true);
			}
			return tempPageTableEntry;
		}
		else
		{
			if(tempPageTableEntry.getValidatingThread() == null)
			{
				tempPageTableEntry.pageFaulted = true;
				InterruptVector.setInterruptType(referenceType);
				InterruptVector.setPage(tempPageTableEntry);
				InterruptVector.setThread(thread);
				CPU.interrupt(PageFault);
				if(thread.getStatus() == GlobalVariables.ThreadKill)
				{
					return tempPageTableEntry;
				}
			}
			else
			{
				thread.suspend(tempPageTableEntry);
				if(thread.getStatus() == GlobalVariables.ThreadKill)
				{
					return tempPageTableEntry;
				}
			}
		}
		tempPageTableEntry.getFrame().setReferenced(true);
		if(referenceType == GlobalVariables.MemoryWrite)
		{
			tempPageTableEntry.getFrame().setDirty(true);
		}
		return tempPageTableEntry;
    }

    public static void atError()
    {

    }
    public static void atWarning()
    {

    }

}
