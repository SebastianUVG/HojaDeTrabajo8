package uvg;

/*
 * Este programa esta inspirado en el programa que brindo el profesro en 
 * la clase para realizar dicho programa.  
 * @author MICHAELLE ALEXANDER PEREZ RIZ
 */
/** @author MICHAELLE ALEXANDER PEREZ RIZ
 * @author Sebastian Garcia
 * @version 1.0
 */

 
import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements NewInterface<E> {

	protected Vector<E> data; // the data, kept in heap order

	public VectorHeap()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}

	protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
		return (i - 1) / 2;
	}

	protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2 * i + 1;
	}

	protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
		return (2 * i + 1) + 1;
	}

	protected void percolateUp(int leaf)
	// pre: 0 <= leaf < size
	// post: moves node at index leaf up to appropriate position
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
			data.set(leaf, data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf, value);
	}

	public boolean add(E value)
	// pre: value is non-null comparable
	// post: value is added to priority queue
	{
		data.add(value);
		percolateUp(data.size() - 1);
		return true;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public void clear() {

	}

	protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize) {
				if ((right(root) < heapSize) &&
						((data.get(childpos + 1)).compareTo
								(data.get(childpos)) < 0)) {
					childpos++;
				}
				// Assert: childpos indexes smaller of two children
				if ((data.get(childpos)).compareTo
						(value) < 0) {
					data.set(root, data.get(childpos));
					root = childpos; // keep moving down
				} else { // found right location
					data.set(root, value);
					return;
				}
			} else { // at a leaf! insert and halt
				data.set(root, value);
				return;
			}
		}
	}

	/*
	Estos no estaban implementados
	 */
	@Override
	public E getFirst() {
		return data.elementAt(0);
	}

	public E remove()
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	{
		E minVal = getFirst();
		data.set(0, data.get(data.size() - 1));
		data.setSize(data.size() - 1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}

	@Override
	public String toString() {
		return "VectorHeap{" +
				"data=" + data +
				'}';
	}
}