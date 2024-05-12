package minorProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Welcome{

	JFrame wlcFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.wlcFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\1668418175440.jpeg");    
		wlcFrame = new JFrame();
		wlcFrame.setTitle("IManager");
		wlcFrame.getContentPane().setBackground(Color.WHITE);
		wlcFrame.setBounds(540, 150, 500, 350);
		wlcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wlcFrame.setResizable(false);
		wlcFrame.setIconImage(icon);
		wlcFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.lgFrame.setVisible(true);
				wlcFrame.dispose();
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(242, 156, 111));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.setBounds(42, 75, 130, 32);
		wlcFrame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register rg = new Register();
				rg.rgFrame.setVisible(true);
				wlcFrame.dispose();	
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(new Color(242, 156, 111));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnNewButton_1.setBounds(42, 129, 130, 39);
		wlcFrame.getContentPane().add(btnNewButton_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\MinorProject.png"));
		lblNewLabel_1.setBounds(211, 50, 250, 221);
		wlcFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome To IManager");
		lblNewLabel.setBounds(0, 0, 486, 30);
		wlcFrame.getContentPane().add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
	}
}