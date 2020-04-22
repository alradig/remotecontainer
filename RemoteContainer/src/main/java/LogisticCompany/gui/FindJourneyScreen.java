package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import LogisticCompany.App.LogisticCompanyApp;

public class FindJourneyScreen {
	LogisticCompanyApp logisticCompanyApp;
	private LogisticCompanyFunctionalitiesScreen parentWindow;

	private JPanel panelFindJourney;

	public FindJourneyScreen(LogisticCompanyApp logisticCompanyApp,
			LogisticCompanyFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	private void initialize() {
		panelFindJourney = new JPanel();
		parentWindow.addPanel(panelFindJourney);
		panelFindJourney.setLayout(null);
		panelFindJourney.setBorder(BorderFactory.createTitledBorder(
                "Find Existing Journey"));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelFindJourney.add(btnBack);
		
	}
	
	public void setVisible(boolean aFlag) {
		panelFindJourney.setVisible(aFlag);
		
	}

}
