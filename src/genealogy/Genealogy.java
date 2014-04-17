package genealogy;
import acm.program.*;
import utilities.*;

public class Genealogy extends ConsoleProgram { 
   
   BirthRecord gwa = new BirthRecord ("George Washington", 1732);
   BirthRecord father = new BirthRecord ("Augustine Washinton", 1693);
   BirthRecord mother = new BirthRecord ("Mary Ball", 1708);
   BirthRecord fgfa= new BirthRecord("Lawrence Washington", 1659);
   BirthRecord fgma= new BirthRecord ("Mildred Warner", 1670);
   BirthRecord mgfa = new BirthRecord ("Joseph Ball", 1649);
   BirthRecord mgma = new BirthRecord("Mary Johnson", 1655);
   
  BTree<BirthRecord> genealogy = new BTree 
          (gwa, 
          new BTree(father, new BTree (fgfa, null, null), new BTree (fgma, null, null)),
          new BTree (mother, new BTree (mgfa, null, null), new BTree (mgma, null, null)));
          

    public void queueOrderPrint(BTree<BirthRecord> bTree) {
        Queue<BTree<BirthRecord>> theQueue = new QueueListDL<BTree<BirthRecord>>();
        theQueue.enQueue(bTree);
        while (!theQueue.isEmpty()) {
            BTree<BirthRecord> bT = (BTree) theQueue.deQueue();
            println(bT.data.getName() + " " + bT.data.getBirthYear() + " ");
            if (bT.left != null) {
                theQueue.enQueue(bT.left);
            }
            if (bT.right != null) {
                theQueue.enQueue(bT.right);
            }
        }
    }

    public void priorityQueueOrderPrint(BTree<BirthRecord> bTree) {
        PriorityQueue<BTree<BirthRecord>> theQueue = new PriorityQueueListSL<BTree<BirthRecord>>();
        theQueue.insert(bTree);
        while (!theQueue.isEmpty()) {
            BTree<BirthRecord> bT = (BTree) theQueue.delete();
            println(bT.data.getName() + " " + bT.data.getBirthYear() + " ");
            if (bT.left != null) {
                theQueue.insert(bT.left);
            }
            if (bT.right != null) {
                theQueue.insert(bT.right);
            }
        }
    }
     
 
    public void run() {
        println("Washington's Ancestors Ordered Backwards by Generation: ");
        queueOrderPrint(genealogy);
        println();
        println("Washington's Ancestors Ordered Backwards by Birth Year: ");
        priorityQueueOrderPrint(genealogy);
    }

    public static void main(String[] args) {
        new Genealogy().start();
    }
    
}
