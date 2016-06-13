package com.manifestcorp.refactoring.rental.types;

import com.manifestcorp.refactoring.rental.*;

public class ChildrensRental extends Rental {

    public ChildrensRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    public double getPrice() {
        double initalAmount = 1.5;
        if (this.getDaysRented() > 3) {
            initalAmount += (this.getDaysRented() -3) * 1.5;
        }
        return initalAmount;
    }
}
