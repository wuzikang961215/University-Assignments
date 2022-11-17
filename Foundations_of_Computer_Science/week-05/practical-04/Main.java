import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Main{
    public static void main(String[]args){
        while(true){
            Scanner input = new Scanner(System.in);
            try {
                TimeUnit.SECONDS.sleep( 1 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Would you like to take a round of RPS game? a.yes  b.no");
            String playGame = input.next();
            if(playGame.equals("a")){
                Referee referee = new Referee();
                referee.showMoves();
                referee.judging();
            }
            else if(playGame.equals("b")){
                System.out.println("Goodbye.");
                break;
            }
            else{
                System.out.println("Sorry, you have to enter a or b");
            }

        }
    }
}