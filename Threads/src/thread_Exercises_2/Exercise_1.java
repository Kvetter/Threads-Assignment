/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread_Exercises_2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaspe
 */
public class Exercise_1 {

    int sum = 0;

    public void createThreads() {

        Runnable link1 = () -> {
            Threads t1 = new Threads("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
            try {
                sum += t1.getSum();
            } catch (IOException ex) {
                System.out.println("Bad thing happened");
            }
        };
        Runnable link2 = () -> {
            Threads t2 = new Threads("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
            try {
                sum += t2.getSum();
            } catch (IOException ex) {
                System.out.println("Bad thing happened");
            }
        };
        Runnable link3 = () -> {
            Threads t3 = new Threads("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
            try {
                sum += t3.getSum();
            } catch (IOException ex) {
                System.out.println("Bad thing happened");
            }
        };

        new Thread(link1).start();
        new Thread(link2).start();
        new Thread(link3).start();

    }

    private class Threads {

        private String url = "";

        Threads(String url) {
            this.url = url;
        }
// Wrong here, convert byte to int

        public int getSum() throws IOException {
            int sum = 0;
            byte[] bytes = getBytesFromUrl(url);
            for (int i = 0; i < bytes.length; i++) {
                sum += bytes[i];
            }
            return sum;
        }

        public byte[] getBytesFromUrl(String url) throws IOException {
            URLConnection connection = new URL(url).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.connect();
            ByteArrayOutputStream bis = new ByteArrayOutputStream();
            try {
                InputStream is = connection.getInputStream();
                byte[] bytebuff = new byte[4096];
                int read;
                while ((read = is.read(bytebuff)) > 0) {
                    bis.write(bytebuff, 0, read);
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
            return bis.toByteArray();
        }

    }

}
