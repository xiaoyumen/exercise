import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @auther zzyy
 * @create 2019-01-01 21:41
 */
public class CyclicBarrierDemo
{
    public static void main(String[] args)
    {


        CyclicBarrier cyclicBarrier = new CyclicBarrier(7);
        for (int i = 0; i <7 ; i++) {
            final int temp= i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集了第"+temp+"颗");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            },String.valueOf(temp)).start();

        }
    }
}
