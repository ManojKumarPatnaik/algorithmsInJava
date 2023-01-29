package My_Learning.linkedList;

public class DesignListLeetcode707 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Node {
        int val;
        Node next;
        Node(int x) {
            this.val = x;
        }    
    }
     
    Node head;
    Node tail;
    int size;
    
    public DesignListLeetcode707() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    
    public int get(int index) {
        if(index<0 || index>=size){
            return -1;
        }
        Node curr=head;
        for(int i=0; i<index;i++){
            curr=curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node temp=new Node(val);
        if(head==null){
            head=temp;
            tail=temp;
        }else{
            temp.next=head;
            head=temp;
        }
        size++;
    }
    
    public void addAtTail(int val) {
         Node temp=new Node(val);
        if(tail==null){
            tail=temp;
            head=temp;
        }else{
            tail.next=temp;
            tail=temp;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index==size){
            addAtTail(val);
        }else if(index>size){
            return;
        }else if(index==0){
            addAtHead(val);
        }else{
            Node curr=head;
            Node prev=null;
            for(int i=0; i<index;i++){
                prev=curr;
                curr=curr.next;
            }
            Node temp=new Node(val);
            prev.next=temp;
            temp.next=curr;
            size++;
            
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size) return;
        if(index==0){
            head=head.next;
            size--;
            return;
        }else if(index==size-1){
            Node curr=head;
            while(curr.next!=tail){
                curr=curr.next;
                
            }
            curr.next=null;
            tail=curr;
            size--;
            return;
        }
           Node curr=head;
            Node prev=null;
            for(int i=0; i<index;i++){
                prev=curr;
                curr=curr.next;
            }
        prev.next=curr.next;
        size--;
    }
	

}
