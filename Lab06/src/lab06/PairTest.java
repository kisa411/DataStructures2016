/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06;

/**
 * A class to test the generic class pair on a few examples
 * @author kisa411
 */
public class PairTest {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //STOCKS EXAMPLE
        //create a pair with a stock-ticker name and price
        Pair<String, Double> ticker1;
        ticker1 = new Pair<>("MSFT", 43.87);                 // create new stock Pair
        Pair<String, Double> ticker2;
        ticker2 = new Pair<>("FB", 75.74);                 // create new stock Pair
        Pair<String, Double> ticker3;
        ticker3 = new Pair<>("AAPL", 127.08);                 // create new stock Pair
        Pair<String, Double> ticker4;
        ticker4 = new Pair<>("IBM", 160.4);                 // create new stock Pair
        Pair<String, Double> ticker5;
        ticker5 = new Pair<>("TWTR", 48.5);                 // create new stock Pair
        
//        String stock = ticker1.getFirst();
//        double price = ticker1.getSecond();
        //System.out.println(stock);
//        System.out.println(price);

        
        //create an array of such stock-ticker pairs
        Pair<String, Double>[] holdings;                    //holdings is an array of pair classes (with types String and Double)
        //holdings = new Pair<String,Double>[25];           // NOTE: this is illegal syntax - can't set size with <>      
        holdings = new Pair[5];                             //array of five elements
        
        holdings[0] = ticker1;                              // valid element assignment
        holdings[1] = ticker2;
        holdings[2] = ticker3;
        holdings[3] = ticker4;
        holdings[4] = ticker5;
        
        //System.out.println(holdings[0].getFirst());         // print first stock's name
        double sum = 0;
        for ( int i=0; i<5; i++ ) {                         //calculate the total vlaue of the stocks in holdings
            sum+=holdings[i].getSecond();
        }
        System.out.print("Calculated sum of stock values is: ");
        System.out.printf("%1.2f \n", sum);                   //print out the calculated sum                            
        
        /*BIRD EXAMPLE*/
        //make bird objects 
        Bird bird = new Bird(0);
        Duck duck = new Duck(0);
        Loon loon = new Loon(10);
        
        //make pair objects containing owner name and pet bird
        Pair<String, Bird> bird1;
        bird1 = new Pair<>("Bogum", bird);                  //assign bird object to first pair
        Pair<String, Bird> bird2;
        bird2 = new Pair<>("Kyle", duck);                   //assign duck object to second pair
        Pair<String, Bird> bird3;
        bird3 = new Pair<>("Luke", loon);                   //assign loon object to third pair
        
        //create array of Pair<String, Bird>
        Pair<String, Bird>[] pets;
        pets = new Pair[3];
        
        pets[0] = bird1;
        pets[1] = bird2;
        pets[2] = bird3;
        
        for ( int i=0; i<3; i++ ) {
            pets[i].getSecond().makeNoise();
        }
        

    }

    
}
