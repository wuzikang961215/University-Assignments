/*==================================
Foundations of Computer Science
Student: Zikang, Wu
id: a1816094
Semester: tr3
Year: 2020
Practical Exam Number: 
===================================*/

public class Club{
    
    // attributes
    private Player head; // represents the first player in the club

    // constructor
    public Club(){
        this.head = null;
    }

    // accessor
    public Player getHead(){
        return this.head; // return the first player
    }
    // mutator
    public void setHead(Player head){
        this.head = head; // set the first player
    }

    // add a member to the club
    public void addMember(Player player){
        // if there is no member in the club
        if(head == null){
            head = player;
            return;
        }
        // if there are already members
        Player currentPlayer = head;
        while(currentPlayer.getNext() != null){
            currentPlayer = currentPlayer.getNext(); // traversing the club
        }
        // add the player to the last position
        currentPlayer.setNext(player);
    }
    // remove a member by ID
    public boolean removeMemberById(int id){
        // if the club is empty
        if(head == null)
            return false;
        // if the head has the id
        if(head.getId() == id){
            head = head.getNext(); // remove head
            return true; // remove successfully
        }
        // if the head does not have the id
        Player previousPlayer = head;
        Player currentPlayer = head.getNext();
        boolean removeOrNot = false;
        while(currentPlayer != null){
            if(currentPlayer.getId() == id){
                previousPlayer.setNext(currentPlayer.getNext()); //remove currentplayer
                removeOrNot = true; // remove successfully
                break;
            }
            previousPlayer = previousPlayer.getNext();
            currentPlayer = currentPlayer.getNext();
        }
        return removeOrNot; // if not removed, this will be false
    }

    // print the members
    public void printMembers(){
        if(head == null)
            return;
        // if the club is not empty
        if(head != null){
            Player currentPlayer = head;
            // traversing
            while(currentPlayer != null){
                System.out.println(currentPlayer.toString()); // print the information
                currentPlayer = currentPlayer.getNext();
            }
        }
    }

    // count the number of junior and senior members
    public void countMembers(){
        int senior = 0;
        int junior = 0;
        // if the club is not empty
        if(head != null){
            Player currentPlayer = head;
            // traversing
            while(currentPlayer != null){
                if(currentPlayer.getAge() < 21)
                    junior++; // add the value of senior
                else if(currentPlayer.getAge() >= 21)
                    senior++; // add the value of junior
                currentPlayer = currentPlayer.getNext();
            }          
        }
        System.out.println("The club has "+junior+" junior and "+senior+" senior members");
    }

    // get the player of the highest rank
    public Player getHighestRankedPlayer(){
        // if the club is empty
        if(head == null)
            return null;
        // if not empty
        Player highestRankedPlayer = head; // for saving the highest rank
        Player currentPlayer = head.getNext();
        // traversing
        while(currentPlayer != null){
            if(currentPlayer.getRanking() > highestRankedPlayer.getRanking()) // if the rank is larger
                highestRankedPlayer = currentPlayer;
            else if(currentPlayer.getRanking() == highestRankedPlayer.getRanking()){ // if the rank equals
                // compare the ages
                if(currentPlayer.getAge() < highestRankedPlayer.getAge())
                    highestRankedPlayer = currentPlayer;
            }
            currentPlayer = currentPlayer.getNext();
        }
        return highestRankedPlayer;
    }

    // get the player among junior that has the highest ranking
    public Player getHighestRankedJunior(){
        // if the club is empty
        if(head == null)
            return null;
        // if not empty
        int numJunior = 0;
        Player current = head;
        Player highestRankedPlayer = head;
        while(current != null){
            if(current.getAge() < 21){
                highestRankedPlayer = current; // for saving the highest rank
                numJunior++;
            }
            current = current.getNext();
        }
        if(numJunior == 0) //if there is no junior
            return null;
        Player currentPlayer = head.getNext();
        // traversing
        while(currentPlayer != null){
            if(currentPlayer.getRanking() > highestRankedPlayer.getRanking() && currentPlayer.getAge() < 21) // if the rank is larger
                highestRankedPlayer = currentPlayer;
            else if(currentPlayer.getRanking() == highestRankedPlayer.getRanking() && currentPlayer.getAge() < 21){ // if the rank equals
                // compare the ages
                if(currentPlayer.getAge() < highestRankedPlayer.getAge())
                    highestRankedPlayer = currentPlayer;
            }
            currentPlayer = currentPlayer.getNext();
        }
        return highestRankedPlayer;
    }

}