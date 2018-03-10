package mBankingTestPages;

import java.util.ArrayList;

public class ArraylistDemo {
   public static void main(String[] args) {
      
      // create an empty array list with an initial capacity
      ArrayList<String> arrlist = new ArrayList<String>(5);

      // use add() method to add values in the list
      arrlist.add("G");
      arrlist.add("E");
      arrlist.add("F");
      arrlist.add("M");
      
      System.out.println("Size of list: " + arrlist.size());

      // let us print all the values available in list
      for (String value : arrlist) {
         System.out.println("Value = " + value);
      }  

      // retrieving the index of element "E"
      int retval = arrlist.indexOf("E");
      System.out.println("The element E is at index " + arrlist.indexOf("E"));
      System.out.println("The element E is at index " + arrlist.indexOf("F"));
      System.out.println("The element E is at index " + arrlist.indexOf("M"));
   }
} 