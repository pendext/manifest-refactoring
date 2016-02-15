package com.manifestcorp.refactoring.rental;

public class NewReleaseRental extends Rental {

    public NewReleaseRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    double getCost() {
        return getDaysRented() * 3;
    }
}
