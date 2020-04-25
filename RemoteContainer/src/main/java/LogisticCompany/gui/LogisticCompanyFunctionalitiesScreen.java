package LogisticCompany.gui;

import LogisticCompany.App.LogisticCompanyApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
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
	RegisterContainerScreen registerContainerScreen;
	FindClientScreen findClientScreen; 
	FindJourneyScreen findJourneyScreen;
	private LogisticCompanyLoginScreen parentWindow;
	
	private JButton btnRegisterClient;
	private JButton btnContainerForJourney;
	private JButton btnFindJourney; 
	private JButton btnFindClient;
	private JButton btnLogout;
	private JPanel panelLogisticCompanyFunc;
	private JFrame frame;
	MainScreen mainScreen;


	public LogisticCompanyFunctionalitiesScreen(LogisticCompanyApp logisticCompanyApp, LogisticCompanyLoginScreen parentWindow, JFrame frame, MainScreen mainScreen) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.mainScreen = mainScreen;
		this.frame = frame;
		initialize();
	}
	private void initialize() {
		
		panelLogisticCompanyFunc = new JPanel();
		parentWindow.addPanel(panelLogisticCompanyFunc);
		panelLogisticCompanyFunc.setLayout(null);
		panelLogisticCompanyFunc.setBorder(BorderFactory.createTitledBorder(
                "Logistic Company functionalities"));
		
		
		btnRegisterClient = new JButton("Register Client");
		btnRegisterClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				registerClientScreen.setVisible(true);
			}
		});
		btnRegisterClient.setBounds(104, 93, 193, 29);
		panelLogisticCompanyFunc.add(btnRegisterClient);	
		
		

		btnContainerForJourney = new JButton("Register Container for Journey");
		btnContainerForJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				registerContainerScreen.setVisible(true);
			}
		});
		btnContainerForJourney.setBounds(104, 133, 193, 29);
		panelLogisticCompanyFunc.add(btnContainerForJourney);
		
		btnFindJourney = new JButton("Find Journey");
		btnFindJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				findJourneyScreen.setVisible(true);
			}
		});
		btnFindJourney.setBounds(104, 173, 193, 29);
		panelLogisticCompanyFunc.add(btnFindJourney);
		
		btnFindClient = new JButton("Find Client");
		btnFindClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				findClientScreen.setVisible(true);
			}
		});
		btnFindClient.setBounds(104, 213, 193, 29);
		panelLogisticCompanyFunc.add(btnFindClient);
		
		btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainScreen.setVisible(true);
				// logout from LogisticCompanyApp !!!!!!!!
			}
		});
		btnLogout.setBounds(21, 28, 80, 40);
		panelLogisticCompanyFunc.add(btnLogout);
		
		
		registerClientScreen = new RegisterClientScreen(logisticCompanyApp, this);
		registerContainerScreen = new RegisterContainerScreen(logisticCompanyApp, this);
		findClientScreen = new FindClientScreen(logisticCompanyApp, this);
		findJourneyScreen = new FindJourneyScreen(logisticCompanyApp, this, frame);
		
	}
	
	public void setVisible(boolean aFlag) {
		panelLogisticCompanyFunc.setVisible(aFlag);
		
	}
	public void addPanel(JPanel panel) {
		frame.getContentPane().add(panel);
	}
	


}
