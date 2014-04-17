package utilities;

public class ListDL<D> implements List<D> {

    protected int count;
    protected ListElementDL<D> head;
    protected ListElementDL<D> tail;

    public ListDL() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(D data) {
        addToHead(data);
    }

    public void addToHead(D data) {
        ListElementDL<D> temp = new ListElementDL<D>(data, head, null);
        if (head != null) {
            head.previous = temp;
        }
        head = temp;
        if (tail == null) {
            tail = head;
        }
        count++;
    }

    public D removeFromHead() {
        ListElementDL<D> temp = head;
        head = head.next();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }
        temp.setNext(null);
        count--;
        return temp.data();
    }

    public void addToTail(D data) {
        ListElementDL<D> temp = new ListElementDL<D>(data, null, tail);
        if (tail != null) {
            tail.next = temp;
        }
        tail = temp;
        if (head == null) {
            head = tail;
        }
        count++;
    }

    public D removeFromTail() {
        ListElementDL<D> temp = tail;
        tail = tail.previous();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        count--;
        return temp.data();
    }

    public D headPeek() {
        return head.data();
    }

    public D tailPeek() {
        return tail.data();
    }

    public boolean contains(D data) {
        ListElementDL<D> current = head;
        while ((current != null) && (!current.data().equals(data))) {
            current = current.next();
        }
        return current != null;
    }

    public D remove(D data) {
        ListElementDL<D> current = head;
        while (current != null
                && !current.data().equals(data)) {
            current = current.next();
        }
        if (current != null) {
            if (current.previous() != null) {
                current.previous().setNext(current.next());
            } else {
                head = current.next();
            }
            if (current.next() != null) {
                current.next().setPrevious(current.previous());
            } else {
                tail = current.previous();
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
        head = tail = null;
        count = 0;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("<ListDL:");
        ListElementDL<D> current = head;
        while (current!=null) {
            s.append(" "+current.data());
            current = current.next();
        }
        s.append(">");
        return s.toString();
    }

    public void insert(D d, int index) {
        ListElementDL<D> newElement = new ListElementDL<D>(d);
        if (count == 0) {
            head = newElement;
            tail = newElement;
        } else if (count == index) {
            newElement.setPrevious(tail);
            tail.setNext(newElement);
            tail = newElement;
        } else {
            int currentIndex = 0;
            ListElementDL<D> currentElement = head;
            while (currentIndex < index) {
                currentElement = currentElement.next();
                currentIndex++;
            }
            ListElementDL<D> previousElement = currentElement.previous();
            newElement.setNext(currentElement);
            currentElement.setPrevious(newElement);
            newElement.setPrevious(previousElement);
            if (previousElement != null) {
                previousElement.setNext(newElement);
            } else {
                head = newElement;
            }
        }
        count ++;
    }

    public void delete(int index) {
        int currentIndex = 0;
        ListElementDL<D> currentElement = head;
        while (currentIndex < index) {
            currentElement = currentElement.next();
            currentIndex++;
        }
        if (currentElement.next() != null) {
            currentElement.next().setPrevious(currentElement.previous());
        } else {
            tail = currentElement.previous();
        }
        if (currentElement.previous() != null) {
            currentElement.previous().setNext(currentElement.next());
        } else {
            head = currentElement.next();
        }
        count--;
    }

    public D elementAt(int index) {
        int currentIndex = 0;
        ListElementDL<D> currentElement = head;
        while (currentIndex < index) {
            currentElement = currentElement.next();
            currentIndex++;
        }
        return currentElement.data();
    }
}





