package lockedmepkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class LMmainClass {
         
	//Giving the folderpath for input files
	static final String folderpath = "F:\\Phase1project\\FilesLockedMe";
	public static void main(String[] args) 
	{   
		try {
		int proceed=1;
		do
		{	
		
	    // variables 
		Scanner sc = new Scanner(System.in);
		int chr =1 ;
		
		DisplayMenu();
        System.out.println("Enter your choice :");
        chr = Integer.parseInt(sc.nextLine());
        
        switch(chr)
        {
        case 1: getFiles();
                break;
        case 2: addFiles();
                break;
        case 3: deleteFiles();
                break;        
        case 4: searchFile();
                break;
        case 5: System.out.println("Exited from the Menu");
                System.exit(0);  
                break;
        default:System.out.println("Invalid Option");   
                break;
                
        }
		}while(proceed>0);
		
		}
		catch (Exception ex)
		{  
			System.out.println("Please check the option numbers above");
			 
		} 
	 }
	
	public static void DisplayMenu()
	{
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("\t\tLockedMe.com");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("1.Display all the files");
	    System.out.println("2.Add a file");
	    System.out.println("3.Delete a file");
	    System.out.println("4.Search a file");
	    System.out.println("5.Exit");
	    System.out.println("_____________________________________________");
	  
		
	}
	/**
	 * This method returns all the file names from the folder 
	 */
	public static void getFiles()
	{
		//getting file names
	List<String>FileNames = FileManagerLM.getFiles(folderpath);
	
	if(FileNames.size()==0)
		System.out.println("The directory does not have files");
	else
		System.out.println("File List:");
	for(String k :FileNames)
		
		System.out.println(k); 
	}
	
	/**
	 *  To add user specified file
	 */
	public static void addFiles() 
	{
	 	//Variable Declaration
		String FileName;
		int linesCount;
		List<String>content = new ArrayList<String>();
	Scanner sc = new Scanner(System.in);
	
	//Reading file-names from user
    System.out.println("Enter the file name:");
    FileName = sc.nextLine();
    
    //Read no. of lines in a file from user
    System.out.println("Enter number of lines in the file");
    linesCount = Integer.parseInt(sc.nextLine());
    
    //Reading the lines
    for(int i=1;i<=linesCount;i++)
    	{System.out.println("Enter line " +i+ ":" );
    content.add(sc.nextLine());
    	}
    //saving the content into the file
    boolean isSaved = FileManagerLM.addFiles(folderpath, FileName, content);
    
    if(isSaved)
    	System.out.println("File & content saved");
    else
    	System.out.println("Error: file not saved. Please contact admin@lockedme.com");
    
     
	} 
  

  
	/**
	 *  To delete user specified file
	 */
	public static void deleteFiles() 
	{
	String FileName;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the  file to be deleted:");
	FileName = sc.nextLine();
	
	//obtaining the file to be deleted & checking its validity using boolean
	boolean isDeleted = FileManagerLM.deleteFile(folderpath, FileName);
	

			if(isDeleted)
		System.out.println("File deleted");
			else
		System.out.println("File Not Found or access error occured");
			
	}
	
	/** To search a user specified file
	 *
	 */	
	public static void searchFile()
	{
		
	    String fileName;
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the file to be searched:");
		fileName = sc1.nextLine();
		
		//obtaining the file to be searched & checking its validity using boolean
		boolean isFound = FileManagerLM.searchFile(folderpath, fileName);
		

				if(isFound)
			System.out.println("File exists in the folder");
				else
			System.out.println("No such File found in the folder");	 
	

	}

}
