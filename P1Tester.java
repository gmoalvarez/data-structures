/*  Tester program for CS310 SP 2015 Program #1
    Alan Riggins
*/

import data_structures.*;
import java.util.Iterator;

public class P1Tester {
    private LinearListADT<Integer> list;

    public P1Tester() {
        list = new ArrayLinearList<Integer>();
        runTests();
    }

    private void runTests() {
        for(int i=1; i <= 10; i++)
            list.addLast(i);
        System.out.println("Should print 1 .. 10");

        for(int x : list)
            System.out.print(x + " ");
        System.out.println("\n");
        System.out.println("The size right now before removing is:" +list.size());
        System.out.println("The third element is (should be 3): " + list.get(3));
        System.out.println("This will try to locate the integer 4 (should return 4):" +list.locate(4));
        System.out.println("Now removing them all using the object remove");
        for(int i=1; i <= 10; i++)
            System.out.println(list.remove(new Integer(i)));

        System.out.println("Current size of list: (should be zero) "
                + list.size());
//        System.out.println("Trying to get third element(should throw an exception): " + list.get(3));
        for(int i=1; i <= 10; i++)
            list.addFirst(new Integer(i));
        System.out.println("Current size of list: (should be 10)"
                + list.size());

        System.out.println("Now using the iterator, should print "
                + "10 .. 1");
        for(int x : list)
            System.out.print(x + " ");
        System.out.println();

        for(int i=1; i <= 10; i++)
            System.out.println(list.removeFirst());
        System.out.println("List should be empty, nothing should " +
                "print below\n\n");
        for(int x : list)
            System.out.print(x + " ");

        for(int i=1; i <= 10; i++)
            list.addLast(new Integer(i));
        System.out.println("Current size of list: (should be 10)"
                + list.size());

        System.out.println("Now using the iterator, should print "
                + "1 .. 10");
        for(int x : list)
            System.out.print(x + " ");
        System.out.println();

        for(int i=1; i <= 10; i++)
            System.out.println(list.removeFirst());
        System.out.println("List should be empty, nothing should " +
                "print below\n\n");
        for(int x : list)
            System.out.print(x + " ");

        list.addFirst(new Integer(25));
        list.addLast(new Integer(50));
        list.insert(new Integer(75), 2);
        System.out.println("Should print 25 75 50");
        for(int x : list)
            System.out.print(x + " ");
        System.out.println();
        if(!list.contains(75))
            System.out.println("ERROR, element in list not found!");
        if(!list.contains(25))
            System.out.println("ERROR, element in list not found!");
        if(!list.contains(50))
            System.out.println("ERROR, element in list not found!");
        list.remove(new Integer(75));
        list.remove(new Integer(50));
        list.remove(new Integer(25));
        if(list.remove(new Integer(100)) != null)
            System.out.println("ERROR, found element not in list!");
        System.out.println("List should be empty, nothing should print below\n\n");
        for(int x : list)
            System.out.print(x + " ");

        list.clear();
        System.out.println("Now inserting 100k elements in position #1\n" +
                "Testing the resize and shift operations\n" +
                "Times will vary, about 30 seconds on rohan, " +
                "3 secs on my office machine.");
        long start = System.currentTimeMillis();
        for(int i=1; i <= 100000; i++)
            list.addFirst(new Integer(i));

        long stop = System.currentTimeMillis();
//        for(int x : list)
//            System.out.print(x + " ");

        System.out.println("Operation took " + ((stop-start)/1000) + " seconds");
        System.out.println("The current size is " +list.size());
        System.out.println("Now removing them all using the location remove.");
        int counter = 100000;
        start = System.currentTimeMillis();
        while(!list.isEmpty()) {
            list.remove(counter);
            counter--;
        }
        stop = System.currentTimeMillis();
        System.out.println("The current size is " +list.size());
        System.out.println("Operation took " + ((stop-start)/1000) + " seconds");
        System.out.println("Done.");

    }

    public static void main(String [] args) {
        try {
            new P1Tester();
        }
        catch(Exception e) {
            System.out.println("ERROR " + e);
            e.printStackTrace();
        }
    }
}