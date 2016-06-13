/*
  Detect cycle in the list
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int HasCycle(Node head) {
    if(head == null){
        return 0;
    }
    Node tort = head;
    Node hare = head;
    int power = 2;
    int steps = 0;
    while(tort.next!=null){
        tort = tort.next;
        if(tort == hare){
            return 1;
        }
        steps++;
        if(steps == power){
            power <<= 1;
            hare = tort;
            steps = 0;
        }
        
    }
    
    return 0;
    
}
