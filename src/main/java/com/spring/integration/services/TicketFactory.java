package com.spring.integration.services;

import com.google.common.collect.ImmutableList;
import com.spring.integration.domain.Ticket;
import com.spring.integration.domain.TicketSeverity;

import java.util.List;

public class TicketFactory {

    public List<Ticket> generateTickets() {
        return ImmutableList.of(
                new Ticket(TicketSeverity.MEDIUM, "UAT is DOWN !"),
                new Ticket(TicketSeverity.HIGH, "QA is DOWN !"),
                new Ticket(TicketSeverity.LOW, "DEV is DOWN !"),
                new Ticket(TicketSeverity.CRITICAL, "PROD is DOWN !")
        );
    }

}