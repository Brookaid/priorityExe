import java.util.concurrent.*;

public class Main {

        private static Thread thread1 = null;
        private static Thread thread2 = null;
        private static Thread thread3 = null;
        private static Semaphore sem = null;


        public static void main(String[] args) {
            memoryShared ms = memoryShared.getInstance();
            sem = new Semaphore(1);

            thread1 = new Thread(new ThreadExe(sem,"/Applications/Firefox.app",  ms, 1), "thread1");
            thread2 = new Thread(new ThreadExe( sem,"/Applications/Google Chrome.app", ms, 3), "thread2");
            thread3 = new Thread(new ThreadExe( sem,"/Applications/Microsoft Excel.app", ms, 2), "thread3");

            thread1.start();
            thread2.start();
            thread3.start();


            try {
                thread1.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                thread2.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                thread3.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.exit(0);

        }
}
