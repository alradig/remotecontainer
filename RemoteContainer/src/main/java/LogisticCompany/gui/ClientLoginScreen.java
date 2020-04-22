package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import LogisticCompany.App.LogisticCompanyApp;


public class ClientLoginScreen {
	LogisticCompanyApp logisticCompanyApp;
	private JPanel panelClientLogin;
	private MainScreen parentWindow;
	private JTextField userNameField;
	private JTextField passwordField;
	private JButton btnBack;
	private JButton btnLogin;
	private JLabel lblPassword;
	private JLabel lblUsername;
	
	
	public ClientLoginScreen(LogisticCompanyApp logisticCompanyApp, MainScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	public void initialize() {
		
		panelClientLogin = new JPanel();
		parentWindow.addPanel(panelClientLogin);
		panelClientLogin.setLayout(null);
		panelClientLogin.setBorder(BorderFactory.createTitledBorder(
                "Client login"));
		
		userNameField = new JTextField();
		userNameField.setBounds(138, 100, 130, 26);
		panelClientLogin.add(userNameField);
		userNameField.setColumns(10);
		
		lblUsername = new JLabel("User Name:");
		lblUsername.setBounds(50, 105, 74, 16);
		panelClientLogin.add(lblUsername);

		
		passwordField = new JTextField();
		passwordField.setBounds(138, 140, 130, 26);
		panelClientLogin.add(passwordField);
		passwordField.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 145, 74, 16);
		panelClientLogin.add(lblPassword);

		
		
		JButton btnLogin = new JButton("Login");

		btnLogin.setBounds(148, 200, 117, 29);
		panelClientLogin.add(btnLogin);
		btnLogin.getRootPane().setDefaultButton(btnLogin);
		
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 59, 29);
		panelClientLogin.add(btnBack);
		
		
	
		
	}

	public void setVisible(boolean aFlag) {
		panelClientLogin.setVisible(aFlag);
		
	}
	
}
