
package FileHandling;

import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

class Mini_Project
{   
	static int temp=1,i=0;
	public void listFiles( ArrayList<String> List_Record,String Directory) throws IOException
	{
		File directory = new File(Directory);
		File[] File_List = directory.listFiles();

		for (File file : File_List)
		{
			String Directory_Name = file.toString();
			
			if(file.isDirectory())
			{
				listFiles(List_Record,Directory_Name);
			}
			
			else
			{
				try {
					String File_Name = (file.getName()).toString();
					String File_Path = file.toString();

					List_Record.add(File_Name);
					i++;
					List_Record.add(File_Path);
					i++;

				}

				finally 
				{
					System.out.println("File  "+temp+"  Add into your CSV File");
					temp++;
				}
			}
		}
	}

	public static void main (String[] args) throws IOException
	{

		File fout = new File("E:\\Record.csv");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fos));

		Mini_Project M = new Mini_Project();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Path");
		String path = sc.nextLine();
		
		ArrayList<String> List_Record=new ArrayList<String>();

		try 
		{
			M.listFiles(List_Record,path);
		}

		catch(IOException e)
		{
			System.out.println("Wrong Input");
		}
		
		finally
		{
			System.out.println("Record Saved in Your CSV File");
			sc.close();
		}

		buffer.write("Filename" +" , " + "Filepath");
		buffer.newLine();
		for(int j = 0 ; j < i ; j = j +2)
		{
			buffer.write(List_Record.get(j) +" , " + List_Record.get(j+1));
			buffer.newLine();
		}
		
		buffer.close();
	}
}

