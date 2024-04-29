import Classes.Class;

public class Student {
    private final String name;
    private String MatNr;
    private final String gender;
    private final String courseName;
    private final String semester;

    public Student(String name, String gender, String courseName, String semester) {
        this.name = name;
        this.gender = gender;
        this.courseName = courseName;
        this.semester = semester;
        setRandomStudentMatnr();
    }

    public String toString() {
        return "Students.Student: " + name + " (" + gender + ")" + " with Matriculation Number: " + MatNr;
    }

    private void setRandomStudentMatnr() {
        this.MatNr = "s0" + (int) (Math.random() * 1000000);
    }

    public String getName() {
        return name;
    }
}
