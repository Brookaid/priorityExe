import java.io.IOException;
import java.util.concurrent.*;

public class ThreadExe implements Runnable{

    private Semaphore sem;
    private String exe;
    private memoryShared ms;
    private int prio;

    public ThreadExe (Semaphore sem, String exe, memoryShared ms, int prio){
        this.sem = sem;
        this.exe = exe;
        this.ms = ms;
        this.prio = prio;
    }

    public void run(){
        try {

            boolean bool =false;
            do{
                sem.acquire();

                if(prio == ms.getThread()){

                    bool = true;
                    ms.setThread();
                }
                else{
                    sem.release();
                }
            }
            while(bool==false);

            Runtime.getRuntime().exec(exe);
            sem.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
