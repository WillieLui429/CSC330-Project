import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
@SuppressWarnings("unchecked")
public class Pokedex {
	public static void main(String arg[])  throws IOException
	{
		File myFile = new File("C:\\Users\\willi\\Documents\\CSC330 Project.csv");
		Scanner inputFile = new Scanner(myFile);
		ArrayList<Integer> Poknum = new ArrayList<Integer>();
		ArrayList<String> PokeName = new ArrayList<String>();
		ArrayList<String> Type1 = new ArrayList<String>();
		ArrayList<String> Type2 = new ArrayList<String>();
		Scanner myObj = new Scanner(System.in);
		while(inputFile.hasNext())
		{
			String line = inputFile.nextLine();
            String[] token=line.split(","); 
            Poknum.add(Integer.parseInt(token[0]));
            PokeName.add(token[1]);
            Type1.add(token[2]);
            Type2.add(token[3]);
            
		}
		char choice='a';
		System.out.println("Pokedex: First Generation");
		do
		{
			System.out.println("What would you like to do?");
			System.out.println("1) Find a Pokemon by name.");
			System.out.println("2) Look up some Pokemon by type");
			System.out.println("3) Look up a Pokemon by number");
			System.out.println("4) Quit");
			choice = myObj.next().charAt(0);
			
		}while(choice!='4');
		inputFile.close();

		
	}

}
