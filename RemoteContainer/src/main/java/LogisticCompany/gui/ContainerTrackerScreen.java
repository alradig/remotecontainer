package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import LogisticCompany.App.LogisticCompanyApp;

public class ContainerTrackerScreen {
	
	LogisticCompanyApp logisticCompanyApp;
	private ClientFindJourneyScreen parentWindow;
	private JPanel panelContainerTracker;

	public ContainerTrackerScreen(LogisticCompanyApp logisticCompanyApp, ClientFindJourneyScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		
		initialize();
	}
	
	private void initialize() {
		panelContainerTracker = new JPanel();
		parentWindow.addPanel(panelContainerTracker);
		panelContainerTracker.setLayout(null);
		panelContainerTracker.setBorder(BorderFactory.createTitledBorder(
                "Find Existing Journey"));
	
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			parentWindow.setVisible(true);
		}
	});
	btnBack.setBounds(21, 28, 65, 29);
	panelContainerTracker.add(btnBack);
	
	}
	
	public void setVisible(boolean aFlag) {
		panelContainerTracker.setVisible(aFlag);
		
	}
}
