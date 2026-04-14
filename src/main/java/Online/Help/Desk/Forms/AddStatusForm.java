package Online.Help.Desk.Forms;

import Online.Help.Desk.Model.Status;
import Online.Help.Desk.Model.Ticket;
import org.antlr.v4.runtime.misc.NotNull;

public class AddStatusForm {

    private Ticket ticket;

    private Status status;

    @NotNull
    private int ticketId;

    @NotNull
    private int statusId;

    public AddStatusForm(Ticket ticket, Status status){
        this.ticket = ticket;
        this.status = status;
    }

    public AddStatusForm(){};

    public Ticket getTicket() {
        return ticket;
    }

    public Status getStatus() {
        return status;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getStatusId() {
        return statusId;
    }
}
