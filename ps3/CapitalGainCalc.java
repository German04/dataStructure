/*
 * CapitalGainCalc.java
 *
 * Modified by:     <your name>, <your e-mail address>
 * Date modified:   <current date>
 */

import java.util.*;

/**
 * A class for calculating capital gains on stock sales.
 */
public class CapitalGainCalc {
    /* 
     * An inner class for storing information about a stock purchase.
     */
    private class Purchase {
        private int numShares;
        private int price;

        Purchase(int numShares, int price) {
            this.numShares = numShares;
            this.price = price;
        }
    }

    /* Put your instance variables below */
    private Queue<Integer> capital;
    private int totalNumShares;

    public CapitalGainCalc() {
        this.capital = new LLQueue<Integer>();
        this.totalNumShares = 0;

    }

    public void processPurchase(int numShares, int price) {
    	// Add to capital
    	for(int i=0; i<numShares; i++){
    		this.capital.insert(price);
    		totalNumShares++;
    	}
    }

    public int processSale(int numSharesToSell, int price) {
    	if(totalNumShares < numSharesToSell)
    		throw new IllegalArgumentException("** You don't have " + numSharesToSell + " shares to sell. **");
    	// Remove from capital
    	int sum = 0;
    	
    	// do sth if return null
    	for(int i=0; i<numSharesToSell; i++){
    	    sum += this.capital.remove();
    	    totalNumShares--;
    	}
    	
    	// gain: sell - bought
    	int gain = numSharesToSell*price - sum;
        return gain;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CapitalGainCalc calc = new CapitalGainCalc();
        int totalGain = 0;
        int gain = 0;

        while (true) {
            // Get the choice of operation.
            System.out.print("\n(1) purchase, (2) sale, or (3) done: ");
            int choice = scan.nextInt();
            if (choice == 3)
                break;
            if (choice != 1 && choice != 2) {
                System.err.println("Please enter 1, 2, or 3.");
                continue;
            } 

            // Get the number of shares and the price.
            System.out.print("number of shares: ");
            int numShares = scan.nextInt();
            System.out.print("price: ");
            int price = scan.nextInt();
            if (numShares <= 0 || price <= 0) {
                System.err.println("Please enter positive numbers.");
                continue;
            }

            if (choice == 1)
                calc.processPurchase(numShares, price);
            else {
                try {
                    gain = calc.processSale(numShares, price);
                    System.out.println("Capital gain on sale: $" + gain);
                    totalGain += gain;
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
        }               

        System.out.println("Total capital gain: $" + totalGain);
    }
}
