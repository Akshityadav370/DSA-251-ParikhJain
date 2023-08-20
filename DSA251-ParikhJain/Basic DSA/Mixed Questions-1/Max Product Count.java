import java.util.* ;
import java.io.*; 
public class Solution {
    public static long[] maxProductCount(int arr[], int n) {
        // Write your code here.
         // To store the product of two number as Key and value as the total number of occurrence.        
         HashMap<Long, Integer> map = new HashMap<>();

       // To find all pair product and store it to HashMap with there frequencies.        
       for (int i = 0; i < n; i++) {            
           for (int j = i + 1; j < n; j++) {                
               long a = arr[i];                
               long b = arr[j];                
               long pairProduct = a * b;                
               map.putIfAbsent(pairProduct, 0);                
               map.put(pairProduct, map.get(pairProduct) + 1);            
            }        
        }

       // To store max product pair.        
       long maxProd = 0;

       // To store frequency of max product.        
       int freq = 0;

       // Traverse the HashMap.        
       for (Long prod : map.keySet()) {            
           if (map.get(prod) >= freq) {                
               // If frequency is same as previous max frequency then choose the one with minimum product.                
               if (map.get(prod) == freq) {                    
                   maxProd = Math.min(maxProd, prod);                
                } else {                    
                    maxProd = prod;                
                }                
                freq = map.get(prod);            
            }        
        }

       // Array to store the values of max product and Quadruples.        
       long[] result = new long[2];

       // If there is no pair having frequency count > 1.        
       if (map.get(maxProd) == null || map.get(maxProd) == 1) {            
           // Returning the array containing max product and number of Quadruples.            
           result[0]=0;            
           result[1]=0;            
           return (result);        
        }

       // Calculating total Quadruples as all Combination a pair can have with given frequency.        
       long allCombinations = ((freq * (freq - 1))) / 2;        
       result[0] = maxProd;        
       result[1] = allCombinations;        
       // Returning the array containing max product and number of Quadruples.        
       return (result);
    }
}