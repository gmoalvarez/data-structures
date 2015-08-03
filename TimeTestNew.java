/**
 * Created by guillermo on 3/8/15.
 */

import data_structures.*;

public class TimeTestNew {
    private LinearListADT<Integer> list;

    public TimeTestNew() {
        list = new LinearList<Integer>();
        runTests();
    }

    private void runTests() {
        int testListSize = 256000;
        int numberElements;
        long runTime;
        
        //addLast(E obj)
        for (int n = 1; n <= 16; n *= 2) {
            numberElements = n * 3000;
            fillList(testListSize);
            runTime = timeAddLast(numberElements);
            System.out.println("AddLast n = " + numberElements + " took " + runTime + " milliseconds");
        }
        list.clear();
        System.out.println("\n");
        //removeLast()
        for (int n = 1; n <= 16; n *= 2) {

            numberElements = n * 3000;
            fillList(testListSize);

            runTime = timeRemoveLast(numberElements);
            System.out.println("removeLast n = " + numberElements + " took " + runTime + " seconds");
        }
        list.clear();
        System.out.println("\n");
        //addFirst(E obj)
        for (int n = 1; n <= 16; n *= 2) {
            numberElements = n * 3000;
            fillList(testListSize);
            runTime = timeAddFirst(numberElements);
            System.out.println("addFirst size n = " + numberElements + " took " + runTime + " milliseconds");
        }
        list.clear();
        System.out.println("\n");
        //removeFirst()
        for (int n = 1; n <= 16; n *= 2) {
            numberElements = n * 3000;
            fillList(testListSize);

            runTime = timeRemoveFirst(numberElements);
            System.out.println("removeFirst n = " + numberElements + " took " + runTime + " milliseconds");
        }
        list.clear();
        System.out.println("\n");
        //insert(E obj, int location)
        for (int n = 1; n <= 16; n *= 2) {
            numberElements = n * 3000;
            fillList(testListSize);
            runTime = timeInsert(numberElements, 1);
            System.out.println("insert (in first) n = " + numberElements + " took " + runTime + " seconds");
            runTime = timeInsert(numberElements, list.size() / 2);
            System.out.println("insert (in middle) n = " + numberElements + " took " + runTime + " seconds");
            runTime = timeInsert(numberElements, list.size());
            System.out.println("insert (in end) n = " + numberElements + " took " + runTime + " seconds");
        }
        list.clear();
        System.out.println("\n");
        //remove(int location)
        for (int n = 1; n <= 16; n *= 2) {
            numberElements = n * 3000;
            fillList(testListSize);
            runTime = timeRemoveLocation(numberElements, 1);
            System.out.println("remove(int location) method (first) n = " + numberElements + " took " + runTime + " seconds");
            runTime = timeRemoveLocation(numberElements, list.size() / 2);
            System.out.println("remove(int location) method (middle) n = " + numberElements + " took " + runTime + " seconds");

            runTime = timeRemoveLocation(numberElements, list.size() - numberElements);
            System.out.println("remove(int location) method (last) n = " + numberElements + " took " + runTime + " seconds");
        }
        list.clear();
        System.out.println("\n");

        //remove(E obj)
        for (int n = 1; n <= 16; n *= 2) {
            numberElements = n * 3000;
            fillList(testListSize);
            runTime = timeRemoveObject(numberElements);
            System.out.println("remove(object) method n = " + numberElements + " took " + runTime + " seconds");
        }
        list.clear();
        System.out.println("\n");
        //get(int location)
        for (int n = 1; n <= 16; n *= 2) {
            numberElements = n * 3000;
            fillList(testListSize);
            runTime = timeGet(numberElements, 1);
            System.out.println("get (first) n = " + numberElements + " took " + runTime + " seconds");
            runTime = timeGet(numberElements, list.size() / 2);
            System.out.println("get (middle) n = " + numberElements + " took " + runTime + " seconds");
            runTime = timeGet(numberElements, list.size());
            System.out.println("get (last) n = " + numberElements + " took " + runTime + " seconds");
        }
        list.clear();
        System.out.println("\n");
        //contains(E obj)
        for (int n = 1; n <= 16; n *= 2) {
            numberElements = n * 3000;
            fillList(testListSize);
            runTime = timeContains(numberElements);
            System.out.println("contains method (average case) n = " + numberElements + " took " + runTime + " seconds");
        }
        list.clear();
        System.out.println("\n");
        //locate(E obj)
        for (int n = 1; n <= 16; n *= 2) {
            numberElements = n * 3000;
            fillList(testListSize);
            runTime = timeLocate(numberElements);
            System.out.println("locate method (average case) n = " + numberElements + " took " + runTime + " seconds");
        }
        list.clear();
        System.out.println("\n");

    }

    private void fillList(int testListSize) {
        for (int i = 1; i <= testListSize; i++)
            list.addLast(i);
    }
    private long timeLocate(int numberElements) {
        long start;
        long stop;
        long runTime;
        int[] searchNumber = new int[numberElements+1];
        for (int i = 1; i <= numberElements; i++)
            searchNumber[i] = (int) ((float)list.size() * Math.random());
        start = System.nanoTime();
        for (int i = 1; i <= numberElements; i++)
            list.locate(searchNumber[i]);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }
    private long timeContains(int numberElements) {
        long runTime;
        long start;
        long stop;

        int[] searchNumber = new int[numberElements+1];
        for (int i = 1; i <= numberElements; i++)
            searchNumber[i] = (int) ((float)list.size() * Math.random());
        start = System.nanoTime();
        for (int i = 1; i <= numberElements; i++)
            list.contains(searchNumber[i]);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }
    private long timeGet(int numberElements, int indexToGet) {
        long start;
        long stop;
        long runTime;
        start = System.nanoTime();
        for (int i = 1; i<= numberElements; i++)
            list.get(indexToGet);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }
    private long timeRemoveObject(int numberElements) {
        long start;
        long stop;
        long runTime;
        int[] searchNumber = new int[numberElements+1];
        for (int i = 1; i <= numberElements; i++)
            searchNumber[i] = (int) ((float)list.size() * Math.random());
        start = System.nanoTime();
        for (int i = 1; i <= numberElements; i++)
            list.remove(new Integer(searchNumber[i]));
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }
    private long timeRemoveLocation(int numberElements, int indexToRemove) {
        long start;
        long stop;
        long runTime;
        start = System.nanoTime();
        for (int i = 1; i<= numberElements; i++)
            list.remove(indexToRemove);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }
    private long timeInsert(int numberElements,int location) {
        long start;
        long stop;
        long runTime;
        start = System.nanoTime();
        for (int i = 1; i <= numberElements; i++)
            list.insert(1000, location);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }
    private long timeRemoveFirst(int numberElements) {
        long start;
        long stop;
        long runTime;
        start = System.nanoTime();
        for (int i = 1; i<= numberElements; i++)
            list.removeFirst();
        stop = System.nanoTime();
        runTime = (stop-start)/1000000;
        return runTime;
    }
    private long timeAddFirst(int numberElements) {
        long start;
        long stop;
        long runTime;
        start = System.nanoTime();
        for (int i = 1; i<= numberElements; i++)
            list.addFirst(2);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000;
        return runTime;
    }
    private long timeRemoveLast(int numberElements) {
        long start;
        long stop;
        long runTime;
        start = System.nanoTime();
        for (int i = 1; i<= numberElements; i++)
            list.removeLast();
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }
    private long timeAddLast(int numberElements) {
        long start;
        long stop;
        long runTime;
        start = System.nanoTime();//start test
        for (int i = 1; i<= numberElements; i++)
            list.addLast(2);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000;
        return runTime;
    }
    public static void main(String [] args) {
        try {
            new TimeTestNew();
        }
        catch(Exception e) {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }
}