package kz.aitu.Universityms.entities;

public class proffesor extends Person {

    private String department;
    private double salary;

    public proffesor(int id, String fullName, String department, double salary) {
        super(id, fullName);
        this.department = department;
        this.salary = salary;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String getInfo() {
        return "Professor{id=" + getId() + ", name='" + getFullName() + "', department='" + department + "', salary=" + salary + "}";
    }


    public void compareSalary(proffesor other) {
        if (other == null) {
            System.out.println("there is no prof. with this name");
            return;
        }

        if (this.salary > other.salary) {
            System.out.println(getFullName() + " has a bigger salary than " + other.getFullName());
        } else if (this.salary < other.salary) {
            System.out.println(other.getFullName() + " has a bigger salary than " + getFullName());
        } else {
            System.out.println("They have the same salary");
        }
        System.out.println();
    }
}

