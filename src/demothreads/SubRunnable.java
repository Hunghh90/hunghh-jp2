package demothreads;

public class SubRunnable implements Runnable{
    @Override
    public void run() {
        for(int j = 0 ; j<20;j++){
            System.out.println("SubRunnable j = "+j);
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
}
