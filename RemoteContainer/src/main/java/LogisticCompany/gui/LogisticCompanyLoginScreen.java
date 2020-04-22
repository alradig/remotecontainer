package LogisticCompany.gui;


import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
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


public class LogisticCompanyLoginScreen {
	
	LogisticCompanyApp logisticCompanyApp;
	private JPanel panelLogisticCompanyLogin;
	private MainScreen parentWindow;
	private JTextField passwordField;
	private JButton btnBack;
	private JButton btnLogin;
	private JLabel lblPassword;
	private JFrame frame;
	MainScreen mainScreen;
	LogisticCompanyFunctionalitiesScreen logisticCompanyFunctionalitiesScreen;
	
	public LogisticCompanyLoginScreen(LogisticCompanyApp logisticCompanyApp, MainScreen parentWindow, JFrame frame) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.frame = frame;
		initialize();
	}
	
	public void initialize() {
		
		panelLogisticCompanyLogin = new JPanel();
		parentWindow.addPanel(panelLogisticCompanyLogin);
		panelLogisticCompanyLogin.setLayout(null);
		panelLogisticCompanyLogin.setBorder(BorderFactory.createTitledBorder(
                "Logistic Company login"));
		
		passwordField = new JTextField();
		passwordField.setBounds(138, 100, 130, 26);
		panelLogisticCompanyLogin.add(passwordField);
		passwordField.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 105, 74, 16);
		panelLogisticCompanyLogin.add(lblPassword);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				logisticCompanyFunctionalitiesScreen.setVisible(true);	
			}
		});
		btnLogin.setBounds(148, 200, 117, 29);
		
		
		panelLogisticCompanyLogin.add(btnLogin);
		btnLogin.getRootPane().setDefaultButton(btnLogin);
		
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelLogisticCompanyLogin.add(btnBack);
		logisticCompanyFunctionalitiesScreen = new LogisticCompanyFunctionalitiesScreen(logisticCompanyApp, this, frame, parentWindow);
		
	}

	public void setVisible(boolean aFlag) {
		panelLogisticCompanyLogin.setVisible(aFlag);
		
	}
	public void addPanel(JPanel panel) {
		frame.getContentPane().add(panel);
	}
	
}
