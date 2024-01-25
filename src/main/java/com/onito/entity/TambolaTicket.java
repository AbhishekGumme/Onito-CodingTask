package com.onito.entity;



import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tambola_tickets")
public class TambolaTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_key", nullable = false)
    private String ticketKey;

    @ElementCollection
    @CollectionTable(name = "ticket_data", joinColumns = @JoinColumn(name = "ticket_id"))
    @Column(name = "number")
    private List<List<Integer>> ticketData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketKey() {
		return ticketKey;
	}

	public void setTicketKey(String ticketKey) {
		this.ticketKey = ticketKey;
	}

	public List<List<Integer>> getTicketData() {
		return ticketData;
	}

	public void setTicketData(List<List<Integer>> ticketData) {
		this.ticketData = ticketData;
	}

	public TambolaTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TambolaTicket(Long id, String ticketKey, List<List<Integer>> ticketData) {
		super();
		this.id = id;
		this.ticketKey = ticketKey;
		this.ticketData = ticketData;
	}

    
}
