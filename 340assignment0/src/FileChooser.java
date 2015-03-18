import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
  public static void main(String[] args) throws Exception {

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
      String name = file.getName().substring(0, file.getName().length()-4);
      //http://www.dreamincode.net/forums/topic/297048-reading-a-file-using-a-jfilechooser-and-printing-the-contents-into-2d/
      Scanner scan = new Scanner (new FileReader(file));
      String contents = "";
      while (scan.hasNextLine()) {
          String line = scan.nextLine();
          contents +=line + "\n";
      }
      
      //http://stackoverflow.com/questions/1053467/how-do-i-save-a-string-to-a-text-file-using-java
      FileWriter outFile = new FileWriter(name+"_out.txt");
      PrintWriter out = new PrintWriter(outFile,true);
      out.println(contents);
      out.close();
      outFile.close();
      scan.close();
      
    }
  }
}


