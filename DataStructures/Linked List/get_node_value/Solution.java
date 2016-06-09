/*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    
int GetNode(Node head,int n) {
     // This is a "method-only" submission. 
     // You only need to complete this method. 
    
if(head==null){
        return 0;
    }
    int size=0;
    Node temp = head;
    while(temp!=null){
       temp= temp.next;
        size++;
    }
    size = size-n;
    temp = head;
    int i=0;
    while(i<size-1){
        temp = temp.next;
        i++;
    }
    
    return temp.data;
    
    
}
