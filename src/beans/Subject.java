package beans;

public class Subject {
    public Solution solution;

    public Subject(Solution solution) {
        this.solution = solution;
    }

    public void run() {
        solution.solve();
    }
}
