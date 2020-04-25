package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Journey;
import LogisticCompany.domain.JourneyStatusEntry;
import LogisticCompany.info.JourneyInfo;

public class UpdateJourneyScreen {
	private FindJourneyScreen parentWindow;
	LogisticCompanyApp logisticCompanyApp;
	private JPanel panelUpdateJourney;
	private JTextField updateField;
	private JourneyInfo journeyinfo;
	private Journey journey;
    private JourneyStatusEntry journeyStatus;
	private String errorMessage;

	public UpdateJourneyScreen(LogisticCompanyApp logisticCompanyApp,
			FindJourneyScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelUpdateJourney = new JPanel();
		parentWindow.addPanel(panelUpdateJourney);
		panelUpdateJourney.setLayout(null);
		panelUpdateJourney.setBorder(BorderFactory.createTitledBorder(
                "Update Journey"));
		
		updateField = new JTextField();
		updateField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		updateField.setBounds(138, 28, 130, 26);
		panelUpdateJourney.add(updateField);
		updateField.setColumns(10);
		
		JButton btnSearch = new JButton("Update");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateJourney();
			}
		});
		btnSearch.setBounds(148, 68, 117, 29);
		panelUpdateJourney.add(btnSearch);
		btnSearch.getRootPane().setDefaultButton(btnSearch);
		
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelUpdateJourney.add(btnBack);
	
	}
	
	protected void updateJourney() {
		journey = logisticCompanyApp.findJourney(journeyinfo);
		journeyStatus = new JourneyStatusEntry(journeyinfo.getOriginPort(),journeyinfo.getDestinationPort(), updateField.getText());
		
		try {
			logisticCompanyApp.updateJourneyInfo(journey, journeyStatus);
			
		} catch (OperationNotAllowedException e) {
			errorMessage = e.getMessage();
		} 
	
	}
	
	public void setVisible(boolean aFlag) {
		panelUpdateJourney.setVisible(aFlag);
		
	}

}
