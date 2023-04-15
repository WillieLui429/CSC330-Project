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
		String ptype;
		System.out.println("Pokedex: First Generation");
		do
		{
			System.out.println("What would you like to do?");
			System.out.println("1) Find a Pokemon by name.");
			System.out.println("2) Look up some Pokemon by type");
			System.out.println("3) Look up a Pokemon by number");
			System.out.println("4) See the weakness of your Pokemon");
			System.out.println("5) Quit");
			choice = myObj.next().charAt(0);
			if(choice =='1')
			{
				System.out.println("What is the Pokemon you want to look up?");
				pname = keyboard.nextLine();
				NameLookup(PokeName,pname,Type1,Type2,Poknum);
			}
			else if(choice =='2')
			{
				System.out.println("What Pokemon type do you want to look up?");
				ptype = keyboard.nextLine();
				TypeLookup(ptype,Type2,PokeName, Type1, Poknum);
			}
			else if(choice =='3')
			{
				System.out.println("What is the Pokemon you want to look up by number?");
				poknum = keyboard.nextInt();
				NumLookup(poknum,PokeName,Type1,Type2,Poknum);
			}
			else if(choice =='4')
			{
				System.out.println("What is the Pokemon you want to look up?");
				pname = keyboard.nextLine();
				WeaknessLookup(pname,PokeName,Type1,Type2,Poknum);
				
			}
			else if(choice== '5')
			{
				System.out.println("Thank you for using the Pokedex");
				System.out.println("Goodbye");
			}
			
		}while(choice!='5');
		inputFile.close();

		
	}
	public static void NameLookup(ArrayList<String> Name,String Pokname,ArrayList<String> Type1,ArrayList<String> Type2,ArrayList<Integer> Poknum )
	{
		int tof =Name.indexOf(Pokname);
		if(tof!=-1)
		{
			if(!(Type2.get(tof).contains("None")))
			{
				System.out.println("Number: " + Poknum.get(tof));
				System.out.println("Pokemon: " + Name.get(tof));
				System.out.println("Type: " + Type1.get(tof) +" and "+Type2.get(tof));
				
			}
			else if((Type2.get(tof).contains("None")))
			{
				System.out.println("Number: " + Poknum);
				System.out.println("Pokemon: " + Name.get(tof));
				System.out.println("Type: " + Type1.get(tof));
			}
		}
		else if(tof==-1)
		{
			System.out.println("There is no such instance of "+ Pokname + " to be found");
		}
	}
	public static void NumLookup(int num, ArrayList<String> PokeName,ArrayList<String> Type1, ArrayList<String> Type2,ArrayList<Integer> Poknum)
	{
		num--;
		
		if(!(Type2.get(num).contains("None")))
		{
			System.out.println("Number: " + Poknum.get(num));
			System.out.println("Pokemon: " + PokeName.get(num));
			System.out.println("Type: " + Type1.get(num) +" and "+Type2.get(num));
		}
		else if(Type2.get(num).contains("None"))
		{
			System.out.println("Number: " + Poknum.get(num));
			System.out.println("Pokemon: " + PokeName.get(num));
			System.out.println("Type: " + Type1.get(num));
		}
		else if(!(Poknum.contains(num)))
		{
			System.out.println("The Pokedex has no data on this.");
		}
	}
	public static void TypeLookup(String typ, ArrayList<String> PokeName,ArrayList<String> Type1, ArrayList<String> Type2,ArrayList<Integer> Poknum)
	{
		int total = 0;
		for(int i=0;i<PokeName.size();i++)
		{
			if(Type2.get(i).contains(typ))
			{
				total++;
			}
			else if(PokeName.get(i).contains(typ))
			{
				total++;
			}
		}
		System.out.println("There are a total of " + total +" Pokemon that are "+typ+" type" );
	}
	public static void WeaknessLookup(String name, ArrayList<String> PokeName, ArrayList<String> Type1, ArrayList<String> Type2,ArrayList<Integer> Poknum)
	{
		NameLookup(PokeName, name,Type1,Type2,Poknum);
		String Weak1 = null, Weak2 = null;
		int tof=PokeName.indexOf(name);
		if(tof==-1)
		{
			System.out.println("The Pokemon that you just entered does not exist");
		}
		else if(!(tof==-1))
		{
			if(Type1.get(tof).contains("Normal"))
			{
				Weak1="Fighting";
			}
			else if(Type1.get(tof).contains("Fire"))
			{
				Weak1="Water, Ground, Rock";
			}
			else if(Type1.get(tof).contains("Water"))
			{
				Weak1="Grass, Electric";
			}
			else if(Type1.get(tof).contains("Grass"))
			{
				Weak1="Fire, Ice, Poison, Flying, Bug";
			}
			else if(Type1.get(tof).contains("Electric"))
			{
				Weak1="Ground";
			}
			else if(Type1.get(tof).contains("Ice"))
			{
				Weak1="Fire, Fighting, Rock, Steel";
			}
			else if(Type1.get(tof).contains("Fighting"))
			{
				Weak1="Flying, Psychic, Fairy";
			}
			else if(Type1.get(tof).contains("Poison"))
			{
				Weak1="Ground, Psychic";
			}
			else if(Type1.get(tof).contains("Ground"))
			{
				Weak1="Water, Grass, Ice";
			}
			else if(Type1.get(tof).contains("Flying"))
			{
				Weak1="Electric, Ice, Rock";
			}
			else if(Type1.get(tof).contains("Psychic"))
			{
				Weak1="Bug, Ghost, Dark";
			}
			else if(Type1.get(tof).contains("Bug"))
			{
				Weak1="Flying, Rock, Fire";
			}
			else if(Type1.get(tof).contains("Rock"))
			{
				Weak1="Water, Grass, Fighting, Ground, Steel";
			}
			else if(Type1.get(tof).contains("Ghost"))
			{
				Weak1="Ghost, Dark";
			}
			else if(Type1.get(tof).contains("Dragon"))
			{
				Weak1="Ice, Dragon, Fairy";
			}
			else if(Type1.get(tof).contains("Dark"))
			{
				Weak1="Fighting, Bug, Fairy";
			}
			else if(Type1.get(tof).contains("Steel"))
			{
				Weak1="Fire, Fighting, Ground";
			}
			else if(Type1.get(tof).contains("Fairy"))
			{
				Weak1="Poison, Steel";
			}
			if(Type2.get(tof).contains("Normal"))
			{
				Weak2="Fighting";
			}
			else if(Type2.get(tof).contains("Fire"))
			{
				Weak2="Water, Ground, Rock";
			}
			else if(Type2.get(tof).contains("Water"))
			{
				Weak2="Grass, Electric";
			}
			else if(Type2.get(tof).contains("Grass"))
			{
				Weak2="Fire, Ice, Poison, Flying, Bug";
			}
			else if(Type2.get(tof).contains("Electric"))
			{
				Weak2="Ground";
			}
			else if(Type2.get(tof).contains("Electric"))
			{
				Weak2="Ground";
			}
			else if(Type2.get(tof).contains("Ice"))
			{
				Weak2="Fire, Fighting, Rock, Steel";
			}
			else if(Type2.get(tof).contains("Fighting"))
			{
				Weak2="Flying, Psychic, Fairy";
			}
			else if(Type2.get(tof).contains("Poison"))
			{
				Weak2="Ground, Psychic";
			}
			else if(Type2.get(tof).contains("Ground"))
			{
				Weak2="Water, Grass, Ice";
			}
			else if(Type2.get(tof).contains("Flying"))
			{
				Weak2="Electric, Ice, Rock";
			}
			else if(Type2.get(tof).contains("Psychic"))
			{
				Weak2="Bug, Ghost, Dark";
			}
			else if(Type2.get(tof).contains("Bug"))
			{
				Weak2="Flying, Rock, Fire";
			}
			else if(Type2.get(tof).contains("Rock"))
			{
				Weak2="Water, Grass, Fighting, Ground, Steel";
			}
			else if(Type2.get(tof).contains("Ghost"))
			{
				Weak2="Ghost, Dark";
			}
			else if(Type2.get(tof).contains("Dragon"))
			{
				Weak2="Ice, Dragon, Fairy";
			}
			else if(Type2.get(tof).contains("Dark"))
			{
				Weak2="Fighting, Bug, Fairy";
			}
			else if(Type2.get(tof).contains("Steel"))
			{
				Weak2="Fire, Fighting, Ground";
			}
			else if(Type2.get(tof).contains("Fairy"))
			{
				Weak2="Poison, Steel";
			}
			else if(Type2.get(tof).contains("None"))
			{
				Weak2=" ";
			}
			Weakprint(Weak1,Weak2);

		}
	}
	public static void Weakprint(String Weak1,String Weak2)
	{
		System.out.println("The weakness of this Pokemon is/are " +Weak1+" "+Weak2);
	}
}
