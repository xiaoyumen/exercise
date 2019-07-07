import static sun.misc.Version.print;

public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array, 保存皇后放置位置的结果,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;
    public static void main(String[] args) {
        //测试一把 ， 8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w
}
    //编写一个方法，放置第n个皇后
    //特别注意：check是每一次递归时，进入到check中都有
    //因此会有回溯
    private void check(int n) {
        if (n==max){
            //n=8,其实8个皇后就既然放好了
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int j = 0; j <max ; j++) {
            //先把当前这个皇后n,放到改行的第1列
            array[n]=j;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)){
                //不冲突，J接着放n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行，array[n]=i;即将第n个皇后，放置
            //在本行得后移的位置

        }
    }
    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i <n; i++) {
            //说明
            //1.array[i]==array[n]表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            //2.Math.abs()
        }
        return false;
    }
}
