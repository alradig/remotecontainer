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

public class UpdateClientInfoScreen extends Screen{
	LogisticCompanyApp logisticCompanyApp;
	private Screen parentWindow;
	
	private JPanel panelRegisterClient;
	private JTextField nameField;
	private JLabel lblName;
	private JTextField emailField;
	private JLabel lblemail;
	private JTextField zipCodeField;
	private JLabel lblZipCode;
	private JTextField cityField;
	private JLabel lblCity;
	private JTextField streetField;
	private JLabel lblStreet;
	private JTextField refPField;
	private JLabel lblRefP;
	private JLabel lblRegistrationStatus;

	public UpdateClientInfoScreen(LogisticCompanyApp logisticCompanyApp, Screen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelRegisterClient = new JPanel();
		parentWindow.addPanel(panelRegisterClient);
		panelRegisterClient.setLayout(null);
		panelRegisterClient.setBorder(BorderFactory.createTitledBorder(
                "Update Client"));
		
		lblRegistrationStatus = new JLabel("");
		lblRegistrationStatus.setBounds(53, 65, 300, 16);
		lblRegistrationStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panelRegisterClient.add(lblRegistrationStatus);
		
		nameField = new JTextField();
		nameField.setBounds(170, 100, 130, 26);
		panelRegisterClient.add(nameField);
		nameField.setColumns(10);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(50, 105, 74, 16);
		panelRegisterClient.add(lblName);
		
		refPField = new JTextField();
		refPField.setBounds(170, 140, 130, 26);
		panelRegisterClient.add(refPField);
		
		lblRefP = new JLabel("Reference Person:");
		lblRefP.setBounds(50, 145, 115, 16);
		panelRegisterClient.add(lblRefP);
		
		emailField = new JTextField();
		emailField.setBounds(170, 180, 130, 26);
		panelRegisterClient.add(emailField);
		emailField.setColumns(10);
		
		lblemail = new JLabel("email:");
		lblemail.setBounds(50, 185, 74, 16);
		panelRegisterClient.add(lblemail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(208, 260, 74, 16);
		panelRegisterClient.add(lblAddress);
		
		zipCodeField = new JTextField();
		zipCodeField.setBounds(170, 290, 130, 26);
		panelRegisterClient.add(zipCodeField);
		zipCodeField.setColumns(10);
		
		lblZipCode = new JLabel("Zip code:");
		lblZipCode.setBounds(50, 295, 74, 16);
		panelRegisterClient.add(lblZipCode);
		
		cityField = new JTextField();
		cityField.setBounds(170, 330, 130, 26);
		panelRegisterClient.add(cityField);
		cityField.setColumns(10);
		
		lblCity = new JLabel("City:");
		lblCity.setBounds(50, 335, 74, 16);
		panelRegisterClient.add(lblCity);
		
		streetField = new JTextField();
		streetField.setBounds(170, 370, 130, 26);
		panelRegisterClient.add(streetField);
		streetField.setColumns(10);
		
		lblStreet = new JLabel("Street:");
		lblStreet.setBounds(50, 375, 74, 16);
		panelRegisterClient.add(lblStreet);
		
		
		JButton btnregister = new JButton("Update");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateClient();
			}
		});
		btnregister.setBounds(155, 450, 100, 29);
		panelRegisterClient.add(btnregister);
		
				
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
				lblRegistrationStatus.setText("");
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelRegisterClient.add(btnBack);
	}
	
	protected void updateClient() {
		String name = nameField.getText();
		String email = emailField.getText();
		String zipCode = zipCodeField.getText();
		String city = cityField.getText();
		String street = streetField.getText();
		String refPerson = refPField.getText();
		
		
		if (!email.isEmpty() && (!email.contains("@") || !email.contains("."))) {
			lblRegistrationStatus.setText("Email is not valid");
		} else {
			logisticCompanyApp.updateClient(name, refPerson, email, zipCode, city, street);
			lblRegistrationStatus.setText("Client is successfully updated!");
			
			nameField.setText("");
			emailField.setText("");
			zipCodeField.setText("");
			cityField.setText("");
			streetField.setText("");
			refPField.setText("");
		}
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		panelRegisterClient.setVisible(aFlag);
		
	}

	@Override
	public void addPanel(JPanel panel) {
		parentWindow.addPanel(panel);
	}
	
	

}

