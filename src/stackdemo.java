import java.util.Stack;

public class stackdemo {


    public static void main(String[] args) {

        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        //测试一下单链表的反转功能
        singleLinkedList.list();
    }
    //可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特性打印

    public  static  void  reversePrint(HeroNode head){
        if (head.next==null){
            return;//空链表，不能打印

        }
        //创建要给一个栈，将各个节点压人栈
    Stack<HeroNode> stack = new Stack();
        HeroNode cur =head.next;
        //将链表的所有节点压入栈
        while (cur!=null){
            stack.push(cur);
            cur= cur.next;
            //cur后移，这样就可以压入下一个节点

        }
        //将栈中的节点进行打印，pop出栈
        while (stack.size()>0){
            System.out.println(stack.pop());
        }//stack的特点是先进后出

    }
    //将单链表反转
    public static void reversetlist(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next==null||head.next.next==null){
            return;
        }
        //定义一个辅助的指针（变量），帮助我们遍历原来的链表
        HeroNode cur =head.next;
        HeroNode next =null;
        //指向当前节点cur的下一个节点
        HeroNode reverseHead =new HeroNode(0,"","");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表
        while (cur!=null){

            next =cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next=reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next=cur;//将cur连接到新的链表上
            cur=next;//让cur后移
        }
        //将head。next指向reverseHead.next，实现单链表的反转
        head.next=reverseHead.next;

    }
    //查找单链表中的倒数第k个结点 【新浪面试题】
    //思路
    //1. 编写一个方法，接收head节点，同时接收一个index
    //2. index 表示是倒数第index个节点
    //3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    //4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    //5. 如果找到了，则返回该节点，否则返回nulll




}

//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HeroNode {
    //data域
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点
    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}

class SingleLinkedList{
    //先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode head =new HeroNode(0,"","");
    //返回头结点
    public  HeroNode getHead(){return  head;}
    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp =head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if (temp.next==null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp=temp.next;

        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next·指向新的节点
        temp.next=heroNode;
    }
    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public  void addByOrder(HeroNode heroNode) {
        //因为头结点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {
                //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明希望添加的heroNode的编号已然存在
                flag = true;
                break;
            }
            temp = temp.next;//后移，遍历当前链表


        }
        if (flag){
            //判断flag的值 不能添加，说明编号存在
            System.out.println("编号已经存在");

        }else {
            //插入到链表中，temp的后面
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }
    //修改节点的信息，根据no编号来修改，即no编号不能改
    //1.根据newHeroNOde的no来修改即可
    public void update(HeroNode newHeroNode){
        //判断是否空
        if (head.next==null){
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp =head.next;
        boolean flag =false;//表示是否找到该节点
        while (true){
            if (temp==null){
                //已经遍历完链表
                break;
            }
            if (temp.no==newHeroNode.no){
                //找到
                flag =true;
                break;
            }
            temp =temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name =newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else {
            //没有找到
            System.out.println("没有找到编号");
        }
    }
    //删除节点
    //1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2.说明我们在比较时，是temp.next。no和需要删除的节点的no比较
    public void del(int no){
        HeroNode temp =head;
        boolean flag = false;//标志是否找到待删除节点的
        while (true){
            if (temp.next==null){
                //已经到链表的最后
                break;
            }
            if (temp.next.no==no){
                //找到的待删除节点的前一个节点temp
                flag=true;
                break;
            }
            temp=temp.next;
            //后移，遍历
        }
        //判断flag
        if (flag){
            //找到，可以可以删除
            temp.next=temp.next.next;

        }else {
            System.out.println("要删除的节点不存在");
        }
    }
    //显示链表遍历
    public void list(){
        //判断链表是否为·空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp =head.next;
        while (true){
            //判断是否到链表最后
            if (temp==null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp=temp.next;

        }
    }
}
