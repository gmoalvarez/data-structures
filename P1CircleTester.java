/*  Tester program for CS310 SP 2015 Program #1
    Alan Riggins
*/

import data_structures.*;
import java.util.Iterator;

public class P1CircleTester {
    private LinearListADT<Circle> list;

    public P1CircleTester() {
        list = new ArrayLinearList<Circle>();
        runTests();
    }

    private void runTests() {
//        String[] names  = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for (int i=1; i<= 10; i++)
            list.addFirst(new Circle(i));



        System.out.println("Should print radius");

        for (Circle x : list)
            System.out.print(x+"\n ");
//        System.out.println();
//        System.out.println("The size right now before removing is (should be 26):" + list.size());
//        System.out.println("The third element is (should be c): " + list.get(3));
//        System.out.println("This will try to locate the letter j (should return 10):" + list.locate("j"));
//
////            System.out.println("Trying to get 27th element(should throw an exception): " + list.get(27));
//        for(int i=25; i >= 0; i--)
//            if(((Comparable<String>)names[i]).compareTo(list.removeFirst()) != 0)
//                System.out.println("ERROR, elements don't match");
//        System.out.println("The size right now after removing is (should be 0):" + list.size());
//
//        for (int i=0; i< names.length; i++)
//            list.addFirst(names[i]);
//
//        System.out.println("Now using the iterator, should print "
//                + "z..a");
//        for (String x : list)
//            System.out.print(x + " ");
//        System.out.println();
//        for(int i=0; i <= 25; i++)
//            if(((Comparable<String>)names[i]).compareTo(list.removeLast()) != 0)
//                System.out.println("ERROR, elements don't match");
//        System.out.println("The size right now after removing is (should be 0):" + list.size());
//        System.out.println("List should be empty, nothing should " +
//                "print below\n\n");
//        for (String x : list)
//            System.out.print(x + " ");
//
//        for (int i=0; i< names.length; i++)
//            list.addLast(names[i]);
//        for (int i=0; i< names.length; i++)
//            list.addLast(names[i]);
//        for (int i=0; i< names.length; i++)
//            list.addLast(names[i]);
//        for(int i=25; i >= 0; i--)
//            if(((Comparable<String>)names[i]).compareTo(list.removeLast()) != 0)
//                System.out.println("ERROR, elements don't match");
//        System.out.println("Current size of list: (should be 52): " + list.size());
//
//        System.out.println("Now using the iterator, should print a .. z twice");
//        for (String x : list)
//            System.out.print(x + " ");
//        System.out.println();
//        for(int i=25; i >= 0; i--)
//            if(((Comparable<String>)names[i]).compareTo(list.removeLast()) != 0)
//                System.out.println("ERROR, elements don't match");
//        for(int i=25; i >= 0; i--)
//            if(((Comparable<String>)names[i]).compareTo(list.removeLast()) != 0)
//                System.out.println("ERROR, elements don't match");
//
//        System.out.println("List should be empty, nothing should " +
//                "print below\n\n");
//        for (String x : list)
//            System.out.print(x + " ");
//        System.out.println("Current size of list: (should be 0): " + list.size());
//
//        list.addFirst("a");
//        list.addLast("c");
//        list.insert("b", 2);
//        System.out.println("Should print a b c");
//        for (String x : list)
//            System.out.print(x + " ");
//        System.out.println();
//        if (!list.contains("a"))
//            System.out.println("ERROR, element in list not found!");
//        if (!list.contains("b"))
//            System.out.println("ERROR, element in list not found!");
//        if (!list.contains("c"))
//            System.out.println("ERROR, element in list not found!");
//        list.remove("a");
//        list.remove("b");
//        list.remove("c");
//        System.out.println("List should be empty, nothing should " +
//                "print below\n\n");
//        for (String x : list)
//            System.out.print(x + " ");
//        System.out.println("Current size of list: (should be 0): " + list.size());
//        if (list.remove("a") != null)
//            System.out.println("ERROR, found element not in list!");
//        System.out.println("Now inserting 130k elements in position #1\n" +
//                "Testing the resize and shift operations\n" +
//                "Times will vary, about 30 seconds on rohan, " +
//                "3 secs on my office machine.");
//        long start = System.currentTimeMillis();
//        for (int n = 1; n <= 5000; n++)
//            for (int i = 0; i <= 25; i++)
//                list.addFirst(names[i]);
//        long stop = System.currentTimeMillis();
//
//        System.out.println("Operation took " + ((stop - start) / 1000) + " seconds");
//        System.out.println("The current size is " + list.size());
//        System.out.println("Now removing them all using the location remove.");
//        int counter = 130000;
//        start = System.currentTimeMillis();
//        while (!list.isEmpty()) {
//            list.remove(counter--);
//        }
//        stop = System.currentTimeMillis();
//        System.out.println("The current size is " + list.size());
//        System.out.println("Operation took " + ((stop - start) / 1000) + " seconds");
//        System.out.println("Done.");

    }

    public static void main(String [] args) {
        try {
            new P1CircleTester();
        }
        catch(Exception e) {
            System.out.println("ERROR " + e);
            e.printStackTrace();
        }
    }
}