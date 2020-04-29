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
	private JLabel submitStatus;
	

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
		
		JLabel lblComment = new JLabel("<html>Enter the name and email of the user you want to give access to your journey information.</html>");
		lblComment.setBounds(50, 75, 300, 50);
		panelGiveAccess.add(lblComment);
		nameField = new JTextField();
		
		submitStatus = new JLabel("");
		submitStatus.setBounds(100, 110, 300, 26);
		panelGiveAccess.add(submitStatus);
		
		nameField.setBounds(138, 150, 130, 26);
		panelGiveAccess.add(nameField);
		nameField.setColumns(10);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(50, 155, 74, 16);
		panelGiveAccess.add(lblName);
		
		emailField = new JTextField();
		emailField.setBounds(138, 190, 130, 26);
		panelGiveAccess.add(emailField);
		nameField.setColumns(10);
		
		lblemail = new JLabel("email:");
		lblemail.setBounds(50, 195, 74, 16);
		panelGiveAccess.add(lblemail);
		
		JButton btnregister = new JButton("submit");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean submitionOk = false;
				
				try {
					submitionOk = logisticCompanyApp.provideAccess(nameField.getText(), emailField.getText());
				} catch (Exception e1) {
					submitStatus.setText(e1.getMessage());
				}
				
				if(submitionOk) {
					submitStatus.setText("Access successfully granted!");
					emailField.setText("");
					nameField.setText("");
				}
			}
		});
		btnregister.setBounds(170, 255, 74, 29);
		panelGiveAccess.add(btnregister);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
				submitStatus.setText("");
				emailField.setText("");
				nameField.setText("");
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelGiveAccess.add(btnBack);
	}
	
	public void setVisible(boolean aFlag) {
		panelGiveAccess.setVisible(aFlag);
		
	}
	
}
