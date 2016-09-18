package SoftwareTesting.exercise01.Management;

import SoftwareTesting.exercise01.QueuePack.QueueImpl;
import SoftwareTesting.exercise01.QueuePack.QueueIsEmptyException;
import SoftwareTesting.exercise01.QueuePack.QueueIsFullException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.jar.Pack200;

/**
 * Created by rubenspessoa on 31/07/16.
 */

public class Menu {

    QueueImpl<Integer> queue;

    public void run() {

        Scanner scanner = new Scanner(System.in);
        int capacity = -1;

        while (capacity <= 0) {
            try {
                capacity = scanner.nextInt();
                this.queueConstructor(capacity);
            } catch (NegativeArraySizeException e) {
                System.err.println("Try again. Hint: Only positive values are allowed.");
            }
        }

        boolean isRunning = true;
        String command;

        while (isRunning) {

            command = scanner.next();

            switch (command) {

                case "add":
                    int aux;

                    try {
                        aux = scanner.nextInt();
                        this.add(aux);
                    } catch (QueueIsFullException e) {
                        System.err.println(e.getMessage());
                        System.err.println("Insert a valid command.");
                    } catch (InputMismatchException e) {
                        System.err.println("Insert an Integer.");
                    } catch (Exception e) {
                        System.err.println("Try again.");
                    }

                    break;

                case "remove":

                    try {
                        System.out.println(this.remove());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.err.println("Insert a valid command.");
                    }

                    break;

                case "element":

                    try {
                        System.out.println(this.element());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.err.println("Insert a valid command.");
                    }

                    break;

                case "size":

                    System.out.println(this.size());
                    break;

                case "print":
                    try {
                        System.out.println(this.print());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    break;

                case "quit":

                    isRunning = false;
                    break;

                default:
                    System.err.println("Insert a valid command.");
            }
        }
    }

    /*
    Queue Constructor.
     */

    public void queueConstructor(int capacity) {
        this.queue = new QueueImpl<Integer>(capacity);
    }

    /*
    Insert an element at the end of the queue.
     */

    public void add(Integer e) throws Exception {
        this.queue.enqueue(e);
    }

    /*
    Remove and print the first element of the queue.
     */

    public Integer remove() throws Exception {
        return this.queue.dequeue();
    }

    /*
    Print the first element of the queue.
     */

    public Integer element() throws Exception {
        return this.queue.element();
    }

    /*
    Retorna the size of queue.
     */

    public int size() {
        return this.queue.size();
    }

    /*
    Remove all queue elements and print them.
     */

    public String print() throws Exception {

        String ans = this.queue.toString();

        try {
            this.queue.resetQueue();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return ans;
    }




}
