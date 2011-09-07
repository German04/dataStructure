import com.sun.org.apache.xpath.internal.operations.Bool;

/* 
 * Bag.java
 * 
 * Author:          Computer Science S-111 staff
 * Modified by:     <your name>, <your e-mail address>
 * Date modified:   <current date>
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
    int numItems();

    /**
     * grab - returns a reference to a randomly chosen in the Bag.
     */
    Object grab();

    /**
     * toArray - return an array containing the current contents of the bag
     */
    Object[] toArray();
    
    /**
     * returns the number of additional items that the ArrayBag has 
     * room to store. For example, if the maximum size of the bag is 10 and there are 
     * currently 7 items in the bag, this method should return 3, since the bag has room 
     * for 3 more items. Hint: This method should only need one or two lines of code.
     * @return int room left in the bag
     */
    int roomLeft();
    
    /**
     * boolean isEmpty() Ð returns  true if the  ArrayBag is empty, and  false
     * otherwise 
     * @return bool true if the  ArrayBag is empty, and  false
     * otherwise 
     */
    boolean isEmpty();
} 
