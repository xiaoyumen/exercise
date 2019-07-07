public class Josepfu {
}


class CircleSinleLinkedList{
    //创建一个环形的单向链表
    private  Boy fist =null;
    //添加小孩节点，构建成一个环形的链表
    public  void addBoy(int nums){
        //num 做一个数据检验
        if (nums<1){
            System.out.println("num的值不正确");
            return;
        }
        Boy curBoy =null;
        //辅助指针帮助构建环形链表
        for (int i = 1; i <nums ; i++) {
            //根据编号，创建小孩节点
            Boy boy =new Boy(i);
            //如果是第一个小孩
            if (i==1){
                fist=null;
                fist.setNext(fist);//构成环
                curBoy=fist;//让curBoy指向第一个小孩

            }else {
                curBoy.setNext(boy);
                boy.setNext(fist);
                curBoy=boy;

            }
        }
    }
    //遍历当前的环形链表
    public  void showBoy(){
        //判断链表是否为空
        if (fist==null){
            System.out.println("没有任何小孩");
        return;
    }
    //因为fist不能动，因此我仍然使用一个辅助指针完成遍历
    Boy curBoy =fist;
    while(true){
        System.out.printf("小孩的编号 %d \n", curBoy.getNo());
        if (curBoy.getNext()==fist){
        //说明已经遍历完毕
            break;
            }
        curBoy =curBoy.getNext();//curBoy后移
    }
    }
    public  void countBoy(int starNp, int countNum ,int nums){
        //先对数据进行检验
        if (fist==null||starNp<1||starNp>nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建要给辅助指针，帮助完成小孩出圈
        Boy helper=fist;
        //需求创建一个辅助指针helper,事先应该指向环形链表的最后这个节点
        while (true){
            if (helper.getNext()==fist){
                //说明helper指向最后一个节点
                break;
            }
            helper=helper.getNext();
        }
        //小孩报数前，先让fist和helper移动k-1次
        for (int i = 0; i <starNp-1 ; i++) {
            fist=fist.getNext();
            helper=helper.getNext();
        }
        //当小孩报数时，让fist和helper指针同时的移动
        //这里是一个循环操作，知道圈中只有一个节点
        while (true){
            if (helper==fist){
                //说明圈中只有一个节点
                break;
            }
            //让fist和helper指针同时的移动，countNum-1
            for (int i = 0; i <countNum-1 ; i++) {
                fist=fist.getNext();
                helper=helper.getNext();
            }
            //这时fist指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", fist.getNo());
            //这时将fis指向的小孩节点出圈
            fist=fist.getNext();
            helper.setNext(fist);
        }
        System.out.println("最后留在圈中的小孩编号");
    }
}


// 创建一个Boy类，表示一个节点
class Boy {
    private int no;// 编号
    private Boy next; // 指向下一个节点,默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}
