import java.io.*;
import java.util.*;

public class multithreading {

    public static void main(String[] args) throws IOException {
        int n;
        String[] arr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("WELCOME TO RESTAURANT");
        System.out.println("Here each part gets their own thread!");
        System.out.println("How many no of orders taken?");
        n = Integer.parseInt(br.readLine()); 
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the item in the order " + (i + 1) + ": ");
            arr[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            RSThread canthread1 = new RSThread(arr[i]);
            canthread1.start();
        }
    }
}

class RSThread implements Runnable {
    Thread userthread;
    private String name;

    RSThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + "'s Thread running\n");
        for (int i = 0; i < 2; i++) {
            System.out.println("Order in Progress! ");
            System.out.println(name);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
    }

    public void start() {
        System.out.println("Thread started");
        if (userthread == null) {
            userthread = new Thread(this, name);
            userthread.start();
        }
    }
}
