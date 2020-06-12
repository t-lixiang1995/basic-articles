package ai.pcitc.thread;

public class PossibleRecordering {

    private void sequence(){
        int x = 10;    //语句1
        int y = 2;    //语句2
        x = x + 3;    //语句3
        y = x*x;     //语句4

        System.out.println("x:" + x + ",y:" + y);
    }

    static int a = 0, b = 0;
    static int x = 0, y = 0;
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (i <10) {
            Thread one =  new Thread(() -> {
                a = 1;  //语句1
                x = b;  //语句2
            }, "One");


            Thread two =  new Thread(() -> {
                b = 1; //语句3
                y = a; //语句4
            }, "Two");

            one.start();
            two.start();
            one.join();
            two.join();
            System.out.println("x:" + x + ",y:" + y);

            i++;
        }
    }
}
