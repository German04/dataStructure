/* 
 * StringRecursion.java
 * 
 * Author:          Nicolas Rannou
 * Modified by:     <your name>, <your e-mail address>
 * Date modified:   <current date>
 */

import java.util.*;

public class StringRecursion {

    /**
     * Print letters recursivelly. The comma might have to be handled in a better way.
     * @param str
     */
    public static void printLetters(String str){
        //check if string is empty
        if(str.length() <= 0)
            return;
        // if not empty, print first letter of the string then remove it
        else{
            String firstLetter = str.substring(0, 1);
            // not sure about the best way to this comma thing...
            if(str.length() > 1){
                System.out.print(firstLetter + ", ");
            }
            else{
                System.out.print(firstLetter + "\n");
                System.out.print("Done spelling recursivelly" + "\n");
            }
        String substring = str.substring(1, str.length());
        printLetters(substring);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Spelling \"Rabbit\"");
        printLetters("Rabbit");
        System.out.println("Spelling \"I like to recurse!\"");
        printLetters("I like to recurse!");
        System.out.println("Spelling \"\"");
        printLetters("");
    }
}