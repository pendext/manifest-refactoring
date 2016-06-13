package com.manifestcorp.refactoring.rental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals;
    private static final String TAB = "\t";
    private static final String NEWLINE = "\n";

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
            double amountForIndividualRental = 0;

            amountForIndividualRental += rental.getPrice();

            // Add a frequent renter point for each rental
            frequentRenterPoints += calculateFrequentRenterPointsForRental(rental); 
            result += TAB + rental.getMovie().getTitle() + TAB + String.valueOf(amountForIndividualRental) + NEWLINE;
            totalAmountForStatement += amountForIndividualRental;
        }

        result += "Amount owed is " + String.valueOf(totalAmountForStatement) + NEWLINE;
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

}
