class AssociationList <Key,Value> {
  private class Node{
    private Key key;
    private Value value;
    private Node next;
    public Node(Key key,Value value,Node next){
      this.key = key;
      this.value = value;
      this.next=next;
    }
  }
  private Node head;
  public AssociationList(){
    head = new Node(null,null,null);
  }
  public void delete(Key key){
    Node left = head;
    Node right = left.next;
    if(isIn(key)){
        while(right!=null){
          if(isEqual(right.key,key)){
            left.next = right.next;
            break;
          }else{
          left =right;
          right = right.next;
          }
        }
    } 
  }
  
  public Value get(Key key){
    Node temp = head.next;
    if(isIn(key)==true){
      while(temp!=null){
        if(isEqual(temp.key,key)){
        return temp.value;
      }
        temp=temp.next;
      }
    }
    throw new IllegalArgumentException();
  }
  private boolean isEqual(Key leftKey, Key rightKey){
    if(leftKey == null || rightKey == null){
      if (leftKey == rightKey){
        return true;
      }else{
        return false;
      }
    }
    else{
      if(leftKey.equals(rightKey)){
        return true;
      }else{
        return false;
      }
    }
  }
  public boolean isIn(Key key){
    Node temp = head.next;
    if (head.next == null){
      return false;
    }
    while(temp!=null){
      if(isEqual(temp.key,key)){
        return true;
      }
        temp=temp.next;
    }
    return false;
  }
  
  public void put(Key key,Value value){
//    if(head == null){
//      head = new Node(key,value,head);
//    }
    if(isIn(key))
    {
      Node temp = head.next;
      while(temp!=null){
        if(isEqual(temp.key,key)){
          temp.value=value;
        }
        temp=temp.next;
      
      }
    }else{
    head.next= new Node(key,value,head.next);
    }
  }
  
}