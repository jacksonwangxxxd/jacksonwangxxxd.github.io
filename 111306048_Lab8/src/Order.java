
public class Order {
	
	private Fruit fruit;
	private int number;
	
	
	Fruit apple = new Fruit("apple",10,15);
	Fruit banana = new Fruit("banana",5,10);
	Fruit orange = new Fruit("orange",20,35);
	
	public Order(Fruit fruit,int number) {
		this.fruit=fruit;
		this.number=number;
	}
	
	public int getOrderCost() {
		return fruit.getCost()*this.number;
	}
	
	public int getOrderRevenue() {
		return fruit.getPrice()*this.number;
	}
	

}

