package com.onito.service;

import com.onito.entity.TambolaTicket;
import com.onito.repository.TambolaTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.PageRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class TambolaTicketServiceImpl implements TambolaTicketService {

    @Autowired
    private TambolaTicketRepository tambolaTicketRepository;

    @Override
    @Transactional
    public List<TambolaTicket> generateTickets(int numSets) {
        List<TambolaTicket> generatedTickets = new ArrayList<>();

        try {
            for (int i = 1; i <= numSets; i++) {
                TambolaTicket ticket = generateSingleTicket();
                tambolaTicketRepository.save(ticket);
                generatedTickets.add(ticket);
            }
            return generatedTickets;
        } catch (Exception e) {
            
            e.printStackTrace();
            throw new RuntimeException("Error generating and saving Tambola tickets");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<TambolaTicket> getAllTickets(int page, int size) {
        try {
            List<TambolaTicket> tickets = tambolaTicketRepository.findAll(PageRequest.of(page, size)).getContent();
            return tickets;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching Tambola tickets");
        }
    }

    private TambolaTicket generateSingleTicket() {
        TambolaTicket ticket = new TambolaTicket();
        ticket.setTicketKey("Ticket_" + System.currentTimeMillis());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 90; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        List<List<Integer>> ticketData = new ArrayList<>();
        int index = 0;
        for (int row = 0; row < 3; row++) {
            List<Integer> rowData = new ArrayList<>();
            for (int col = 0; col < 9; col++) {
                rowData.add(numbers.get(index++));
            }
            ticketData.add(rowData);
        }

        ticket.setTicketData(ticketData);

        return ticket;
    }
}
