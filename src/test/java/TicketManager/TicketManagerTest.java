package TicketManager;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {
    @Test
    public void ticketTest() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, 100, "MSK", "SPB", 72);
        Ticket ticket2 = new Ticket(2, 500, "MSK", "SPB", 73);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "SPB", 71);
        Ticket ticket4 = new Ticket(4, 400, "MSK", "SPB", 74);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.findAll("MSK", "SPB");
        Ticket[] expected = {ticket1, ticket3, ticket4, ticket2};


        assertArrayEquals(actual, expected);
    }

    @Test
    public void ticketTest2() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1, 500, "MSK", "GOJ", 63);
        Ticket ticket2 = new Ticket(2, 500, "MSK", "SPB", 73);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "SPB", 71);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] actual = manager.findAll("MSK", "GOJ");
        Ticket[] expected = {ticket1};


        assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketTest3() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1, 500, "MSK", "UFA", 113);
        Ticket ticket2 = new Ticket(2, 500, "MSK", "SPB", 73);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "SPB", 71);
        Ticket ticket4 = new Ticket(4, 200, "MSK", "UFA", 114);
        Ticket ticket5 = new Ticket(5, 900, "MSK", "UFA", 115);
        Ticket ticket6 = new Ticket(6, 400, "MSK", "UFA", 113);
        Ticket ticket7 = new Ticket(7, 700, "MSK", "UFA", 111);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.findAll("MSK", "UFA");
        Ticket[] expected = {ticket4, ticket6, ticket1, ticket7, ticket5};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketTest4() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1, 500, "MSK", "UFA", 113);
        Ticket ticket2 = new Ticket(2, 500, "MSK", "SPB", 73);
        Ticket ticket3 = new Ticket(4, 300, "MSK", "SPB", 71);
        Ticket ticket4 = new Ticket(5, 200, "MSK", "UFA", 111);
        Ticket ticket5 = new Ticket(6, 900, "MSK", "UFA", 113);
        Ticket ticket6 = new Ticket(7, 400, "MSK", "UFA", 112);
        Ticket ticket7 = new Ticket(8, 700, "MSK", "UFA", 114);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.findAll("MSK", "MSK");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void ticketTest5WithComporator() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1, 500, "MSK", "UFA", 113);
        Ticket ticket2 = new Ticket(2, 500, "MSK", "SPB", 73);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "SPB", 71);
        Ticket ticket4 = new Ticket(4, 200, "MSK", "UFA", 111);
        Ticket ticket5 = new Ticket(5, 900, "MSK", "UFA", 115);
        Ticket ticket6 = new Ticket(6, 400, "MSK", "UFA", 112);
        Ticket ticket7 = new Ticket(7, 700, "MSK", "UFA", 114);
        Ticket ticket8 = new Ticket(8, 700, "MSK", "GOJ", 64);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketByTimeComparator();

        Ticket[] actual = manager.findAll("MSK", "UFA", comparator);
        Ticket[] expected = {ticket5, ticket7, ticket1, ticket6, ticket4};

        assertArrayEquals(expected, actual);
    }
}

