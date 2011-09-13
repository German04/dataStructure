/* 
 * MagicSquare.java
 * 
 * Author:          Computer Science S-111 staff
 * Modified by:     Nicolas Rannou, huko.rannou@gmail.com
 * Date modified:   Fall 2011
 */

import java.util.*;

public class MagicSquare {
    // the current contents of the cells of the puzzle values[r][c]
    // gives the value in the cell at row r, column c
    private int[][] values;

    // the order (i.e., the dimension) of the puzzle
    private int order;
    
    // numbers to be assigned
    // list might be more efficient to remove index
    private int[] tobeassigned;

    /**
     * Creates a MagicSquare object for a puzzle with the specified
     * dimension/order.
     */
    public MagicSquare(int order) {
        values = new int[order][order];
        this.order = order;

        // Add code to this constructor as needed to initialize
        // the fields that you add to the object.
        System.out.println("to be assigned: ");
        tobeassigned = new int[order*order];
        for(int i=1; i<order*order+1; i++){
          tobeassigned[i-1] = i;
          System.out.println(tobeassigned[i-1]);
        }
    }

    /**
     * This method should call the separate recursive-backtracking method
     * that you will write, passing it the appropriate initial parameter(s).
     * It should return true if a solution is found, and false otherwise.
     */
    public boolean solve() {
        return findSolutions(0, tobeassigned);
    }
    
    /**
     * Backtracking method
     */
    
    private boolean findSolutions( int position, int[] param){
        
        if(position == order*order){
          return true;
        }
        
        // go though parameters
        for(int i=0; i<param.length; i++){
          if(isSafe(position, param[i])){
            // place number
            placeNumber(position, param[i]);
            
            // not efficient to use array...?
            // very time consuming
            // create new array without parameter
            int[] new_param = new int[param.length -1];
            int pos = 0;
            for(int j=0; j<param.length; j++){
              if(param[j] != param[i]){
                new_param[pos] = param[j];
                ++pos;
              }
            }
            
            // recursive call
            boolean success = findSolutions(position+1, new_param);
            
            // if we reach the end, return true, else loop....
            if(success){
              return success;
            }
            else{
              removeNumber(position);
            }
            
          }
        }
        return false;
    }
    
    /**
     * Check if location is safe
     * @param position
     * @param value
     * @return
     */
    private boolean isSafe(int position, int value){
      //
      int magicSum = (order*order*order + order)/2;
      
      int max_column = position/order;
      int max_row = position%order;
      
      //check sum < number
      // in columns
      for(int i=0; i<max_column; i++){
        int sum = 0;
        for(int j=0; j<max_row; j++){
          sum += values[i][j];
        }
        sum+= value;
        
        if(sum > magicSum)
          return false;
      }
    
      // in rows
      for(int i=0; i<max_column; i++){
        int sum = 0;
        for(int j=0; j<max_row; j++){
          sum += values[j][i];
        }
        sum += value;
        
        if(sum > magicSum)
          return false;
      }
      
      return true;
    }
    
    /**
     * Add number if location is safe
     * @param position
     * @param value
     */
    private void placeNumber(int position, int value){
      // add value in array
      values[position/order][position%order] = value;
      }

    private void removeNumber(int position){
        // add value in array
        values[position/order][position%order] = 0;
        }
    
    /**
     * Displays the current state of the puzzle.
     * You should not change this method.
     */
    public void display() {
        for (int r = 0; r < order; r++) {
            printRowSeparator();
            for (int c = 0; c < order; c++) {
                System.out.print("|");
                if (values[r][c] == 0)
                    System.out.print("   ");
                else {
                    if (values[r][c] < 10) {
                        System.out.print(" ");
                    }
                    System.out.print(" " + values[r][c] + " ");
                }
            }
            System.out.println("|");
        }
        printRowSeparator();
    }

    // A private helper method used by display()
    // to print a line separating two rows of the puzzle.
    private void printRowSeparator() {
        for (int i = 0; i < order; i++)
            System.out.print("-----");
        System.out.println("-");
    }
    
    public static void main(String[] args) {
        /*******************************************************
          **** You should NOT change any code in this method ****
          ******************************************************/

        Scanner console = new Scanner(System.in);
        System.out.print("What order Magic Square would you like to solve? ");
        int order = console.nextInt();
        
        MagicSquare puzzle = new MagicSquare(order);
        if (puzzle.solve()) {
            System.out.println("Here's the solution:");
            puzzle.display();
        } else {
            System.out.println("No solution found.");
        }
    }
}