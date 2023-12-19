package com.gabriella.itschool.utils.design_patterns;

public class SingletonExample {

}

class Catalog {

    private static Catalog instance;
//    private List<String> books;

    private Catalog() {
//        books = new ArrayList<>();
    }

    public static synchronized Catalog getInstance() {
        if (instance == null) {
            instance = new Catalog();
        }

        return instance;
    }
}
