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
    
    /**
     * Print letters recursivelly. The comma might have to be handled in a better way.
     * @param str
     */
    
    public static int indexOf(char ch, String str){
        
        if(str.length() <= 0){
            return -1;
        }
        
        //check if string is empty, nothing has been found (or nothing can be found)
        if(ch == str.charAt(0)){
            return 0;
        }
        // recursion
        else{
            int index = 1;
            String substring = str.substring(1, str.length());
            // not sure if it is the best way to do it,
            // in case we reach the end of the string without finding the character
            if(indexOf(ch, substring) == -1){
                return -1;
            }
            return index += indexOf(ch, substring);
            }
    }
    
    /**
     * Print letters recursivelly. The comma might have to be handled in a better way.
     * @param str
     */
    
    public static String replace(String str, char oldChar, char newChar){
        // check old and new char
        if(str.isEmpty()){
            return "";
        }
        
        //if(oldChar == null)
        //    return "";
        
        // modify first character
        String firstCharacter = str.substring(0, 1);
        if(firstCharacter.equals(Character.toString(oldChar))){
            firstCharacter = Character.toString(newChar);
        }
        
        String otherCharacters = str.substring(1, str.length());
        firstCharacter += replace(otherCharacters, oldChar, newChar);
        
        return firstCharacter;
    }
    
    public static void main(String[] args) {
        System.out.println("Spelling \"Rabbit\"");
        printLetters("Rabbit");
        int index = indexOf('i', "Rabbit");
        System.out.println("Index Of \"i\" in \"Rabbit\" is:" + index);
        String stringReplace = replace("Rabbit", 'b', 'p');
        System.out.println("Replace \"b\" by \"p\" in \"Rabbit\": " + stringReplace);
        System.out.println("Spelling \"I like to recurse!\"");
        printLetters("I like to recurse!");
        index = indexOf('P', "I like to recurse!");
        System.out.println("Index Of \"P\" in \"I like to recurse!\" is:" + index);
        System.out.println("Spelling \"\"");
        printLetters("");
        index = indexOf('f', "");
        System.out.println("Index Of \"f\" in \"\" is:" + index);
        
        
    }
}