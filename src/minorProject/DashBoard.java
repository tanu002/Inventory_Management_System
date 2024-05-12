package minorProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DashBoard {

	 JFrame dbFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard window = new DashBoard();
					window.dbFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DashBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\1668418175440.jpeg");
		dbFrame = new JFrame("DashBoard");
		dbFrame.setResizable(false);
		dbFrame.getContentPane().setBackground(new Color(255, 245, 238));
		dbFrame.setBounds(100, 50, 1356, 742);
		dbFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dbFrame.setIconImage(icon);
		dbFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(470, 79, 850, 544);
		panel.setBackground(new Color(218, 112, 214));
		dbFrame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\DashBoard.jpg"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(218, 112, 214), 4));
		panel_2.setBackground(new Color(221, 160, 221));
		panel_2.setBounds(25, 79, 435, 544);
		dbFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Product");
		btnNewButton.setBounds(107, 191, 229, 39);
		panel_2.add(btnNewButton);
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBorder(new LineBorder(new Color(186, 85, 211), 3, true));
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Products pr = new Products();
				pr.frame.setVisible(true);
				dbFrame.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Customers");
		btnNewButton_1.setBounds(107, 280, 229, 39);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(new LineBorder(new Color(186, 85, 211), 3, true));
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customers cr = new Customers();
				cr.frame.setVisible(true);
				dbFrame.dispose();
			}
		});
		
		
		JButton btnNewButton_2 = new JButton("Suppliers");
		btnNewButton_2.setBounds(107, 102, 229, 39);
		panel_2.add(btnNewButton_2);
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorder(new LineBorder(new Color(186, 85, 211), 3, true));
		btnNewButton_2.setBackground(new Color(255, 240, 245));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suppliers sr = new Suppliers();
				sr.frame.setVisible(true);
				dbFrame.dispose();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Invoice");
		btnNewButton_4.setBounds(107, 368, 229, 39);
		panel_2.add(btnNewButton_4);
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setBorder(new LineBorder(new Color(186, 85, 211), 3, true));
		btnNewButton_4.setBackground(new Color(255, 240, 245));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invoice invoice = new Invoice();
				invoice.ivFrame.setVisible(true);
				dbFrame.dispose();
			}
		});
		
		JButton btnNewButton_5 = new JButton("Logout");
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setBorder(new LineBorder(new Color(186, 85, 211), 2, true));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome wlc = new Welcome();
				wlc.wlcFrame.setVisible(true);
				dbFrame.dispose();
			}
		});
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		btnNewButton_5.setBounds(1069, 638, 251, 39);
		dbFrame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("DashBoard");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_1.setBounds(1087, 28, 229, 40);
		dbFrame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(new Color(218, 112, 214));
		panel_1.setBounds(918, 26, 402, 48);
		dbFrame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setBackground(new Color(255, 105, 180));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(180, 28, 122, 38);
		dbFrame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(218, 112, 214), 2));
		panel_3.setBackground(new Color(255, 240, 245));
		panel_3.setBounds(108, 28, 272, 38);
		dbFrame.getContentPane().add(panel_3);
	}
}
