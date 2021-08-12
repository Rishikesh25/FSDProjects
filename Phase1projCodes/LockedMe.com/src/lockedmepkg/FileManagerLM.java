package lockedmepkg;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManagerLM {

	/**
	 * This method returns all the file names from the directory
	 * @param folderpath
	 * @return FileNames
	 */
	public static List<String>getFiles(String folderpath)
	{
		File fl = new File(folderpath);
		
		//Getting the files into array-File
		File[]	fileslist = fl.listFiles();
		
		//Get all the files' names in the list
		List<String> FileNames = new ArrayList<String> ();
	
		for (File F : fileslist)
		FileNames.add(F.getName());
		Collections.sort(FileNames);
		return FileNames;
			
}
	/**
	 * this method will add files 
	 * @param folderpath
	 * @param FileNames
	 * @param content
	 * @return  
	 */
	public static boolean addFiles(String folderpath,String FileNames,List<String>content)
	{
		try
		{
			File fl = new File(folderpath, FileNames);
			FileWriter fw = new FileWriter(fl);
			
			for (String k : content)
			{
				fw.write(k+ "\n");
			}
			fw.close();
			return true;
		}

		catch(Exception Ex)
		{
			return false;
		}
		
		
	}
	
	/**
	 * this method deletes the file provided with path & name
	 * @param folderpath
	 * @param FileName
	 * @return
	 */
	public static boolean deleteFile(String folderpath,String FileName)
	{
		 File fl = new File(folderpath+ "\\" +FileName);
		 try
		 {
			 if(fl.delete())
			 {
				 return true;
			 }
			 
			 else
			 {
				 return false;
			 }
		 }
		 catch(Exception Ex)
		 {
			 return false;
		 }
	
		
	}

	/**
	 * this method searches file in the folder
	 * @param folderpath
	 * @param FileName
	 * @return 
	 */
	
	public static boolean searchFile(String folderpath,String FileName)
	{
		 File fl = new File(folderpath+ "\\" +FileName); 
		 
		 if(fl.exists())
			 return true;
		 else
			 return false;
	}	
}	

