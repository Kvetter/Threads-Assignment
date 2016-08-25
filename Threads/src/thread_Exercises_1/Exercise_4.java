/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread_Exercises_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author kaspe
 */
public class Exercise_4 {

    static class Tester {

        static final int NUMBER_OF_TURNSTILES = 40;
        static Turnstile[] turnStiles = new Turnstile[NUMBER_OF_TURNSTILES];

        public static void main(String[] args) throws InterruptedException {
            //This is the shared Counter used by all turnstilles
            TurnstileCounter sharedCounter = new TurnstileCounter();

            for (int i = 0; i < NUMBER_OF_TURNSTILES; i++) {
                turnStiles[i] = new Turnstile(sharedCounter);
            }

            //This example uses a ThreadPool to handle threads
            ExecutorService es = Executors.newCachedThreadPool();

            for (int i = 0; i < NUMBER_OF_TURNSTILES; i++) {
                es.execute(turnStiles[i]);
            }

            es.shutdown();
            es.awaitTermination(10, TimeUnit.SECONDS);

            System.out.println("All turnstiles are done");
            //Print the updated value
            System.out.println(sharedCounter.getValue());
        }
    }

    static class Turnstile implements Runnable {

        private final TurnstileCounter counter;
        private int count;

        final int COUNT_MAX = 1000;

        Turnstile(TurnstileCounter c) {
            counter = c;
        }

        public int getCount() {
            return count;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT_MAX; i++) {
                counter.incr();
                count++;
            }
        }

    }

    static class TurnstileCounter {

        static final long DELAY_VAL = 10000;
        long count = 0;

        public long getValue() {
            return count;
        }

        // Added keyword
       synchronized public void incr() {
//   If the program initially does not fail, replace the count line with the lines below
            long n = count;
            //Spend some time to force preemtion
            for (long a = 0; a < DELAY_VAL; a++);
            n = n + 1;
            count = n;

            //count++;
        }
    }
}
