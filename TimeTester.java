/*  Time Tester program for CS310 SP 2015 Program #1
    Guillermo Alvarez
*/

import data_structures.*;

public class TimeTester {
    private LinearListADT<Integer> list;

    public TimeTester() {
        list = new ArrayLinearList<Integer>();
        runTests();
    }

    private void runTests() {
        int testListSize = 512000;
        int numberElements;
        long runTime;

        for (int n = 1; n <= 16; n*=2) {

            //fill up the list
            numberElements = n * 1000;
            for(int i=1; i <= testListSize ; i++)
                list.addLast(i);

            //addLast(E obj)
            runTime = timeAddLast(numberElements);
            System.out.println("AddLast n = "+numberElements + " took " + runTime + " seconds");

            //removeLast()
            runTime = timeRemoveLast(numberElements);
            System.out.println("removeLast n = "+numberElements + " took " + runTime + " seconds");

            //addFirst(E obj)
            runTime = timeAddFirst(numberElements);
            System.out.println("addFirst size n = "+numberElements + " took " + runTime + " seconds");

            //removeFirst()
            runTime = timeRemoveFirst(numberElements);
            System.out.println("removeFirst n = "+numberElements + " took " + runTime + " seconds");

            //insert(E obj, int location)
            runTime = timeInsert(numberElements,1);
            System.out.println("insert (in first) n = "+numberElements + " took " + runTime + " seconds");

            runTime = timeInsert(numberElements,list.size()/2);
            System.out.println("insert (in middle) n = "+numberElements + " took " + runTime + " seconds");

            runTime = timeInsert(numberElements,list.size());
            System.out.println("insert (in end) n = "+numberElements + " took " + runTime + " seconds");

            //remove(int location)
            runTime = timeRemoveLocation(numberElements, 1);
            System.out.println("remove(int location) method (first) n = "+numberElements + " took " + runTime + " seconds");

            runTime = timeRemoveLocation(numberElements, list.size()/2);
            System.out.println("remove(int location) method (middle) n = "+numberElements + " took " + runTime + " seconds");

            runTime = timeRemoveLocation(numberElements, list.size());
            System.out.println("remove(int location) method (last) n = "+numberElements + " took " + runTime + " seconds");

            //remove(E obj)

            timeRemoveObject(numberElements);

            //get(int location)

            runTime = timeGet(numberElements, 1);
            System.out.println("get (first) n = "+numberElements + " took " + runTime + " seconds");

            runTime = timeGet(numberElements, list.size()/2);
            System.out.println("get (middle) n = "+numberElements + " took " + runTime + " seconds");

            runTime = timeGet(numberElements, list.size());
            System.out.println("get (last) n = "+numberElements + " took " + runTime + " seconds");

            //contains(E obj)

            runTime = timeContains(numberElements);
            System.out.println("contains method (average case) n = "+numberElements + " took " + runTime + " seconds");
//
            //locate(E obj)
            runTime = timeLocate(numberElements);
            System.out.println("locate method (average case) n = "+numberElements + " took " + runTime + " seconds");
            list.clear();

        }
    }

    public long timeLocate(int numberElements) {
        long start;
        long stop;
        long runTime;
        int[] searchNumber = new int[numberElements+1];
        for (int i = 1; i <= numberElements; i++)
            searchNumber[i] = (int) ((float)numberElements * Math.random());
        start = System.nanoTime();
        for (int i = 1; i <= numberElements; i++)
            list.locate(searchNumber[i]);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }

    public long timeContains(int numberElements) {
        long runTime;
        long start;
        long stop;
        int[] searchNumber = new int[numberElements+1];
        for (int i = 1; i <= numberElements; i++)
            searchNumber[i] = (int) ((float)numberElements * Math.random());
        start = System.nanoTime();
        for (int i = 1; i <= numberElements; i++)
            list.contains(searchNumber[i]);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }

    public long timeGet(int numberElements, int indexToGet) {
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

    public long timeRemoveObject(int numberElements) {
        long start;
        long stop;
        long runTime;
        int[] searchNumber = new int[numberElements+1];
        for (int i = 1; i <= numberElements; i++)
            searchNumber[i] = (int) ((float)numberElements * Math.random());
        start = System.nanoTime();
        for (int i = 1; i <= numberElements; i++)
            list.remove(searchNumber[i]);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }

    public long timeRemoveLocation(int numberElements, int indexToRemove) {
        long start;
        long stop;
        long runTime;
        start = System.nanoTime();
        for (int i = 1; i<= numberElements; i++)
            list.remove(indexToRemove--);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }

    public long timeInsert(int numberElements,int location) {
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

    public long timeRemoveFirst(int numberElements) {
        long start;
        long stop;
        long runTime;
        start = System.nanoTime();
        for (int i = 1; i<= numberElements; i++)
            list.removeFirst();
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }

    public long timeAddFirst(int numberElements) {
        long start;
        long stop;
        long runTime;
        start = System.nanoTime();
        for (int i = 1; i<= numberElements; i++)
            list.addFirst(2);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }

    public long timeRemoveLast(int numberElements) {
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

    public long timeAddLast(int numberElements) {
        long start;
        long stop;
        long runTime;
        start = System.nanoTime();//start test
        for (int i = 1; i<= numberElements; i++)
            list.addLast(2);
        stop = System.nanoTime();
        runTime = (stop-start)/1000000000;
        return runTime;
    }

    public static void main(String [] args) {
        try {
            new TimeTester();
        }
        catch(Exception e) {
            System.out.println("ERROR " + e);
            e.printStackTrace();
        }
    }
}