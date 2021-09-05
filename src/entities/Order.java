package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private StringBuilder sb = new StringBuilder();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	// Composição -> Um pedido possui um cliente
	private Client client;
	
	// Composição -> Lista de items
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public Client getClient() {
		return client;
	}

	public void addItem(OrderItem item) {
		orderItems.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItems.remove(item);
	}
	
	public Double total() {
		Double total = 0.0;
		for (OrderItem item : orderItems) {
			total += item.subTotal();
		}
		return total;
	}
	
	public String toString() {
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + " (" + sdf.format(client.getBirthDate()) + ") " + "- " + client.getEmail() + "\n");
		sb.append("Order items: \n");
		for (OrderItem item : orderItems) {
			sb.append(item.getProduct().getName() + ", $" + String.format("%.2f", item.getPrice()) + ", Quantity: " + item.getQuantity() + ", Subtotal: $" + String.format("%.2f", item.subTotal()) + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", this.total()));
		return sb.toString();
	}
}
