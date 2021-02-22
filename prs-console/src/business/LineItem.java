package business;

public class LineItem {
	private int id;
	private int requestID;
	private int productID;
	private int quantity;
	
	public LineItem() {
	}
	
	public LineItem(int inID, int inPrID, int inPdtID, int inQty) {
		id = inID;
		requestID = inPrID;
		productID = inPdtID;
		quantity = inQty;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "purchaseRequestLineItem [id=" + id + ", requestID=" + requestID + ", productID="
				+ productID + ", quantity=" + quantity + "]";
	}

}