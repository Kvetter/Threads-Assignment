/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread_Exercises_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaspe
 */
public class Exercise_Threads_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Exercise_1 ex1 = new Exercise_1();
        Exercise_2 ex2 = new Exercise_2();
        
        ex1.Exercise1();
        // The first occurence of a uneven number happens after 10_000 most of the times
        // but the method is made atomic with the synchrnized keyword
        //ex2.Exercise2();
        
        
    }
}
