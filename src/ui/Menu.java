package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.LinkedMatrix;
import model.Positions;



public class Menu {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private LinkedMatrix matrix;
	private Positions positions = new Positions();
	
	
	
	public void startMenu() throws IOException {
		System.out.println(showMenu());
		int option = 0;
		try {
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			startMenu();
			return;
		}
		switch(option) {
		case 1:
			executeOperation();
		break;
		case 2:
			System.out.println(positions);
			startMenu();
		break;
		case 3:
			System.out.println("The program has been closed");
		break;
		default: startMenu();
		break;
		
		}
		
		
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
	
		
	private void executeOperation() throws IOException {
		System.out.println("Type: nickname row col mirrors");		
		String[] input;
		String nickname = "";
		try {
			input = br.readLine().split(" ");
			nickname = input[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			executeOperation();
			return;
		}
		
		int row = 0;
		int col = 0;
		int mirrors = 0;
		try {
			row = Integer.parseInt(input[1]);
			col = Integer.parseInt(input[2]);
			mirrors = Integer.parseInt(input[3]);
		} catch (NumberFormatException e) {
			executeOperation();
			return;
		}
		matrix = new LinkedMatrix(row, col, mirrors);
		matrix.setNickname(nickname);
		System.out.println(matrix.getNickname()+": "+matrix.getHidden()+" mirrors hidden\n");
		System.out.println(matrix);
		command();
		
	}

	private void command() throws IOException {
		String input = br.readLine();
		if(input.equals("menu")) {
			score();
			startMenu();
		}
		else if(input.charAt(0)=='L') {
			int row = Integer.parseInt(input.substring(1,input.length()-2))-1;
			int col = input.charAt(input.length()-2)-65;
			String h = "";
            if(input.charAt(input.length()-1)=='R') {
                h = "R";
            }else {
                h = "L";
            }
			matrix.locate(row, col, h);
		}
		else {
			int row = Integer.parseInt(input.substring(0,input.length()-1))-1;
			int col = input.charAt(input.length()-1)-65;
			matrix.laser(row, col);
		}
		if(matrix.getHidden()==0) {
			System.out.println("You win\n");
			score();
			startMenu();
			
		}
		else {			
		
		System.out.println(matrix.getNickname()+": "+matrix.getHidden()+" mirrors hidden\n");
		System.out.println(matrix);
		command();
		}
		
		
		
		
	}

	private void score() {
		int score = ((matrix.getMirrors()-matrix.getHidden())*10)+(matrix.getShoots()*-1/2)+(matrix.getFails()*-1);
		if(score<0) {
			score = 0;
		}
		System.out.println("Your score was "+score);
		positions.add(matrix.getNickname(),score,matrix.getRow(),matrix.getCol(),matrix.getMirrors());
		
	}	
		
}
	