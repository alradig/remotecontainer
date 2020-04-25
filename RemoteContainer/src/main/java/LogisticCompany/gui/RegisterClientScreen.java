package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;

public class RegisterClientScreen {
	LogisticCompanyApp logisticCompanyApp;
	private LogisticCompanyFunctionalitiesScreen parentWindow;
	private JPanel panelRegisterClient;
	private JTextField nameField;
	private JLabel lblName;
	private JTextField emailField;
	private JLabel lblemail;
	private JTextField passwordField;
	private JLabel lblPassword;
	private JTextField zipCodeField;
	private JLabel lblZipCode;
	private JTextField cityField;
	private JLabel lblCity;
	private JTextField streetField;
	private JLabel lblStreet;
	private JTextField refPField;
	private JLabel lblRefP;
	private JLabel lblRegistrationStatus;

	public RegisterClientScreen(LogisticCompanyApp logisticCompanyApp, LogisticCompanyFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelRegisterClient = new JPanel();
		parentWindow.addPanel(panelRegisterClient);
		panelRegisterClient.setLayout(null);
		panelRegisterClient.setBorder(BorderFactory.createTitledBorder(
                "Register Client"));
		
		lblRegistrationStatus = new JLabel("");
		lblRegistrationStatus.setBounds(0, 65, 300, 16);
		lblRegistrationStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panelRegisterClient.add(lblRegistrationStatus);
		
		nameField = new JTextField();
		nameField.setBounds(138, 100, 130, 26);
		panelRegisterClient.add(nameField);
		nameField.setColumns(10);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(50, 105, 74, 16);
		panelRegisterClient.add(lblName);
		
		emailField = new JTextField();
		emailField.setBounds(138, 140, 130, 26);
		panelRegisterClient.add(emailField);
		nameField.setColumns(10);
		
		lblemail = new JLabel("email:");
		lblemail.setBounds(50, 145, 74, 16);
		panelRegisterClient.add(lblemail);
		
		passwordField = new JTextField();
		passwordField.setBounds(138, 180, 130, 26);
		panelRegisterClient.add(passwordField);
		passwordField.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 185, 74, 16);
		panelRegisterClient.add(lblPassword);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(170, 225, 74, 16);
		panelRegisterClient.add(lblAddress);
		
		zipCodeField = new JTextField();
		zipCodeField.setBounds(138, 260, 130, 26);
		panelRegisterClient.add(zipCodeField);
		passwordField.setColumns(10);
		
		lblZipCode = new JLabel("Zip code:");
		lblZipCode.setBounds(50, 265, 74, 16);
		panelRegisterClient.add(lblZipCode);
		
		cityField = new JTextField();
		cityField.setBounds(138, 300, 130, 26);
		panelRegisterClient.add(cityField);
		passwordField.setColumns(10);
		
		lblCity = new JLabel("City:");
		lblCity.setBounds(50, 305, 74, 16);
		panelRegisterClient.add(lblCity);
		
		streetField = new JTextField();
		streetField.setBounds(138, 340, 130, 26);
		panelRegisterClient.add(streetField);
		passwordField.setColumns(10);
		
		lblStreet = new JLabel("Street:");
		lblStreet.setBounds(50, 345, 74, 16);
		panelRegisterClient.add(lblStreet);
		
		refPField = new JTextField();
		refPField.setBounds(138, 380, 130, 26);
		panelRegisterClient.add(refPField);
		passwordField.setColumns(10);
		
		lblRefP = new JLabel("Reference Person:");
		lblRefP.setBounds(50, 385, 74, 16);
		panelRegisterClient.add(lblRefP);
		
		
		JButton btnregister = new JButton("Register");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String email = emailField.getText();
				String password = passwordField.getText();
				String zipCode = zipCodeField.getText();
				String city = cityField.getText();
				String street = streetField.getText();
				String refPerson = refPField.getText();
				
				
				if (name.equals("") || email.equals("") || password.equals("") || zipCode.equals("") || city.equals("") || street.equals("") || refPerson.equals("")) {
					lblRegistrationStatus.setText("Missing information!");
				}else {
					try { 
						logisticCompanyApp.registerClient(name, email, password, zipCode, city, street, refPerson);
						lblRegistrationStatus.setText("Client is successfully registered!");
					} catch (OperationNotAllowedException e1) {
						e1.printStackTrace();
					}
					
					nameField.setText("");
					emailField.setText("");
					passwordField.setText("");
					zipCodeField.setText("");
					cityField.setText("");
					streetField.setText("");
					refPField.setText("");
				}
			}
		});
		btnregister.setBounds(170, 425, 74, 16);
		panelRegisterClient.add(btnregister);
		
				
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelRegisterClient.add(btnBack);
	}
	
	public void setVisible(boolean aFlag) {
		panelRegisterClient.setVisible(aFlag);
		
	}
	
	

}
