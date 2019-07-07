import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**u
 * @auther zzyy
 * @create 2019-01-01 21:15
 */
public class CountDownLatchDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i <6; i++) {
//            final  int temp =i;
            new Thread(()->{
                countDownLatch.countDown();


                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"离开了教室");

            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"班长离开了教室");


    }


}
