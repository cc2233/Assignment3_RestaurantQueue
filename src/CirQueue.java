import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


public class CirQueue<T> implements Queue<T> {

        Node mHead, mTail;
        public int mSize;
        
        public CirQueue() 
        {
                mTail = null;
                mSize = 0;
        }
        
        
        public void enqueue(T element)
        {
        	
        	Node<T> newTail = new Node<T>(element, null);
        	//if queue is empty
        	if(mTail == null)
        	{
        		mHead = newTail;
        		mSize = 1;
        	}
        	else
        	{
        		mTail.setLink(newTail);
        		mSize++;
        	}
        	
        	mTail = newTail;
        	
        }
        
        public T dequeue() throws QueueUnderflowException
        { 
        	//if queue is empty
        	if(mHead == null)
        	{
        		throw new QueueUnderflowException("Queue is empty!");
        	}
        	
        	Node<T> mCopyHead = mHead; //copying mHead
        	
        	//if last in queue
        	if(mHead == mTail)
        	{
        		mHead.setLink(null);
        		mTail.setLink(null);
        		mSize = 0;
        	}
        	else
        	{
        		
        		mHead = mHead.getLink();
        		mSize--;
        	}
        	mCopyHead.setLink(null);
        	
        	return mCopyHead.getData();
        }
        
        public Node<T> find(String searchFor)
        {
        	Node<T> iter = mHead;
        	if(iter==null)
        	{
        		return null;
        	}
        	
        	for(;iter!=null;iter=iter.getLink())
        	{
        		if(iter.getData().equals(searchFor))
        		{
        			return iter;
        		}
        		if(iter==mTail)
        			break;
        	}
        	
        	return null;
        }
        
        
        @Override
        public boolean addAll(Collection<? extends T> arg0) 
        {
                // TODO Auto-generated method stub
                return false;
        }

        @Override
        public void clear() 
        {
                // TODO Auto-generated method stub
                
        }

       
        @Override
        public boolean containsAll(Collection<?> arg0) 
        {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isEmpty() 
        {
            
            return mTail==null;
        }

        @Override
        public Iterator<T> iterator() 
        {
            // TODO Auto-generated method stub
            return null;
        }


        public Node<T> removeNode(Node<T> toRemove, Node<T> prev)
        {
        	//case no prev ---> toRemove must be mHead
        	if( toRemove == mHead)
        	{
        		//it is also the tail
        		if(toRemove == mTail)
        		{
        			mHead = null;
        			mTail = null;
        		}
        		// its not the tail
        		else
        		{
        			mHead = mHead.getLink();
        		}
        	}//case where toRemove is mTail
        	else if(toRemove == mTail)
        	{
        		mTail = prev;
        		mTail.setLink(null);        		
        	}//case where toRemove is in the middle
        	else
        	{
        		prev.setLink(toRemove.getLink());
        	}
        	
        	--mSize;
			toRemove.setLink(null);
			return toRemove;
        }
        
        public Node<T> remove(String searchFor) 
        {
        	Node<T> iter = mHead;
        	Node<T> prev = null;
            
            while (iter != null) 
            {
                if(iter.getData().equals(searchFor))
                {
                	return removeNode(iter, prev);
                }
                else
                {
	                prev = iter;
	                iter = iter.getLink();
                }
            }
            return null;
        }
        
        public String toString()
        {
        	String ret = "";
        	Node<T> iter = mHead;

        	for(;iter!=null;iter=iter.getLink())
            {
                ret = ret + iter.getData().toString() + ",";
            }
        	return ret;
        }

        public boolean hasNext(Node<T> current)
        {
        	if(mHead==mTail)
        	{
        		return false;
        	}
        	
        	return current.getLink()!=null;

        }
        
        public Node<T> next(Node<T> current) throws QueueUnderflowException
        {
        	if(!hasNext(current))
        	{
        		throw new QueueUnderflowException();
        	}
        	
        	return current.getLink();
        }
        
        @Override
        public boolean removeAll(Collection<?> arg0) 
        {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> arg0) 
        {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public int size() 
        {
            return mSize;
        }

        @Override
        public Object[] toArray() 
        {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public <T> T[] toArray(T[] arg0) 
        {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean add(T arg0) 
        {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public T element() 
        {
            // TODO Auto-generated method stub
            return null;
        }

       

        @Override
        public T peek() 
        {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public T poll() 
        {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public T remove() 
        {
                // TODO Auto-generated method stub
                return null;
        }

        


		@Override
		public boolean contains(Object arg0) {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public boolean offer(T e) {
			// TODO Auto-generated method stub
			return false;
		}

}