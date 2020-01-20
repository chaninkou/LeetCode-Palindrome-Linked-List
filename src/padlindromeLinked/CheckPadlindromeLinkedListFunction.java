package padlindromeLinked;

public class CheckPadlindromeLinkedListFunction {
	public boolean isPalindrome(ListNode head) {
        // Fast will go next 2 nodes
        ListNode fast = head;
        
        // Slow will go next node
        ListNode slow = head;
        
        // Finding the middle point of the linked List
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // odd node, let right side half smaller in order for them to have equal length
        if(fast != null){
            slow = slow.next;
        }
        
        // Reverse the slow linked list
        slow = reverse(slow);
        
        // Fast will become the head of the original linkedlist now
        fast = head;
        
        // Comparing the slow and fast linked list
        // If the node was odd, we don't care what is in the middle ex: 1,2,2,2,1
        while(slow != null){
            // If last node is not the same as first node, false
            if(slow.val != fast.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
    
        return true;
	}

	// Reverse the Linked List
	private ListNode reverse(ListNode head) {
		// Creating a new Linked List
		// The last node is always pointing to null
		ListNode previous = null;
		
		// While head is not null
		while(head != null){
			// Keep track of what is next first
			ListNode nextTemp = head.next;
			
			head.next = previous;
			
			// previous will be the head now, it should be null first
			previous = head;
			
			// move the head now
			head = nextTemp;
	        
		}
		
		// Since head will be null, we need to return previous
		return previous;
	}
}

