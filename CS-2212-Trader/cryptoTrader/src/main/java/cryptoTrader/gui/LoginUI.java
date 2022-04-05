package cryptoTrader.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cryptoTrader.utils.Login;

public class LoginUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private static LoginUI instance;
	
	private static JLabel usernameLabel;
	private static JTextField usernameFill;
	private static JLabel passwordLabel;
	private static JPasswordField passwordFill;
	private static JButton loginBtn;
	
	public static LoginUI getInstance() {
		if (instance == null) instance = new LoginUI();
		return instance;
	}
	
	private LoginUI() {
		super("Login - Crypto Trading Tool");
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(25, 25, 80, 25);
		
		usernameFill = new JTextField(24);
		usernameFill.setBounds(100, 25, 175, 25);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(25, 60, 80, 25);
		
		passwordFill = new JPasswordField(24);
		passwordFill.setBounds(100, 60, 175, 25);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(25, 100, 250, 25);
		loginBtn.addActionListener(this);
		
		loginPanel.add(usernameLabel);
		loginPanel.add(usernameFill);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordFill);
		loginPanel.add(loginBtn);
		
		getContentPane().add(loginPanel);
	}
	
	public static void main(String[] args) {
		JFrame loginFrame = LoginUI.getInstance();
		loginFrame.setSize(new Dimension(325, 200));
	
		loginFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String setUsername = usernameFill.getText();
		String setPassword = String.valueOf(passwordFill.getPassword());
		Login login = new Login(setUsername, setPassword);
		
		if (login.attempt()) {
			LoginUI.getInstance().setVisible(false);
			LoginUI.getInstance().dispose();
			MainUI.main(null);
		} else {
			JOptionPane.showMessageDialog(null, "The username or password was incorrect.");
		}
	}
	
}
