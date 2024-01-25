package com.onito.service;

import java.util.List;

import com.onito.entity.TambolaTicket;

public interface TambolaTicketService {
	
	
    List<TambolaTicket> generateTickets(int numSets);

    List<TambolaTicket> getAllTickets(int page, int size);
}
