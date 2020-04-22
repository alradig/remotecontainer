package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import LogisticCompany.App.LogisticCompanyApp;

public class ChangePasswordScreen {
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelChangePassword;
	

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

