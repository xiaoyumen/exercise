

class ThreadLock implements  Runnable{
    private int lockA;
    private  int lockB;

    public ThreadLock(int lockA, int lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        String s = lockA + "";
        String s1 = lockB + "";
        synchronized (s){
            System.out.println(Thread.currentThread().getName()+"获取"+System.identityHashCode(s)+"尝试获取"+System.identityHashCode(s1));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (s1){
                System.out.println(Thread.currentThread().getName()+"获取"+System.identityHashCode(s1)+"尝试获取"+System.identityHashCode(s));
            }

        }

    }
}



public class ThreadPoolexcuetor {
    public static void main(String[] args) {

        int lockA =1;
        int lockB =2;
        int lockC =3;
        new Thread(new ThreadLock(lockC,lockB),"AAA").start();
        new Thread(new ThreadLock(lockB,lockC),"BBB").start();

    }
}


