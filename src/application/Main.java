package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
		Client client = new Client(name, email, date);
		
		System.out.println("Enter order data:");
		System.out.printf("STATUS: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("quantity: ");
			int quantity = sc.nextInt();
			Product product = new Product(name,price);
			OrderItem orderItem = new OrderItem(quantity, price, product);
			order.addOrderItem(orderItem);
		}
		
		System.out.println();
		System.out.println(order);
		
		
		
		sc.close();
		
		

	}

}
