package minorProject;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register {

	JFrame rgFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private ButtonGroup btnGroup;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.rgFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\1668418175440.jpeg");
		rgFrame = new JFrame();
		rgFrame.setTitle("Registration Page");
		rgFrame.getContentPane().setBackground(new Color(245, 245, 220));
		rgFrame.setBounds(460, 100, 616, 600);
		rgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rgFrame.setResizable(false);
		rgFrame.setIconImage(icon);
		rgFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK));
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(209, 0, 196, 47);
		rgFrame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Registration");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Name ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(10, 64, 82, 26);
		rgFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(10, 113, 85, 26);
		rgFrame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email ID ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3.setBounds(10, 257, 106, 26);
		rgFrame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Shop Name");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_4.setBounds(10, 341, 106, 30);
		rgFrame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Category ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_5.setBounds(10, 305, 106, 26);
		rgFrame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_6.setBounds(10, 381, 103, 26);
		rgFrame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Mobile No.");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_8.setBounds(10, 221, 106, 26);
		rgFrame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Password ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_7.setBounds(10, 417, 103, 26);
		rgFrame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_10 = new JLabel("ConfirmPW");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_10.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_10.setBounds(10, 452, 106, 26);
		rgFrame.getContentPane().add(lblNewLabel_10);
		
		textField = new JTextField("Enter name");
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField.setBounds(123, 65, 213, 26);
		rgFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField("Enter your valid mobile no.");
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField_2.setBounds(123, 222, 213, 26);
		rgFrame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField("Enter your current address");
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField_3.setBounds(123, 381, 457, 26);
		rgFrame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField("Enter your valid email ID");
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField_4.setBounds(123, 258, 213, 26);
		rgFrame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_6 = new JTextField("Enter shop name");
		textField_6.setBackground(Color.LIGHT_GRAY);
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField_6.setBounds(123, 344, 213, 26);
		rgFrame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_5 = new JTextField("");
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField_5.setColumns(10);
		textField_5.setBackground(Color.LIGHT_GRAY);
		textField_5.setBounds(123, 417, 312, 26);
		rgFrame.getContentPane().add(textField_5);
		
		textField_1 = new JTextField("confirm password");
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(123, 453, 312, 26);
		rgFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorder(new LineBorder(new Color(242, 156,111), 1, true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Validation val = new Validation();
				if(textField.getText().equals("")||textField_2.getText().equals("")||textField_4.getText().equals("")||textField_3.getText().equals("")||textField_6.getText().equals("")||textField_5.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter all the details!!!", null, JOptionPane.WARNING_MESSAGE);
				}
				else if(val.isValidName(textField.getText())==false||val.isValidMobileNo(textField_2.getText())==false) {
					JOptionPane.showMessageDialog(null, "Entered wrong data!!!", null, JOptionPane.WARNING_MESSAGE);
				}
				else if(textField_5.getText().equals(textField_1.getText())){
					rgFrame.dispose();
					RegistrationData rd = new RegistrationData();
					rd.frame.setVisible(true);
					rd.textField.setText(textField.getText());
					rd.textField_1.setText(textField_2.getText());
					rd.textField_2.setText(textField_4.getText());
					rd.textField_3.setText(textField_6.getText());
					
					DBConnection dbcon = new DBConnection();
					dbcon.setName(textField.getText());
					dbcon.setGender(btnGroup.getSelection().getActionCommand());
					dbcon.setMobile_no(textField_2.getText());
					dbcon.setEmail_id(textField_4.getText());
					dbcon.setAddress(textField_3.getText());
					dbcon.setCategory(comboBox.getSelectedItem().toString());
					dbcon.setShop_name(textField_6.getText());
					dbcon.setPassword(textField_5.getText());
					dbcon.addRegistrationData();
					
					JOptionPane.showMessageDialog(null, "Registration successful!", null, JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Password not matched!!!", null, JOptionPane.WARNING_MESSAGE);
				}
					
			}
				
				
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(230, 509, 106, 26);
		rgFrame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_6.setText("");
				textField.setText("");
				textField_1.setText("");
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				comboBox.setSelectedIndex(0);
				
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBorder(new LineBorder(new Color(242, 156,111), 1, true));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(346, 509, 106, 26);
		rgFrame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome wlc = new Welcome();
				wlc.wlcFrame.setVisible(true);
				rgFrame.dispose();	
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBorder(new LineBorder(new Color(242, 156,111), 1, true));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(462, 509, 106, 26);
		rgFrame.getContentPane().add(btnNewButton_2);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(481, 494, 1, 1);
		rgFrame.getContentPane().add(desktopPane);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"      ---select catagory---", "Medicine", "Food", "Fashion & Garments", "Footwears", "Electronics"}));
		comboBox.setBounds(123, 305, 206, 26);
		rgFrame.getContentPane().add(comboBox);
		
		rdbtnNewRadioButton = new JRadioButton("male");
		rdbtnNewRadioButton.setActionCommand("male");
		rdbtnNewRadioButton.setFocusable(false);
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdbtnNewRadioButton.setBounds(123, 114, 213, 26);
		rgFrame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("female");
		rdbtnNewRadioButton_1.setActionCommand("female");
		rdbtnNewRadioButton_1.setFocusable(false);
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdbtnNewRadioButton_1.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_1.setBounds(123, 142, 213, 26);
		rgFrame.getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("others");
		rdbtnNewRadioButton_2.setActionCommand("others");
		rdbtnNewRadioButton_2.setFocusable(false);
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdbtnNewRadioButton_2.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_2.setBounds(123, 170, 213, 26);
		rgFrame.getContentPane().add(rdbtnNewRadioButton_2);
		
		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnNewRadioButton);
		btnGroup.add(rdbtnNewRadioButton_1);
		btnGroup.add(rdbtnNewRadioButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 0)));
		panel_1.setBounds(346, 64, 234, 307);
		rgFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(10, 10, 212, 289);
		panel_1.add(lblNewLabel_9);
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\Rs01 (1).jpg"));
		
		
	}
}
