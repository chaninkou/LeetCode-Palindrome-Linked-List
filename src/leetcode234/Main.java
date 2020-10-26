package leetcode234;

public class Main {
	public static void main(String[] args) {
		int[] input = {1,2,2,1,4};
		ListNode head = insertNode(input);
		
		// Delete node 4 and display it
		displayLinkedList(removeNode(head, 4));
		
		CheckPadlindromeLinkedListFunction solution = new CheckPadlindromeLinkedListFunction();
		
		System.out.println("Solution: " + solution.isPalindrome(head));
		
	}
	
	public static ListNode insertNode(int[] input){
		ListNode dummyRoot = new ListNode(0);
		ListNode previous = dummyRoot;
		
		for(int item : input){
			previous.next = new ListNode(item);
			previous = previous.next;
		}
	
		return dummyRoot.next;
	}
	
	public static void displayLinkedList(ListNode head){
		System.out.println("Input: ");
		ListNode current = head;
		
		while(current != null){
			System.out.print(current.val + " -> ");
			
			if(current.next == null){
				System.out.print("null");
			}
			
			current = current.next;
		}
		
		System.out.println(" ");
	}
	
	public static ListNode removeNode(ListNode head, int val){
		// New Linked List
		ListNode fakeHead = new ListNode(0);
		
		// Point the fakehead to the head
		fakeHead.next = head;
		
		// Keeping track of current, starts from head
		ListNode current = head;
		
		// Keep track of previous node
		ListNode dummyNode = fakeHead;
		
		while(current != null){
			if(current.val == val){
				dummyNode.next = current.next;
			} else {
				dummyNode = dummyNode.next;
			}
			
			current = current.next;
		}
		
		// Since fakeHead was just a temporary head
		return fakeHead.next;
	}
}
