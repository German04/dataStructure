/* 
 * StringRecursion.java
 * 
 * Author:          Nicolas Rannou
 * Date modified:   Fall 2011
 */

import java.util.*;

public class StringRecursion {

    /**
     * Print letters recursivelly. The comma might have to be handled in a better way.
     * @param str
     */
    public static void printLetters(String str){
        if(str == null)
          return;

        //check if string is empty
        if(str.length() <= 1){
          System.out.print(str + "\n");
          return;
        }
        
        // if not empty, print first letter of the string then remove it
        System.out.print(str.charAt(0) + ", ");
        String substring = str.substring(1);
        printLetters(substring);
    }
    
    /**
     * Print letters recursivelly. The comma might have to be handled in a better way.
     * @param str
     */
    
    public static int indexOf(char ch, String str){
        if(str == null || str.equals("")){
            return -1;
        }

        if(ch == str.charAt(0))
            return 0;
        
        int recursiveIndex = indexOf(ch, str.substring(1));
        
        if( recursiveIndex == -1){
            return -1;
            }
        else{
            return recursiveIndex +1;
            }
    }
    
    /**
     * Print letters recursivelly. The comma might have to be handled in a better way.
     * @param str
     */
    
    public static String replace(String str, char oldChar, char newChar){
        // base case
        if(str == null || str.equals("")){
            return "";
        }
        
        if(Character.toString(oldChar) == null)
            return "";
        
        String newString = replace(str.substring(1), oldChar, newChar);
        if(str.charAt(0) == oldChar){
            return newChar + newString;
        }
        else{
            return str.charAt(0) + newString;
        }
    }
    
    public static void main(String[] args) {
    	// RABBIT
        System.out.println("*************************");
        System.out.println("\"Rabbit\"");
        System.out.println("*************************");
        System.out.println("Spelling \"Rabbit\"");
        printLetters("Rabbit");
        int index = indexOf('i', "Rabbit");
        System.out.println("Index Of \"i\" in \"Rabbit\" is:" + index);
        String stringReplace = replace("Rabbit", 'b', 'p');
        System.out.println("Replace \"b\" by \"p\" in \"Rabbit\": " + stringReplace);
        
        // I LIKE TO RECURSE
        System.out.println("*************************");
        System.out.println("\"I like to recurse!\"");
        System.out.println("*************************");
        System.out.println("Spelling \"I like to recurse!\"");
        printLetters("I like to recurse!");
        index = indexOf('P', "I like to recurse!");
        System.out.println("Index Of \"P\" in \"I like to recurse!\" is:" + index);
        stringReplace = replace("I like to recurse!", 'b', 'p');
        System.out.println("Replace \"b\" by \"p\" in \"I like to recurse!\": " + stringReplace);
        
        // ""
        System.out.println("*************************");
        System.out.println("\"\"");
        System.out.println("*************************");
        System.out.println("Spelling \"\"");
        printLetters("");
        index = indexOf('f', "");
        System.out.println("Index Of \"f\" in \"\" is:" + index);
        stringReplace = replace("", 'b', 'p');
        System.out.println("Replace \"b\" by \"p\" in \"\": " + stringReplace);
        
        
    }
}