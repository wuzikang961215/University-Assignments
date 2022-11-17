public abstract class Player{

    // private number as required
    private int privateNumber;

    // basic constructor
    Player(){
        this.privateNumber = 0;
    }

    // accessor
    int getPrivateNumber(){
        return this.privateNumber;
    }

    // mutator
    void setPrivateNumber(int privateNumber){
        this.privateNumber = privateNumber;
    }


    // abstract methods playerMove and performMove 
    abstract String playerMove();
    abstract void performMove(String move);
}