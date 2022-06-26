package ru.netology.manager;

import ru.netology.domian.TicketData;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

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
        Arrays.sort(ticket);
        return ticket;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }


}
