package LogisticCompany.gui;


import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import java.beans.*;
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
import LogisticCompany.App.OperationNotAllowedException;



public class LogisticCompanyLoginScreen implements PropertyChangeListener  {
	
	PropertyChangeSupport support = new PropertyChangeSupport(this);
	LogisticCompanyApp logisticCompanyApp;
	private JPanel panelLogisticCompanyLogin;
	private MainScreen parentWindow;
	private JTextField passwordField;
	private JLabel lblLoginStatus;
	private JButton btnBack;
	private JButton btnLogin;
	private JLabel lblPassword;
	private JFrame frame;
	private String errorMessage;
	MainScreen mainScreen;
	LogisticCompanyFunctionalitiesScreen logisticCompanyFunctionalitiesScreen;
	
	public LogisticCompanyLoginScreen(LogisticCompanyApp logisticCompanyApp, MainScreen parentWindow, JFrame frame) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.frame = frame;
		initialize();
	}
	
	void addObserver(PropertyChangeListener l) {
		support.addPropertyChangeListener(l);
	}
	
	public void initialize() {
		
		panelLogisticCompanyLogin = new JPanel();
		parentWindow.addPanel(panelLogisticCompanyLogin);
		panelLogisticCompanyLogin.setLayout(null);
		panelLogisticCompanyLogin.setBorder(BorderFactory.createTitledBorder(
                "Logistic Company login"));
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(138, 100, 130, 26);
		panelLogisticCompanyLogin.add(passwordField);
		
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 105, 74, 16);
		panelLogisticCompanyLogin.add(lblPassword);
		
		lblLoginStatus = new JLabel("");
		lblLoginStatus.setBounds(0, 65, 300, 16);
		lblLoginStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panelLogisticCompanyLogin.add(lblLoginStatus);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean loginOk = false;
				
				try {
					loginOk = logisticCompanyApp.logisticCompanyLogin(passwordField.getText());
				} catch (OperationNotAllowedException exception) {
					lblLoginStatus.setText(exception.getMessage());
				}
				
				passwordField.setText("");
				
				if(loginOk) {
					setVisible(false);
					logisticCompanyFunctionalitiesScreen.setVisible(true);
					lblLoginStatus.setText("");
				}
				
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
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {	
	}
	
}
