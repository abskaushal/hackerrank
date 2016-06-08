/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element  
  Node is defined as  
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 
Node Reverse(Node head) {
    if(head == null){
        return head;
    }
    if(head.next == null){
        return head;
    }
    Node temp = head.next;
    Node prev = head;
    Node tempHead = head;
    //prev.next = null;
    while(temp.next!=null){
      
        head = temp;
        
        temp = temp.next;
        head.next = prev;
        prev = head;
    }
    head = temp;
    head.next = prev;
    tempHead.next =null;
    
    
    return head;
}
