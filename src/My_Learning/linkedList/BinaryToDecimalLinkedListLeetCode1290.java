package My_Learning.linkedList;

public class BinaryToDecimalLinkedListLeetCode1290 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Method 1 : 1 -> 1 -> 0 to get the power of 2 we can get the length and then
	 * take a variable and length - i
	 * 
	 * Method - 2 : reverse the linked list and then proceed
	 * 
	 * Method - 3 : we can assume one node and make our answer and if we move next
	 * and we find other node then the older answer will get multipled by 2 i.e inc
	 * the power of all the node previous to it by 1 and adding the current node
	 * value to it. 2^0.
	 */
	public int getDecimalValue(ListNode head) {
        if (head==null) return 0;
        
        int ans =0;
        ListNode temp = head;
        while(temp!=null){
            ans *= 2;
            ans += temp.val;
            temp = temp.next;
        }
        
        return ans;
    }

}
