package utilities;

public class ListElementSL<D> {
    protected D data;
    protected ListElementSL<D> next;
    
    public ListElementSL(D data) {
        this(data,null);
    }
    
    public ListElementSL(D data, ListElementSL<D> next) {
        this.data = data;
        this.next = next;
    }
    
    public ListElementSL next() {
        return next;
    }
    
    public void setNext(ListElementSL<D> next) {
        this.next = next;
    }
    
    public D data() {
        return data;
    }
    
    public void setData(D data) {
        this.data = data;
    }
    
    public String toString() {
        return "<ListElementSL: "+data()+">";
    }
}

