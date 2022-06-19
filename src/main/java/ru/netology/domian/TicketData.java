package ru.netology.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketData implements Comparable<TicketData> {
    private int id;
    private double price;
    private String airportFrom;
    private String airportTo;
    private int travelTime;

    @Override
    public int compareTo(TicketData otherTicket) {
        if (price < otherTicket.price) {
            return -1;
        } else if (price > otherTicket.price) {
            return 1;
        }
        return 0;
    }
}
