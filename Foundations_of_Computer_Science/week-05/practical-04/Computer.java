import java.util.*;

public class Computer extends Player{

    // computer randomly makes choice
    String playerMove(){
        Random random = new Random();
        String [] RPS = {"Rock","Paper","Scissors"};
        String computerChoice = RPS[random.nextInt(3)];
        return computerChoice;
    }
    
    // perfomrMove inherited from Player class to print out computer player's move
    void performMove(String move){
        System.out.println("Computer's choice: "+move);
    }
}