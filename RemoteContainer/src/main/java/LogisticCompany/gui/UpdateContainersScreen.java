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

public class UpdateContainersScreen {
	private FindJourneyScreen parentWindow;
	LogisticCompanyApp logisticCompanyApp;
	private JPanel panelUpdateContainer;
	private JTextField updateTemperatureField;
	private JTextField updateHumidityField = new JTextField();
	private JTextField updateAtmPressureField;
	private JourneyInfo journeyinfo;
	private Journey journey;
    private JourneyStatusEntry journeyStatus;
	private String errorMessage;
	private JLabel lblTemperature;
	private JLabel lblHumidity;
	private JLabel lblPressure;

	public UpdateContainersScreen(LogisticCompanyApp logisticCompanyApp,
			FindJourneyScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelUpdateContainer = new JPanel();
		parentWindow.addPanel(panelUpdateContainer);
		panelUpdateContainer.setLayout(null);
		panelUpdateContainer.setBorder(BorderFactory.createTitledBorder(
                "Update Container"));
		
		lblTemperature = new JLabel("New temperature:");
		lblTemperature.setBounds(20, 85, 120, 16);
		panelUpdateContainer.add(lblTemperature);
		
		updateTemperatureField = new JTextField();
		updateTemperatureField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		updateTemperatureField.setBounds(138, 80, 130, 26);
		panelUpdateContainer.add(updateTemperatureField);
		updateTemperatureField.setColumns(10);
		
		lblHumidity = new JLabel("New humidity:");
		lblHumidity.setBounds(20, 125, 120, 16);
		panelUpdateContainer.add(lblHumidity);
		
		updateHumidityField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		updateHumidityField.setBounds(138, 120, 130, 26);
		panelUpdateContainer.add(updateHumidityField);
		updateHumidityField.setColumns(10);
		
		lblPressure = new JLabel("New air pressure:");
		lblPressure.setBounds(20, 165, 120, 16);
		panelUpdateContainer.add(lblPressure);
		
		updateAtmPressureField = new JTextField();
		updateAtmPressureField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		updateAtmPressureField.setBounds(138, 160, 130, 26);
		panelUpdateContainer.add(updateAtmPressureField);
		updateAtmPressureField.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateContainer();
				updateTemperatureField.setText("");
				updateHumidityField.setText("");
				updateAtmPressureField.setText("");
			}
		});
		btnUpdate.setBounds(148, 200, 117, 29);
		panelUpdateContainer.add(btnUpdate);
		btnUpdate.getRootPane().setDefaultButton(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelUpdateContainer.add(btnBack);
	
	}
	
	protected void updateContainer() {
		logisticCompanyApp.updateSelectedContainer(updateTemperatureField.getText(),updateHumidityField.getText(), updateAtmPressureField.getText());
	}
	
	public void setVisible(boolean aFlag) {
		panelUpdateContainer.setVisible(aFlag);
		
	}

}
