import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

class McPatternsPresenter {
	// This is the class that will handle the model <-> UI communication.
	MenuModel model;
	McPatternsGUI view;
	String file = null;

	public McPatternsPresenter(String filename) {
		model = new MenuModel();
		file = filename;
	}

	void loadMenuItems() {

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));

			String str;
			while ((str = in.readLine()) != null) {
				String[] parts = str.split("\\|");
				String item = parts[0];
				String priceHold = parts[1];
				String[] newPrice = priceHold.split("\\.");
				String price = (newPrice[0] + newPrice[1]);
				int intPrice = Integer.parseInt(price);
				model.addToMenu(item);
				model.addToMenu(priceHold);
				model.addToPriceList(intPrice);
			}
			createButtons();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void attachView(McPatternsGUI view) {
		this.view = view;
	}

	// Add functions to return the menu items.

	public void createButtons() {
		model.createButtons();
	}

	public ArrayList getButtons() {
		return model.buttonList;
	}

	public ArrayList returnMenu() {
		return model.menu;
	}

	void addToOrder(String item) {
		model.addToOrder(item);
	}

	String returnOrder() {
		return model.getOrder();
	}

	String returnReciept() {
		return model.getReciept();
	}

	public void updatePrice(String aPrice) {
		model.updateTotalPrice(aPrice);
	}

	public String returnTotal() {
		return model.totalPriceString;
	}
}