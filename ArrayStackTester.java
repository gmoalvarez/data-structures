import data_structures.ArrayStack;
import data_structures.StackADT;
import java.util.Arrays;
/**
 *
 * @author steve_000
 */
public class ArrayStackTester {

    public static <E> void reverse(E[] a) {
        StackADT<E> buffer = new ArrayStack<>(a.length);
        for (int i =0; i<a.length;i++){
            buffer.push(a[i]);
        }
        for (int j = 0; j < a.length; j++){
            a[j] =  buffer.pop();
        }
    }

    public static void main(String[] args) {
        // demo reverse using stack
        System.out.println("Hello from DemoStacks!");
        Integer[] a = {2,4,6,8,10,12};
        String[] s  = {"Alan","Bob","Carol","Debbie","Erikson"};

        System.out.println("A = " + Arrays.toString(a));
        System.out.println("S = " + Arrays.toString(s));
        System.out.println("Reversing them...");
        reverse(a);
        reverse(s);
        System.out.println("A = " + Arrays.toString(a));
        System.out.println("S = " + Arrays.toString(s));

    }
}
