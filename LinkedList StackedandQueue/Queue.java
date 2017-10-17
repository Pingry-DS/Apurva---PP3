public class Queue<E> implements SimpleQueue<E>
{
  MyList<E> queue;
  int size;

  public void Queue()
  {
    queue = new MyList<E>();
    size = 0;
  }

  public boolean isEmpty()
  {
    return(queue.isEmpty());
  }

  public int size()
  {
    return size;
  }

  public boolean offer(E e)
  {
    size++;
    queue.add(0, e);
    return true;
  }

  public E poll()
  {
    if(size > 0)
      return (E)  queue.remove(0);
    throw new IndexOutOfBoundsException();
  }

  public E peek()
  {
    return (E) queue.get(0);
  }
}
