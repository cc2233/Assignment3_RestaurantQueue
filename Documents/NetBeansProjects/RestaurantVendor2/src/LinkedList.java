public class LinkedList <T> implements LinkedListInterface <T>{

    public LinkedListNode <T> list;
    public String name;
    public int count=0;

    public LinkedList() 
    {
        this.name = "Linked List";
	list = null;
    }

    public LinkedList(String name) 
    {
	this.name = name;
	list = null;
    }

		
    public void add(T element) 
    {
	// add first element
	LinkedListNode <T> newNode = new LinkedListNode<T>(element, list);
	list = newNode;
	count++;
    }

		
    public T remove(T elememt) 
    {
	count--;
	return null;
    }


    public T pop() 
    {
	T temp = list.getElement();
	list = list.getLink();
	count--;
	return temp;
    }


    public boolean contains(T element) 
    {
	LinkedListNode<T> current = list;
	if (!isEmpty()) 
	{
            while (current != null) 
            {
		if (current.getElement().equals(element))
		return true;
		current = current.getLink();
            }
	}
	return false;
    }

		
    public boolean isEmpty() 
    {
	return list==null;
    }

    public String getName() 
    {
	return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int size() 
    {
        return this.count;
    }

    public String toString() 	
    {
	String out = "";
	LinkedListNode<T> temp;
	temp = list;
	while (temp != null) 
        {
            out += temp.getElement() + "\n";
            temp = temp.getLink();
	}
        return out;
    }

		
}