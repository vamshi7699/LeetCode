class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode x= head;
        while(head!=null){
            ListNode k = head;
            while(head.next!=null && k.val==head.next.val)
                head.next=head.next.next;
            head=head.next;
        }
        return x;
    }
}
