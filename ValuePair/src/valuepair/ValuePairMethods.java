/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valuepair;

/**
 * Driver class to test out the Pair and ValuePair classes
 * @author kisa411
 */
public class ValuePairMethods {

    /**
     * @param array array of ValuePairs
     * @return sum the computed sum of the values of the pairs
     */
    public static double sum( ValuePair[] array ) { //function to return the sum of the values of the pairs
       double sum = 0;
       int n = array.length;
       
       for( int i=0; i<n; i++ ) {
           sum+= array[i].getValue(); //get the second variable value of the ValuePair objects but use the getValue() function so that they are returned as doubles
       }
       return sum;
    }
    
    /**
     * function to return the ValuePair that has the maximal value
     * @param array array of ValuePairs
     * @return maximum returns the ValuePair that has the maximal value
     */
    public static ValuePair max( ValuePair[] array ) { //function to return the ValuePair that has the maximal value
        double maximum = 0;
        ValuePair maximumValuePair = null;
        
        int n = array.length;
        
        for( int i=0; i<n; i++ ) {
            if ( array[i].getValue() > maximum ) { //if there's a new maximum
                maximum = array[i].getValue(); //store the maximum value in the variable maximum
                maximumValuePair = array[i];   //store the ValuePair in the variable maximumValuePair
            }
        }
        
        return maximumValuePair;
    }
    
    /**
     * function to return the ValuePair that has the minimal value
     * @param array array of ValuePairs
     * @return minimum returns the ValuePair that has the minimal value
     */
    public static ValuePair min( ValuePair[] array ) { //function to return the ValuePair that has the minimal value
        double minimum = array[0].getValue();
        
        ValuePair minimumValuePair = array[0];
        
        int n = array.length;
        
        for( int i=0; i<n; i++ ) {
            if ( array[i].getValue() < minimum ) { //if there's a new minimum
                minimum = array[i].getValue(); //store the minimum value in the variable minimum
                minimumValuePair = array[i];   //store the ValuePair in the variable minimumValuePair
            }
        }
        
        return minimumValuePair;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //STOCKS EXAMPLE
        
        //create an array of stock-ticker pairs
        ValuePair<String, Double>[] holdings;  
        holdings = new ValuePair[5];   
        
        holdings[0] = new ValuePair<>("MSFT", 43.87);              
        holdings[1] = new ValuePair<>("FB", 75.74);
        holdings[2] = new ValuePair<>("AAPL", 127.08);
        holdings[3] = new ValuePair<>("IBM", 160.4);
        holdings[4] = new ValuePair<>("TWTR", 48.5);
             
//        for (int i = 0; i < holdings.length; i++) {
//            System.out.println(holdings[i].toString());
//        }
//        
        
        System.out.println("Sum: ");
        System.out.println(sum(holdings));
        System.out.println("Max: ");
        System.out.println(max(holdings));
        System.out.println("Min: ");
        System.out.println(min(holdings));
        
        //integer examples
        ValuePair<String, Integer>[] sports;  
        sports = new ValuePair[5];   
        
        sports[0] = new ValuePair<>("thehuskies", 43);              
        sports[1] = new ValuePair<>("thefrogs", 75);
        sports[2] = new ValuePair<>("cincinnati chairs", 12);
        sports[3] = new ValuePair<>("killer daisies", 160);
        sports[4] = new ValuePair<>("the scary unicorns", 48);
             
//        for (int i = 0; i < holdings.length; i++) {
//            System.out.println(holdings[i].toString());
//        }
//        
        
        System.out.println("Sum: ");
        System.out.println(sum(sports));
        System.out.println("Max: ");
        System.out.println(max(sports));
        System.out.println("Min: ");
        System.out.println(min(sports));
        
    }
    
}
