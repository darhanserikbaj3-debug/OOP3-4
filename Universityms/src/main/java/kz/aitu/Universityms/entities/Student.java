package kz.aitu.Universityms.entities;

public class Student extends Person {

    private String major;
    private double gpa;


    public Student(int id, String fullName, String major, double gpa) {
        super(id, fullName);
        this.major = major;
        this.gpa = gpa;
    }


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


    @Override
    public String getInfo() {
        return "Student{id=" + getId() + ", name='" + getFullName() + "', major='" + major + "', gpa=" + gpa + "}";
    }
}

