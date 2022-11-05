package demothreads;

public class Main {
    public static void main(String[] args){
        SubThread1 st1 = new SubThread1();
        st1.start();
        SubRunnable sr = new SubRunnable();
        Thread t = new Thread(sr);
        t.start();

        for(int j = 0 ; j<20;j++){
            System.out.println("Main j = "+j);
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
}
