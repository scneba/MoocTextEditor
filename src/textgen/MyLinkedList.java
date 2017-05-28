package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next=tail;
		tail.prev=head;
		size=0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		
		new LLNode(0,element,tail);
		this.size++;
	
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		 if(this.size<(index+1)||index<0 ){
			  throw new IndexOutOfBoundsException("Input index is out of bounds");
			 
		 }
	      LLNode<E> NextNode = head;
	      for(int i=0;i<index+1;i++){
	    	  NextNode=NextNode.next;
	      }
		
		return NextNode.data;
	}
	
	
	/** get the linkedlist Node at a position and return it*/
   public LLNode<E> getNode(int index){
	   if((index>this.size+1)||index<0 ){
			  throw new IndexOutOfBoundsException("Input index is out of bounds");
			 
		 }
	      LLNode<E> NextNode = head;
	      for(int i=0;i<index+1;i++){
	    	  NextNode=NextNode.next;
	      }
	      return NextNode;
   }
	

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{	
		// TODO: Implement this method
		
		// TODO: Implement this method
				if(element==null){
				throw new NullPointerException("Element must not be null");	
				}
		
	      LLNode<E> NextNode = this.getNode(index);
	    
	      LLNode<E> thisNode = new LLNode<E>(element);
	      thisNode.next=NextNode;
	      thisNode.prev=NextNode.prev;
	      NextNode.prev.next=thisNode;
	      NextNode.prev=thisNode;
	      this.size++;
	      	
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		 LLNode<E> NodeAtIndex = this.getNode(index);
	      
	      E value = NodeAtIndex.data;
	      NodeAtIndex.prev.next = NodeAtIndex.next;
	      NodeAtIndex.next.prev=NodeAtIndex.prev;
	      NodeAtIndex=null;
	      this.size--;
		
		return value;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element==null){
		throw new NullPointerException("Element must not be null");	
		}
		 LLNode<E> NodeAtIndex = this.getNode(index);
		 NodeAtIndex.data=element;
		return NodeAtIndex.data;
				
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	public LLNode(Integer type,E e,LLNode<E> HeadOrTailNode){
		this(e);
	if(type==0){//addding node at end of linklist
		this.prev=HeadOrTailNode.prev;
		this.next=HeadOrTailNode;
		this.prev.next=this;
		this.next.prev=this;
	}
	else if(type==1){// adding node at beginning of link list
		this.next=HeadOrTailNode.next;
		this.prev=HeadOrTailNode;
		HeadOrTailNode.next=this;
		this.next.prev=this;
		
	}
	else{
		//do nothing
	}
	}
          
}
