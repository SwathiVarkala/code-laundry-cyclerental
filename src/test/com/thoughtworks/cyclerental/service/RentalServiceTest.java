package com.thoughtworks.cyclerental.service;

import com.thoughtworks.cyclerental.dto.Customer;
import com.thoughtworks.cyclerental.dto.Cycle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RentalServiceTest {

    RentalService rentalService;

    @Test public void testRentingCycleAndReturnWithinNoOfDays() {
        rentalService.rentCycle(2, 1);
        assertEquals("5 Rent: 5.0\n" +
                "-------------------------------------------\n" +
                "Total: 5.0",
                rentalService.returnCycle(1, 5));
    }

    @Test public void testRentingCycleAndReturnAfterNoOfDays() {
        rentalService.rentCycle(2, 1);
        assertEquals("Base Rent for 10: 5.0Extra Rent for 1 extra days: 10.0\n" +
                        "-------------------------------------------\n" +
                        "Total: 15.0",
                rentalService.returnCycle(1, 11));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        Cycle cycle = new Cycle(1, "Hero", "Hero 1.1", (double) 5);
        Cycle cycleWithBasePrice = new Cycle(2, "Hero", "Hero 1.1", (double) 5, 10, (double) 10);
        Customer customer = new Customer(1, "Swathi");
        List<Cycle> cycles = new ArrayList<>();
        cycles.add(cycle);
        cycles.add(cycleWithBasePrice);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer);
        rentalService = new RentalService(cycles, customers);
    }
}
