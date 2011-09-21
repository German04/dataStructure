/* 
 * written_excercise.java
 * 
 * For:          Computer Science S-111 staff
 * Created by:     Nicolas Rannou, huko.rannou@gmail.com
 * Date modified:   Fall 2011
 */

import java.util.*;

public class written_exercise {

  public static void shiftRight( Integer[] arr){

  if( (arr == null) || (arr.length < 2) ){
    // don’t do anything
    return;
  }

  // keep value of the first integer
  Integer firstValue = arr[arr.length-1];

  for(Integer i=arr.length-1; i>0; --i){
    arr[i] = arr[i-1];
  }
  // put first integer at last position
  arr[0] = firstValue;
  }

  
  public static Integer indexOf( Integer[] arr1, Integer[] arr2){
  
  if( arr1 == null || arr2 == null){
    // don’t do anything
    return -1;
    }

  // go through array2, minus size of array1 + 1
  for(Integer i=0; i<arr2.length - arr1.length  + 1; ++i){
    Boolean match = true;
    Integer j = 0;
    while(match && j < arr1.length){
      // if no match, no need to compare anymore, match == false so we exit the while
      if(arr2[i+j] != arr1[j]){
        match = false;
        }
      j++;
      }
    
    // if match == true, we found a solution!
    if(match){
      return i;
    }
  }
  return -1;
  }
  
  public static Boolean search(Object item, Object[] arr){
  
  for(Integer i=0;i<arr.length; i++){
    if(arr[i] == item){
      return true;
    }
  }
  return false;
  }
  
  public static Boolean recursive_search(Object item, Object[] arr, Integer i){
  // base case
  if(i == arr.length){
    return false;
  }
  
  if(arr[i] == item){
      return true;
    }
  
  return recursive_search(item, arr, i+1);
  }
  
  public static Integer mystery(Integer a, Integer b){
    if(a*b == 0)
      return a;
    else
      return b + mystery(a-1, b-2);
  }
  
  public static void main(String[] args) {
  
    System.out.print("-----------------------\n");
    Integer[] testArray = {1, 2, 3, 4, 5};
    System.out.print("base array: ");
    for(int i=0; i<testArray.length; ++i){
      System.out.print(testArray[i] + " ");
      }
    System.out.print("\n");
    
   // shift right
    System.out.print("-----------------------\n");
    shiftRight(testArray);
    System.out.print("shifted array: ");
    for(int i=0; i<testArray.length; ++i){
        System.out.print(testArray[i] + " ");
        }
      System.out.print("\n");
    
    //index of
    System.out.print("-----------------------\n");
    Integer[] findMe = {3, 4};
    Integer[] findMeToo = {3, 3};
    Integer index = indexOf(findMe, testArray);
    System.out.print("index of {3,4} is: " + index);
    System.out.print("\n");
    index = indexOf(findMeToo, testArray);
    System.out.print("index of {3,3} is: " + index);
    System.out.print("\n");
    
    // search
    System.out.print("-----------------------\n");
    Integer value = 7;
    Boolean found = search(value, testArray);
    System.out.print("search " + value + " in {5, 1, 2, 3, 5}: " + found);
    System.out.print("\n");
    String[] testArrayString = {"h", "e", "l", "l", "o"};
    String valueString = "o";
    found = search(valueString, testArrayString);
    System.out.print("search " + valueString + " in {h, e, l, l, 0}: " + found);
    System.out.print("\n");
    
    // recursive search
    System.out.print("-----------------------\n");
    found = recursive_search(value, testArrayString, 0);
    System.out.print("search " + value + " in of {h, e, l, l, o}: " + found);
    System.out.print("\n");
    found = recursive_search(valueString, testArrayString, 0);
    System.out.print("search " + valueString + " in of {h, e, l, l, 0}: " + found);
    System.out.print("\n");
    
    // mystery
    System.out.print("-----------------------\n");
    System.out.print("mystery(5,6): " + mystery(5,6));
    System.out.print("\n");
  }
  
}
