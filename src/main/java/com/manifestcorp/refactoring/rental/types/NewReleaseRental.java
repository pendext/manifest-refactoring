package com.manifestcorp.refactoring.rental.types;

import com.manifestcorp.refactoring.rental.*;

public class NewReleaseRental extends Rental {

    public NewReleaseRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    public double getPrice() {
        return this.getDaysRented() * 3;
    }
}
