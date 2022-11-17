public class Human extends Player{

    // read input from human
    String playerMove(){
        System.out.println("Please enter your choice from Rock, Paper and Scissors: ");
        String move = System.console().readLine();
        return move;
    }
    // perfomrMove inherited from Player class to print out human player's move
    void performMove(String move){
        System.out.println("Your choice: "+move);
    }


}