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
            double individualAmount = getAmountForRental(rental);
            frequentRenterPoints = incrementFrequentRenterPoints(frequentRenterPoints, rental);
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(individualAmount) + "\n";
            totalAmount += individualAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points.";
        return result;
    }

    private int incrementFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        frequentRenterPoints++;
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
            rental.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    private double getAmountForRental(Rental rental) {
        double amount = 0;
        switch(rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (rental.getDaysRented() > 2) {
                    amount += (rental.getDaysRented() - 2) * 1.5;
                }
                return amount;
            case Movie.NEW_RELEASE:
                amount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (rental.getDaysRented() > 3) {
                    amount += (rental.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return amount;
    }


}
