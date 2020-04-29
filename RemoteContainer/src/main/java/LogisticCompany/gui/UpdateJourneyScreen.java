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
	LogisticCompanyApp LogisticCompanyApp ;
	private JPanel panelUpdateJourney;
	private JTextField updateField;
	private JourneyInfo journeyinfo;
    private JourneyStatusEntry journeyStatus;
	private String errorMessage;
	private JLabel lblUpdateStatus;

	public UpdateJourneyScreen(LogisticCompanyApp logisticCompanyApp, FindJourneyScreen parentWindow ) {
		this.LogisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelUpdateJourney = new JPanel();
		parentWindow.addPanel(panelUpdateJourney);
		panelUpdateJourney.setLayout(null);
		panelUpdateJourney.setBorder(BorderFactory.createTitledBorder(
                "Update Journey"));
		
		JLabel lblComment = new JLabel("<html>Please enter the current location of the container</html>");
		lblComment.setBounds(50, 80, 370, 50);
		panelUpdateJourney.add(lblComment);
		
		updateField = new JTextField();
		updateField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		updateField.setBounds(138, 130, 130, 26);
		panelUpdateJourney.add(updateField);
		updateField.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateJourney();
				updateField.setText("");

			}
		});
		btnUpdate.setBounds(145, 200, 117, 29);
		panelUpdateJourney.add(btnUpdate);
		btnUpdate.getRootPane().setDefaultButton(btnUpdate);

		lblUpdateStatus = new JLabel("");
		lblUpdateStatus.setBounds(53, 65, 300, 16);
		lblUpdateStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panelUpdateJourney.add(lblUpdateStatus);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
				lblUpdateStatus.setText("");
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelUpdateJourney.add(btnBack);
	
	}
	
	protected void updateJourney() {	
		try {
			LogisticCompanyApp.updateSelectedJourney(updateField.getText());
			lblUpdateStatus.setText("Journey is successfully updated!");
		} catch (OperationNotAllowedException e) {
			errorMessage = e.getMessage();
		} 
	}
	
	public void setVisible(boolean aFlag) {
		panelUpdateJourney.setVisible(aFlag);
		
	}

}
