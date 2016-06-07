/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 

Node Delete(Node head, int position) {
  // Complete this method
    if(head == null){
        return head;
    }
    if(position == 0){
        head = head.next;
        return head;
    }else{
        int i=0;
        Node temp = head;
        while(i<position-1){
            temp = temp.next;
            i++;
        }
        if(temp.next.next !=null)
        temp.next = temp.next.next;
        else
            temp.next = null;
        return head;
        
    }

}

