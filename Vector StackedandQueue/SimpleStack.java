
public interface SimpleStack<E>
{
  /*
  *This function returns the size of the stack
  *@return size of the list
  */
  public int size();

  /*
  *Inserts an item at the beginning of the list
  *@param any element to be inserted into the same element type stack
  *@return true if it pushed it false if it did not
  */
  public boolean push(E e);

  /*
  *Removes the first item in the list
  *@return the element removed
  */
  public E pop();

  /*
  *Looks at the first item in the list
  *@return the first item in the list
  */
  public E peek();
}
