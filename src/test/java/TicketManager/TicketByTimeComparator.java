package TicketManager;


import java.util.Comparator;

public class TicketByTimeComparator  implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o2.getTime() - o1.getTime();
    }
}
