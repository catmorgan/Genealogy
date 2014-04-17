package utilities;

class ListElementDL<D> {

    protected D data;
    protected ListElementDL<D> next;
    protected ListElementDL<D> previous;

    ListElementDL(D d, ListElementDL<D> n, ListElementDL<D> p) {
        data = d;
        next = n;
        previous = p;
        if (next != null) {
            next.previous = this;
        }
        if (previous != null) {
            previous.next = this;
        }
    }

    ListElementDL(D d) {
        this(d, null, null);
    }

    ListElementDL<D> next() {
        return next;
    }

    ListElementDL<D> previous() {
        return previous;
    }

    D data() {
        return data;
    }

    void setNext(ListElementDL<D> n) {
        next = n;
    }

    void setPrevious(ListElementDL<D> p) {
        previous = p;
    }

    void setValue(D data) {
        data = data;
    }

    public String toString() {
        return "<ListElementDL: " + data() + ">";
    }
}
