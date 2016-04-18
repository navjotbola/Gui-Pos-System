import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

class McPatternsGUI extends JFrame {
	McPatternsPresenter presenter;
	CreditCardFactory ccFactory;

	public McPatternsGUI(McPatternsPresenter presenter) {

		this.presenter = presenter;
		presenter.attachView(this);
		showGUI();

	}

	private void showGUI() {
		presenter.loadMenuItems();

		// JFRAME
		JFrame theFrame = new JFrame("Navjot's Store");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());
		Color blue = Color.decode("#e5e5ff");
		theFrame.getContentPane().setBackground(blue);

		// JPANEL
		JPanel title = new JPanel(new FlowLayout());
		title.setBackground(blue);
		title.add(new JLabel("Welcome to Navjot's Store!"));

		// ORDER PANE
		JPanel orderPane = new JPanel();
		orderPane.setBackground(blue);
		orderPane.setLayout(new BoxLayout(orderPane, BoxLayout.PAGE_AXIS));
		JLabel orderDetails = new JLabel("Your order");
		orderPane.setBorder(BorderFactory.createRaisedBevelBorder());
		orderPane.add(orderDetails);
		orderPane.setBackground(blue);
		JTextField ccEntry = new JTextField("Enter CC #");

		// TEXT AREA

		JTextArea currentOrder = new JTextArea(20, 20);
		currentOrder
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		theFrame.add(currentOrder);
		JScrollPane scrollPane = new JScrollPane(currentOrder,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// TOTAL OF ORDER
		JLabel yourTotal = new JLabel("Your total is: $0.00");

		// Confirm Button
		JButton confirm = new JButton("Place Order");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Add the function to handle confirmed order
				// Think about where you will store order and who should
				// manipulate.
				// Handle the Payment validation before confirming order. Who
				// should validate?
				ccFactory = new CreditCardFactory(ccEntry.getText());
				if (ccFactory.verifyCC() == true) {
					orderDetails.setText(ccFactory.ccName + " card accepted!");
					System.out.println(presenter.returnOrder());

					// Reciept Confirmation Frame
					JFrame recieptFrame = new JFrame("Reciept");
					// recieptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					recieptFrame.setLayout(new BorderLayout());
					recieptFrame.getContentPane().setBackground(blue);
					JTextArea reciept = new JTextArea(20, 20);
					reciept.setText(presenter.returnReciept());
					reciept.setEditable(false);
					recieptFrame.add(reciept);
					recieptFrame.setVisible(true);
					recieptFrame.pack();
				} else {
					orderDetails.setText("Payment not accepted. Re-enter CC.");
				}
			}
		});

		// Cancel Button
		JButton cancel = new JButton("Cancel Order");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Add the function to handle cancel order
				// Think about where you will store order and who should
				// manipulate.
				orderDetails.setText("Order cancelled");
				currentOrder.setText("");
				ccEntry.setText("Enter CC #");
				presenter.model.order = new ArrayList<String>();
				presenter.model.totalPrice = 0;
				yourTotal.setText("Your total is: $0.00");
			}
		});

		// Clear Button
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderDetails.setText("Your Order");
				currentOrder.setText("");
				ccEntry.setText("Enter CC #");
				presenter.model.order = new ArrayList<String>();
				presenter.model.totalPrice = 0;
				yourTotal.setText("Your total is: $0.00");
			}
		});

		orderPane.add(scrollPane);
		orderPane.add(yourTotal);
		orderPane.add(ccEntry);
		orderPane.add(confirm);
		orderPane.add(cancel);
		orderPane.add(clearButton);

		// BUTTON PANEL
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		int buttonPanelSize = (presenter.model.menu.size()) / 2;
		buttonPanel.setBackground(blue);
		buttonPanel.setLayout(new GridLayout(buttonPanelSize, buttonPanelSize));

		// TODO: Ask the presenter for the buttons to create. Iterate over the
		// buttons and create them

		// CREATING BUTTONS
		ArrayList buttonsToCreate = presenter.getButtons();
		for (int i = 0; i < buttonsToCreate.size(); i++) {
			JButton currentButton = (JButton) buttonsToCreate.get(i);
			currentButton.setSize(5, 20);
			buttonPanel.add(currentButton);
			currentButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					presenter.addToOrder(((JComponent) e.getSource()).getName());
					currentOrder.setText(currentOrder.getText() + "\n"
							+ ((JComponent) e.getSource()).getName());
					presenter.updatePrice(((AbstractButton) e.getSource())
							.getActionCommand());
					yourTotal.setText("Your total is: $"
							+ presenter.returnTotal());
				}
			});
		}

		theFrame.add(title, BorderLayout.NORTH);
		theFrame.add(buttonPanel, BorderLayout.CENTER);
		theFrame.add(orderPane, BorderLayout.EAST);
		theFrame.setSize(800, 600);
		theFrame.pack();
		theFrame.setVisible(true);
	}
}
