/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab08;

/**
 * HTML Tag checker
 * @author kisa411
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Simplified test of matching tags in an HTML document.
 */
public class HtmlTagChecker {

    /**
     * Tests if every opening tag has a matching closing tag in HTML string.
     * @param html HTML file 
     * @return boolean value
     */
    public static boolean isHTMLMatched(String html) {
        Stack<String> buffer = new LinkedStack<>();      //make a new LinkedStack called buffer
        int j = html.indexOf('<');                       // find first '<' character (if any)

        while (j != -1) {                                // '<' character is found
            int k = html.indexOf('>', j + 1);            // find next '>' character
            if (k == -1) {
                return false;                            // invalid tag
            }
            String tag = html.substring(j + 1, k);       // strip away < >
            if (!tag.startsWith("/"))                    // this is an opening tag
            {
                //tag = tag.substring(0);                  //sets the entire string as the tag
                buffer.push( tag );                      // store the tag string in the stack
//                System.out.println("Pushed: " + tag);
            } else {                                     // this is a closing tag
                tag = tag.substring(1);                  // returns the string characters after '/'
                if ( tag.equals(buffer.top()) ) {        // if the closing tag matches the most recent opening tag
                    buffer.pop();                           // remove the tag string in the stack w/o the '/' character
                } else { 
                    return false;
                }
//                System.out.println( "Popped: " + tag );
            }
            j = html.indexOf('<', k + 1);                // find next '<' character (if any)
        }
        
        return buffer.isEmpty();                   
    }

    /**
     * Test the given HTML file for mismatched tags.
     * @param args Name of file to open
     */
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader("testfile1.html")));
            s.useDelimiter("\\Z"); //ignore whitespace and line breaks to read whole file

            if (s.hasNext()) {
                String file = s.next();
                if (isHTMLMatched(file)) {
                    System.out.println("The input file is a matched HTML document.");
                } else {
                    System.out.println("The input file is not a matched HTML document.");
                }
            }
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("That file cannot be found.");
        }
    }

}