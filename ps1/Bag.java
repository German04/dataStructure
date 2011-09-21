import com.sun.org.apache.xpath.internal.operations.Bool;

/* 
 * Bag.java
 * 
 * Author:          Computer Science S-111 staff
 * Modified by:     Nicolas Rannou, huko.rannou@gmail.com
 * Date modified:   Fall 2011
 */

/**
 * An interface for a Bag ADT.
 */
public interface Bag {
    /** 
     * adds the specified item to the Bag.  Returns true on success
     * and false if there is no more room in the Bag.
     */
    boolean add(Object item);

    /** 
     * removes one occurrence of the specified item (if any) from the
     * Bag.  Returns true on success and false if the specified item
     * (i.e., an object equal to item) is not in the Bag.
     */
    boolean remove(Object item);

    /**
     * returns true if the specified item is in the Bag, and false
     * otherwise.
     */
    boolean contains(Object item);

    /**
     * returns true if the calling object contain all of the items in
     * otherBag, and false otherwise.  Also returns false if otherBag 
     * is null or empty. 
     */
    boolean containsAll(Bag otherBag);

    /**
     * returns the number of items in the Bag.
     */
    Integer numItems();

    /**
     * grab - returns a reference to a randomly chosen in the Bag.
     */
    Object grab();

    /**
     * toArray - return an array containing the current contents of the bag
     */
    Object[] toArray();
    
    Integer roomLeft();
    
    Integer capacity();
    
    boolean isEmpty();
    
    boolean isFull();
    
    void increaseCapacity(Integer increment);
    
    boolean removeItems(Bag otherBag);
    
    Bag unionWith(Bag otherBag);
} 
