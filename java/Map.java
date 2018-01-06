class Map<Key,Value>{
  private Key[]a;
  private Value[]b;
  private int record;
  public Map(int length){
    if (length<0){
      throw new IllegalArgumentException();
    }else{
     a = (Key[])new Object[length];
     b = (Value[])new Object[length];
    }
  }
  public Value get(Key key){
    int test = where(key);
    if( test!=-1){
      return b[test];
    }else {
      throw new IllegalArgumentException();
    }
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
    int count =0;
    for (int i= 0; i<record;i++){
      if(isEqual(a[i],key)){
        count ++;
        return true;
      }
    }
    if(count ==0){
      return false;
    }else{
      return true;
    }
  }
  public void put(Key key,Value value){
//     if(isIn(key)==true && isEqual(null,key) && c!=0){
//        b[where(key)]=value;
//     }else if(isIn(key)==true && ! isEqual(null,key)){
//        b[where(key)]=value;
//     }else if(isIn(key)==false || (c==0 && isEqual(null,key))){
//       if(record<a.length){
//         if(key!=null){
//           a[record]=key;
//           b[record]=value;
//           record++;
//         }else{
//           if(c==0){
//             a[record]=key;
//             b[record]=value;
//             c++;
//             record++;
//           }
//         }
//       }else{
//         throw new IllegalStateException();
//       }
//     }
    
    
    if(isIn(key)==true){
      b[where(key)]=value;
    }else{
      if(record<a.length){
        a[record]=key;
        b[record]=value;
        record++;
      }else{
        throw new IllegalStateException();
      }
    }
    
    
  }
  private int where(Key key){
    int count =0;
    for (int i=0;i<record;i++){
      if(isEqual(a[i],key)){
        count++;
        return i;
      }
    }
    if(count == 0){
      return -1;
    }else{
      return 1;
    }
  }
}