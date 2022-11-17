import java.util.concurrent.TimeUnit;

class Referee{
    
    private String [] choices = {"ROCK","PAPER","SCISSORS"}; // for handling inputs
    private String [] outChoices = {"Rock","Paper","Scissors"}; // for printing moves
    int notfound;

    // handling inputs
    String handleInputs(String choice){
        // transforming input into capital letters
        choice = choice.toUpperCase();
        String playerMove = " ";
        int found = 0;
        notfound = 0; // check the case if there is wrong input
        for(int i = 0; i < choices.length; i++){
            // searching for keywords in choices array
            if((found = choices[i].indexOf(choice,found))!= -1){
                playerMove = outChoices[i];
                break;
            }
            else{
                notfound++;
            }
        }
        if(notfound == 3){
            System.out.println("Sorry, you have to enter Rock, Paper or Scissors");
        }
        return playerMove;
    }

    // polymorphism: instantiate the players
    Player player1 = new Human();
    Player player2 = new Computer();
    String player1Move = handleInputs(player1.playerMove());
    String player2Move = player2.playerMove();

    // polymorphism: instantiate the players
    void showMoves(){
        // print choices only when human input is right
        if(notfound!=3){
            player1.performMove(player1Move);
            player2.performMove(player2Move);
        }
    }

    // judging
    void judging(){
        // wait a minute before annoucing the winnner
        try {
            TimeUnit.SECONDS.sleep( 1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // who wins
        if(player1Move.equals(player2Move)){
            System.out.println("Draw!");
        }
        else if(player1Move.equals(outChoices[0]) && player2Move.equals(outChoices[1])){
            System.out.println("You lose.");
        }
        else if(player1Move.equals(outChoices[1]) && player2Move.equals(outChoices[2])){
            System.out.println("You lose.");
        }
        else if(player1Move.equals(outChoices[2]) && player2Move.equals(outChoices[0])){
            System.out.println("You lose.");
        }
        else if(player1Move.equals(outChoices[1]) && player2Move.equals(outChoices[0])){
            System.out.println("Congratulations! You win!");
        }
        else if(player1Move.equals(outChoices[2]) && player2Move.equals(outChoices[1])){
            System.out.println("Congratulations! You win!");
        }
        else if(player1Move.equals(outChoices[0]) && player2Move.equals(outChoices[2])){
            System.out.println("Congratulations! You win!");
        }
    }

}