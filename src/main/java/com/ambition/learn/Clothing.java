package com.ambition.learn;

import java.util.ArrayList;
import java.util.List;

class Clothing implements Comparable<Clothing> {
    private List<Integer> ratings;

    public Clothing() {
        this.ratings = new ArrayList<>();
    }

    public void rate(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        ratings.add(rating);
    }

    @Override
    public int compareTo(Clothing other) {
        double avgRating = ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
        double otherAvgRating = other.ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
        return Double.compare(otherAvgRating, avgRating);
    }
}

class Pants extends Clothing {
    private int size;
    private ClothingType type;

    public Pants(int size, ClothingType type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return type + ", size " + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pants pants = (Pants) obj;
        return size == pants.size && type == pants.type;
    }
}

class Shirt extends Clothing {
    private int size;
    private ClothingType type;

    public Shirt(int size, ClothingType type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return type + ", size " + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shirt shirt = (Shirt) obj;
        return size == shirt.size && type == shirt.type;
    }
}

enum ClothingType {
    COLOR,
    SEASON
}

class Outfit {
    private List<Clothing> outfit;

    public Outfit(int size, ClothingType type) {
        outfit = new ArrayList<>();
        outfit.add(new Shirt(size, type));
        outfit.add(new Pants(size, type));
    }

    public Outfit merge(Outfit other) {
        Outfit mergedOutfit = new Outfit(0, ClothingType.COLOR);
        mergedOutfit.outfit.addAll(this.outfit);
        mergedOutfit.outfit.addAll(other.outfit);
        return mergedOutfit;
    }
}
