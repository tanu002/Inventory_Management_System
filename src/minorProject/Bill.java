package minorProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bill {

    JFrame blFrame;
	JTextField textFieldBL;
	JTextField textFieldBL_1;
	JTextField textFieldBL_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	String date, items;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill window = new Bill();
					window.blFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bill() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\1668418175440.jpeg");
		blFrame = new JFrame("Bill Gennerate");
		blFrame.setResizable(false);
		blFrame.getContentPane().setBackground(new Color(255, 248, 220));
		blFrame.setBounds(430, 100, 650, 390);
		blFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		blFrame.setIconImage(icon);
		blFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(92, 95, 181, 34);
		blFrame.getContentPane().add(lblNewLabel);
		
		textFieldBL = new JTextField();
		textFieldBL.setEditable(false);
		textFieldBL.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldBL.setBackground(new Color(215, 215, 215));
		textFieldBL.setBounds(288, 97, 290, 40);
		blFrame.getContentPane().add(textFieldBL);
		textFieldBL.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBounds(0, 92, 636, 51);
		blFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 179, 102));
		panel_1.setBounds(208, 10, 209, 40);
		blFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("IManager");
		lblNewLabel_1.setBounds(41, 5, 127, 35);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_2 = new JLabel("Phone No.");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_2.setBounds(134, 174, 181, 34);
		blFrame.getContentPane().add(lblNewLabel_2);
		
		textFieldBL_1 = new JTextField();
		textFieldBL_1.setEditable(false);
		textFieldBL_1.setBackground(new Color(215, 215, 215));
		textFieldBL_1.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		textFieldBL_1.setBounds(339, 180, 209, 25);
		blFrame.getContentPane().add(textFieldBL_1);
		textFieldBL_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Purchased amount");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_3.setBounds(134, 232, 195, 34);
		blFrame.getContentPane().add(lblNewLabel_3);
		
		textFieldBL_2 = new JTextField();
		textFieldBL_2.setEditable(false);
		textFieldBL_2.setBackground(new Color(215, 215, 215));
		textFieldBL_2.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		textFieldBL_2.setBounds(339, 238, 209, 25);
		blFrame.getContentPane().add(textFieldBL_2);
		textFieldBL_2.setColumns(10);
		
		btnNewButton = new JButton("Print");
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(new LineBorder(new Color(255, 140, 0), 1, true));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.setBounds(208, 302, 105, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintInvoice pi = new PrintInvoice();
				pi.cust_name = textFieldBL.getText();
				pi.cust_ph = textFieldBL_1.getText();
				pi.items = items;
				pi.date = date;
				pi.amount = textFieldBL_2.getText();
				pi.generateInvoice();
				JOptionPane.showMessageDialog( null, "Invoice Printed!", null, JOptionPane.WARNING_MESSAGE);
			}
		});
		blFrame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource()==btnNewButton_1) {
						
						blFrame.dispose();
						
					}
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(new LineBorder(new Color(255, 140, 0), 1, true));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1.setBounds(364, 302, 105, 34);
		blFrame.getContentPane().add(btnNewButton_1);
	}
}
