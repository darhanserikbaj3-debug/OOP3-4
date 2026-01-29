package kz.aitu.Universityms.entities;

public class Course {

    private String courseName;
    private String courseCode;
    private Integer credits;

    public Course() {}

    public Course(String courseName, String courseCode, Integer  credits) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }


    public Integer getCredits() { return credits; }
    public void setCredits(Integer credits) { this.credits = credits; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }


    public void Info()
    {
        System.out.println("Course name: " + courseName);
        System.out.println("Course code: " + courseCode);
        System.out.println("course сredits: " + credits + "\n");
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", credits=" + credits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Course course = (Course) o;

        return courseCode != null && courseCode.equalsIgnoreCase(course.courseCode);
    }

    @Override
    public int hashCode() {

        String safeCourseCode;

        if (courseCode == null) {
            safeCourseCode = null;
        } else {
            safeCourseCode = courseCode.toLowerCase();
        }

        return java.util.Objects.hash(safeCourseCode);
    }

}
