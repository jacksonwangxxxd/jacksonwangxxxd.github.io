import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Lab8 {

	public static void main(String[] args)throws IOException {
		
		String report;
		Fruit apple = new Fruit("apple", 10, 15);
		Fruit banana = new Fruit("banana", 5, 10);
		Fruit orange = new Fruit("orange", 20, 35);
		Shop shop = new Shop();
		try {	
			File file = new File("salesData.txt");
			Scanner reader = new Scanner(file);
			reader.nextLine();
			while (reader.hasNextLine()) {
				int ap = reader.nextInt();
				int ba = reader.nextInt();
				int or = reader.nextInt();
				shop.addOrder(apple,ap);
				shop.addOrder(banana,ba);
				shop.addOrder(orange,or);
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();			
		}
		
		try
		{
			report = shop.getReport();
			System.out.print(report);
			
			FileWriter mywriter = new FileWriter("shop_report.txt");
			mywriter.write(report);
			System.out.print("Report has been written to shop_report.txt");
			mywriter.close();
		}	catch(IOException e) {
			e.printStackTrace();
		}
	}

}
