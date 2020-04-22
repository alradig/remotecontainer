package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import LogisticCompany.App.LogisticCompanyApp;

public class RegisterContainerScreen {
	LogisticCompanyApp logisticCompanyApp;
	private LogisticCompanyFunctionalitiesScreen parentWindow;
	private JPanel panelRegisterContainer;
	public RegisterContainerScreen(LogisticCompanyApp logisticCompanyApp,
			LogisticCompanyFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	private void initialize() {
		panelRegisterContainer = new JPanel();
		parentWindow.addPanel(panelRegisterContainer);
		panelRegisterContainer.setLayout(null);
		panelRegisterContainer.setBorder(BorderFactory.createTitledBorder(
                "Register Container for Journey"));
		

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelRegisterContainer.add(btnBack);
	
	}
	
	public void setVisible(boolean aFlag) {
		panelRegisterContainer.setVisible(aFlag);
		
	}
	
}
