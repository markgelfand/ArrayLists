import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

public class ArrayList_gelfand<E> extends AbstractList<E>implements List<E> {


    //Instance Variable
private E[] arr;
int size = 0;
  
  //Constructors
  public ArrayList_gelfand() {
   arr = (E[])(new Object[10]);
  }

  public ArrayList_gelfand(int initialCapacity) {
    arr = (E[])(new Object[initialCapacity]);
  }

  public ArrayList_gelfand(Collection<? extends E> c) {
    arr = (E[])(new Object[10]);
    this.addAll(c);
  }


  //Methods

  //size 1
  public int size() {
    return size;
  }
    
  
  //ensureCapacity 2
  public void ensureCapacity(int minCapacity) {
    E[] arr2 = (E[])(new Object[minCapacity]);
    for(int i = 0; i<this.size(); i++) {
      arr2[i] = arr[i];
  
    }
    arr = arr2;
  }

  //Get 3
  public E get(int index) {
    return arr[index];
  }

  //Add 4
  public boolean add(E e) {
    ensureCapacity(arr.length + 1);
    arr[size] = e;
    size++;
    return true;
  }

  //Set 5
  public E set(int index, E element) {
    if(index < 0 || index >= this.size()) {
      throw new IndexOutOfBoundsException("Index too high or low");
    }
    E temp = arr[index];
    arr[index] = element;
    return temp;
  }

  //Clear 6
  public void clear() {
    E[] arr2 = (E[])(new Object[0]);
      arr = arr2;
    size = 0;
  }

  //Index Of 7
  public int indexOf(Object o) {
    for(int i = 0; i < this.size(); i++) {
      if(arr[i].equals(o))
        return i;
    }
    return -1;
  }

  //Contains 8
  public boolean contains(Object o) {
    for(int i = 0; i < this.size(); i++) {
      if(arr[i].equals(o))
        return true;
    }
    return false;
  }

  //ToArray 9
  public Object[] toArray() {
    return arr;
  }

  //lastIndexOf 10
  public int lastIndexOf(Object o) {

    int target = -1;
    
    for(int i = 0; i<this.size(); i++) {
      if(arr[i].equals(o)) {
        target = i;
      }
    }
    return target;
  }

  //trimToSize 11
  public void trimToSize() {
    if(this.size() < arr.length) {
      E[] arr2 = (E[])(new Object[this.size()]);
      for(int i = 0; i < this.size(); i++) {
        arr2[i] = arr[i];
      }
      arr = arr2;
    }
  }
  

  //Add specific spot 12
  public void add(int index, E element) {
    if(index >= 0 && index < this.size()) {
     ensureCapacity(arr.length + 1);
    arr[index] = element;
    size++;
    }
    else {
      throw new IndexOutOfBoundsException("Index input is too high/low");
    }
  }

  //Remove 13
  public boolean removeObject(Object o) {
    int index = -1;
    for(int i = 0; i < this.size(); i++) {
      if(arr[i].equals(o)) {
        index = i;
      
        E[] arr2 = (E[])(new Object[this.size()]);
        for(int j = 0; j < index; j++) {
          arr2[j] = arr[j];
        }
        for(int j = index; j < arr2.length-1; j++) {
          arr2[j] = arr[j+1];
        }
        arr = arr2;
        size--;
        return true;
      }
    }
    return false;
  }

  //Remove index 14
  public E remove(int index) {
    E removed = arr[index];
    if(index < 0 || index >= arr.length) {
      throw new IndexOutOfBoundsException("Index too high/low");
    }
    E[] arr2 = (E[])(new Object[this.size()-1]);
        for(int j = 0; j < index; j++) {
          arr2[j] = arr[j];
        }
        for(int j = index; j < arr2.length; j++) {
          arr2[j] = arr[j+1];
        }
    arr = arr2;
    size--;
    return removed;
  }
//removeRange 15
 protected void removeRange(int fromIndex, int toIndex) {
  if(fromIndex < 0 || toIndex > this.size() || fromIndex > toIndex) {
    throw new IndexOutOfBoundsException("Index too high/low");
  }
   int toRemove = toIndex - fromIndex;
   int range = this.size() - toRemove;
   E[] arr2 = (E[])(new Object[range]);

   int secondIndex = 0;
   for(int i = 0; i < this.size(); i++) {
     if(i < fromIndex || i >= toIndex) {
     arr2[secondIndex] = arr[i];
      secondIndex++;
     }
   }
   arr = arr2;
   size -= toRemove;
}
  //Sublist 16
  public <E> E[] sublist(int fromIndex, int toIndex) {
    if(fromIndex < 0 || toIndex > this.size()) {
    throw new IndexOutOfBoundsException("Index too high/low");
  }
    int toSub = toIndex - fromIndex;
    E[] arr2 = (E[])(new Object[toSub+1]);
    int x = 0;
    for(int i = fromIndex; i < toIndex; i++) {
      arr2[x] = (E)arr[i];
      x++;
    }
    return arr2;
  }

  
}