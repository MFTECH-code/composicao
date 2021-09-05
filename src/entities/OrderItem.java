package entities;

public class OrderItem {
	private Integer quantity;
	
	// Composição preço do produto
	private Product product;
	private Double price;
	
	public OrderItem() {
		
	}

	public OrderItem(Integer quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
		this.price = this.product.getPrice();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Product getProduct() {
		return product;
	}

	public Double subTotal() {
		return this.price * this.quantity;
	}
	
}
