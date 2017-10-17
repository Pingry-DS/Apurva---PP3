public interface SimpleQueue<E>
{
  /*
  *Adds an item to the beginning of the line in the Queue
  *@return true if success add, false if not success
  */
  public boolean offer(E e);

  /*
  *removes the first item, which is in the last spot of the list
  *@return element that was removed
  */
  public E poll();

/*
*Peeks at the last item in the list
*@return element it looked at
*/
  public E peek();

/*
*Checks if the list is empty
*@return true if it is empty, if not false
*/
  public boolean isEmpty();

/*
*Checks the size of the list
*@return the size of the list
*/
  public int size();
}
