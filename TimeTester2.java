/*  Timer.java
    A simple example of a timer for project #2-modified for project #4
    
    CS310 Spring 15
    Alan Riggins
*/


import data_structures.*;

import java.util.Random;
import java.util.UUID;
import java.util.Arrays;

public class TimeTester2 {
    final int NUMBER_OF_ITERATIONS = 20;
    final int STEP_SIZE = 10000;
    final int CYCLES = 1000;

    public TimeTester2() {
        runTests();
    }

    private void runTests() {
//        DictionaryADT<String,Integer> dictionary = new HashTable<>(500000);
        DictionaryADT<String,Integer> dictionary = new BinarySearchTree<>();
//        DictionaryADT<String,Integer> dictionary = new RedBlackTree<>();
        LinearListADT<String> list = new LinearList<>();


        String [] keyArray;
        String [] keyAdditions;
        String[] keyDeletions;
        Random x;
        int n = 10000;
        long start, stop;




        for(int i=0; i < NUMBER_OF_ITERATIONS; i++) {
            dictionary.clear();
            keyArray = new String[n];
            keyAdditions = new String[n*CYCLES];
            keyDeletions = new String[n*CYCLES];
            // build the structure
            for(int j=0; j < n;j++ )
                keyArray[j] = UUID.randomUUID().toString();
            //Sorted Dictionary
            Arrays.sort(keyArray);

            //Add to Dictionary
            for(int j=0; j < n; j++) {
                dictionary.add(keyArray[j], 0);
//                list.addFirst(keyArray[j]);
            }



            //keys to add/delete
            for(int j=0; j < CYCLES;j++ ) {
//                keyAdditions[j] = UUID.randomUUID().toString();
                keyDeletions[j] = keyArray[n/2+j];
            }

            // now time
            start = System.nanoTime();
            for(int k=0; k < CYCLES; k++) {
//                dictionary.getValue(keyArray[((int) (Math.random() * n))]);
//                dictionary.add(keyAdditions[k],0);
                dictionary.delete(keyDeletions[k]);
            }
            stop = System.nanoTime();
            System.out.println("Time with n = " + n +
                    " is: " + (stop-start)/1000000 + " milliseconds");
            //Linked List comparison
//            start = System.nanoTime();
//            for(int k=0; k < CYCLES; k++) {
////                list.insert(keyAdditions[k], n / 2);
//                list.locate(keyArray[n/2]);
//            }
//            stop = System.nanoTime();
//            System.out.println("Linked List time with n = " + n +
//                    " is: " + (stop-start)/1000000 + " milliseconds");
            n += STEP_SIZE;
//            System.out.println("The current size of hash table is "+dictionary.size());
        }
        System.out.println("Done");
    }

    private static String[] shellSort(String n[]) {

        if(n.length < 2)
            return n;
        int in=0, out=0, h=1;
        String temp=null;
        int size = n.length;

        while(h <= size/3)
            h = h*3+1;
        while(h > 0) {
            for(out=h; out < size; out++) {
                temp = n[out];
                in = out;
                while(in > h-1 &&
                        ((Comparable)n[in-h]).compareTo(temp) >= 0) {
                    n[in] = n[in-h];
                    in -= h;
                }
                n[in] = temp;

            } // end for
            h = (h-1)/3;
        } // end while

        return n;
    }

    public static void main(String [] args) {
        new TimeTester2();
    }
}