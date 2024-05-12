package minorProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Login {

	JFrame lgFrame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.lgFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\1668418175440.jpeg");
		lgFrame = new JFrame();
		lgFrame.setTitle("Login Page");
		lgFrame.getContentPane().setBackground(new Color(245, 245, 220));
		lgFrame.setBounds(500, 150, 560, 300);
		lgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lgFrame.setResizable(false);
		lgFrame.setIconImage(icon);
		lgFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		panel.setBorder(new LineBorder(Color.BLACK, 1, true));
		panel.setBounds(200, 0, 146, 27);
		lgFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(39, 0, 66, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblNewLabel_1 = new JLabel("UserID");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(new Color(255, 200, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(25, 64, 81, 27);
		lgFrame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField("Enter name");
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(116, 65, 230, 27);
		lgFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(28, 113, 78, 27);
		lgFrame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField("Enter password");
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_1.setBounds(116, 114, 230, 27);
		lgFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBorder(new LineBorder(new Color(242, 156,111), 1, true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Validation val = new Validation();
				if(val.isValidUser(textField.getText(), textField_1.getText())) {
					DashBoard db = new DashBoard();
					db.dbFrame.setVisible(true);
					lgFrame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password!!!", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(141, 215, 117, 21);
		lgFrame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBorder(new LineBorder(new Color(242, 156,111), 1, true));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton_1.setBounds(268, 215, 124, 21);
		lgFrame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome wlc = new Welcome();
				wlc.wlcFrame.setVisible(true);
				lgFrame.dispose();	
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBorder(new LineBorder(new Color(242, 156,111), 1, true));
		btnNewButton_2.setBounds(402, 215, 119, 21);
		lgFrame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ayanp\\eclipse-workspace for GUI\\InventoryManagementSystem\\src\\IMS (1).jpg"));
		lblNewLabel_3.setBounds(370, 50, 151, 157);
		lgFrame.getContentPane().add(lblNewLabel_3);
	}
}
