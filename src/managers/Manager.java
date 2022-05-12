package managers;

import java.util.Scanner;

public class Manager {
	public Scanner scanner;
	public ToolSet toolSet;
	
	public Manager() {
		
	}
	public Manager(Scanner scanner) {
		this.scanner = scanner;
		toolSet = new ToolSet(this.scanner);
	}
	
	public static void main(String[] args)
	{
		Manager M = new Manager(new Scanner(System.in));
		M.toolSet.string_separateByString(0);
	}
	
}
