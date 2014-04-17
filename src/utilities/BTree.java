package utilities;

public class BTree <D extends Comparable <D>> implements Comparable<BTree<D>> {    
    
    public D data;
    public BTree<D> left, right;
    
    public BTree(D data) {
        this(data,null,null);
    }    
    
    public BTree(D data, BTree<D> left, BTree<D> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public int compareTo(BTree<D> other) {
        return this.data.compareTo(other.data);
    }
}
