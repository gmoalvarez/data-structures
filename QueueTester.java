import data_structures.*;
import java.util.Iterator;

public class QueueTester {
    private Queue<Person> list;
    private Queue<Integer> list2;
    private String [] fnames = {"John", "Robert", "Sam", "Henry", "Bill", "William",
            "Alan","Cyril","Gregory","Dennis","David","James","Joseph","Jerome","Gary"};
    private String [] lnames = {"Doe","Jones","Roberts","Shapiro","Martinez","Perez",
            "Wong","Nguyen","White","Bell","Brown","Black","Green","Trenton","Nagy"};
    private Person [] fullName;
    private Person sentinal = new Person("Aaron Burr");

    public QueueTester() {
        fullName = new Person[100];
        for(int i=0; i < 100; i++) {
            int ind1 = (int) (15.0f*Math.random());
            int ind2 = (int) (15.0f*Math.random());
            fullName[i] = new Person(fnames[ind1] + " " + lnames[ind2]);
//System.out.println(fullName[i]);    
        }
        list = new Queue<Person>();
        runTests();
    }

    private void runTests() {
        for(int i=1; i <= 5; i++)
            list.enqueue(fullName[i]);
        for(Person x : list)
            System.out.print(x + " \n");
        System.out.println("\n");
        list.makeEmpty();
        try {
            for(int i=0; i < 100; i++)
                list.enqueue(fullName[i]);
            for(int i=0; i <= 99; i++)
                if(((Comparable<Person>)fullName[i]).compareTo(list.dequeue()) != 0)
                    System.out.println("ERROR, elements don't match");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        list.makeEmpty();
        try {
            for(int i=0; i < 100; i++)
                list.enqueue(fullName[i]);
            for(int i=0; i <=99; i++)
                if(((Comparable<Person>)fullName[i]).compareTo(list.dequeue()) != 0)
                    System.out.println("ERROR, elements don't match");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        list.makeEmpty();
        try {
            for(int i=0; i < 100; i++)
                list.enqueue(fullName[i]);
            for(int i=1; i <= 100; i++)
                if(((Comparable<Person>)fullName[i-1]).compareTo(list.dequeue()) != 0)
                    System.out.println("ERROR, elements don't match");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        if(list.size() != 0)
            System.out.println("Size wrong, should be zero but is " + list.size());

        list.makeEmpty();
        for(int i=0; i < 100; i++)
            list.enqueue(fullName[i]);


        try {
            if(list.contains(new Person("Foobar")))
                System.out.println("ERROR, found an invalid element");
        }
        catch(Exception e) {
            System.out.println("ERROR, failed with negative location "+e);

        }


        // did they use equals or == ?
        list.enqueue(sentinal);
        if(list.contains(new Person("Aaron Burr")) == false)
            System.out.println("ERROR, could not find valid element");

//===========
        list2 = new Queue<Integer>();
        for(int i=1; i < 50; i++)
            list2.enqueue(new Integer(i));

        // this will remove the top half of the stack. Should only print 25-49 below
        for(int i=2; i <= 25; i++)
            list2.dequeue();

        for(Integer x : list2)
            System.out.print(x+" ");
        System.out.println();

        System.out.println("Done.");

    }

    public static void main(String [] args) {
        try {
            new QueueTester();
        }
        catch(Exception e) {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }


    // implements Comparable but NOT equals
    class Person implements Comparable<Person> {
        String name;

        public Person(String n) {
            name = n;
        }

        public String getName() {
            return name;
        }

        public int compareTo(Person p) {
            return name.compareTo(p.name);
        }

        public String toString() {
            return name;
        }
    }
}