/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genealogy;

/**
 *
 * @author catherinemorgan
 */
public class BirthRecord implements Comparable<BirthRecord>{
    private String name;
    private int birthYear;
    
    public BirthRecord (String name, int birthYear) {
        this.name= name;
        this.birthYear=birthYear;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBirthYear() {
        return birthYear;
    }
    
    public int compareTo(BirthRecord other) {
        if (this.birthYear > other.birthYear) {
            return -1;
        }
        else if (this.birthYear == other.birthYear) {
        return 0;
        }
        
        else return 1;
        
    }
    
}
