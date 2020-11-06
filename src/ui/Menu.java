package ui;
import java.util.Scanner;



public class Menu {
	private  Scanner lector;
	
	private final static int EXIT_OPTION = 3;
	
	public Menu() {
		lector = new Scanner(System.in);
		
	}
	
	public void startMenu() {
		String menu = showMenu();
		int option;
		do {
			System.out.print(menu);
			option = readOption();
			executeOperation(option);
		}while(option!=EXIT_OPTION);
				
	}
	
	private String showMenu() {
		String menu; 
		menu = "________________________\n";
		menu += "Welcome to the menu\n";
		menu += "________________________\n";
		menu += "1. Play\n";
		menu += "2. Print\n";
		menu += "3. Exit\n";
				
		return menu;		
	
	}
	
	private int readOption() {
		int op;
		op = Integer.parseInt(lector.nextLine());
		return op;
	}

	
	private void executeOperation(int option) {
		switch(option) {
		case 1:
					
		break;
		case 2:
			
		break;
		
		}
		
	}	
		
}
	