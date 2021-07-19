
package list_doble;

public class DoubleList {
    
    private DoubleNode first;
    private DoubleNode last;

    public DoubleList() {
    }
    
    public boolean isEmpty()
    {
        return first==null && last == null;
    }
    
    public void AddFirst(Object data)
    {
        if(isEmpty())
        {
            first = new DoubleNode(data);
            last = first;
        }
        else
        {
            DoubleNode n = new DoubleNode(data);
            first.setPrevious(n);
            n.setNext(first);
            first = n;
        }
    }
    
    @Override
    public String toString()
    {
        String text="";
        DoubleNode aux = first;
        while(aux != null)
        {
            text = text + aux.getData() + "\n";
            aux = aux.getNext();
        }
        return text;
    }
    
    public void AddLast(Object data)
    {
        if(isEmpty())
            AddFirst(data);
        else
        {
            DoubleNode n = new DoubleNode(data);
            last.setNext(n);
            n.setPrevious(last);
            last=n;
        }
    }
    
    public int Size()
    {
        int counter = 0;
        DoubleNode aux = last;  //DoubleNode aux = first
        while(aux!=null)
        {
            counter++;
            aux = aux.getPrevious(); //aux = aux.getNext();
        }
        return counter;
    }

    //insertar en una posición determinada, garantizando que posicion sea valida
    public void Add(Object data, int pos)
    {
        if(pos == 1)
            AddFirst(data);
        else
        {
            if(pos == Size()+1)
                AddLast(data);
            else
            {
                DoubleNode aux = first;
                int counter=1;
                //recorremos buscando la posicion en la que vamos a insertar
                while(aux!=null && counter<pos)
                {
                    aux = aux.getNext();
                    counter++;
                }
                DoubleNode n = new DoubleNode(data);
                n.setNext(aux);
                n.setPrevious(aux.getPrevious());
                aux.getPrevious().setNext(n);
                aux.setPrevious(n);
            }
        }
    }
    
    public void Add(Object data)
    {
        DoubleNode aux = first;
        while(aux!=null  && ((String)data).compareTo((String)aux.getData())>0)
            aux = aux.getNext();
        
        if(aux!=null)
        {
            if(aux.getPrevious()!=null)
            {
                DoubleNode n = new DoubleNode(data);
                n.setNext(aux);
                n.setPrevious(aux.getPrevious());
                aux.getPrevious().setNext(n);
                aux.setPrevious(n);
            }
            else
                AddFirst(data);
        }
        else
            AddLast(data);
    }
    
    public boolean RemoveFirst()
    {
        if(!isEmpty())
        {
            first = first.getNext();
            if(first == null)
                last = null;
            else
                first.setPrevious(null);
            
            return true;
        }
        return false;
    }
    
    public boolean RemoveLast()
    {
        if(!isEmpty())
        {
            last = last.getPrevious();
            if(last == null)
                first = null;
            else
                last.setNext(null);
            
            return true;
        }
        return false;
    }

    public boolean Remove(int pos)
    {
        if(!isEmpty())
        {
            if(pos==1)
                RemoveFirst();
            else
            {
                if(pos==Size())
                    RemoveLast();
                else
                {
                    int cont=1;
                    DoubleNode aux = first;
                    while(cont<pos){
                        aux=aux.getNext();
                        cont++;
                    }
                    aux.getPrevious().setNext(aux.getNext());
                    aux.getNext().setPrevious(aux.getPrevious());
                }
            }
            return true;
        }
        
        return false;
    }
    
    public boolean Remove(String name)
    {
        DoubleNode aux = first;
        while(aux!=null && !((String)aux.getData()).equalsIgnoreCase(name))
            aux=aux.getNext();
        
        if(aux!=null)  //se encontró el elemento
        {
            if(aux.getPrevious()==null) //preguntamos si es el primero
                RemoveFirst();
            else
            {
                if(aux.getNext()==null) //preguntamos si es el ultimo
                    RemoveLast();
                else
                {
                    aux.getPrevious().setNext(aux.getNext());
                    aux.getNext().setPrevious(aux.getPrevious());
                }
            }
            return true;
        }
        return false;
    }
}
