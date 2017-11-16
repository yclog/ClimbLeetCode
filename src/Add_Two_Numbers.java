import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Add_Two_Numbers {
    public static void main(String[] args){
        ListNode l1=new ListNode(0);
        ListNode l2=new ListNode(7);
        initData(l1,l2,0);
        System.out.println("起始l1");
        print(l1);
        System.out.println("起始l2");
        print(l2);
        align(l1,l2);
        System.out.println("对齐后l1");
        print(l1);
        System.out.println("对齐后l2");
        print(l2);
        add(l1,l2,0);
        System.out.println("求和后");
        print(l1);

    }

    //初始化ListNode数据
    public static void initData(ListNode l1, ListNode l2,int time){
        if (time==0) {
            //用于测试长度不匹配情况
            l2.next=new ListNode(3);
            return;
        }
        l2.next=new ListNode(5);
        initData(l1.next,l2.next,time+1);
    }

    //打印ListNode
    public static void print(ListNode list){
        System.out.print(list.val+" ");
        if (list.next==null){
            System.out.println(" ");
            return;
        }
        print(list.next);
    }

    /**
     * @param priority 传递本层权值（进位）进入下层
     * */
    public static void add(ListNode l1, ListNode l2, int priority) {
          if (l2==null||l1==null) {
              return ;
          }
          int temp=l1.val+l2.val+priority;
          if (temp>=10&&l1.next==null){
              l1.next=new ListNode(1);
          }
          l1.val=temp%10;
          if (temp>=10){
              add(l1.next,l2.next,1);
          } else {
              add(l1.next,l2.next,0);
          }
    }

    //l1与l2长度对齐
    public static void align(ListNode l1,ListNode l2){
        if (l1.next==null&&l2.next!=null){
            l1.next=new ListNode(0);
        } else if (l1.next!=null&&l2.next==null){
            l2.next=new ListNode(0);
        } else if (l1.next==null&&l2.next==null){
            return;
        }
        align(l1.next,l2.next);
    }
}
