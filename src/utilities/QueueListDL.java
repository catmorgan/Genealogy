package utilities;

public class QueueListDL<D> implements Queue<D> {

    private ListDL<D> contents;

    public QueueListDL() {
        contents = new ListDL<D>();
    }

    public boolean isEmpty() {
        return contents.isEmpty();
    }
    
    public D front() {
        return contents.headPeek();
    }    

    public D enQueue(D item) {
        contents.addToTail(item);
        return item;
    }

    public D deQueue() {
        D temp = contents.headPeek();
        contents.removeFromHead();
        return temp;
    }

}
