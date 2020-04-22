package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import LogisticCompany.App.LogisticCompanyApp;

public class ClientFindJourneyScreen {
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelClientFindJourney;
	

	public ClientFindJourneyScreen(LogisticCompanyApp logisticCompanyApp, ClientFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelClientFindJourney = new JPanel();
		parentWindow.addPanel(panelClientFindJourney);
		panelClientFindJourney.setLayout(null);
		panelClientFindJourney.setBorder(BorderFactory.createTitledBorder(
                "Register Journey"));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelClientFindJourney.add(btnBack);
	}
	
	public void setVisible(boolean aFlag) {
		panelClientFindJourney.setVisible(aFlag);
		
	}
	
}
