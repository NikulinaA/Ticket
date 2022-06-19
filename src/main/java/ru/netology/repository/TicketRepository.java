package ru.netology.repository;

import ru.netology.domian.TicketData;

public class TicketRepository {
    private TicketData[] tickets = new TicketData[0];

    public TicketRepository() {

    }

    public void save(TicketData ticket) {
        int id = ticket.getId();
        if (findById(id) != null) {
            throw new AlreadyExistsException("Идентификатор " + ticket.getId() + " уже существует");
        }

        int length = tickets.length + 1;
        TicketData[] tmp = new TicketData[length];

        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;


    }

    public TicketData[] findAll(String from, String to) {
        TicketData[] tmp = new TicketData[tickets.length];
        int index = 0;
        for (TicketData ticket : tickets) {
            if (ticket.getAirportFrom() == from) {
                if (ticket.getAirportTo() == to) {
                    tmp[index] = ticket;
                    index++;
                }
            }
        }
        TicketData[] find = new TicketData[index];
        System.arraycopy(tmp, 0, find, 0, find.length);
        if (find.length != 0) {
            return find;

        }
        TicketData[] noS = new TicketData[0];
        return noS;
    }

    public void removeById(int id) {
        int length = tickets.length - 1;
        TicketData[] tmp = new TicketData[length];
        int index = 0;
        if (findById(id) != null) {

            for (TicketData ticket : tickets) {
                if (ticket.getId() != id) {
                    tmp[index] = ticket;
                    index++;
                }
            }
            tickets = tmp;

        } else {
            throw new NotFoundException("Идентификатор " + id + " не найден. Введите валидный идентификатор.");
        }
    }


    public TicketData[] findById(int id) {

        TicketData[] tmp = new TicketData[tickets.length];
        int index = 0;
        for (TicketData ticket : tickets) {
            if (ticket.getId() == id) {
                tmp[index] = ticket;
                index++;
            }
        }
        TicketData[] find = new TicketData[index];
        System.arraycopy(tmp, 0, find, 0, find.length);
        if (find.length != 0) {
            return find;

        }
        return null;
    }
}
