package pa04;

import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * a Game is a set of rooms
 * containing items with players
 * that move through the rooms
 * picking up and dropping items.
 * To create a Game you should subclass
 * this class and define the createWorld
 * method
 * @author tim
 *
 */
public class Game {
	public Door[] exits;
	public String name;
	public String description;
	protected Player player1;
	protected Room[] rooms;
	protected ItemBox items;
	private Scanner scanner;

	public Game(String name, String description) {
		this.name=name;
		this.description = description;
		createWorld();
	}
	/**
	 * this should create a collection of rooms 
	 * connected by doors and containing items.
	 * Any rooms or items that are created should
	 * be stored in the rooms and items arrays
	 * respectively
	 * This method should be overridden by subclasses
	 */
	protected void createWorld(){
	}
	
	/**
	 * override this to specify when
	 * the game is over
	 * @param p
	 * @return true if the game is over
	 */
	protected boolean gameOver(Player p){
		return false;
	}
	
	
	/**
	 * describe all of the rooms in the game
	 * including the items they contain
	 * @return description of the rooms and items
	 * in the game
	 */
	public String describeGame(){
		String s="The rooms in the game are: ";
		for(int i=0; i<rooms.length; i++){
			s+= rooms[i].describeSelf() + "\n======\n";			
		}
		String t="The items in the game are: ";
		for(int i=0; i<rooms.length; i++){
			t+= items.getItem(i).name + "\n";			
		}
		return s+"\n"+t+"\n==========\n";
	}
	
	
	public void play(){
		this.scanner = new Scanner(System.in);
		while(!gameOver(this.player1)){
			takeTurn(this.player1);
		}

		System.out.println("Congratulations! You won!");

	}
	
	/**
	 * describe the players location,
	 * prompt them for a command
	 * read and process the command
	 * @param p
	 */
	protected void takeTurn(Player p){
		Room currentRoom = p.location;
		//JOptionPane.showMessageDialog(null,"You are " + p.describeSelf());
		System.out.println("You are "+p.describeSelf());
		System.out.println(currentRoom.describeSelf());
       // JOptionPane.showMessageDialog(null, "Please take a turn "+p.name);
		System.out.println("Please take a turn "+p.name);
		System.out.println("command>> ");
		//String command = JOptionPane.showInputDialog(readCommand());
		
		
	
		
				
	    
		String command = readCommand();
		processCommand(p,command);
	}
	

	protected String readCommand(){
		String cmd = scanner.next();
		return cmd;
	}
	
	protected int readArgument(){
		int arg = scanner.nextInt();
		return arg;
	}
	
	/**
	 * processes the command and returns true
	 * if it was able to process the command.
	 * @param cmd the command to process
	 * @return true if the command was recognized and processed
	 * 
	 */
	protected boolean processCommand(Player p, String cmd){
		if (cmd.equals("quit")) {			System.exit(0);
		}else if (cmd.equals("moveto")){
			int k = readArgument();
			if (k > p.location.exits.length || k < 0) {
				System.out.println("ERROR: The door is out of range. The range is from 0 to " + (p.location.exits.length - 1));
			} else {
			Door theDoor = p.location.exits[k];
			theDoor.admit(p);
			}
		}else if (cmd.equals("pickup")){
			int k = readArgument();
			if (p.location.items.size() == 0){
				System.out.println("ERROR: There are no items remaining in this room");
			} else if (k > p.location.items.size() || k < 0) {
				System.out.println("ERROR: The item is out of range. The range is from 0 to " + (p.location.items.size() - 1));
			} else {
			Item x = p.location.items.getItem(k);
			p.pickup(x);
			}
		}else if (cmd.equals("drop")){
			int k = readArgument();
			Item x = p.backpack.getItem(k);
			p.drop(x);
		}else if (cmd.equals("help")){
			printHelp();
		}else {
			return false;
		}
		return true;
	}
	
	private void actionPerformed(ActionEvent e, String text, Player y) {
		// TODO Auto-generated method stub
		
	}
	public void printHelp(){
		System.out.println(
				"HELP MENU: moveto K, pickup K, drop K, help, quit");
	}


}

