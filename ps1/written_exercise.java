import java.util.*;

public class written_exercise {

  public static void shiftRight( int[] arr){

  if( (arr == null) || (arr.length < 2) ){
    // donÕt do anything
    return;
  }

  // keep value of the first integer
  int firstValue = arr[0];

  for(int i=1; i<arr.length; ++i){
    arr[i-1] = arr[i];
  }
  // put first integer at last position
  arr[arr.length-1] = firstValue;
  }

  
  public static int indexOf( int[] arr1, int[] arr2){
  
  if( arr1 == null || arr2 == null){
    // donÕt do anything
    return -1;
    }

  // go through array2, minus size of array1 + 1
  for(int i=0; i<arr2.length - arr1.length  + 1; ++i){
    Boolean match = true;
    int j = 0;
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
  
  for(int i=0;i<arr.length; i++){
    if(arr[i] == item){
      return true;
    }
  }
  return false;
  }
  
  public static Boolean recursive_search(Object item, Object[] arr, int i){
  // base case
  if(i == arr.length){
    return false;
  }
  
  if(arr[i] == item){
      return true;
    }
  
  return recursive_search(item, arr, i+1);
  }
  
}
