/*
Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

Node RemoveDuplicates(Node head) {
  // This is a "method-only" submission. 
  // You only need to complete this method. 
    if(head == null){
        return head;
    }
    Node temp = head;
    while(temp.next!=null){
        if(temp.data == temp.next.data){
            temp.next = temp.next.next;
        }else{
            temp = temp.next;
        }
    }
    
    return head;

}
