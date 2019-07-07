import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolexcuto {
    public static void main(String[] args) {


    //线程池
   ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,60,
            TimeUnit.SECONDS,new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory()
    , new ThreadPoolExecutor.DiscardOldestPolicy());
   //测试
        System.out.println(Runtime.getRuntime().availableProcessors());
        //模拟有10个顾客过来银行办理业务，目前池子里面有5个工作人员提供服务
        for (int i = 1; i <11 ; i++) {

            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"/t办理业务");
            });
        }
        threadPoolExecutor.shutdown();
    }
}
