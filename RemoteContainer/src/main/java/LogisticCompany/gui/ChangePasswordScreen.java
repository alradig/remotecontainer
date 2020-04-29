package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.Client;
import LogisticCompany.info.ClientInfo;

public class ChangePasswordScreen implements PropertyChangeListener  {
	LogisticCompanyApp logisticCompanyApp;

	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelChangePassword;
	private JPasswordField currentPasswordField;
	private JLabel lblCurrentPassword;
	private JPasswordField newPasswordField;
	private JLabel lblNewPassword;
	private JLabel lblRegistrationStatus;


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
		
		lblRegistrationStatus = new JLabel("");
		lblRegistrationStatus.setBounds(0, 65, 300, 16);
		lblRegistrationStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panelChangePassword.add(lblRegistrationStatus);
		
		currentPasswordField = new JPasswordField();
		currentPasswordField.setBounds(170, 100, 130, 26);
		panelChangePassword.add(currentPasswordField);
//		currentPasswordField.setColumns(10);
		
		lblCurrentPassword = new JLabel("Current Password:");
		lblCurrentPassword.setBounds(50, 105, 120, 16);
		panelChangePassword.add(lblCurrentPassword);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(170, 140, 130, 26);
		panelChangePassword.add(newPasswordField);
//		newPasswordField.setColumns(10);
		
		lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(50, 145, 120, 16);
		panelChangePassword.add(lblNewPassword);
		
		JButton btnregister = new JButton("Submit");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentPassword = currentPasswordField.getText();
				String newPassword = newPasswordField.getText();
				
				if (!currentPassword.equals(logisticCompanyApp.getSelectedClient().getPassword())) {
					lblRegistrationStatus.setText("The password is wrong!");
				} else if (newPassword.equals("")) {
					lblRegistrationStatus.setText("Please enter a new password!");
				} else {
					logisticCompanyApp.setClientPassword(new ClientInfo(logisticCompanyApp.getSelectedClient()), newPassword);
					lblRegistrationStatus.setText("The password is changed!");
				}
				newPasswordField.setText("");
				currentPasswordField.setText("");	
			}
		});
		btnregister.setBounds(155, 230, 100, 29);
		panelChangePassword.add(btnregister);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
				lblRegistrationStatus.setText("");
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelChangePassword.add(btnBack);
	}
	
	public void setVisible(boolean aFlag) {
		panelChangePassword.setVisible(aFlag);
		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}
	
}

