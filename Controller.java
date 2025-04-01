package assign1Package;

//The Stock program is following the MVC design template and this is our controller object.
//The main functionality for buying and selling the stocks are in this controller object.
//This is the ONLY file you may edit

import java.util.LinkedList;
import java.util.Scanner;

public class Controller {
	
	public Controller() {
	
		
		LinkedList<Stock> stockList = new LinkedList<Stock>();
		Scanner input = new Scanner(System.in);
		
		do {
			
	
			System.out.print("Enter your perferred stock, 3 to quit: ");
			String stockSelect = input.next();
			
			if(stockSelect.equals("3")) {
				System.out.print("Exiting..."); 
				break;
			}
			System.out.println("Your chosen stock: " + stockSelect); //testing
		
			System.out.print("Input 1 to buy, 2 to sell: ");
			int controlNum = input.nextInt();
			
				
			if(controlNum == 1) {
				System.out.print("How many stocks: "); 
				int quantity = input.nextInt();

				System.out.print("At what price: ");
				double price = input.nextDouble();
				
				Controller.buyStock(stockList, stockSelect, quantity, price);
				
			} else if(controlNum == 2){
				System.out.print("How many stocks: "); 
				int quantity = input.nextInt();

				System.out.print("At what price: ");
				double priceSell = input.nextDouble();
				System.out.print("Press 1 for LIFO accounting, 2 for FIFO accounting: ");
				controlNum = input.nextInt();
				if(controlNum == 1) {
					Controller.sellLIFO(stockList, quantity, priceSell);
				}
				else {
					Controller.sellFIFO(stockList, quantity, priceSell);
				}
			} else {
				System.out.print("Error, please pick 1 or 2\n");
				continue;
			} 
	
	
			
			
		} while(true);
		
		input.close();
	}
			
	public static void buyStock(LinkedList<Stock> list, String name, int quantity, double price) {
		Stock temp = new Stock(name,quantity,price);
		list.push(temp);
		System.out.printf("You bought %d shares of %s stock at $%.2f per share %n", quantity, name, price);
	}
	
	public static void sellLIFO(LinkedList<Stock> list, int numToSell, double priceNum) {
	    // You need to write the code to sell the stock using the LIFO method (Stack)
	    // You also need to calculate the profit/loss on the sale
	    double total = 0; // this variable will store the total after the sale
	    double profit = 0; // the price paid minus the sale price, negative # means a loss
	    int totalShares = 0;
	    
	    for(Stock s: list) {
	    	totalShares += s.getQuantity();
	    }
	    //Checks if user has enough stocks to sell 
	    if(numToSell > totalShares) {
	    	System.out.printf("Cannot sell more than what you own\n");
	    	return;
	    }

	    Stock temp = list.removeFirst(); // create copy of our object stock, mimic stack pop
	   
	    total = numToSell * priceNum; // 
	    		                          
	    profit = (priceNum  * numToSell) - (temp.getPrice() * numToSell);
	    	     
	    
		System.out.printf("You sold %d shares of %s stock at %.2f per share %n", numToSell, temp.getName(), total/numToSell);
	    System.out.printf("You made $%.2f on the sale %n", profit);
	}
	
	public static void sellFIFO(LinkedList<Stock> list, int numToSell, double priceNum) {
	    // You need to write the code to sell the stock using the FIFO method (Queue)
	    // You also need to calculate the profit/loss on the sale
	    double total = 0; // this variable will store the total after the sale
	    double profit = 0; // the price paid minus the sale price, negative # means a loss
	    int totalShares = 0;
	    
	    for(Stock s: list) {
	    	totalShares += s.getQuantity();
	    }
	    //Checks if user has enough stocks to sell 
	    if(numToSell > totalShares) {
	    	System.out.printf("Cannot sell more than what you own\n");
	    	return;
	    }

	    Stock temp = list.removeLast(); // remove element in the front of the queue
	   
	    total = numToSell * priceNum;
	    
	    profit = (priceNum  * numToSell) - (temp.getPrice() * numToSell);
	    	     
	    
		System.out.printf("You sold %d shares of %s stock at %.2f per share %n", numToSell, temp.getName(), total/numToSell);
	    System.out.printf("You made $%.2f on the sale %n", profit);
	}
	
	
}
