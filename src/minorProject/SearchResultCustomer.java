package minorProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchResultCustomer {

	JFrame frame;
	private JTable table;
	private String customer_id,customer_name,phone_no,amount,product_name,date;
	DefaultTableModel model = new DefaultTableModel();
	DBConnection dbconn = new DBConnection();

	/**
	 * Launch the application.
	 */
	public void showData(String cid) {
		try {
			String [] cols = {"Customer ID","Customer Name","Phone No","Amount","Date","Product Name"};
	        model.setColumnIdentifiers(cols);
        	ResultSet rs = dbconn.showCustomer(cid);
			while(rs.next()) {
				customer_id = rs.getString(1);
				customer_name = rs.getString(2);
				phone_no = rs.getString(3);
				amount = rs.getString(4);
				product_name = rs.getString(5);
				date = rs.getString(6);
				String [] rows = {customer_id,customer_name,phone_no,amount,product_name,date};
				model.addRow(rows);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchResultCustomer window = new SearchResultCustomer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchResultCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\1668418175440.jpeg");
		frame = new JFrame("Result");
		frame.getContentPane().setBackground(new Color(245, 245, 216));
		frame.setBounds(360, 100, 832, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(icon);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 798, 226);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBackground(new Color(216, 191, 216));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBorder(new LineBorder(new Color(242, 156, 111), 2, true));
		btnNewButton.setBounds(338, 286, 124, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
	}
}
