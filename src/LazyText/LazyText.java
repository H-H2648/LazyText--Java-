/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LazyText;


import java.util.Scanner;

/**
 *
 * @author hhong
 */
public class LazyText {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        SystemClipboard Clipboard = new SystemClipboard();
        Database Data = new Database();
        System.out.println("Welcome!");
        System.out.println("What do you want to do? add or take? [if you type anything other than 'add' or 'take' this program will end]");
        Scanner sc = new Scanner(System.in);
        String action = sc.nextLine();
        while(action.equals("add") || action.equals("take")){
            if(action.equals("add")){
                Scanner content = new Scanner(System.in);
                Scanner key = new Scanner(System.in);
                System.out.println("Enter Your Text (Please limit to 500 characters MAX): ");
                String text = content.nextLine();
                System.out.println("Plase name your text (Please limit to 10 characters MAX)");
                String name = key.nextLine();
                Data.addMessage(name, text);
            }
            if(action.equals("take")){
                Scanner key = new Scanner(System.in);
                System.out.println("What is the name of your message?");
                String name = key.nextLine();
                String text = Data.takeMessage(name);
                Clipboard.copy(text);
                System.out.println("Here is your text (we already copied it in your clipboard): ");
                System.out.println(text);
            }
           System.out.println("What do you want to do? add or take? [if you type anything other than 'add' or 'take' this program will end]");
           action = sc.nextLine();
        }
        
    }
    
}
