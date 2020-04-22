package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LogisticCompany.App.LogisticCompanyApp;

public class RegisterJourneyScreen {
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelRegisterJourney;
	
	private JTextField cargoField;
	private JLabel lblCargo;
	private JTextField startDestinationField;
	private JLabel lblStartDestinationField;
	private JTextField endDestinationField;
	private JLabel lblEndestinationField;

	
	public RegisterJourneyScreen(LogisticCompanyApp logisticCompanyApp, ClientFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	private void initialize() {
		panelRegisterJourney = new JPanel();
		parentWindow.addPanel(panelRegisterJourney);
		panelRegisterJourney.setLayout(null);
		panelRegisterJourney.setBorder(BorderFactory.createTitledBorder(
                "Register Journey"));
		
		cargoField = new JTextField();
		cargoField.setBounds(138, 100, 130, 26);
		panelRegisterJourney.add(cargoField);
		cargoField.setColumns(10);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(50, 105, 74, 16);
		panelRegisterJourney.add(lblCargo);
		
		startDestinationField = new JTextField();
		startDestinationField.setBounds(138, 140, 130, 26);
		panelRegisterJourney.add(startDestinationField);
		startDestinationField.setColumns(10);
		
		lblStartDestinationField = new JLabel("Start destination:");
		lblStartDestinationField.setBounds(50, 145, 74, 16);
		panelRegisterJourney.add(lblStartDestinationField);
		
		endDestinationField = new JTextField();
		endDestinationField.setBounds(138, 180, 130, 26);
		panelRegisterJourney.add(endDestinationField);
		endDestinationField.setColumns(10);
		
		lblEndestinationField = new JLabel("End destination:");
		lblEndestinationField.setBounds(50, 185, 74, 16);
		panelRegisterJourney.add(lblEndestinationField);
		
		
		JButton btnregister = new JButton("Register");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// register and go back 
				parentWindow.setVisible(true);
			}
		});
		btnregister.setBounds(170, 225, 74, 16);
		panelRegisterJourney.add(btnregister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelRegisterJourney.add(btnBack);

	}
	
	public void setVisible(boolean aFlag) {
		panelRegisterJourney.setVisible(aFlag);
		
	}
	
}
