package LogisticCompany.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import LogisticCompany.App.LogisticCompanyApp;

public class RegisterJourneyScreen {
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelRegisterClient;
	

	public RegisterJourneyScreen(LogisticCompanyApp logisticCompanyApp, ClientFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
//		initialize();
	}
	
	
	public void setVisible(boolean aFlag) {
		panelRegisterClient.setVisible(aFlag);
		
	}

}
