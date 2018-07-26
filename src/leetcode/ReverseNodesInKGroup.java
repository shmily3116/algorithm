package leetcode;

public class ReverseNodesInKGroup {

    public static void main(String[] args){
        ReverseNodesInKGroup rk = new ReverseNodesInKGroup();
        ListNode ln = new ListNode(-1), last = ln;
        int[] values = {1,2,3,4,5,6,7,8};
        for (int i : values){
            last.next = new ListNode(i);
            last = last.next;
        }
        ListNode tmp = rk.reverseKNode(ln.next);
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
        System.out.println(ln.next.val);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tmp = new ListNode(head.val), partHead = tmp;
        int count = 1;
        while(head.next != null){
            if (count < k) {
                head = head.next;
                tmp.next = new ListNode(head.val);
                tmp = tmp.next;
                count++;
            } else {
                reverseKNode(partHead);
            }
        }
        return tmp.next;
    }

    private ListNode reverseKNode(ListNode head){
        ListNode tmp = new ListNode(-1), last = head;
        tmp.next = head;
        while(head.next != null){
            tmp.next = head.next;
            head.next = head.next.next;
            tmp.next.next = last;
            last = tmp.next;
        }
        return tmp.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
