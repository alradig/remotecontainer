package LogisticCompany.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import LogisticCompany.App.LogisticCompanyApp;

public class RegisterClientScreen {
	LogisticCompanyApp logisticCompanyApp;
	private LogisticCompanyFunctionalitiesScreen parentWindow;
	private JPanel panelRegisterClient;
	

	public RegisterClientScreen(LogisticCompanyApp logisticCompanyApp, LogisticCompanyFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
//		initialize();
	}
	
	
	public void setVisible(boolean aFlag) {
		panelRegisterClient.setVisible(aFlag);
		
	}

}
