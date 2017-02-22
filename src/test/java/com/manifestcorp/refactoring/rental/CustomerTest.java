package com.manifestcorp.refactoring.rental;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void customerWithSingleRegularRentalProducesAccurateStatement() throws Exception {
        Customer customer = new Customer("Phillip J. Fry");
        Movie movie = new RegularMovie("Blade Runner", Movie.REGULAR);
        Rental rental = new Rental(movie, 1);

        customer.addRental(rental);

        String expectedResult = "Rental result for Phillip J. Fry.\n";
        expectedResult += "\tBlade Runner\t2.0\n";
        expectedResult += "Amount owed is 2.0\n";
        expectedResult += "You earned 1 frequent renter points.";

        assertEquals("The statement method did not return the appropriate string.",
                expectedResult, customer.statement());
    }

    @Test
    public void customerWithMultipleRegularRentalsProducesAccurateStatement() throws Exception {
        Customer customer = new Customer("Phillip J. Fry");
        Movie bladeRunner = new RegularMovie("Blade Runner", Movie.REGULAR);
        Movie jaws = new RegularMovie("Jaws", Movie.REGULAR);
        Movie starWars = new RegularMovie("Star Wars", Movie.REGULAR);

        Rental bladeRunnerRental = new Rental(bladeRunner, 1);
        Rental jawsRental = new Rental(jaws, 1);
        Rental starWarsRental = new Rental(starWars, 1);

        customer.addRental(bladeRunnerRental);
        customer.addRental(jawsRental);
        customer.addRental(starWarsRental);

        String expectedResult = "Rental result for Phillip J. Fry.\n";
        expectedResult += "\tBlade Runner\t2.0\n";
        expectedResult += "\tJaws\t2.0\n";
        expectedResult += "\tStar Wars\t2.0\n";
        expectedResult += "Amount owed is 6.0\n";
        expectedResult += "You earned 3 frequent renter points.";

        assertEquals("The statement method did not return the appropriate string.",
                expectedResult, customer.statement());
    }

    @Test
    public void customerWithSingleRegularRentalOfSeveralDaysProducesAccurateStatement() throws Exception {
        Customer customer = new Customer("Phillip J. Fry");
        Movie movie = new RegularMovie("Blade Runner", Movie.REGULAR);
        Rental rental = new Rental(movie, 4);

        customer.addRental(rental);

        String expectedResult = "Rental result for Phillip J. Fry.\n";
        expectedResult += "\tBlade Runner\t5.0\n";
        expectedResult += "Amount owed is 5.0\n";
        expectedResult += "You earned 1 frequent renter points.";

        assertEquals("The statement method did not return the appropriate string.",
                expectedResult, customer.statement());
    }

    @Test
    public void customerWithSingleChildrenRentalOfSeveralDaysProducesAccurateStatement() throws Exception {
        Customer customer = new Customer("Phillip J. Fry");
        Movie movie = new ChildrensMovie("Toy Story", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 4);

        customer.addRental(rental);

        String expectedResult = "Rental result for Phillip J. Fry.\n";
        expectedResult += "\tToy Story\t3.0\n";
        expectedResult += "Amount owed is 3.0\n";
        expectedResult += "You earned 1 frequent renter points.";

        assertEquals("The statement method did not return the appropriate string.",
                expectedResult, customer.statement());
    }

    @Test
    public void customerWithMultipleMoviesOfVaryingTypesAndDaysProducesAccurateStatement() throws Exception {
        Customer customer = new Customer("Phillip J. Fry");
        Movie bladeRunner = new RegularMovie("Blade Runner", Movie.REGULAR);
        Movie jaws = new RegularMovie("Jaws", Movie.REGULAR);
        Movie starWars = new RegularMovie("Star Wars", Movie.REGULAR);
        Movie inBruges = new RegularMovie("In Bruges", Movie.REGULAR);
        Movie thisIsTheEnd = new NewMovie("This Is The End", Movie.NEW_RELEASE);
        Movie theLittleMermaid = new ChildrensMovie("The Little Mermaid", Movie.CHILDRENS);

        Rental bladeRunnerRental = new Rental(bladeRunner, 4);
        Rental jawsRental = new Rental(jaws, 3);
        Rental starWarsRental = new Rental(starWars, 2);
        Rental inBrugesRental = new Rental(inBruges, 3);
        Rental thisIsTheEndRental = new Rental(thisIsTheEnd, 5);
        Rental theLittleMermaidRental = new Rental(theLittleMermaid, 1);

        customer.addRental(bladeRunnerRental);
        customer.addRental(jawsRental);
        customer.addRental(starWarsRental);
        customer.addRental(inBrugesRental);
        customer.addRental(thisIsTheEndRental);
        customer.addRental(theLittleMermaidRental);

        String expectedResult = "Rental result for Phillip J. Fry.\n";
        expectedResult += "\tBlade Runner\t5.0\n";
        expectedResult += "\tJaws\t3.5\n";
        expectedResult += "\tStar Wars\t2.0\n";
        expectedResult += "\tIn Bruges\t3.5\n";
        expectedResult += "\tThis Is The End\t15.0\n";
        expectedResult += "\tThe Little Mermaid\t1.5\n";
        expectedResult += "Amount owed is 30.5\n";
        expectedResult += "You earned 7 frequent renter points.";

        assertEquals("The statement method did not return the appropriate string.",
                expectedResult, customer.statement());
    }

}
