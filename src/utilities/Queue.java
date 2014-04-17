package utilities;

public interface Queue<D> {

    public boolean isEmpty();
    public D enQueue(D item);
    public D deQueue();
    public D front();
}
