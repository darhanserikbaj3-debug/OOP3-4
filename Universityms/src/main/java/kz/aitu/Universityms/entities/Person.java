package kz.aitu.Universityms.entities;

public abstract class Person {

    private final int id;
    private String fullName;

    protected Person(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId()
    {
        return id;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }


    public abstract String getInfo();


    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
}
