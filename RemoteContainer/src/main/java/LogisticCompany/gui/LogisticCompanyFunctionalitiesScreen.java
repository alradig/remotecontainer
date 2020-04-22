package LogisticCompany.gui;

import LogisticCompany.App.LogisticCompanyApp;

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

public class LogisticCompanyFunctionalitiesScreen {
	LogisticCompanyApp logisticCompanyApp;
	RegisterClientScreen registerClientScreen;
	private LogisticCompanyLoginScreen parentWindow;
	
	private JButton btnRegisterClient;
	private JButton btnContainerForJourney;
	private JButton btnFindJourney; 
	private JButton btnFindClient;
	private JButton btnLogout;
	private JPanel panelLogisticCompanyFunc;
	


	public LogisticCompanyFunctionalitiesScreen(LogisticCompanyApp logisticCompanyApp, LogisticCompanyLoginScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	private void initialize() {
		
		panelLogisticCompanyFunc = new JPanel();
		parentWindow.addPanel(panelLogisticCompanyFunc);
		panelLogisticCompanyFunc.setLayout(null);
		panelLogisticCompanyFunc.setBorder(BorderFactory.createTitledBorder(
                "Logistic Company functionalities"));
		
		
		btnRegisterClient = new JButton("Register Client");
//		btnRegisterClient.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
////				setVisible(false);
////				registerClientScreen.setVisible(true);
//			}
//		});
		btnRegisterClient.setBounds(104, 93, 193, 29);
		panelLogisticCompanyFunc.add(btnRegisterClient);	
		
		registerClientScreen = new RegisterClientScreen(logisticCompanyApp, this);
	
		
		
	}
	
	public void setVisible(boolean aFlag) {
		panelLogisticCompanyFunc.setVisible(aFlag);
		
	}
	


}
