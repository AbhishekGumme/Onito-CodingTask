package com.onito.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.onito.entity.TambolaTicket;

public interface TambolaTicketRepository extends JpaRepository<TambolaTicket, Long> {
}