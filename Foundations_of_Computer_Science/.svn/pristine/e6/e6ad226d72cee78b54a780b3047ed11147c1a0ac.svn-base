class HanoiTower{

    int disks; // this stores number of disks
    String pole1 = "Pole1"; // this represents pole1
    String pole2 = "Pole2"; // this represents pole2
    String pole3 = "Pole3"; // this represents pole3
    String changePole;

    // initialize 3 disks
    public HanoiTower(){
        this.disks = 3;
    }

    // initialize dTmp disks
    public HanoiTower(int dTmp){
        this.disks = dTmp;
    }

    // printing every step of solution
    public void solve(){
        // if there is only one disk, only need to move it to pole3
        if(disks == 1)
            System.out.println("Move the disk "+disks+" from "+pole1+" to "+pole3);
        else{
            // this is step 1: move disks-1 disks from pole1 to pole2
            disks--;
            // change pole2 and pole3
            changePole = pole3;
            pole3 = pole2;
            pole2 = changePole;
            solve();
            // change back
            changePole = pole3;
            pole3 = pole2;
            pole2 = changePole;
            disks++;
            // this is step 2: move the biggest disk from pole1 to pole3
            System.out.println("Move the disk "+disks+" from "+pole1+" to "+pole3);
            // this is step 3: move disks-1 disks from pole2 to pole3
            disks--;
            // change pole1 and pole2
            changePole = pole2;
            pole2 = pole1;
            pole1 = changePole;
            solve();
            // change back
            changePole = pole2;
            pole2 = pole1;
            pole1 = changePole;
            disks++;
        }
    }
}