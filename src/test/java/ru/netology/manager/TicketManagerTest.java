package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domian.TicketData;
import ru.netology.repository.AlreadyExistsException;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketManagerTest {
    TicketData ticket1 = new TicketData(1, 2500, "svo", "kzn", 95);
    TicketData ticket2 = new TicketData(2, 1700, "vko", "kzn", 105);
    TicketData ticket3 = new TicketData(3, 6200, "vko", "kzn", 254);
    TicketData ticket4 = new TicketData(4, 2500, "svo", "kzn", 98);
    TicketData ticket5 = new TicketData(5, 2340, "svo", "kzn", 155);
    TicketData ticket6 = new TicketData(6, 12500, "vko", "kzn", 90);
    TicketData ticket7 = new TicketData(7, 21500, "svo", "kzn", 80);
    TicketData ticket8 = new TicketData(8, 22500, "svo", "aer", 195);
    TicketData ticket9 = new TicketData(9, 37000, "vko", "aer", 230);
    TicketData ticket10 = new TicketData(10, 500, "svo", "kzn", 950);
    TicketData ticket11 = new TicketData(11, 210, "vko", "kzn", 99);
    TicketData ticket12 = new TicketData(12, 2589, "vko", "kzn", 91);
    TicketData ticket13 = new TicketData(13, 28500, "svo", "kzn", 365);
    TicketData ticket101 = new TicketData(10, 500, "svo", "kzn", 950);

    @Test

    public void AddTicket() {
        TicketManager ticket = new TicketManager(new TicketRepository());

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        ticket.add(ticket10);
        ticket.add(ticket11);
        ticket.add(ticket12);
        ticket.add(ticket13);


        TicketData[] actual = ticket.findAll("svo", "kzn");
        TicketData[] expected = {ticket1,ticket4,ticket5,ticket7,ticket10,ticket13};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void AddTicketSort() {
        TicketManager ticket = new TicketManager(new TicketRepository());

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        ticket.add(ticket10);
        ticket.add(ticket11);
        ticket.add(ticket12);
        ticket.add(ticket13);
        TicketData[] sor = ticket.findAll("svo", "kzn");
        Arrays.sort(sor);
        TicketData[] actual = sor;

        TicketData[] expected = {ticket10,ticket5,ticket1,ticket4,ticket7,ticket13};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test

    public void AddNoTicket() {
        TicketManager ticket = new TicketManager(new TicketRepository());

        ticket.add(ticket2);

        TicketData[] actual = ticket.findAll("svo", "kzn");

        TicketData[] expected = {};


        Assertions.assertArrayEquals(expected, actual);
    }
    @Test

    public void RemoveNoIdTicketSort() {
        TicketManager ticket = new TicketManager(new TicketRepository());

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        ticket.add(ticket10);
        ticket.add(ticket11);
        ticket.add(ticket12);
        ticket.add(ticket13);
        TicketData[] sor = ticket.findAll("svo", "kzn");
        Arrays.sort(sor);
        TicketData[] actual = sor;



        assertThrows(NotFoundException .class, () -> {ticket.removeById(547);});
    }

    @Test

    public void RemoveIdTicketSort() {
        TicketManager ticket = new TicketManager(new TicketRepository());

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        ticket.add(ticket10);
        ticket.add(ticket11);
        ticket.add(ticket12);
        ticket.add(ticket13);

        ticket.removeById(4);
        TicketData[] sor = ticket.findAll("svo", "kzn");
        Arrays.sort(sor);
        TicketData[] actual = sor;

        TicketData[] expected = {ticket10,ticket5,ticket1,ticket7,ticket13};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void AddRepeatedIdTicket() {
        TicketManager ticket = new TicketManager(new TicketRepository());

        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
        ticket.add(ticket5);
        ticket.add(ticket6);
        ticket.add(ticket7);
        ticket.add(ticket8);
        ticket.add(ticket9);
        ticket.add(ticket10);
        ticket.add(ticket11);
        ticket.add(ticket12);
        ticket.add(ticket13);


        assertThrows(AlreadyExistsException.class, () -> {
            ticket.add(ticket101);
        });

    }


}
