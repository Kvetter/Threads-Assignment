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
public class Exercise_1 {

    public void Exercise1() {

        Runnable task1 = () -> {
            long x = 0;
            for (int i = 0; i < 1_000_000_000; i++) {
                x += i;
            }
            System.out.println("Task1 : " + x);
        };

        Runnable task2 = () -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println("Task2 : " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                }
            }
        };

        Task3 task3 = new Task3();

        new Thread(task1).start();
        new Thread(task2).start();
        Thread t3 = new Thread(task3);
        t3.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
        }

        task3.bool = false;

    }

    static class Task3 implements Runnable {

        boolean bool = true;

        @Override
        public void run() {

            int y = 10;
            while (bool) {

                System.out.println("Task3 : " + y++);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                }

            }

        }

    }
}
