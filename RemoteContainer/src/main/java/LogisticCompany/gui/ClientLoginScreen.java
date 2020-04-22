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
		userNameField.setBounds(138, 28, 130, 26);
		panelClientLogin.add(userNameField);
		userNameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(138, 28, 130, 26);
		panelClientLogin.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");

		btnLogin.setBounds(148, 68, 117, 29);
		panelClientLogin.add(btnLogin);
		btnLogin.getRootPane().setDefaultButton(btnLogin);
		
		
		btnBack = new JButton("Back");
		btnBack.setBounds(21, 28, 59, 29);
		panelClientLogin.add(btnBack);
		
		
	
		
	}

	public void setVisible(boolean aFlag) {
		panelClientLogin.setVisible(aFlag);
		
	}
	
}
