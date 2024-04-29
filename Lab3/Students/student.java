package Students;

import Classes.Class;

public class Student {
    private final String name;
    private String MatNr;
    private final String gender;
    private final boolean isPreferredCandidate;

    public Student(String name, String gender, boolean isPreferredCandidate) {
        this.name = name;
        this.gender = genders;
        this.isPreferredCandidate = isPreferredCandidate;
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

    public boolean isPreferredCandidate() {
        return isPreferredCandidate;
    }

    public void notifyifaccepted(Class acceptedClass) {
        System.out.println("Student.Student" + name + " has been accepted to class " + acceptedClass);
    }

}
