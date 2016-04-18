import java.util.ArrayList;

import javax.swing.JButton;

class MenuModel {
	// Add your implementation for Menu Items here.
	// Determine what data you want to store for each item.
	ArrayList<String> order = new ArrayList<String>();
	ArrayList<Integer> price = new ArrayList<Integer>();
	ArrayList<JButton> buttonList = new ArrayList<JButton>();
	ArrayList<String> menu = new ArrayList<String>();
	int totalPrice = 0;
	String totalPriceString = null;

	public void addToMenu(String newItem) {
		menu.add(newItem);
	}

	public void createButtons() {

		for (int i = 0; i < menu.size(); i += 2) {
			String item = (String) menu.get(i);
			String testPrice = null;
			String price = null;
			if (menu.size() > i + 1) {
				testPrice = menu.get(i + 1);
				String[] newPrice = testPrice.split("\\.");
				price = (newPrice[0] + newPrice[1]);

			}
			JButton itemButton = new JButton(item + " - $" + testPrice);
			itemButton.setActionCommand(price);
			itemButton.setName(item + " (" + testPrice + ")");
			buttonList.add(itemButton);
		}

	}

	void addToOrder(String item) {
		order.add(item);
	}

	void addToPriceList(int currentPrice) {
		price.add(currentPrice);
	}

	String getOrder() {
		String orderText = "\n" + "The order is below: " + "\n"
				+ "--------------------" + "\n";
		for (int i = 0; i < order.size(); i++) {
			orderText = orderText + order.get(i) + "\n";
		}
		return orderText;
	}

	String getReciept() {
		String orderText = "\n" + "Navjot's Store Reciept " + "\n"
				+ "------------------" + "\n";
		for (int i = 0; i < order.size(); i++) {
			orderText = orderText + order.get(i) + "\n";
		}
		orderText = orderText + "\n" + "Total Items: " + order.size() + "\n"
				+ "------------------" + "\n" + "Total: $" + totalPriceString;
		return orderText;
	}

	public void updateTotalPrice(String price) {
		int intPrice = Integer.parseInt(price);
		totalPrice = totalPrice + intPrice;
		String newPrice = Integer.toString(totalPrice);
		totalPriceString = newPrice.substring(0, newPrice.length() - 2) + "."
				+ newPrice.substring(newPrice.length() - 2, newPrice.length());
	}
}