package cybersim;

import java.util.Random;

/**
 * This class represents the Cyber Cafe and simulates the line at lunchtime
 * using a queue.
 */
public class Cyber {
        
    /**
     * The main method defines simulation parameters and calls simulation method
     * @param args (unused)
     */
    public static void main(String[] args) {
        
        //SIMULATION PARAMETERS
        //number of simulation hours (11am-1pm)
        int simHours = 2;
        //average number of customers per hour
        int custPerHour = 90;
        //number of registers
        int numRegisters = 4;
        //if the line is longer than tooLong, any new customers will leave
        int tooLong = 15;
        
        //Run simulation with these parameters and print the results
        simulation(simHours, custPerHour, numRegisters, tooLong);
        
    }

    /**
     * This methods performs a minute-by-minute simulation of the line at the
     * cafe and prints the results.
     * @param simHours the number of hours that the simulation should run
     * @param custPerHour the expected number of customers to arrive per hour
     * @param numRegisters the number of registers open
     * @param tooLong if line has at least this many people, a new customer will leave
     */
    private static void simulation(int simHours, int custPerHour, int numRegisters, int tooLong) {

        //how many minutes the simulation should run
        int totalMins = 60 * simHours;

        //A queue that will hold and manage objects of type Customer.
        Queue<Customer> line = new LinkedQueue<Customer>();
        
        //TO DO: Code the simulation using the following for loop
        
        int n, totalCustomers=0, servedCustomers=0, leftCustomers=0;
        int lineLength=0;
        double avgLineLength=0, totalLineLength=0;
        double waitTime=0, avgWaitTime=0;
        
        //loop through lunch rush minute by minute
        for (int time = 1; time <= totalMins; time++) { //at the end of the two hours, all remaining customers will be
                                                        //served but no more will be allowed to enter the cafe
                                                        
            //decide how many customers arrived in the past minute
            n = numNewCustomers(custPerHour);
//            System.out.println("people who came this minute: " + n);
            totalCustomers+=n; //keep track of how many customers arrived in total
            
            for ( int i=0; i<n; i++ ) { //for each customer that came, add them to the line
                //i - one customer

                if ( line.size()>=tooLong ) {  //stop adding customers if line is too long
                    leftCustomers+=(n-i); //because new customers will leave
//                    System.out.println("The line was too long and " + (n-i) + " people left.");
//                    System.out.println("So far " + leftCustomers + " have left.");
                    break;
                } else { //add customers if the line isn't too long yet
                    Customer customer = new Customer(time); //create a new customer instance
//                    System.out.println("Adding customer to queue.");
                    line.enqueue(customer); //add the customer to the total line
                    
                    lineLength++; //increment linelength for each time a customer was added
//                    System.out.println("Line length is now:" + lineLength);
                }
            }
            if ( line.size()!=0 ) {
                    for ( int k=0; k<numRegisters; k++ ) { //get the first people from the line (depends on how many registers are open)
                        if ( line.size()!=0 && line.first().getProcessTime() == 1 ) { //if the customer only take a minute to serve
//                            System.out.println("Customer takes one minute to serve.");
                            
                            line.first().calculateWaitTime(time); //calculate the wait time of the customer
                            waitTime+=line.first().getWaitTime(); //add the wait time of the customer to the total wait time
                            
//                            System.out.println("Removing customer from queue.");
                            line.dequeue(); //remove them from the line since they were served during this minute
                            lineLength--; //decrement the number of people who are currently in line
//                            System.out.println("People in line now: " + lineLength);
                            servedCustomers++; //increase the number of customers who were served
//                            System.out.println("People who were served: " + servedCustomers);
                             
                        } else { //if the customers take two minutes to be served, then
//                            System.out.println("Customer takes two minutes to serve.");
                            if ( line.size()!=0 ) {
                                line.first().setProcessTime(1); //decrease the amount of time it takes for the first two customers to be served
                            }
                        }
                        totalLineLength+=lineLength; //add the current line length to the total line length to calculate avgLineLength later
                    }
                }
            }
            
            
        
       
        avgLineLength = (totalLineLength)/(totalMins); //calculate the average length of the line over the time
        avgWaitTime = (waitTime)/(servedCustomers); //calculate the average waittime of the served customers
        if ( servedCustomers!=totalCustomers ) { //factor in the last people in the cafe after lunch rush ended
            servedCustomers+=(totalCustomers-servedCustomers-leftCustomers);
        }
        
        //print out the results
        System.out.println("The total number of customers that came to the cafe is: " + totalCustomers + " people");
        System.out.println("The total number of served customers is: " + servedCustomers + " people");
        System.out.println("The total number of customers who left is: " + leftCustomers + " people");
        System.out.println("The average length of the line was: " + String.format("%.2f", avgLineLength) + " people");
        System.out.println("The average wait time was: " + String.format("%.2f", avgWaitTime) + " minutes");
    }

    /**
     * A method to randomly choose how many customers arrived in a given minute
     * based on the average number of customers per hour
     * (assumes arrivals are Poisson distributed)
     * @param custPerHour the average number of customers per hour
     * @return the number of customers that arrived in a minute
     */
    private static int numNewCustomers (double custPerHour) {
        Random r = new Random();
        double L = Math.exp(-custPerHour/60);
        int k = 0;
        double p = 1.0;
        do {
            p = p * r.nextDouble();
            k++;
        } while (p > L);
        return k - 1;
    }

}
