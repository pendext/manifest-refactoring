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

            amountForIndividualRental += rental.getCost();

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

    private double getPriceforRental(Rental rental) {
        double amountForIndividualRental = 0;
        switch(rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    amountForIndividualRental += 2;
                    if (rental.getDaysRented() > 2) {
                        amountForIndividualRental += (rental.getDaysRented() -2) * 1.5;
                    }
                    break;
                case Movie.NEW_REALEASE:
                    amountForIndividualRental += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    amountForIndividualRental += 1.5;
                    if (rental.getDaysRented() > 3) {
                        amountForIndividualRental += (rental.getDaysRented() - 3) * 1.5;
                    }
                    break;
                default:
                    throw new RuntimeException();
            }
            return amountForIndividualRental;
    }


}
