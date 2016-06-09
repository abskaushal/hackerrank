/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

Node MergeLists(Node headA, Node headB) {
     // This is a "method-only" submission. 
     // You only need to complete this method 
    
    if(headA == null){
        return headB;
    }
    if(headB == null){
        return headA;
    }
    Node head;
    
    if(headA.data < headB.data){
        head = headA;
        merge(head,headB);
    }else{
        head = headB;
        merge(head, headA);
    }
    
return head;
}

private void merge(Node temp, Node b){
    
    while(temp.next!=null && b!=null){
        if(b.data < temp.next.data){
            Node t = temp.next;
            Node bt = b.next;
            temp.next =b;
            b.next = t;
            temp= t;
            b = bt;
        }else{
            temp = temp.next;
        }
    }
    if(b!=null){
        temp.next =b;
    }
    
}
