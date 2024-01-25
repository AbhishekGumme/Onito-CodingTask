package com.onito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.onito.entity.TambolaTicket;
import com.onito.service.TambolaTicketService;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TambolaTicketController {

	@Autowired
    private TambolaTicketService tambolaTicketService;

    @PostMapping("/generate")
    public List<TambolaTicket> generateTickets(@RequestParam int numSets) {
        return tambolaTicketService.generateTickets(numSets);
    }

    @GetMapping
    public List<TambolaTicket> getAllTickets(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        return tambolaTicketService.getAllTickets(page, size);
    }
}