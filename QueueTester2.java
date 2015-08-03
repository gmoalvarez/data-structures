import data_structures.LinkedQueue;

public class QueueTester2 {
    private LinkedQueue<Job> aQueue;

    public QueueTester2(){

        try {
            aQueue = new LinkedQueue<Job>();

            runTests();
            System.out.println("Test runs");
            aQueue.enqueue(new Job(3,"B"));
            aQueue.enqueue(new Job(6,"C"));
            aQueue.enqueue(new Job(9,"D"));
            aQueue.enqueue(new Job(12,"D"));
            aQueue.enqueue(new Job(15,"E"));
            int i = 1;
            System.out.println("aQ size = " + aQueue.size());
            while ( !aQueue.isEmpty()) {
                System.out.println("aQueue[" + i++ + "]= " + aQueue.dequeue().toString());
            }

        }
        catch (Exception e) {
            System.out.println("Failed!!!");
            e.printStackTrace();
        }

    }

    private void runTests(){

        int points = 20;
        try {
            enQueueTest();
        } catch (Exception ex) {
            System.err.println("Enqueue Failed");
            //ex.printStackTrace();
            points -= 20;
        }


    }
    private void enQueueTest() throws Exception {
        if (aQueue.size() != 0) {
            throw new Exception("Add First Failed");
        }

        aQueue.enqueue(new Job(5, "A"));

        if (aQueue.size() != 1) {
            throw new Exception("Add First Failed");
        }

        aQueue.enqueue(new Job(7, "B"));
        aQueue.enqueue(new Job(2, "C"));
        aQueue.enqueue(new Job(10, "D"));
        aQueue.enqueue(new Job(5, "E"));
        aQueue.enqueue(new Job(1, "F"));
        aQueue.enqueue(new Job(5, "G"));
        aQueue.enqueue(new Job(1, "H"));

        if (aQueue.size() != 8) {
            throw new Exception("Enqueue Failed");
        }
    }

    public class Job implements Comparable<Job> {

        private int priority;
        private String label;

        public Job(int p, String s) {
            priority = p;
            label = s;
        }

        public int compareTo(Job j) {
            return priority - j.priority;
        }

        public String toString() {
            return label + " priority=" + priority;
        }

    }
    public static void main(String args[]) {
        System.out.println("Running Tests");
        new QueueTester2();

    }

}
