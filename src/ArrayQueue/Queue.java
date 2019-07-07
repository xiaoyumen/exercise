import java.text.SimpleDateFormat;
import java.util.Date;

public class  Queue{
    public static void main(){
        int[] arr = new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]=(int)(Math.random()*80000);

        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        bubbleSort(arr);
        Date d = new Date();
        String s = simpleDateFormat.format(d);
        System.out.println(s);


    }

    private static void bubbleSort(int[] arr) {
        //冒泡排序的时间复杂度n2
        int temp =0;
        boolean flag=false;
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1 ; j++) {
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if ((!flag)){
                break;
            }else {
                flag=false;
            }
        }

    }
    //插入排序
    public static  void  insertSort(int []arr){
        int insertVal =0;
        int insertIndex =0;
        //for循环来把代码简化
        for (int i = 0; i <arr.length ; i++) {
            //定义待插入的数
            insertVal=arr[i];
            insertIndex=i-1;//即arr[i]的前面这个数的下标
            //给insertVal 找到插入的位置·
            //说明·
            //1.insertIndex>=0保证在给insertVal找插入的位置，不越界
            //2.insertVal<arr[insertIndex]待插入的数，还没有找到·插入位置
            //3.就需要将arr[insertIndex]后移
            while (insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
            System.out.println("");



        }
    }
}

