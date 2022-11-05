package demothreads;

public class SubThread1 extends Thread{
    @Override
    public void run(){
        for(int j = 0 ; j<20;j++){
            System.out.println("Subthread1 j = "+j);
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
}
