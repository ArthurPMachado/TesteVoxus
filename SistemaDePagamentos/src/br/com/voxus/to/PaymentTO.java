package br.com.voxus.to;

public class PaymentTO {
	private int id;
	private String title;
	private double value;
	private String date;
	private double tax;
	private String comments;
	
	public PaymentTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentTO(int id, String title, double value, String date, double tax, String comments) {
		super();
		this.id = id;
		this.title = title;
		this.value = value;
		this.date = date;
		this.tax = tax;
		this.comments = comments;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
