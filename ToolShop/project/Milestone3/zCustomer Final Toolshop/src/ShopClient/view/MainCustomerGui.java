package ShopClient.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class MainCustomerGui {
	private JButton buyButton;
	private JButton btnListItems;
	private JButton btnSearchByName;
	private JTextArea textArea;
	private JButton btnExit;
	private JFrame frame;


	/**
	 * Create the application.
	 */
	public MainCustomerGui() {
		initialize();
		frame.setVisible(true);
		frame.setResizable(true);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 16));
		frame.getContentPane().setBackground(new Color(100, 149, 237));
		frame.getContentPane().setLayout(null);
		
		JPanel sidepanel = new JPanel();
		sidepanel.setBackground(new Color(100, 149, 237));
		sidepanel.setBounds(0, 0, 296, 663);
		frame.getContentPane().add(sidepanel);
		sidepanel.setLayout(null);
		
		JPanel buyPanel = new JPanel();
		buyPanel.setLayout(null);
		buyPanel.setBackground(new Color(85, 85, 118));
		buyPanel.setBounds(0, 190, 281, 57);
		sidepanel.add(buyPanel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icons8_buy_48px.png"));
		label.setBounds(12, 0, 56, 57);
		buyPanel.add(label);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(12, 0, 40, 57);
		buyPanel.add(label_7);
		
		 buyButton = new JButton("Buy");
		buyButton.setForeground(new Color(0, 0, 0));
		buyButton.setBackground(new Color(204, 204, 204));
		buyButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		buyButton.setBounds(102, 13, 130, 25);
		buyPanel.add(buyButton);
		
		JPanel list1Panel = new JPanel();
		list1Panel.setLayout(null);
		list1Panel.setBackground(new Color(85, 85, 118));
		list1Panel.setBounds(0, 290, 281, 57);
		sidepanel.add(list1Panel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("icons8_list_50px_1.png"));
		label_1.setBounds(12, 0, 63, 57);
		list1Panel.add(label_1);
		
		 btnListItems = new JButton("List Items");
		btnListItems.setForeground(Color.BLACK);
		btnListItems.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnListItems.setBackground(new Color(204, 204, 204));
		btnListItems.setBounds(103, 13, 130, 25);
		list1Panel.add(btnListItems);
		
		JPanel searchNamePanel = new JPanel();
		searchNamePanel.setLayout(null);
		searchNamePanel.setBackground(new Color(85, 85, 118));
		searchNamePanel.setBounds(0, 397, 281, 57);
		sidepanel.add(searchNamePanel);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("icons8_search_property_48px.png"));
		label_5.setBounds(12, 0, 40, 57);
		searchNamePanel.add(label_5);
		
		 btnSearchByName = new JButton("Search Item");
		btnSearchByName.setForeground(Color.BLACK);
		btnSearchByName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnSearchByName.setBackground(new Color(204, 204, 204));
		btnSearchByName.setBounds(108, 13, 130, 25);
		searchNamePanel.add(btnSearchByName);
		
		JLabel menu = new JLabel("Menu");
		menu.setBackground(new Color(204, 204, 204));
		menu.setForeground(new Color(255, 255, 255));
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu.setBounds(0, 13, 274, 56);
		sidepanel.add(menu);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(85, 85, 118));
		panel.setBounds(0, 521, 291, 57);
		sidepanel.add(panel);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("icons8_exit_sign_40px.png"));
		label_9.setBounds(12, 0, 40, 57);
		panel.add(label_9);
		
		 btnExit = new JButton("Exit");
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnExit.setBackground(new Color(204, 204, 204));
		btnExit.setBounds(113, 10, 130, 25);
		panel.add(btnExit);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(100, 149, 237));
		headerPanel.setBounds(358, 13, 836, 220);
		frame.getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(369, 13, 85, 102);
		headerPanel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("icons8_small_business_80px.png"));
		
		JLabel lblEshop = new JLabel("E-Shop");
		lblEshop.setHorizontalAlignment(SwingConstants.CENTER);
		lblEshop.setBounds(269, 115, 289, 92);
		headerPanel.add(lblEshop);
		lblEshop.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		lblEshop.setForeground(new Color(204, 204, 204));
		
		//JPanel panel = new JPanel();
		//panel.setBounds(316, 243, 905, 407);
		//panel.setBackground(new Color(240,240,240));
		//frame.getContentPane().add(panel);
		//panel.setLayout(null);
		
		 textArea = new JTextArea();
		 textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(114, 5, 410, 240);
		textArea.setBackground(new Color(240,240,240));
		JScrollPane scrollBar = new JScrollPane(textArea);
		scrollBar.setSize(898, 404);
		scrollBar.setLocation(334, 246);
		frame.getContentPane().add(scrollBar);
		//panel.add(scrollBar);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1281, 710);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * Assigns a listener to the buy button.
	 * @param listener an ActionListener.
	 */
	public void addBuyListener(ActionListener listener) {
		this.buyButton.addActionListener(listener);
	}
	/**
	 * Assigns a listener to the list all items to the listAllItems button.
	 * @param listener
	 */
	public void addlistAllItemsListener(ActionListener listener) {
		this.btnListItems.addActionListener(listener);
	}

	/**
	 * Assigns a listener to the search by name.
	 * @param listener an ActionListener.
	 */
	public void addSearchByNameListener(ActionListener listener) {
		this.btnSearchByName.addActionListener(listener);
	}

	public void addExitListener(ActionListener listener) {
		this.btnExit.addActionListener(listener);
	}
	/**
	 * Clears out to the text area.
	 */
	public void clear() {
		textArea.setText("");
		textArea.repaint();
	}
	/**
	 * returns the text area.
	 * @return text area.
	 */
	public JTextArea getTextArea() {
		return textArea;
	}
}
