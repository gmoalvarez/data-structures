/**
 * Created by guillermo on 3/4/15.
 */
public class Professor extends Faculty {
    protected String rank;
    protected float annualSalary;

    public Professor(String n) {
        super(n);
    }
    public String getName() {
        return "I am a professor, and my name is "+ name;
    }

    public float getSalary() {
        return annualSalary;
    }

    public void setSalary(float f) {
        annualSalary = f;
    }

    public float pay() {
        return annualSalary / 12.0f;
    }

    public String getTitle() {
        return "Professor";
    }
}
