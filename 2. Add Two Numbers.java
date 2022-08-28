class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode head=null, p =null;
        while(l1!=null && l2!=null){
            int k = l1.val+l2.val+c;
            c=k/10;
            ListNode n = new ListNode(k%10);
            if(head==null){
                head=n;
                p=n;
            } else{
                head.next=n;
                head=n;
            }
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int k = l1.val+c;
            c=k/10;
            ListNode n = new ListNode(k%10);
            if(head==null){
                head=n;
                p=n;
            } else{
                head.next=n;
                head=n;
            }
            l1=l1.next;
        }
        while(l2!=null){
            int k = l2.val+c;
            c=k/10;
            ListNode n = new ListNode(k%10);
            if(head==null){
                head=n;
                p=n;
            } else{
                head.next=n;
                head=n;
            }
            l2=l2.next;
        }
        if(c>0){
            ListNode n = new ListNode(c%10);
            if(head==null){
                head=n;
                p=n;
            } else{
                head.next=n;
                head=n;
            }
        }
        return p;
    }
}
