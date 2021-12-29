import beans.Subject;
import beans.Solution;
import subject.linkedList.*;

public class boot {
    public static void main(String[] args) {
        Solution solution = new N21();
        Subject subject = new Subject(solution);
        subject.run();
    }
}
