package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LogisticCompany.App.LogisticCompanyApp;

public class OtherClientScreen {
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelOtherClient;
	private JTextField nameField;
	private JLabel lblName;
	private JTextField emailField;
	private JLabel lblemail;

	public OtherClientScreen(LogisticCompanyApp logisticCompanyApp, ClientFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelOtherClient = new JPanel();
		parentWindow.addPanel(panelOtherClient);
		panelOtherClient.setLayout(null);
		panelOtherClient.setBorder(BorderFactory.createTitledBorder(
                "Register Journey"));
		
		nameField = new JTextField();
		nameField.setBounds(138, 100, 130, 26);
		panelOtherClient.add(nameField);
		nameField.setColumns(10);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(50, 105, 74, 16);
		panelOtherClient.add(lblName);
		
		emailField = new JTextField();
		emailField.setBounds(138, 140, 130, 26);
		panelOtherClient.add(emailField);
		nameField.setColumns(10);
		
		lblemail = new JLabel("email:");
		lblemail.setBounds(50, 145, 74, 16);
		panelOtherClient.add(lblemail);
		
		JButton btnregister = new JButton("submit");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// register and go back 
				parentWindow.setVisible(true);
			}
		});
		btnregister.setBounds(170, 225, 74, 16);
		panelOtherClient.add(btnregister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelOtherClient.add(btnBack);
	}
	
	public void setVisible(boolean aFlag) {
		panelOtherClient.setVisible(aFlag);
		
	}
	
}
