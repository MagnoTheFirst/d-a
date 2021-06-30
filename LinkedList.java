package bricks;

import java.util.Iterator;
import java.util.List;

public class LinkedList<E> extends ListBasic<E> implements List<E>
{
	Node<E> root;
	int size = 0;
	Node<E> actualNode;
	Node<E> externIteratorNode;
	
    public LinkedList()
    {
    	this.root = new Node<>();
    	root.prev = root;
    	root.next = root;
    	
    	this.actualNode = new Node<E>();
    	root.prev = root;
    	root.next = root;
    	

    }
    
    

    
    @Override
    public int size()
    {
    	return size;
    }

    @Override
    public boolean isEmpty()
    {
    	if(size == 0) 
    	{
    		return true;
    	}      
    	else 
    	{
    		return false;
    	}
        
    }
    
    @Override
    public E get(int index)
    {        	
    	Node<E> tmpActualNode = new Node<E>();
    	tmpActualNode = actualNode;
        if(index <= size() && index > -1) 
        {
    		for(int i = 0; i <= index; i++) 
    		{
    			tmpActualNode = tmpActualNode.next;	
//        		System.out.println(tmpActualNode.element + "  index: " + i);
    		}

    		return (E) tmpActualNode.element;
        }
        else 
        {
//        	System.out.println("The given index is out of range..");
        	return null;	
        }

    }


    @Override
    public E set(int index, E element)
    {
    	Node<E> tmpActualNode = new Node<E>();
    	Node<E> bufferNode = new Node<E>();
    	tmpActualNode = actualNode;
        if(index <= size() && index >= 0) 
	    {	
	    	for(int i = 0; i <= index; i++) 
	    	{
	    		actualNode = actualNode.next;
	    	}
	    		actualNode.element = element;
	    		bufferNode = actualNode;
	    		actualNode = tmpActualNode;
	    		return (E) bufferNode;
	    }
        else 
        {
        	System.out.println("The given index ist out of the existing range ");
        	return null;
        }

    }
    
    /*
     * Muss noch angepasst werden dass es die Werte vorwertsanzeigt. D:D :
     * */
    @Override
    public boolean add(E element)
    {
        if(isEmpty()) 
        {
        	Node<E> newNode = new Node<E>();
        	newNode.element = element;
        	newNode.prev = null;
        	newNode.next = null;
        	
        	actualNode = newNode;
        	root.prev = newNode;
        	root.next = null;
        	size++;
        }
        else 
        {
        	//Neues Node Element wird erzeugt. 
            Node<E> newNode = new Node<E>();

    		//Dem Node werden Element, vorheriger Node und nächster Node zugewiesen. 
            newNode.element = element;
            newNode.next = root.prev;
            newNode.prev = actualNode;

    		//Der neue Knoten wird dem acktuellen zugewiesen. 
            actualNode.next = newNode;
            actualNode = newNode;
            root.next = actualNode;
        	//Listen grösse wird pro Element um eins erhöht.
        	size++;
          //  System.out.println("Node was added to List..");
            
        }

        return true;
    }

    @Override
    public void add(int index, E element)
    {
    	Node<E> tmpActualNode = new Node<E>();
    	Node<E> newNode = new Node<E>();
    	tmpActualNode = actualNode;

    	int counter = 0;
        if(index <= size() && index > 0) 
	    {
		    	for(int i = 0; i <= index; i++) 
		    	{
		    		actualNode = actualNode.next;// nun haben wir den Knoten am gegebenem Index 
	 	    		//System.out.println(actualNode.element + "  index: " + i);
	 	    		counter = i;
		    	}
		    		//System.out.println("Counter is " + counter);
		   			newNode.element = element; //wir weisen dem neuen Knoten das Element zu dass er tragen soll
	    			newNode.next = actualNode;
	    			newNode.prev = actualNode.prev;
	    			
	    			actualNode.prev = newNode;
	    			size++;
	    			actualNode = actualNode.prev;
	    			actualNode = actualNode.prev;
	    			
	    			actualNode.next = newNode;
	    			actualNode = tmpActualNode;
//	    			System.out.println("New Element added" + " Element: " + newNode.element + " index: " + counter);
//	    			System.out.println("Last Element = " + actualNode.element);
        	}
        else if(index == 0)
        {

   			newNode.prev = actualNode;
        	actualNode = actualNode.next; //Wir springen in den neu erstellten Knoten // H index 0
        	
   			newNode.element = element; //wir weisen dem neuen Knoten das Element zu dass er tragen soll
   			newNode.next = actualNode; //der neue Knoten ist fertiggestellt. Er weist auf den prev Knoten und auf den next Knoten und entält das element. 
   			
        	//actualNode = actualNode.next; //Wir springen in den übernächjsten Knoten um den zeiger auf den neuen nächsten Knoten zu definieren.
   			actualNode.prev = newNode; //wir weisen dem übernächsten Knoten den neu erstellten Knoten als vorgänger an um die Kettte nicht zu unterbrechen. 
   			        	
        	actualNode = tmpActualNode;
        	actualNode.next = newNode; //schliesslich definieren wir den neu erstellten Knoten als Anfang der kette. 
        	size++;
        }
        else 
        {
        	System.out.println("The given index is out of range..");
        }
    }

    public void printAllElements() 
    {
    	Node<E> tmpActualNode = new Node<E>();
    	tmpActualNode = actualNode;
    	
		for(int i = 0; i < size; i++) 
		{
			actualNode = actualNode.next;
//			System.out.println("Current index: " + i + " current element: " + actualNode.element);

			
		}
		actualNode = tmpActualNode;
    }

    public boolean contains(Object o)
    {    	
    	Node<E> tmpActualNode = new Node<E>();
    	tmpActualNode = actualNode;
//    	System.out.println("test contains \nsize " + size());
    	actualNode = actualNode.next;
    	for(int i = 0; i <= size(); i++) 
    	{
    		System.out.println(i);
    		if(actualNode.element == o) 
    		{
//    			System.out.println("Its a match " + actualNode.element + " " + i);
    			actualNode = tmpActualNode;
    			return true;
    		}
    		else 
    		{
    			actualNode = actualNode.next;
    		}
    	}

    	return false;
    }

    @Override
    public E remove(int index)
    {
//    	System.out.println("Before Size " + size);
        Node<E> tmpNode = new Node<E>();
        Node<E> bufferNode = new Node<E>();
        tmpNode = actualNode;
        int counter = 0;
        if(index <= size() && index > -1)
        {
        	for(int i = 0; i <= index; i++) 
        	{
        		actualNode = actualNode.next;
//            	System.out.println("-------------------");
//            	System.out.println("Aktual index: " + counter + " Node: "+ actualNode.element);
//            	System.out.println("-------------------");
        		counter++;
        	}
        	bufferNode = actualNode;
//        	System.out.println(bufferNode.element);
        	actualNode = actualNode.prev;
//        	System.out.println(actualNode.element);
        	actualNode.next = actualNode.next.next;
//        	System.out.println(actualNode.element);
//        	System.out.println("-------------------------------");
//        	System.out.println("ActualNode befor reset = " + actualNode.element);
//        	System.out.println("-------------------------------");
        	actualNode = tmpNode;
        }
        size--;
//        System.out.println("bufferNode.element = " + bufferNode.element);
//    	System.out.println("After Size " + size);
        return bufferNode.element;
    }
    
    @Override
    public boolean remove(Object o)
    {
        // TODO
    	return false;
    }

    @Override
    public void clear()
    {
        // TODO
    }

    @Override
    public Iterator<E> iterator()
    {
    	 externIteratorNode = actualNode;
        return new LinkedListIterator();
    }
    
 // Die anderen Methoden des List-Interfaces mÃ¼ssen nicht implementiert werden.
    
///////////////////////////////////////////////////
    
   

    private static class Node<E>
    {
        E element;
        Node<E> next;
        Node<E> prev;
    }
    
    private class LinkedListIterator implements Iterator<E>
    {
       
        @Override
        public boolean hasNext()
        {
            if(actualNode.next != null) 
            {
            	return true;
            }
            else 
            {
            	return false;
        	}
        }

        @Override
        public E next()
        {
        	externIteratorNode = externIteratorNode.next;  	
//        	System.out.println("Iterator" + externIteratorNode.element);
        	return externIteratorNode.element;
        }

        
        @Override
        public void remove()
        {
           // TODO
        }
    }
    

}
