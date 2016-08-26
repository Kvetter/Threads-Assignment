/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread_Exercises_2;

import java.io.IOException;

/**
 *
 * @author kaspe
 */
public class Exercise_Threads_2 {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Exercise_1 ex1 = new Exercise_1();
        
        ex1.createThreads();
        Thread.sleep(3000);
        System.out.println(ex1.sum);

        
    }
    
}
