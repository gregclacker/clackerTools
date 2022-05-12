package managers;

import java.util.ArrayList;
import java.util.Scanner;

import tools.*;

public class ToolSet {

	public Scanner scanner;
	protected String spacer = "\t";
	
	protected int layer = 0;
	protected String form_preset_spacer = "";
	
	public ToolSet(Scanner scanner) {
		this.scanner = scanner;
	}
	public ToolSet() {};
	
	public void cycle() {
		
	}
	
	public void string_separateByString(int layer) {
		string_separateByString(layer, "\t|\t");
	}
	public void string_separateByString(int layer, String form_spacer) 
	{ 
		String form_prep = form_preset_spacer;
		
		System.out.println(form_prep + "string_separateByString(layer:" + layer + ", form_Spacer:\"" + form_spacer + "\")"); 
		for(int i = -1; i < layer; i++) form_prep += "\t";
	  
		print(form_prep + "word separator (no quotes):\t"); 
	  	String separator_word = scanner.nextLine();
	  
	  	print(form_prep + "sentence separator (no quotes):\t"); 
	  	String separator_sentence = scanner.nextLine();
	  
	  	print(form_prep + "first word tracker (int):\t"); 
	  	int firstWordN = scanner.nextInt();
	  
	  	print(form_prep + "fancyPrint (true/false):\t"); 
	  	String enders = "";
	  	try{
	  		enders = scanner.nextBoolean() ? "\"": "";
	  	}
	  	catch(Exception e){
	  		println(form_prep + "\ttypo, defaulting to False:\t" + e);
	  	}
	  
	  	print(form_prep + "source text:\t"); 
	  	String nextLines = getNextLines();
	  	println(form_prep + "pulled text.\t sorting words...");
	  	String[] words = wordTools.pullWords(nextLines, separator_word);
	  		  
	  	int sentence_i = 0;
	  	form_prep += "\t";
	  	println(form_prep + "Sentence#" + form_spacer +"Word Count" + form_spacer + "First " + firstWordN + " words");
	  	  	
	  	//float startTime = System.currentTimeMillis();
	  	float aveCharLength = 0;
	  	for(int i = 0; i < words.length;) {
	  		sentence_i += 1;
	  		int ni = i;
	  		String ret = "";
	  		boolean brokenEnd = words[ni].endsWith(separator_sentence);
	  
	  		for(; ni < words.length; ni++) { 
	  			brokenEnd = words[ni].endsWith(separator_sentence);
	  			if(ni - i < firstWordN){ 
	  				ret += enders+ words[ni] +enders;
	  				if(ni - i + 1 < firstWordN && !brokenEnd) ret += ", "; else ret += " ..."; 
	  			}
	  			
	  			aveCharLength += words[ni].length();
	  			if(brokenEnd) break; 
	  		}
	  
	  		if(brokenEnd) ret += " " + enders+ words[ni] +enders;
	  
	  		println(form_prep + sentence_i + form_spacer + (ni - i) + form_spacer + ret);
	  		i = ni + 1;
	  	}
	  	println(form_prep + "Average Char. Length:" + (aveCharLength / words.length));
	  	print(form_prep + "done.");
	}
	
	public void setLayer(int layer) {
		this.layer = layer;
		
		form_preset_spacer = "";
		for(int i = 0; i < Math.abs(layer); i++)
			form_preset_spacer += spacer;
	}
	
	public void setSpacer(String spacer){
		this.spacer = spacer;
		setLayer(layer);
	}
	
	public String getFormPresetSpacer(){
		return form_preset_spacer;
	}
	
	public String[] getNextLinesArr(){
		ArrayList<String> tokens = new ArrayList<>();
		tokens.add(scanner.nextLine());
		while(scanner.hasNextLine())
		{
			//System.out.print("line found:" + tokens.size());
			String s = scanner.nextLine();
			if(s.equals("")) break;
			tokens.add(s);
			//System.out.println("\t-\tline add to tokens");
		}
		//System.out.println("finished pulling next lines Arr");
		return tokens.toArray(new String[0]);
	}
	public String getNextLines() {
		String r = "";
		for(String s : getNextLinesArr()) r += s;
		//System.out.println("finished pulling next lines");
		return r;
	}
	
	public void print(String out) {
		System.out.print(out);
	}
	public void println(String out) {
		print(out + "\n");
	}
	
}
