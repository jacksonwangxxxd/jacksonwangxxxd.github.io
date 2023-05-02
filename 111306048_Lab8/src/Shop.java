
public class Shop {

	private OrderList orderlist=new OrderList();
	
	public void addOrder(Fruit fruit, int number) {
		Order order = new Order(fruit, number);
		orderlist.addOrder(order);
	}
	
	public String getReport() {
		return "Total Revenue: "+orderlist.getTotalRevenue()+"\nTotal Cost: "+orderlist.getTotalCost()+"\nTotal profit: "+(orderlist.getTotalRevenue()-orderlist.getTotalCost()+"\n");

	}

}
