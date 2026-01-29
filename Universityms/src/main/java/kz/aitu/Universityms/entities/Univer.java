package kz.aitu.Universityms.entities;

public class Univer {

    private String name;
    private String location;
    private Integer rating;

    public Univer() {
    }

    public Univer(String name, String location, Integer rating) {
        this.name = name;
        this.location = location;
        this.rating = rating;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }


    public void UniInfo() {
        System.out.println("Uni name: " + name);
        System.out.println("Uni location: " + location);
        System.out.println("Uni rating: " + rating + "\n");
    }


    public void CompareUni(Univer other) {
        if (this.rating > other.rating) {
            System.out.println(this.name + " has bigger rating than " + other.name + "\n");
        } else if (this.rating < other.rating) {
            System.out.println(other.name + " has bigger rating than " + this.name + "\n");
        } else {
            System.out.println("They have the same rating" + "\n");
        }
    }


    @Override
    public String toString() {
        return "Univer{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Univer univer = (Univer) o;

        return name != null && location != null
                && name.equalsIgnoreCase(univer.name)
                && location.equalsIgnoreCase(univer.location);
    }

    @Override
    public int hashCode() {

        String safeName;
        if (name == null) {
            safeName = null;
        } else {
            safeName = name.toLowerCase();
        }

        String safeLocation;
        if (location == null) {
            safeLocation = null;
        } else {
            safeLocation = location.toLowerCase();
        }

        return java.util.Objects.hash(safeName, safeLocation);
    }
}

