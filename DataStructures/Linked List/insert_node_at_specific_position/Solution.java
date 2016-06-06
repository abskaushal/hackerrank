/*
  Insert Node at a given position in a linked list 
  head can be NULL 
  First element in the linked list is at position 0
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    

Node InsertNth(Node head, int data, int position) {
   // This is a "method-only" submission. 
    // You only need to complete this method. 
    if(head == null){
        head = new Node();
        head.data = data;
        head.next = null;
        return null;
    }else {
        if(position == 0){
            Node n = new Node();
            n.data = data;
            n.next = head;
            head = n;
            return head;
        }else{
            int i=0;
            Node temp = head;
            while(i<position-1){
                temp = temp.next;
                i++;
            }
            Node n = new Node();
            n.data = data;
            n.next = temp.next;
            temp.next = n;
            return head;
            
        }
    }

}
