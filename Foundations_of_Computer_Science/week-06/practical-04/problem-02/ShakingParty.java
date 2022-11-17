import java.util.*;
public class ShakingParty{

    // number of people in the party
    private int nPeople;

    // randomly generate the number of people in the party
    public ShakingParty(){
        Random random = new Random();
        this.nPeople = random.nextInt(100);
    }

    // add nTmp to the number of people in the party
    public ShakingParty(int nTmp){
        this.nPeople += nTmp;
    }

    // accessor
    public int getNPeople(){
        return this.nPeople;
    }

    // mutator
    public void setNpeople(int nPeople){
        this.nPeople = nPeople;
    }

    // count the number of handshakes
    public int countHandShakes(){
        if(this.nPeople <= 2)
            return 1;
        else
            this.nPeople--;
            return this.nPeople + countHandShakes();
    }
}