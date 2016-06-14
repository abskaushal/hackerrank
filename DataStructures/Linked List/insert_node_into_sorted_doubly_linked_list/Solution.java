/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
     Node prev;
  }
*/

Node SortedInsert(Node head,int data) {
    if(head == null){
        head = new Node();
        head.data = data;
        head.next =null;
        head.prev = null;
        return head;
    }else if(head.next == null){
        if(head.data < data){
            Node n = new Node();
            n.data = data;
            head.next = n;
            n.next = null;
            n.prev = head;
            return head;
            
        }else{
            
            Node n = new Node();
            n.data = data;
            
            n.next = head;
            n.prev = null;
            head.prev = n;
            head.next =null;
         return n;
        }
    }else{
    
    Node temp = head;
        Node prev = head;
    
    while(temp!=null && temp.data < data ){
        prev = temp;
        temp = temp.next;
    }
    
    if(temp == null){
        Node n = new Node();
        n.data = data;
        n.next = null;
        n.prev = prev;
        prev.next = n;
        return head;
    }else{
        temp = temp.prev;
        Node n = new Node();
        n.data = data;
        n.next = temp.next;
        
        n.prev = temp;
        
        
        n.next.prev = n;
        temp.next = n;
        
        return head;
    }
    
    }
  
}
