package utilities;

public class PriorityQueueListSL<D extends Comparable<D>> implements PriorityQueue<D> {
    
    private ListElementSL<D> head;
    
    public PriorityQueueListSL() {
        this.head = null;
    }
    
    public boolean isEmpty() { return head==null; }
    
    public D insert(D item) {
        head = insertHelper(item, head);
        return item;
    }
    
    private ListElementSL insertHelper(D item, ListElementSL<D> head) {
        if (head==null || item.compareTo(head.data())<=0)
            return new ListElementSL(item,head);
        else {
            head.setNext(insertHelper(item,head.next()));
            return head;
        }
    }      
    
    public D delete() {
        D data = head.data();
        head = head.next();
        return data;
    }
    
    public D min(){
        return head.data();        
    }
   
    
}
