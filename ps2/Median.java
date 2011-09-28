/*
 * Median.java
 *
 * Author:          <your name>, <your e-mail address>
 * Date modified:   <current date>
 */

public class Median {
    /* partition - helper method for your recursive median-finding method */
    private static int partition(int[] arr, int first, int last) {
        int pivot = arr[(first + last)/2];
        int i = first - 1;  // index going left to right
        int j = last + 1;   // index going right to left
        
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot); 
            
            if (i < j)
                Sort.swap(arr, i, j);
            else
                return j;   // index of last element in the left subarray
        }                   
    }
    
    /* 
     * findMedian - "wrapper" method for your recursive median-finding method.
     * It just makes the initial call to that method, passing it
     * whatever initial parameters make sense.
     */
    public static void findMedian(int[] arr) {
        // add an appropriate call to your recursive
    }
    
    /* 
     * Put the definition of your recursive median-finding method below. 
     */
    
    
    
    public static void main(String[] args) {
        // the median of this array is 15
        int[] oddLength = {4, 18, 12, 34, 7, 42, 15, 22, 5};
        
        // the median of this array is the average of 15 and 18 = 16.5
        int[] evenLength = {4, 18, 12, 34, 7, 42, 15, 22, 5, 27};
        
        
        /* Put code to test your method here. */
        
    }
}

