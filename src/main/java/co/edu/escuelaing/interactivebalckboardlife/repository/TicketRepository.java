package co.edu.escuelaing.interactivebalckboardlife.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TicketRepository {
    private static TicketRepository _instance = new TicketRepository();
    private final List<String> listTickets;
    private int ticketNumber;

    public TicketRepository() {
        listTickets = new CopyOnWriteArrayList<>();
        ticketNumber = 0;
    }

    public static TicketRepository getInstance(){
        return _instance;
    }

    public synchronized Integer getTicket(){
        Integer a = ticketNumber++;
        listTickets.add(a.toString());
        return a;
    }

    public boolean checkTicket(String ticket){
        boolean isValid = listTickets.remove(ticket);
        return isValid;
    }

    private void eviction(){

    }

}
