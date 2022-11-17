/*==================================
Foundations of Computer Science
Student: Zikang, Wu
id: a1816094
Semester: tr3
Year: 2020
Practical Exam Number: 
===================================*/

public class Player extends Person{

    // attributes
    private int id; // represents the identifier of the player
    private int numWins; // represents how many times the player has winned
    private int numPlayed; // represents how many times the player has played
    private static int totalPlayers; // static variable to represent the total number of players
    private Player next; // this is a pointer to the next player in the club

    // parametric constructor
    public Player(String name, int age, int numWins, int numPlayed){
        super(name, age); // call the father class's constructor
        this.numWins = numWins;
        this.numPlayed = numPlayed;
        this.totalPlayers++; // add the value of total players
        this.id = this.totalPlayers; // id is the value of total players
    }

    // accessors
    public int getNumWins(){
        return this.numWins; // get how many games winned
    }
    public int getNumPlayed(){
        return this.numPlayed; // get how many games played
    }
    public int getId(){
        return this.id; // get the id of the player
    }
    public Player getNext(){
        return this.next; // get the next player in the club
    }

    // mutators
    public void setId(int id){
        this.id = id; //set the id of player
    }
    public void setNumWins(int numWins){
        this.numWins = numWins; // set the number wins
    }
    public void setNumPlayer(int numPlayed){
        this.numPlayed = numPlayed; // set the number played
    }
    public void setNext(Player next){
        this.next = next; // set the next player
    }

    // win method
    public void win(){
        this.numWins++; // win one more time
        this.numPlayed++; // play one more time
    }
    // lose method
    public void lose(){
        this.numPlayed++; // play one more time without winning
    }

    // calculating the player's ranking score
    public int getRanking(){
        // if the player played none, return 0 
        if(numPlayed == 0)
            return 0;
        // else
        int ranking = numPlayed*(numWins/numPlayed);
        return ranking;
    }

    // return the string value of the content
    public String toString(){
        // get name and age from father classes and concatenate with id and ranking
        String content = "Person: "+getName()+" is age: "+getAge()+" Id: "+id+" Ranking: "+getRanking(); 
        return content;
    }
}