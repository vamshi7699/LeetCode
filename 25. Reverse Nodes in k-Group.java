class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverse(head, k);
    }
    
    public ListNode reverse(ListNode head, int k){
        if(head==null){
            return null;
        }
        int t = k;
        ListNode root =head;
        ListNode prev = null, curr = head, next = null;
        
        // check if k len exists
        while(t>0 && head!=null){
            t--;
            head=head.next;
        }
        
        // if not exists, do not reverse
        if(t>0){
            return root;
        }
        
        t= k;
        
        
        // reverse the LL of size k
        while(curr!=null && t>0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            --t;
        }
        
        // the reversed current group should be linked to the next reversed group
        // the method always reverses the LL and returns the new head
        // so link the next grp to the current end
        root.next = reverse(curr, k);
        
        // return reveresed LL head
        return prev;
    }
}
