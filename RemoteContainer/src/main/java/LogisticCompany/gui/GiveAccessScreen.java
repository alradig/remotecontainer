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

public class GiveAccessScreen {
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelGiveAccess;
	private JTextField nameField;
	private JLabel lblName;
	private JTextField emailField;
	private JLabel lblemail;
	

	public GiveAccessScreen(LogisticCompanyApp logisticCompanyApp, ClientFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelGiveAccess = new JPanel();
		parentWindow.addPanel(panelGiveAccess);
		panelGiveAccess.setLayout(null);
		panelGiveAccess.setBorder(BorderFactory.createTitledBorder(
                "Give Access to Other Clients"));
		

		nameField = new JTextField();
		nameField.setBounds(138, 100, 130, 26);
		panelGiveAccess.add(nameField);
		nameField.setColumns(10);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(50, 105, 74, 16);
		panelGiveAccess.add(lblName);
		
		emailField = new JTextField();
		emailField.setBounds(138, 140, 130, 26);
		panelGiveAccess.add(emailField);
		nameField.setColumns(10);
		
		lblemail = new JLabel("email:");
		lblemail.setBounds(50, 145, 74, 16);
		panelGiveAccess.add(lblemail);
		
		JButton btnregister = new JButton("submit");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// register and go back 
				parentWindow.setVisible(true);
			}
		});
		btnregister.setBounds(170, 225, 74, 16);
		panelGiveAccess.add(btnregister);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelGiveAccess.add(btnBack);
	}
	
	public void setVisible(boolean aFlag) {
		panelGiveAccess.setVisible(aFlag);
		
	}
	
}
