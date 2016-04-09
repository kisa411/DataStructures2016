

package cybersim;
import java.util.Random;


/**
 * This class represents a Cyber Cafe customer.
 */
public class Customer {
    
    /**
     * time (minutes after start of simulation) that the customer arrived
     */
    int arrivalTime; 
    /**
     * time (duration) that the customer requires to be served
     */
    int processTime; 
    /**
     * //time (duration) that the customer waited in line
     */
    int waitTime;    

    public Customer( int arrival ) { //constructor
       Random r = new Random();
//       int random = r.nextInt(120); //generate random minute from range (1-120)
       arrivalTime = arrival;
//       System.out.println(arrivalTime);
       
       int random = r.nextInt(2); //generate random duration time from range (1-2)
       processTime = random+1;
//       System.out.println(processTime);
       
//       random = r.nextInt(10); //generate random wait time from range (1-10)
       waitTime = 0; //set to 0 for now
//       System.out.println(waitTime);
    }
    
    public int getArrivalTime() {
        return arrivalTime;
    }
    
    public int getProcessTime() {
        return processTime;
    }
    
    public int getWaitTime() {
        return waitTime;
    }
    
    public void setArrivalTime( int t ) {
        arrivalTime = t;
    }
    
    public void setProcessTime( int t ) {
        processTime = t;
    }
    
//    public void setWaitTime( int t ) {
//        waitTime = t;
//    }
    
    public void calculateWaitTime( int leave ) {
        waitTime = leave - arrivalTime;
    }
    
}
