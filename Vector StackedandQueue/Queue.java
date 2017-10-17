/*
*Follows the first in first out
*THe first data item is last in the list and is removed first
*/
public class Queue<E> implements SimpleQueue<E>
{
  Vector queueList;
  int size;

  public void Queue()
  {
    queueList = new Vector<E>();
    size = 0;
  }

  public boolean isEmpty()
  {
    return(size==0);
  }

  public int size()
  {
    return size;
  }
  @SuppressWarnings ("unchecked")
  public boolean offer(E e)
  {
    size++;
    queueList.add(0, e);
    return true;
  }
@SuppressWarnings ("unchecked")
  public E poll()
  {
    size --;
    return (E) (queueList.remove(queueList.size() - 1));
  }
  @SuppressWarnings ("unchecked")
  public E peek()
  {
    return(E)(queueList.get(queueList.size()-1));
  }

}
