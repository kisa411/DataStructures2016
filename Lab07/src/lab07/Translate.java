/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * A class that translates English into pig Latin.
 *
 * @author Emily Koh
 */
public class Translate {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        String test = "pig";
//        //System.out.println(test);
        SinglyLinkedList<Character> charlist;
//        
//        charlist = makeList(test);
//        System.out.println(charlist.simpleToString());
//        
//        translate(charlist);
//        System.out.println(charlist.simpleToString());
//         
        
        //the code within the try block might cause errors
        try {
            //create a scanner for the file
            Scanner s = new Scanner(new BufferedReader(new FileReader("testfile.txt")));
            while (s.hasNextLine()) { //while the textfile has another line
		//get the next line of the file
                String line = s.nextLine(); //stotre the next line of the file
                //System.out.println(line); //print out the line
                //create another scanner for the next *line* of the file
                //we do this so we can now pick out each word of the line
                Scanner lineScanner = new Scanner(line); //reads each word of the sentence
                while (lineScanner.hasNext()) { //while there is another word
                    String next = lineScanner.next(); //store the word
                    //System.out.println(next);
                    charlist = makeList(next); //make the word into a linked list
                    translate(charlist); //translate the word and print it out
                    System.out.print(charlist.simpleToString() + " ");
                }
                System.out.print("\n"); //print a line after each translated sentence
            }
            s.close(); //close the file when program is finished reading from it
        } 
        //we must deal with the fact that FileReader throws a FileNotFoundException
        catch (FileNotFoundException ex) {
            System.out.println("That file cannot be found.");
        }
        
        
    } //end main method
    
    /**
     * Method to make a new linked list with the given word
     * @param word
     * @return linkedList
     */
    public static SinglyLinkedList makeList( String word ) {
        SinglyLinkedList<Character> linkedList; //creates a new linked list with characters
        linkedList = new SinglyLinkedList();
        for ( int i=0; i<word.length(); i++ ) {
            char letter = word.charAt(i); //assign the letter of the word to variable
            linkedList.addLast( letter ); //make a new node
        }
        
        return linkedList;
    } //end of makeList method
    
    /**
     * method to translate english words into pig latin
     * @param s linked list containing the word to be translated
     */
    public static void translate( SinglyLinkedList s ) {
        
        char firstLetter = (char) s.first();
        
        if ( isIn( firstLetter )== true ) { //the first letter is a vowel, so need to add 'way' to end of word
            s.addLast('w'); //add w to end of word in list
            s.addLast('a'); //add a to end of word in list
            s.addLast('y'); //add y to end of word in list
            //System.out.print("\n"); //print out a line break after each word
        } else { //the first letter is a consonant, so need to switch order of letters and then add 'ay' to end of word
            char temp = (char) s.removeFirst(); //take out the first letter and store it so that we can append it to end of list
            s.addLast( temp ); //add the first letter to end of current word
            s.addLast('a'); //add a to end of word in list
            s.addLast('y'); //add y to end of word in list
            //System.out.print("\n"); //print out a line break after each word
        }
    } 
    
    /**
     * method to look for character c in an array of vowels
     * @param c character to look for
     * @return true or false depending on whether or not the character was found in the vowel array
     */
    private static boolean isIn( char c ) {
        char[] vowel = {'a','e', 'i', 'o', 'u'}; //make an array containing vowels
        for ( char letter: vowel ) { //for each letter in the vowel array (for-each syntax)
            if ( c == letter ) { //if the given character is in the vowel array
                return true; //return true
            }
        }
        return false; //given character could not be found in the vowel array
    } //end of isIn method


}

