package com.spring.integration.domain;

public class Ticket {

    private TicketSeverity severity;

    private String message;

    public Ticket(TicketSeverity severity, String message) {
        this.severity = severity;
        this.message = message;
    }

    public TicketSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(TicketSeverity severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "severity=" + severity +
                ", message='" + message + '\'' +
                '}';
    }
}
