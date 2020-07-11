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

    /**
     * @return obtain ticket to validate session
     */
    public synchronized Integer getTicket(){
        Integer a = ticketNumber++;
        listTickets.add(a.toString());
        return a;
    }

    /**
     * @param ticket possible valid ticket
     * @return if is valid the ticket or not
     */
    public boolean checkTicket(String ticket){
        boolean isValid = listTickets.remove(ticket);
        return isValid;
    }

    private void eviction(){

    }

}
