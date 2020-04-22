package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import LogisticCompany.App.LogisticCompanyApp;

public class ChangePasswordScreen {
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelChangePassword;
	private JTextField currentPasswordField;
	private JLabel lblCurrentPassword;
	private JTextField newPasswordField;
	private JLabel lblNewPassword;
	

	public ChangePasswordScreen(LogisticCompanyApp logisticCompanyApp, ClientFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelChangePassword = new JPanel();
		parentWindow.addPanel(panelChangePassword);
		panelChangePassword.setLayout(null);
		panelChangePassword.setBorder(BorderFactory.createTitledBorder(
                "Change Password"));
		
//		currentPasswordField = new JTextField();
//		currentPasswordField.setBounds(170, 100, 130, 26);
//		panelChangePassword.add(currentPasswordField);
//		currentPasswordField.setColumns(10);
		
		JPasswordField passWordText = new JPasswordField();
		passWordText.setBounds(170, 100, 130, 26);
		panelChangePassword.add(passWordText);
		
		lblCurrentPassword = new JLabel("Current Password:");
		lblCurrentPassword.setBounds(50, 105, 120, 16);
		panelChangePassword.add(lblCurrentPassword);
		
//		newPasswordField = new JTextField();
//		newPasswordField.setBounds(170, 140, 130, 26);
//		panelChangePassword.add(newPasswordField);
//		newPasswordField.setColumns(10);
		
		JPasswordField newPassWordText = new JPasswordField();
		newPassWordText.setBounds(170, 140, 130, 26);
		panelChangePassword.add(newPassWordText);
		
		lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(50, 145, 120, 16);
		panelChangePassword.add(lblNewPassword);
		
		
		
		JButton btnregister = new JButton("submit");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// register and go back 
				parentWindow.setVisible(true);
			}
		});
		btnregister.setBounds(170, 225, 74, 16);
		panelChangePassword.add(btnregister);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelChangePassword.add(btnBack);
	}
	
	public void setVisible(boolean aFlag) {
		panelChangePassword.setVisible(aFlag);
		
	}
	
}

