package com.manifestcorp.refactoring.rental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals;

    public Customer(String customerName) {
        rentals = new ArrayList<Rental>();
        name = customerName;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental result for " + getName() + ".\n";

        for (Rental rental : getRentals()) {
            double thisAmount = 0;

            switch(rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2) {
                        thisAmount += (rental.getDaysRented() -2) * 1.5;
                    }
                    break;
                case Movie.NEW_REALEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3) {
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }

            // Add a frequent renter point for each rental
            frequentRenterPoints++;

            if ((rental.getMovie().getPriceCode() == Movie.NEW_REALEASE) &&
                rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points.";
        return result;
    }


}
