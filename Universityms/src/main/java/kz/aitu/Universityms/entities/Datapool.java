package kz.aitu.Universityms.entities;

import java.util.ArrayList;
import java.util.List;

public class Datapool {

    private static final List<Univer> universities = new ArrayList<>();

    public static void init() {
        universities.add(new Univer("AITU", "Astana", 1));
        universities.add(new Univer("KBTU", "Almaty", 2));
        universities.add(new Univer("ENU", "Astana", 3));
        universities.add(new Univer("SKQU", "Petropavl", 4));
    }



    public static void addUniversity(Univer univer)
    {
        universities.add(univer);
    }


    public static List<Univer> findByCity(String city) {
        List<Univer> result = new ArrayList<>();
        if (city == null) return result;

        for (Univer u : universities) {
            if (u.getLocation().equalsIgnoreCase(city)) {
                result.add(u);
            }
        }
        return result;
    }


    public static List<Univer> filterByMinRating(double minRating) {
        List<Univer> result = new ArrayList<>();
        for (Univer u : universities) {
            if (u.getRating() >= minRating) {
                result.add(u);
            }
        }
        return result;
    }


    public static List<Univer> sortByRating() {
        List<Univer> sorted = new ArrayList<>(universities);
        sorted.sort(java.util.Comparator.comparingDouble(Univer::getRating));
        return sorted;
    }

}
