/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread_Exercises_1;

/**
 *
 * @author kaspe
 */
public class Exercise_2 {

    public void Exercise2() {

        Even even = new Even();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                int temp = even.next();
                if (temp%2 != 0){
                    System.out.println(temp);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                int temp = even.next();
                if (temp%2 != 0){
                    System.out.println(temp);
                }
            }
        }).start();

    }

    static class Even {

        private int n = 0;

        
        // synchronized key-wprd is added to make the method atomic
        synchronized public int next() {
            n++;
            n++;
            return n;
        }
    }

}
