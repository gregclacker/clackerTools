# clackerTools
miscellaneous things I (owner) find somewhat useful. Windows forever!! :bright-flash1: :sunglasses: :bright-flash2: 

----

import java.io.IOException;
import java.util.*;
enum exitStatius{
	debug_Marker1,
	debug_Marker2,
	conflictingIssue,
}

enum option{//not used :(
	exitApp,
	exploreTools,
}

//cmd controls -> https://stackoverflow.com/questions/4688123/how-to-open-the-command-prompt-and-insert-commands-using-java#:~:text=Runtime%20rt%20%3D%20Runtime.getRuntime%20%28%29%3B%20rt.exec%20%28%22cmd.exe%20%2Fc,your%20command%20string%20or%20array%20a%20little%20cleaner.?msclkid=7251bb2ad09a11ec8a9ca6e6e69f3ab5
public class Stuff {
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args)
	{
		//open cmd
		try {
	        Runtime.getRuntime().exec("cmd.exe /c start");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
		
		while(true)
			string_separateByString(0);
	}
	
	static void string_separateByString(int layer)
	{
		String form_prep = "", form_spacer = "\t|\t";
		for(int i = 0; i < layer; i++)
			form_prep += "\t";
		System.out.println(form_prep + "english_countSentenceLength()");
		form_prep += "\t";
		
		System.out.print(form_prep + "word separator (no quotes):\t");
		String separator_word = in.nextLine();
		
		System.out.print(form_prep + "sentence separator (no quotes):\t");
		String separator_sentence = in.nextLine();
		
		System.out.print(form_prep + "first word tracker (int):\t");
		int firstWordN = Integer.parseInt(in.nextLine());
		
		System.out.print(form_prep + "fancyPrint (true/false):\t");
		boolean fancyPrint = Boolean.parseBoolean(in.nextLine());
		
		System.out.print(form_prep + "source text:\t");
		String[] words = Tools.pullWords(in, separator_word);
		
		System.out.println();
		//System.exit(exitStatius.debug_Marker1.ordinal());
		
		int sentence_i = 0;
		
		form_prep += "\t";
		System.out.println(form_prep + "Sentence#" + form_spacer + "Word Count" + form_spacer + "First " + firstWordN + " words");
		
		//for(String v : words)
		//	System.out.println("\"" + v + "\"");
		//System.exit(exitStatius.debug_Marker1.ordinal());
		
		String enders = fancyPrint?"\"":"";
		for(int i = 0; i < words.length;)
		{
			sentence_i += 1;
			int ni = i;
			String ret = "";
			boolean brokenEnd = true;
			
			for(; ni < words.length; ni++)
			{
				brokenEnd = words[ni].endsWith(separator_sentence);
				
				if(ni - i < firstWordN){
					ret += enders+ words[ni] +enders;
					if(ni - i + 1 < firstWordN && !brokenEnd) ret += ", "; else ret += " ...";
				}
				
				if(brokenEnd) break;	
			}
			
			if(brokenEnd)
				ret += " " + enders+ words[ni] +enders;
			
			System.out.println(form_prep + sentence_i + form_spacer + (ni - i) + form_spacer + ret);
			i = ni + 1;
		}
	}
}
class Tools{
	static public String[] pullWords(Scanner scanner, String space)
	{
		String source = "";
		
		while(scanner.hasNextLine())
		{
			source += scanner.nextLine();
			scanner.
		}
		
		ArrayList<String> arr = new ArrayList<String>() {};
		
		if(source != null && source.length() > 0)
		for(int i = 0; i < source.length();)
		{
			int ni = source.indexOf(space, i);
			if(ni == -1) ni = source.length();
			String a = ni != i ? source.substring(i, ni) : "";
			if(a.contains(space))
			{
				a.replaceAll(space, "");
				if(a.length() > 1)
					arr.add(a);
			}
			else arr.add(a);
			
			i = ni + 1;
		}
		
		return arr.toArray(new String[0]);
	}
}

