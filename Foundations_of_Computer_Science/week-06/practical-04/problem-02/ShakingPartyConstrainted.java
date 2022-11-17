import java.util.*;
public class ShakingPartyConstrainted extends ShakingParty{
    // number of couples in the party
    private int nCouples;

    // randomly generate the number of people in the party
    public ShakingPartyConstrainted(){
        Random random = new Random();
        this.nCouples = random.nextInt(100);
    }

    // add nTmp to the number of people in the party
    public ShakingPartyConstrainted(int nTmp){
        this.nCouples += nTmp;
    }

    // accessor
    public int getNCouples(){
        return this.nCouples;
    }

    // mutator
    public void setNCouples(int nCouples){
        this.nCouples = nCouples;
    }

    // count the number of handshakes
    int handShakesadded;
    public int countHandShakes(){
        if(this.nCouples <= 1)
            return 0;
        else
            this.nCouples --;
            handShakesadded = this.nCouples*3;
            return handShakesadded + countHandShakes();
    }
}