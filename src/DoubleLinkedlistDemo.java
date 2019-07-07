public class DoubleLinkedlistDemo {
}


//创建一个双向链表的类
class DoubleLinkedList {
    //先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头结点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加一个节点到双向链表的最后
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;

            }
            //如果没有找到最后，将temp后移
            temp=temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next=heroNode;
        heroNode.pre =temp;
    }
    //修改一个节点的内容，可以看到双向链表的节点内容修改和单向链表一样
    //只是节点类型改成HeroNode2
    public  void update(HeroNode2 newHeronode){
        //判断是否空
        if (head.next==null){
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点根据no编号
        //定义一个辅助变量
        HeroNode2 temp =head.next;
        boolean flag =false;//表示是否找到该节点
        while (true){
            if (temp==null){
                break;
            }
            if (temp.no==newHeronode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name=newHeronode.name;
            temp.nickname =newHeronode.nickname;
        }else {
            //没有找到
            System.out.println("没有找到");
        }
    }
    public  void del(int no){
        //判断当前链表是否为空
        if (head.next==null){
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp=head.next;//辅助指针
        boolean flag =false;
        while (true){
        if (temp==null){
            //已经到链表的最后
            break;
        }
        if (temp.no==no){
            //找到的待删除节点的前一个节点temp
            flag=true;
            break;
        }
        temp=temp.next;
        }
        //判断flag
        if (flag){
            //找到，可以删除
            temp.pre.next=temp.next;
            //如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }else {
                System.out.println();
            }
        }
    }

        //   }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一节点，默认为null
    public HeroNode2 pre;
    //构造器


    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}