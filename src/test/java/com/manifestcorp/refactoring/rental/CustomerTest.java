package com.manifestcorp.refactoring.rental;

import com.manifestcorp.refactoring.rental.types.*;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void customerWithSingleRegularRentalProducesAccurateStatement() throws Exception {
        Customer customer = new Customer("Phillip J. Fry");
        Movie movie = new Movie("Blade Runner", Movie.REGULAR);
        Rental rental = new RegularRental(movie, 1);

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
        Movie bladeRunner = new Movie("Blade Runner", Movie.REGULAR);
        Movie jaws = new Movie("Jaws", Movie.REGULAR);
        Movie starWars = new Movie("Star Wars", Movie.REGULAR);

        Rental bladeRunnerRental = new RegularRental(bladeRunner, 1);
        Rental jawsRental = new RegularRental(jaws, 1);
        Rental starWarsRental = new RegularRental(starWars, 1);

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
        Movie movie = new Movie("Blade Runner", Movie.REGULAR);
        Rental rental = new RegularRental(movie, 4);

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
        Movie movie = new Movie("Toy Story", Movie.CHILDRENS);
        Rental rental = new ChildrensRental(movie, 4);

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
        Movie bladeRunner = new Movie("Blade Runner", Movie.REGULAR);
        Movie jaws = new Movie("Jaws", Movie.REGULAR);
        Movie starWars = new Movie("Star Wars", Movie.REGULAR);
        Movie inBruges = new Movie("In Bruges", Movie.REGULAR);
        Movie thisIsTheEnd = new Movie("This Is The End", Movie.NEW_REALEASE);
        Movie theLittleMermaid = new Movie("The Little Mermaid", Movie.CHILDRENS);

        Rental bladeRunnerRental = new RegularRental(bladeRunner, 4);
        Rental jawsRental = new RegularRental(jaws, 3);
        Rental starWarsRental = new RegularRental(starWars, 2);
        Rental inBrugesRental = new RegularRental(inBruges, 3);
        Rental thisIsTheEndRental = new NewReleaseRental(thisIsTheEnd, 5);
        Rental theLittleMermaidRental = new ChildrensRental(theLittleMermaid, 1);

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
