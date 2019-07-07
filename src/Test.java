import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private int i=30;
    private Lock lock = new ReentrantLock();
    public void sell(){

        System.out.println(Thread.currentThread().getName()+"卖出了"+i--);
            lock.lock();

        try {
               } catch (Exception e) {
                   e.printStackTrace();
               }finally {

               }
               lock.unlock();
    }

}







public class Test {

    public static void main(String[] args) {


        List list = Arrays.asList("1","2","3");
        list.forEach(System.out::println);



    }
}
