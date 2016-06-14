/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int FindMergeNode(Node headA, Node headB) {
    // Complete this function
    // Do not write the main method. 
    int sizeA =0;
    Node tempA = headA;
    Node tempB = headB;
    while(headA!=null){
        sizeA++;
        headA = headA.next;
    }
    
    int sizeB =0;
    while(headB!=null){
        sizeB++;
        headB = headB.next;
    }
    
    int mergePoint = 0;
    int i=0;
    if(sizeA>sizeB){
        mergePoint = sizeA-sizeB;
        while(i<mergePoint){
        tempA = tempA.next;
        i++;
    }
    }else{
        mergePoint = sizeB-sizeA;
        while(i<mergePoint){
        tempB = tempB.next;
        i++;
    }
    }
        while(tempA != tempB){
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return tempA.data;
        
    
    
    

}
