
/*
*Follows the last in first out rule
*Its like a stack of blocks, blocks are information
*Place new information on top and removes the top first
*/

public class StackedList<E> implements SimpleStack<E>
{
  Vector stack;
  int size;


  public void StackedList()
  {
    stack = new Vector<E>();
    size = 0;
  }

  public int size()
  {
    return size;
  }
  @SuppressWarnings("unchecked")
  public boolean push(E e)
  {
    size++;
    stack.add(0, e);
    return true;
  }
  @SuppressWarnings("unchecked")
  public E pop()
  {
    if(stack.size()>0)
    {
      size--;
      return (E) (stack.remove(0));
    }
    throw new IndexOutOfBoundsException();

  }
  @SuppressWarnings("unchecked")
  public E peek()
  {
    return (E) stack.get(0);
  }

}
