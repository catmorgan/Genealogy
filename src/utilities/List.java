package utilities;

public interface List<D> {
   void add(D data);
   D remove (D data);
   boolean contains(D data);
   int size();
   boolean isEmpty();
   void clear();
   String toString();
   void insert(D d, int index);
   void delete(int index);
   D elementAt(int index);
}