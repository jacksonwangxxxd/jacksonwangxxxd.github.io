import java.util.ArrayList;

public class OrderList {
	
	ArrayList<Order> orders = new ArrayList<Order>();
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public int getTotalCost() {
		int output=0;
		for(Order x:orders) {
			output+=x.getOrderCost();
		}
		return output ;
		
	}
	public int getTotalRevenue() {
	int output=0;
	for(Order x:orders) {
		output+=x.getOrderRevenue();
	}
		
		return output;
	}
	

}
