class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        // 2 seperate chains for odd and even
        ListNode oddHead = head, oddNode = oddHead, evenNode = head.next, evenHead = evenNode;
        
        boolean odd = true;
        head = head.next.next;
        while(head!=null){
            if(odd){
                oddNode.next = head;
                oddNode = oddNode.next;
            } else {
                evenNode.next = head;
                evenNode = evenNode.next;
            }
            odd = !odd;
            head=head.next;
        }
        
        // attach the odd chain end to even chain start
        oddNode.next = evenHead;
        
        // end the even chain
        evenNode.next = null;
        
        return oddHead;
    }
}
