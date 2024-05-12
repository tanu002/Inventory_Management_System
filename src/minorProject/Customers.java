package minorProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;

public class Customers {

	JFrame frame;
	private JTextField txtSearchById;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table;
	Validation val = new Validation();
	DBConnection dbconn = new DBConnection();
	RandomNums rd = new RandomNums();
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public void showData() {
		String [] cols = {"Serial No.","Customer ID","Customer Name","Phone Number","Amount","Product ID", "Date"};
		String sl_no, customer_id,customer_name,ph_no,amount,product_id,date;
		try {
	        model.setColumnIdentifiers(cols);
        	ResultSet rs = dbconn.showCustomer();
			while(rs.next()) {
				sl_no = rs.getString(1);
				customer_id = rs.getString(2);
				customer_name = rs.getString(3);
				ph_no = rs.getString(4);
				amount = rs.getString(5);
				product_id = rs.getString(6);
				date = rs.getString(7);
				String [] rows = {sl_no,customer_id,customer_name,ph_no,amount,product_id,date};
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
					Customers window = new Customers();
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
	public Customers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\1668418175440.jpeg");
		frame = new JFrame("Products");
		frame.getContentPane().setBackground(new Color(245, 245, 220));
		frame.setBounds(100, 50, 1344, 742);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(icon);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		txtSearchById = new JTextField("Search by Customer ID");
		txtSearchById.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtSearchById.setBounds(31, 34, 316, 36);
		txtSearchById.setColumns(10);
		frame.getContentPane().add(txtSearchById);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setBorder(new LineBorder(new Color(242, 156, 111), 2, true));
		btnNewButton.setBounds(377, 36, 107, 26);
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchResultCustomer sr = new SearchResultCustomer();
				sr.frame.setVisible(true);
				sr.showData(txtSearchById.getText());
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.WHITE);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnReset.setBorder(new LineBorder(new Color(242, 156, 111), 2, true));
		btnReset.setBounds(494, 36, 107, 26);
		btnReset.setFocusable(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchById.setText("");
			}
		});
		frame.getContentPane().add(btnReset);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(31, 101, 528, 426);
		frame.getContentPane().add(tabbedPane);
		
		// Update
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Update", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 215, 181));
		panel_2.setBounds(0, 0, 523, 399);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(40, 37, 86, 19);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblCustomerName_1 = new JLabel("Customer Name");
		lblCustomerName_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCustomerName_1.setBounds(40, 77, 113, 19);
		panel_2.add(lblCustomerName_1);
		
		JLabel lblPhoneNo = new JLabel("Phone Number");
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhoneNo.setBounds(40, 116, 113, 19);
		panel_2.add(lblPhoneNo);
		
		JLabel lblPurchasedAmount = new JLabel("Purchased Amount");
		lblPurchasedAmount.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPurchasedAmount.setBounds(40, 157, 124, 17);
		panel_2.add(lblPurchasedAmount);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblProductId.setBounds(40, 193, 124, 17);
		panel_2.add(lblProductId);
		
		JLabel lblDateOfPurchase = new JLabel("Date of Purchase");
		lblDateOfPurchase.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDateOfPurchase.setBounds(40, 229, 124, 17);
		panel_2.add(lblDateOfPurchase);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setHorizontalAlignment(SwingConstants.LEFT);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(177, 38, 306, 19);
		panel_2.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.LEFT);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(177, 78, 306, 19);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.LEFT);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_7.setColumns(10);
		textField_7.setBounds(177, 117, 306, 19);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.LEFT);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_8.setColumns(10);
		textField_8.setBounds(177, 157, 306, 19);
		panel_2.add(textField_8);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(177, 193, 306, 19);
		panel_2.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(177, 227, 154, 19);
		panel_2.add(textField_2);
		
		JButton btnNewButton_1_1_1 = new JButton("Update");
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_1_1.setBorder(new LineBorder(new Color(242, 156, 111), 2, true));
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(286, 345, 93, 21);
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_6.getText().equals("")||textField_7.getText().equals("")||textField_8.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter all details!!!", null, JOptionPane.WARNING_MESSAGE);
				}
				else if(!val.isValidMobileNo(textField_8.getText())||!val.isValidName(textField_6.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid name or phone number!!!", null, JOptionPane.WARNING_MESSAGE);
				}
				else {
				dbconn.setCustomer_id(textField_5.getText());
				dbconn.setCustomer_name(textField_6.getText());
				dbconn.setPh_no(textField_7.getText());
				dbconn.setAmount(textField_8.getText());
				dbconn.setProduct_Name(textField.getText());
				dbconn.setDate(textField_2.getText());
				dbconn.updateCustomer(textField_5.getText());
				
				int i = table.getSelectedRow();
				model.setValueAt(textField_5.getText(), i, 1);
				model.setValueAt(textField_6.getText(), i, 2);
				model.setValueAt(textField_7.getText(), i, 3);
				model.setValueAt(textField_8.getText(), i, 4);
				model.setValueAt(textField.getText(), i, 5);
				model.setValueAt(textField_2.getText(), i, 6);
				
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField.setText("");
				textField_2.setText("");
				JOptionPane.showMessageDialog(null, "Updated Successfully!!!", null, JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		panel_2.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_3 = new JButton("Reset");
		btnNewButton_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_1_3.setFocusable(false);
		btnNewButton_1_1_3.setBorder(new LineBorder(new Color(242, 156, 111), 2, true));
		btnNewButton_1_1_3.setBackground(Color.WHITE);
		btnNewButton_1_1_3.setBounds(390, 345, 93, 21);
		btnNewButton_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField.setText("");
				textField_2.setText("");
			}
		});
		panel_2.add(btnNewButton_1_1_3);
		
//		Delete
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Delete", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(255, 215, 181));
		panel_2_1.setBounds(0, 0, 523, 399);
		panel_3.add(panel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer ID");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(40, 37, 86, 19);
		panel_2_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(177, 38, 306, 19);
		panel_2_1.add(textField_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setBorder(new LineBorder(new Color(242, 156, 111), 2, true));
		btnNewButton_1_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1_1.setBounds(286, 345, 93, 21);
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconn.deleteCustomer(textField_1.getText());
				int i = table.getSelectedRow();
				model.removeRow(i);
				textField_1.setText("");
				JOptionPane.showMessageDialog(null, "Deleted Successfully!!!", null, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panel_2_1.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_3_1 = new JButton("Reset");
		btnNewButton_1_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_1_3_1.setFocusable(false);
		btnNewButton_1_1_3_1.setBorder(new LineBorder(new Color(242, 156, 111), 2, true));
		btnNewButton_1_1_3_1.setBackground(Color.WHITE);
		btnNewButton_1_1_3_1.setBounds(390, 345, 93, 21);
		btnNewButton_1_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
			}
		});
		panel_2_1.add(btnNewButton_1_1_3_1);
		
		JTextPane txtpndeletingAProduct = new JTextPane();
		txtpndeletingAProduct.setText("*Deleting a customer means deleting all the details of that customer along with it\r\n");
		txtpndeletingAProduct.setToolTipText("");
		txtpndeletingAProduct.setBackground(new Color(255, 215, 181));
		txtpndeletingAProduct.setEditable(false);
		txtpndeletingAProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpndeletingAProduct.setBounds(31, 574, 528, 40);
		frame.getContentPane().add(txtpndeletingAProduct);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(569, 101, 728, 426);
		frame.getContentPane().add(scrollPane);
		
		showData();
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setToolTipText("Customer Details");
		table.setModel(model);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBackground(new Color(216, 191, 216));
		table.addMouseListener(new MouseAdapter() {
			@Override
			 public void mouseClicked(MouseEvent e) {
				 try {
					 textField_1.setText((String)table.getValueAt(table.getSelectedRow(), 1));
					 textField_5.setText((String)table.getValueAt(table.getSelectedRow(), 1));
					 textField_6.setText((String)table.getValueAt(table.getSelectedRow(), 2));
					 textField_7.setText((String)table.getValueAt(table.getSelectedRow(), 3));
					 textField_8.setText((String)table.getValueAt(table.getSelectedRow(), 4));
					 textField.setText((String)table.getValueAt(table.getSelectedRow(), 6));
					 textField_2.setText((String)table.getValueAt(table.getSelectedRow(), 6));
				 }
				 catch(Exception e1) {
					 ;
				 }
				 
		        }
		});
		scrollPane.setViewportView(table);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnDashboard.setFocusable(false);
		btnDashboard.setBorder(new LineBorder(new Color(242, 156, 111), 2, true));
		btnDashboard.setBackground(Color.WHITE);
		btnDashboard.setBounds(1190, 574, 107, 26);
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashBoard dashboard = new DashBoard();
				dashboard.dbFrame.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnDashboard);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(Color.BLACK));
		panel_5.setBackground(new Color(255, 160, 122));
		panel_5.setBounds(986, 21, 311, 49);
		panel_5.setLayout(null);
		frame.getContentPane().add(panel_5);
		
		
		JLabel lblNewLabel_3 = new JLabel("Customers");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3.setBounds(10, 10, 291, 29);
		panel_5.add(lblNewLabel_3);
		
		
	}
}
