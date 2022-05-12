package tools;

import java.util.ArrayList;

public class wordTools {
	static public String[] pullWords(String source, String space)
	{	
		ArrayList<String> arr = new ArrayList<String>();
		
		if(source.length() > 0)
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
