/**
 * Created by guillermo on 3/4/15.
 */
public class Faculty extends Person {
    protected String position;
    protected boolean tenureTrack;

    public Faculty(String n) {
        super(n);
    }

    public String getName() {
        return "I am a Faculty member, and my name is "+ name;
    }
    public void setTrack(boolean track) {
        tenureTrack = track;
    }

    public boolean getTrack() {
        return tenureTrack;
    }

    public String getTitle() {
        return "Faculty member";
    }
}
