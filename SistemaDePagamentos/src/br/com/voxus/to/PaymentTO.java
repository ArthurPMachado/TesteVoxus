package br.com.voxus.to;

import java.util.Calendar;

public class PaymentTO {
	private int id;
	private String title;
	private double value;
	private Calendar date;
	private double tax;
	
	public PaymentTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentTO(int id, String title, double value, Calendar date, double tax) {
		super();
		this.id = id;
		this.title = title;
		this.value = value;
		this.date = date;
		this.tax = tax;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
}
