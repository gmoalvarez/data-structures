
/**
 * Created by guillermo on 3/4/15.
 */
public class Person implements Comparable<Person>{
    protected String redID;
    protected String name;

    public Person(String n) {
        name = n;
    }

    public String getRedID() {
        return redID;
    }

    public String getName() {
        return "I am a person, and my name is "+ name;
    }

    public void setRedID(String id) {
        redID = id;
    }

    public void setName(String n) {
        name = n;
    }

    public String toString() {
        return getName();
    }
    public String getTitle() {
        return "Mr/Ms";
    }

    public int compareTo(Person p) {
        return name.compareTo(p.name);
    }

}

