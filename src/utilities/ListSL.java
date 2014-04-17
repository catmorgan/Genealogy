package utilities;

public class ListSL<D> {
    protected int count;
    protected ListElementSL<D> head;
    
    public ListSL() {
        head = null;
        count = 0;
    }
    
    public void add(D data) {
        addToHead(data);
    }
    
    public void addToHead(D data) {
        head = new ListElementSL<D>(data, head);
        count++;
    }
    
    public D removeFromHead() {
        ListElementSL<D> temp = head;
        head = head.next();
        count--;
        return temp.data();
    }
    
    public void addToTail(D data) {
        ListElementSL<D> temp = new ListElementSL<D>(data,null);
        if (head != null) {
            ListElementSL<D> current = head;
            while (current.next() != null) {
                current = current.next();
            }
            current.setNext(temp);
        } else head = temp;
        count++;
    }
    
    public D removeFromTail() {
        ListElementSL<D> current = head;
        ListElementSL<D> previous = null;
        while (current.next() != null) {
            previous = current;
            current = current.next();
        }
        if (previous == null) {
            head = null;
        } else {
            previous.setNext(null);
        }
        count--;
        return current.data();
    }
    
    public D headPeek() {
        return head.data();
    }
    
    public D tailPeek() {
        ListElementSL<D> current = head;
        while (current.next() != null) {
            current = current.next();
        }
        return current.data();
    }
    
//    public boolean contains(D data) {
//        ListElementSL<D> current = head;
//        while (current != null && !current.data().equals(data)) {
//            current = current.next();
//        }
//        return current != null;
//    }
    
    public boolean contains(D data) {
        return containsHelper(data,head);
    }   
    
    private boolean containsHelper(D data, ListElementSL<D> node) {
        if (node==null) 
            return false;
        else if (node.data().equals(data)) 
            return true;
        else return containsHelper(data,node.next());
    }
    
    public D remove(D data) {
        ListElementSL<D> current = head;
        ListElementSL<D> previous = null;
        while (current != null && !current.data().equals(data)) {
            previous = current;
            current = current.next();
        }
        if (current != null) {
            if (previous == null) {
                head = current.next();
            } else {
                previous.setNext(current.next());
            }
            count--;
            return current.data();
        }
        return null;
    }
      
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public void clear() {
        head = null;
        count = 0;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
//        s.append("<ListSL: ");
        ListElementSL<D> current = head;
        while (current!=null) {
            s.append(" "+current.data()+" ");
            current = current.next();
        }
//        s.append(">");
        return s.toString();
    }
}





