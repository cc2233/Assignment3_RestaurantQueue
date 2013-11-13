import java.util.Iterator;


public class LinkedList<T> implements Iterator<T> 
{
        Node front,rear;
        
        public LinkedList() 
        {
                front = null;
                rear = null;
        }

        @Override
        public boolean hasNext() 
        {
            Node next = null;

            if(!isEmpty()) 
            {
                return true;
            }
            return next!=rear;
                
                
        }

        @Override
        public T next() 
        { 
            return null;
        }

        @Override
        public void remove() 
        {
               
                
        }
        
        public boolean isEmpty() 
        {
            return front==null;
        }
}