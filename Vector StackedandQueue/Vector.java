import java.util.Iterator;
import java.util.NoSuchElementException;

public class Vector<E> implements SimpleList<E>
{
	private Object [] data;
	//How many items the vector can currently hold
	private int capacity;
	//How many items are in the vector
	private int size;
	/**
	 *
	 * @param s int desired size of new Vector
	 */
	public Vector(int s)
	{
		if(s<1)
			throw new IllegalArgumentException("Please initiate with a size of at least 1");
		data = new Object[s];
		size = 0;
		capacity = data.length;

	}
	/**
	 * Default length 10
	 */
	public Vector()
	{
		data = new Object [10];
		size = 0;
		capacity = data.length;

	}
	/**
	 * Copy constructor
	 *
	 * @param other
	 */
	public Vector(Vector<E> other)
	{
		if(other==null)
			throw new IllegalArgumentException("Please initate with a Vector which is not null");
		data = new Object[other.capacity];
		for(int i=0; i<other.size(); i++)
		{
			data[i] = other.data[i];
		}
	}

	/**
	 * Double the capacity of the vector
	 */
	private void increaseCapacity()
	{
		//Exceptions: N/A
		//Relations: Add?
		Object[] copy = new Object[data.length*2];
		for(int i = 0; i<data.length; i++)
		{
			copy[i] = data[i];
		}
		data = copy;
		capacity=data.length;
	}


	/**
	 * Return item at specified index
	 *
	 * @param index
	 * @return E
	 */
	@SuppressWarnings("unchecked")
	public E get(int index)
	{
		//Exceptions: Index out of bounds
		//Relations: contains?
		if(index>=size||index<0)
		{
			throw new IndexOutOfBoundsException("Index out of Bounds error; nice try");
		}
		else
			return (E) data[index];
	}

	/**
	 * Remove and return item at specified index
	 * Shift the other items down
	 *
	 * @param index
	 * @return E
	 */
	@SuppressWarnings("unchecked")
	public E remove(int index)
	{
		//Exceptions: Index out of bounds
		//Relations: N/A
		if(index>=size||index<0)
		{
			throw new IndexOutOfBoundsException("Index out of Bounds error; nice try");
		}
		else
		{
			E holder = (E) data[index];
			data[index] = null;
			for(int i = index; i<size;i++)
			{
				data[i] = data[i+1];
				if(i==(size-1))
					data[i] = null;
			}
			size--;
			return holder;
		}

	}


	/**
	 * Remove first instance of specified object
	 *
	 * @return boolean
	 * @param obj
	 */
	public boolean remove(Object obj)
	{
		int index = indexOf(obj);
		if(index==-1)
		{
			return false;
		}
		else
		{
			data[index] = null;
			for(int i = index; i<=index;i++)
			{
				if(data[i+1]==null)
					data[i] = null;
				else
					data[i] = data[i+1];
			}
			size--;
			return true;
		}

	}


	/**
	 * Place object at specified location
	 *
	 * @param index
	 * @param obj
	 * @return E
	 */
	@SuppressWarnings("unchecked")
	public E set(int index, E obj)
	{
		if(index>=size)
			throw new IndexOutOfBoundsException("Index out of Bounds error; nice try");
		E holder = (E) data[index];
		data[index] = obj;
		return holder;
	}


	/**
	 * //Return the number of items in the vector
	 *
	 * @return int
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Remove all items from the vector
	 *
	 */
	public void clear()
	{
		data = new Object[10];
		size = 0;
		capacity = data.length;


	}

	/**
	 * Return whether or not the vector is empty
	 *
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		return (size==0);
	}

	/**
	 * Return whether or not the vector contains specified object
	 *
	 * @param obj
	 * @return boolean
	 */
	public boolean contains(Object obj)
	{
		return(indexOf(obj)!=-1);
	}


	/**
	 * //Return index of the first instance of specified object
	 *
	 * @return int
	 * @param obj
	 */
	public int indexOf(Object obj)
	{
		{
		for(int i = 0; i<data.length; i++)
			if(data[i]==obj)
				return i;
		}
		return -1;


	}


	/**
	 * How the vector will be displayed once printed
	 *
	 * @return String
	 */
	//Create and return an iterator
	public Iterator<E> iterator()
	{
		return new VectorIterator(this);
	}

	/**
	 * Add item to the first available space in the Vector (ie, the end)
	 *
	 * @param e
	 */
	@SuppressWarnings("unchecked")
	public boolean add(E e)
	{
		data[size] = e;
		size++;
		if(size==capacity)
			increaseCapacity();
		return true;
	}
	/**
	 * Add item to the specified spot and shift the other items down
	 *
	 * @param e
	 * @param index
	 */
	@SuppressWarnings("unchecked")
	public void add(int index, E e)
	{
		if(index>size)
			throw new IndexOutOfBoundsException("Index out of Bounds error; nice try");
		if(size == 0 && index == 0)
		{
			data[0] = e;
			size ++;
		}
		else
		{
			int i = size;
			while(i>=index)
			{
				data[i+1] = data[i];
				i++;
			}
			data[index] = e;
			size++;
			if(size==capacity)
				increaseCapacity();
		}
	}



private class VectorIterator implements Iterator<E>
{
	/**
	 * stores the vector being iterated
	 */
	private Vector<E> vector;

	/**
	 * Which element the VectorIterator is looking at
	 */
	private int currentIndex = 0;

	/**
	 *
	 * @param v Vector that is being iterated
	 */
	public VectorIterator(Vector<E> v)
	{
		vector = v;
	}

	/**
	 * Returns true if there are more elements. Otherwise, returns false.
	 *
	 * @return boolean
	 */
	public boolean hasNext()
	{
		return currentIndex<vector.size();
	}
	/**
	 * Returns the next element. Throws NoSuchElementException if there is not a next element.
	 *
	 * @return E
	 */
	public E next()
	{
		if(!hasNext())
			throw new NoSuchElementException();
		return vector.get(currentIndex++);
	}

	/**
	 *
	 */
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}
}
