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
        double totalAmountForStatement = 0;
        int frequentRenterPoints = 0;
        String result = "Rental result for " + getName() + ".\n";

        for (Rental rental : getRentals()) {
            double thisAmount = 0;

            thisAmount += getPriceforRental(rental);

            // Add a frequent renter point for each rental
            frequentRenterPoints += calculateFrequentRenterPointsForRental(rental); 
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmountForStatement += thisAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmountForStatement) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points.";
        return result;
    }

    private int calculateFrequentRenterPointsForRental(Rental rental) {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;

        if (rentalShouldHaveFrequentRenterPointsIncremented(rental)) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    private boolean rentalShouldHaveFrequentRenterPointsIncremented(Rental rental) {
        return (rental.getMovie().getPriceCode() == Movie.NEW_REALEASE &&
                rental.getDaysRented() > 1);
    }

    private double getPriceforRental(Rental rental) {
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
            return thisAmount;
    }


}
