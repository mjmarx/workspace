import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
	
	static String name;
	static ArrayList<String> visited;
	
	
	public static void main(String[] args) throws Exception{
		String[][]matrix = readIn();
		String[] ans = new String[100];
		visited.add("A");
		
		
		
		//matrix
		int lowestPath=0;
		int lowX, lowY;
		
		//visit all nodes that this node points to
		
		//find lowest tree edge length(save lowest path and x and y) from columns that match columns in visited
		//add that column to visited and to ans
		
		
		readOut(ans);
		
	}
	
	public static String[][] readIn() throws FileNotFoundException{
		JFileChooser fileopen = new JFileChooser();
		//http://stackoverflow.com/questions/13517770/jfilechooser-filters
	    FileFilter filter = new FileNameExtensionFilter("Text Files", "txt");
	    fileopen.setFileFilter(filter);
	    //http://stackoverflow.com/questions/21534515/jfilechooser-open-in-current-directory
	    File workingDirectory = new File(System.getProperty("user.dir"));
	    fileopen.setCurrentDirectory(workingDirectory);

	    int ret = fileopen.showDialog(null, "Open file");

	    if (ret == JFileChooser.APPROVE_OPTION) {
	      File file = fileopen.getSelectedFile();
	      name = file.getName().substring(0, file.getName().length()-4);
	      //http://www.dreamincode.net/forums/topic/297048-reading-a-file-using-a-jfilechooser-and-printing-the-contents-into-2d/
	      Scanner scan = new Scanner (new FileReader(file));
	      //String contents = "";
	      String[][] contents = new String[27][27];
	      int i=0;
	      while (scan.hasNextLine()) {
	          String line = scan.nextLine();
	          contents[i] = line.split("\\s+");
	          i++;
	      }
	      String m[][] = new String[i][i];
	      for(int j=0; j<i;j++){
	    	  for(int k=0; k<i;k++){
	    		  m[j][k]=contents[j][k];
	    	  }
	      }
	      scan.close();
	      return m;
	    }
		return null;
	    
	}
	
	public static void readOut(String[] m) throws Exception {
    
      //http://stackoverflow.com/questions/1053467/how-do-i-save-a-string-to-a-text-file-using-java
      FileWriter outFile = new FileWriter(name+"_out.txt");
      PrintWriter out = new PrintWriter(outFile,true);
      for(int i=0;i<m.length; i++){
    	  out.println(m);
      out.close();
      outFile.close();
      
    }
  }
}


