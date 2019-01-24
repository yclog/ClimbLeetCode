import java.util.ArrayList;

public class Merge_Two_Sorted_Lists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String args[]){
        ListNode l2=new ListNode(3);
        l2.next=new ListNode(2);
        ArrayList<Integer> list=new ArrayList<>();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode(l1.val);
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ArrayList<Integer> list=new ArrayList<>();
        while(l2!=null){
            list.add(l2.val);
            l2=l2.next;
        }
        for (int i = 0; i < list.size(); i++) {
            if (l1.val>list.get(i)){

            }
        }
        return l3;
    }
}
