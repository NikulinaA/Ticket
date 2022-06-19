package ru.netology.manager;

import ru.netology.domian.TicketData;
import ru.netology.repository.TicketRepository;

public class TicketManager {
    private TicketRepository repository;


    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(TicketData ticket) {
        repository.save(ticket);
    }

    public TicketData[] findAll(String from, String to) {
        TicketData[] ticket = repository.findAll(from, to);
        return ticket;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    /*public TicketData[] searchBy(String from, String to) {

        int index = 0;

        TicketData[] result = new TicketData[index];
        for (TicketData ticket : repository.findAll(from, to)) {
            if (matches(ticket, from, to)) {
                int length = result.length + 1;
                TicketData[] tmp = new TicketData[length];


                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[index] = ticket;
                result = tmp;
                index++;

            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(TicketData ticket, String from, String to) {
        if (ticket.getAirportFrom().equals(from) || ticket.getAirportTo().equals(to)) {

            return true;
        } else {
            return false;
        }

    }*/

}
