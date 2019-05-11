package com.akash.BookMyMovie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket_details")
public class TicketDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticketId;
	
	private String username;
	private String movie_name;
	private Integer nooftickets;
	private int amountpaid;
	
	public TicketDetails() {
	}

	public TicketDetails(int ticketId, String username, String movie_name, Integer nooftickets, int amountpaid) {
		super();
		this.ticketId = ticketId;
		this.username = username;
		this.movie_name = movie_name;
		this.nooftickets = nooftickets;
		this.amountpaid = amountpaid;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public Integer getNooftickets() {
		return nooftickets;
	}

	public void setNooftickets(Integer nooftickets) {
		this.nooftickets = nooftickets;
	}

	public int getAmountpaid() {
		return amountpaid;
	}

	public void setAmountpaid(int amountpaid) {
		this.amountpaid = amountpaid;
	}

	@Override
	public String toString() {
		return "TicketDetails [ticketId=" + ticketId + ", username=" + username + ", movie_name=" + movie_name
				+ ", nooftickets=" + nooftickets + ", amountpaid=" + amountpaid + "]";
	}

}
