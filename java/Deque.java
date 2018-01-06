class Deque<Base>{
  private class Node{
  private Node left;
  private Node right;
  private Base object;
  public Node(Node left,Node right,Base object){
    this.left = left;
    this.right = right;
    this.object = object;
    }
  }
  private Node head;
  public Deque(){
    head = new Node(null,null,null);
    head.left = head;
    head.right = head;
  }
  public void enqueueFront(Base object){
      head.right = new Node(head,head.right,object);
      head.right.right.left = head.right;
   
  }
  public void enqueueRear(Base object){
      head.left = new Node (head.left,head,object);
      head.left.left.right = head.left;
  }
  public Base dequeueFront(){
    
    Node temp = head.right;
    if(isEmpty()){
      throw new IllegalStateException();
    }else{
      Node left = head.right;
      Node right = left.right;
      head.right = right;
      right.left = head;
    }
    return temp.object;
    
  }
  public Base dequeueRear(){
    Node temp =head.left;
    if(isEmpty()){
      throw new IllegalStateException();
    }else{
      Node left = head.left;
      Node right = left.left;
      head.left = right;
      right.right = head;
    }
    return temp.object;
  }
  public boolean isEmpty(){
    if (head.left == head && head.right== head){
      return true;
    }
    return false;
  }
 

}