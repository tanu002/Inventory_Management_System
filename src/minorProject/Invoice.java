package minorProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Invoice {

    JFrame ivFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	float price;
	double gst;
	double amount;
	double t_amount;
	int quantity;
	String id = "";
	Validation val = new Validation();
	DBConnection dbconn = new DBConnection();

	/**
	 * Launch the application.
	 */
	public void set(String id) {
		this.id +=id+",";
	}
	
	public String get() {
		return id;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice window = new Invoice();
					window.ivFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Invoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\1668418175440.jpeg");
		ivFrame = new JFrame("Invoice");
		ivFrame.setResizable(false);
		ivFrame.getContentPane().setBackground(new Color(255, 240, 245));
		ivFrame.setBounds(100, 50, 1356, 742);
		ivFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ivFrame.setIconImage(icon);
		ivFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(186, 85, 211));
		panel.setBounds(841, 102, 492, 529);
		ivFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(2, 5, 488, 518);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\payment.jpg"));
		
		JLabel lblNewLabel = new JLabel("Product ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(440, 224, 144, 32);
		ivFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(440, 289, 156, 32);
		ivFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Quantity");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(438, 346, 102, 32);
		ivFrame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(433, 194, 389, 437);
		ivFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals(""))
				{
					JOptionPane.showMessageDialog( null, "Add valid info!", null, JOptionPane.WARNING_MESSAGE);
				}
				else if(dbconn.isZero(textField.getText())) {
					JOptionPane.showMessageDialog( null, "Sorry! the product is out of stock.", null, JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					try {
						ResultSet rs = dbconn.getData(textField.getText());
						while(rs.next()) {
							price = rs.getFloat(1);
						}
						quantity = (Integer.parseInt(textField_2.getText())) ;
						amount += price * quantity;
						textField_3.setText(String.valueOf(amount));
						amount = 0;
						t_amount = 0;
						
						set(textField_1.getText());
						dbconn.setQuantity(textField_2.getText());
						dbconn.updateQuantity(Integer.parseInt(textField.getText()));
						
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(52, 236, 124, 32);
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(217, 236, 124, 32);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_6.setText("");
				textField_7.setText("");
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		
		textField = new JTextField();
		textField.setBounds(170, 34, 209, 32);
		panel_1.add(textField);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 93, 209, 32);
		panel_1.add(textField_1);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 153, 209, 32);
		panel_1.add(textField_2);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Amount");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(52, 120, 88, 32);
		ivFrame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_3.setBounds(150, 120, 246, 32);
		ivFrame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("GST");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setBounds(52, 180, 88, 32);
		ivFrame.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_4.setBounds(150, 180, 246, 32);
		ivFrame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setBounds(52, 237, 88, 32);
		ivFrame.getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_5.setBounds(150, 242, 246, 32);
		ivFrame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Date");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_6.setBounds(52, 297, 88, 32);
		ivFrame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("Pay");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_3.getText().equals("")||textField_4.getText().equals("")||textField_8.getText().equals(""))
				{
					JOptionPane.showMessageDialog( null, "Fill up all Payment Details", null, JOptionPane.WARNING_MESSAGE);
				}
				else { 
					amount = Double.parseDouble(textField_3.getText());
					gst = Double.parseDouble(textField_4.getText());
					t_amount = amount + gst;
					textField_5.setText(String.valueOf(t_amount));
					amount = 0;
					t_amount = 0;
					JOptionPane.showMessageDialog(null, "Payment Successful", null,JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorder(new LineBorder(new Color(255, 140, 0), 2, true));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_2.setBounds(70, 400, 124, 32);
		ivFrame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_8.setText("");
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBorder(new LineBorder(new Color(255, 140, 0), 2, true));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_3.setBounds(230, 400, 124, 32);
		ivFrame.getContentPane().add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		panel_2.setBackground(new Color(255, 160, 122));
		panel_2.setBounds(10, 102, 396, 381);
		ivFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(140, 197, 126, 32);
		panel_2.add(textField_8);
		
		JButton btnNewButton_4 = new JButton("Generate Invoice");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Validation vl = new Validation();
				if(textField_3.getText().equals("")||textField_4.getText().equals("")||textField_5.getText().equals("")||textField_8.getText().equals(""))
				{
					JOptionPane.showMessageDialog( null, "Some error is found!!!", null, JOptionPane.WARNING_MESSAGE);
				}
				else if(!vl.isValidMobileNo(textField_6.getText())||!vl.isValidName(textField_7.getText())) {
					
					JOptionPane.showMessageDialog( null, "Enter valid name or phone no.", null, JOptionPane.WARNING_MESSAGE);
				}
				else 
				{
				    Bill bl = new Bill();
	                bl.blFrame.setVisible(true);
	                bl.textFieldBL.setText(textField_7.getText());
					bl.textFieldBL_1.setText(textField_6.getText());
					bl.textFieldBL_2.setText(textField_5.getText());
					
					bl.date = textField_8.getText();
					bl.items = get();
					
					dbconn.setCustomer_id(textField_6.getText());
					dbconn.setCustomer_name(textField_7.getText());
					dbconn.setPhone_no(textField_6.getText());
					dbconn.setAmount(textField_5.getText());
					dbconn.setProduct_Name(get());
					dbconn.setDate(textField_8.getText());
					dbconn.addCustomer();
					
					amount = 0;
					t_amount = 0;
					
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_8.setText("");
					textField_6.setText("");
					textField_7.setText("");
					
					JOptionPane.showMessageDialog( null, "Invoice Generated!", null, JOptionPane.WARNING_MESSAGE);
	               
				}
			}
		});
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setBorder(new LineBorder(new Color(186, 85, 211), 2, true));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_4.setBounds(83, 599, 257, 32);
		ivFrame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashBoard db = new DashBoard();
                db.dbFrame.setVisible(true);
                ivFrame.dispose();
			}
		});
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setFocusable(false);
		btnNewButton_6.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_6.setBounds(1184, 641, 124, 32);
		ivFrame.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_8 = new JLabel("Product Details");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBackground(new Color(186, 85, 211));
		lblNewLabel_8.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_8.setBounds(516, 152, 217, 32);
		ivFrame.getContentPane().add(lblNewLabel_8);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBorder(new LineBorder(new Color(186, 85, 211), 3, true));
		panel_3.setBackground(new Color(221, 160, 221));
		panel_3.setBounds(890, 29, 389, 48);
		ivFrame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Invoice");
		lblNewLabel_9.setBounds(137, 0, 122, 47);
		lblNewLabel_9.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_9.setForeground(Color.WHITE);
		panel_3.add(lblNewLabel_9);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 105, 180));
		panel_4.setBounds(516, 152, 217, 32);
		ivFrame.getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		panel_5.setBackground(new Color(255, 228, 181));
		panel_5.setBounds(10, 493, 396, 96);
		ivFrame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Customer Ph No.");
		lblNewLabel_2_1.setBounds(3, 10, 164, 30);
		panel_5.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		textField_6 = new JTextField();
		textField_6.setBounds(177, 10, 209, 32);
		panel_5.add(textField_6);
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Customer Name");
		lblNewLabel_2_1_1.setBounds(3, 56, 164, 30);
		panel_5.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		textField_7 = new JTextField();
		textField_7.setBounds(177, 54, 209, 32);
		panel_5.add(textField_7);
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_7.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(153, 50, 204), 1, true));
		panel_6.setBackground(new Color(240, 128, 128));
		panel_6.setBounds(52, 60, 309, 32);
		ivFrame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Payment Details");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(41, 0, 233, 32);
		panel_6.add(lblNewLabel_10);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
	}
}
