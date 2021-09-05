package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// Instanciação de client
		Client client = new Client("Alex Green", "alex@gmail.com", sdf.parse("15/03/1985 00:00:00"));
		
		// Instanciação dos produtos
		Product p1 = new Product("TV", 1000.0);
		Product p2 = new Product("Mouse", 40.0);
		
		// Instanciação dos items do pedido
		OrderItem item1 = new OrderItem(1, p1);
		OrderItem item2 = new OrderItem(2, p2);
		
		// Instanciação do pedido
		Order order = new Order(sdf.parse("20/04/2018 11:25:09"), OrderStatus.PROCESSING, client);
		// Adicionando items ao nosso pedido
		order.addItem(item1);
		order.addItem(item2);
		
		System.out.println(order);
		
		
	}

}
