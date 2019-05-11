package com.akash.BookMyMovie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seat_details")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seat_id;

	private String seat_row;
	private Integer seat_no;

	public Seat() {
		super();
	}

	public Seat(Integer seat_id, String seat_row, Integer seat_no) {
		super();
		this.seat_id = seat_id;
		this.seat_row = seat_row;
		this.seat_no = seat_no;
	}

	public Integer getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(Integer seat_id) {
		this.seat_id = seat_id;
	}

	public String getSeat_row() {
		return seat_row;
	}

	public void setSeat_row(String seat_row) {
		this.seat_row = seat_row;
	}

	public Integer getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(Integer seat_no) {
		this.seat_no = seat_no;
	}

	@Override
	public String toString() {
		return "Seat [seat_id=" + seat_id + ", seat_row=" + seat_row + ", seat_no=" + seat_no + "]";
	}

}
