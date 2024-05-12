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

public class SearchResult {

	JFrame frame;
	private JTable table;
	private String product_name,quantity,price,mfgdt,expdt,supplier_name;
	private int product_id;
	DefaultTableModel model = new DefaultTableModel();
	DBConnection dbconn = new DBConnection();

	/**
	 * Launch the application.
	 */
	public void showData(String pname) {
		try {
			String [] cols = {"Product ID","Product Name","Quantity","Price/Unit","MFG Date","EXP Date","Supplier Name"};
	        model.setColumnIdentifiers(cols);
        	ResultSet rs = dbconn.showProduct(pname);
			while(rs.next()) {
				product_id = Integer.parseInt(rs.getString(1));
				product_name = rs.getString(2);
				quantity = rs.getString(3);
				price = rs.getString(4);
				mfgdt = rs.getString(5);
				expdt = rs.getString(6);
				supplier_name = rs.getString(7);
				String [] rows = {String.valueOf(product_id),product_name,quantity,price,mfgdt,expdt,supplier_name};
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
					SearchResult window = new SearchResult();
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
	public SearchResult() {
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
