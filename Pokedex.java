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
		Scanner keyboard = new Scanner(System.in);
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
		String pname;
		int poknum;
		System.out.println("Pokedex: First Generation");
		do
		{
			System.out.println("What would you like to do?");
			System.out.println("1) Find a Pokemon by name.");
			System.out.println("2) Look up some Pokemon by type");
			System.out.println("3) Look up a Pokemon by number");
			System.out.println("4) Quit");
			choice = myObj.next().charAt(0);
			if(choice =='1')
			{
				System.out.println("What is the Pokemon you want to look up?");
				pname = keyboard.nextLine();
				NameLookup(PokeName,pname,Type1,Type2,Poknum);
			}
			if(choice =='3')
			{
				System.out.println("What is the Pokemon you want to look up by number?");
				poknum = keyboard.nextInt();
				NumLookup(poknum,PokeName,Type1,Type2,Poknum);
			}
			if(choice== '4')
			{
				System.out.println("Thank you for using the Pokedex");
				System.out.println("Goodbye");
			}
			
		}while(choice!='4');
		inputFile.close();

		
	}
	public static void Print(int num, ArrayList<String> Name,ArrayList<String> Type1,ArrayList<String> Type2,ArrayList<Integer> Poknum )
	{
		int num1=num+1;
		int num0 = num -1;
		if(!(Type2.get(num0).contains("None")))
		{
			System.out.println("Number: " + num);
			System.out.println("Pokemon: " + Name.get(num));
			System.out.println("Type: " + Type1.get(num1) +" and "+Type2.get(num));
		}
		else if(Type2.get(num).contains("None"))
		{
			System.out.println("Number: " + num1);
			System.out.println("Pokemon: " + Name.get(num));
			System.out.println("Type: " + Type1.get(num));
		}
		else if(!(Poknum.contains(num)))
		{
			System.out.println("The Pokedex has no data on this.");
		}
	}
	public static void NameLookup(ArrayList<String> Name,String Pokname,ArrayList<String> Type1,ArrayList<String> Type2,ArrayList<Integer> Poknum )
	{
		int tof =Name.indexOf(Pokname);
		if(tof!=-1)
		{
			Print(tof,Name,Type1,Type2,Poknum);
		}
		else if(tof==-1)
		{
			System.out.println("There is no such instance of "+ Pokname + " to be found");
		}
	}
	public static void NumLookup(int num, ArrayList<String> PokeName,ArrayList<String> Type1, ArrayList<String> Type2,ArrayList<Integer> Poknum)
	{
		Print(num,PokeName, Type1, Type2, Poknum);
	}
}
