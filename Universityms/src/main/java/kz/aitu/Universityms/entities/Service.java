package kz.aitu.Universityms.entities;

public class Service {

    public static void searchByCity(String city) {
        var found = Datapool.findByCity(city);
        if (found.isEmpty()) {
            System.out.println("No university found in " + city);
            return;
        }

        System.out.println("Universities in " + city + ":");
        for (Univer u : found) {
            u.UniInfo();
        }
    }



    public static void SearchUniInAstana() {
        var found = Datapool.findByCity("Astana");
        if (found.isEmpty()) {
            System.out.println("No universities found in Astana");
            return;
        }

        System.out.println("Universities in Astana:");
        for (Univer u : found) {
            u.UniInfo();
        }
    }


    public static void sortingByRating() {
        Datapool.sortByRating()
                .forEach(u -> System.out.println(u.getName() + " | rating: " + u.getRating()));
    }


    public static void filterByMinRating(double minRating) {
        var list = Datapool.filterByMinRating(minRating);
        System.out.println("Universities with rating >= " + minRating + ":");
        if (list.isEmpty()) {
            System.out.println("(none)\n");
            return;
        }
        for (Univer u : list) {
            System.out.println(u);
        }
        System.out.println();
    }
}