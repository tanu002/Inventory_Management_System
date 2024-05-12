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

public class Suppliers {

	JFrame frame;
	private JTextField txtSearchById;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table;
	Validation val = new Validation();
	DBConnection dbconn = new DBConnection();
	RandomNums rd = new RandomNums();
	DefaultTableModel model = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public void showData() {
		String [] cols = {"Supplier ID","Supplier Name","Agency Name","Phone Number","Address"};
		String supplier_Name,agency,ph_no,supplier_address;
		int supplier_id;
		try {
	        model.setColumnIdentifiers(cols);
        	ResultSet rs = dbconn.showSupplier();
			while(rs.next()) {
				supplier_id = Integer.parseInt(rs.getString(1));
				supplier_Name = rs.getString(2);
				agency = rs.getString(3);
				ph_no = rs.getString(4);
				supplier_address= rs.getString(5);
				String [] rows = {String.valueOf(supplier_id),supplier_Name,agency,ph_no,supplier_address};
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
					Suppliers window = new Suppliers();
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
	public Suppliers() {
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
		
		txtSearchById = new JTextField("Search by Supplier Id");
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
				SearchResultSupplier sr = new SearchResultSupplier();
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
		
		// Add
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 215, 181));
		tabbedPane.addTab("Add", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblProductName = new JLabel("Supplier's Name");
		lblProductName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblProductName.setBounds(40, 36, 113, 19);
		panel.add(lblProductName);
		
		JLabel lblQuantity = new JLabel("Agency Name");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuantity.setBounds(40, 75, 113, 19);
		panel.add(lblQuantity);
		
		JLabel lblPriceunit = new JLabel("Phone Number");
		lblPriceunit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPriceunit.setBounds(40, 116, 113, 17);
		panel.add(lblPriceunit);
		
		JLabel lblManufacturingDate = new JLabel("Address");
		lblManufacturingDate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblManufacturingDate.setBounds(40, 153, 133, 17);
		panel.add(lblManufacturingDate);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(177, 37, 306, 19);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(177, 76, 306, 19);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(177, 116, 306, 19);
		panel.add(textField_4);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.LEFT);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_9.setColumns(10);
		textField_9.setBounds(177, 153, 306, 19);
		panel.add(textField_9);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBorder(new LineBorder(new Color(242, 156, 111), 2, true));
		btnNewButton_1.setBounds(287, 345, 93, 21);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().equals("")||textField_3.getText().equals("")||textField_4.getText().equals("")||textField_9.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter all details!!!", null, JOptionPane.WARNING_MESSAGE);
				}
				else if(!val.isValidName(textField_2.getText())||!val.isValidMobileNo(textField_4.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid name or mobile number!!!", null, JOptionPane.WARNING_MESSAGE);
				}
				else {
				long random = rd.genSupplierId();
				dbconn.setSupplier_id(random);
				dbconn.setSupplier_Name(textField_2.getText());
				dbconn.setAgency(textField_3.getText());
				dbconn.setPh_no(textField_4.getText());
				dbconn.setSupplier_address(textField_9.getText());
				dbconn.addSupplier();
				
				String [] rows = {String.valueOf(random),textField_2.getText(),textField_3.getText(),textField_4.getText(),textField_9.getText()};
				model.addRow(rows);
				
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_9.setText("");
				
				JOptionPane.showMessageDialog(null, "Added Successfully!!!", null, JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Reset");
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_1.setBorder(new LineBorder(new Color(242, 156, 111), 2, true));
		btnNewButton_1_1.setBounds(390, 345, 93, 21);
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_9.setText("");
			}
		});
		panel.add(btnNewButton_1_1);
		
		// Update
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Update", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 215, 181));
		panel_2.setBounds(0, 0, 523, 399);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Supplier ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(40, 37, 86, 19);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblSupplierName_1 = new JLabel("Supplier's Name");
		lblSupplierName_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSupplierName_1.setBounds(40, 77, 113, 19);
		panel_2.add(lblSupplierName_1);
		
		JLabel lblAgency = new JLabel("Agency Name");
		lblAgency.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAgency.setBounds(40, 116, 113, 19);
		panel_2.add(lblAgency);
		
		JLabel lblPhone_No = new JLabel("Phone Number");
		lblPhone_No.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhone_No.setBounds(40, 157, 113, 17);
		panel_2.add(lblPhone_No);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAddress.setBounds(40, 194, 133, 17);
		panel_2.add(lblAddress);
		
		
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
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.LEFT);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_10.setColumns(10);
		textField_10.setBounds(177, 194, 306, 19);
		panel_2.add(textField_10);
		
		JButton btnNewButton_1_1_1 = new JButton("Update");
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_1_1.setBorder(new LineBorder(new Color(242, 156, 111), 2, true));
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(286, 345, 93, 21);
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_6.getText().equals("")||textField_7.getText().equals("")||textField_8.getText().equals("")||textField_10.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter all details!!!", null, JOptionPane.WARNING_MESSAGE);
				}
				else if(!val.isValidMobileNo(textField_8.getText())||!val.isValidName(textField_6.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid name or phone number!!!", null, JOptionPane.WARNING_MESSAGE);
				}
				else {
				dbconn.setSupplier_Name(textField_6.getText());
				dbconn.setAgency(textField_7.getText());
				dbconn.setPh_no(textField_8.getText());
				dbconn.setSupplier_address(textField_10.getText());
				dbconn.updateSupplier(Integer.parseInt(textField_5.getText()));
				
				int i = table.getSelectedRow();
				model.setValueAt(textField_6.getText(), i, 1);
				model.setValueAt(textField_7.getText(), i, 2);
				model.setValueAt(textField_8.getText(), i, 3);
				model.setValueAt(textField_10.getText(), i, 4);			
				
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_10.setText("");
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
				textField_10.setText("");
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Supplier ID");
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
				int sid = Integer.parseInt(textField_1.getText());
				dbconn.deleteSupplier(sid);
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
		txtpndeletingAProduct.setText("*Deleting a supplier means deleting all the details of that supplier along with it\r\n");
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
		table.setToolTipText("Supplier Details");
		table.setModel(model);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBackground(new Color(216, 191, 216));
		table.addMouseListener(new MouseAdapter() {
			@Override
			 public void mouseClicked(MouseEvent e) {
				 try {
					 textField_1.setText((String)table.getValueAt(table.getSelectedRow(), 0));
					 textField_5.setText((String)table.getValueAt(table.getSelectedRow(), 0));
					 textField_6.setText((String)table.getValueAt(table.getSelectedRow(), 1));
					 textField_7.setText((String)table.getValueAt(table.getSelectedRow(), 2));
					 textField_8.setText((String)table.getValueAt(table.getSelectedRow(), 3));
					 textField_10.setText((String)table.getValueAt(table.getSelectedRow(), 4));
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
		
		
		JLabel lblNewLabel_3 = new JLabel("Suppliers");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3.setBounds(10, 10, 291, 29);
		panel_5.add(lblNewLabel_3);
		
		
	}
}
