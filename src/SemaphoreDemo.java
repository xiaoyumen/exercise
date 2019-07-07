import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @auther zzyy
 * @create 2019-01-02 22:11
 */
public class SemaphoreDemo
{
    public static void main(String[] args)
    {
       Semaphore semaphore = new Semaphore(3);


        for (int i = 1; i <7 ; i++) {
            final int temp =i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.MICROSECONDS.sleep(300);
                    System.out.println(Thread.currentThread().getName()+"离开了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(temp)).start();
        }
    }

}
