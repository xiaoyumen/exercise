import com.sun.webkit.ThemeClient;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


class MyThread implements Callable<Integer>
{
  private   int ticket=30;
    @Override
    public Integer call() throws Exception
    {
        System.out.println("*******come in Callable"+Thread.currentThread().getName());

        //暂停一会儿线程
        while(ticket>0){
            ticket--;
            System.out.println(Thread.currentThread().getName()+"卖出第"+ticket+"票");
        }
        return 1024;
    }
}
class Ticket1{
    private int ticket =30;
    public void sell (){
        while(ticket>0){
            ticket--;
            System.out.println(Thread.currentThread().getName()+"卖出第"+ticket+"票");
        }
    }

        }

/**
 * @auther zzyy
 * @create 2019-02-18 17:11
 * java
 * 多线程中，第3种获得多线程的方式
 *
 * 1    get方法一般请放在最后一行
 */
public class CallableDemo
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {

        MyThread myThread = new MyThread();
        Ticket1 ticket1 = new Ticket1();
        FutureTask futureTask = new FutureTask(()->{
            for (int i = 0; i <30 ; i++) {
                ticket1.sell();
            }

        },"A");
        FutureTask futureTask1 = new FutureTask(()->{
            for (int i = 0; i <30 ; i++) {
                ticket1.sell();
            }
        },"B");
        new Thread(futureTask,"A").start();
//        System.out.println(futureTask.get());
        new Thread(futureTask1,"B").start();



    }
}
