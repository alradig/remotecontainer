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

public class ClientFunctionalitiesScreen {
	LogisticCompanyApp logisticCompanyApp;
	RegisterJourneyScreen registerJourneyScreen;
	ClientFindJourneyScreen clientFindJourneyScreen;
	OtherClientScreen otherClientScreen;
	GiveAccessScreen giveAccessScreen;
	ChangePasswordScreen changePasswordScreen;	
	private ClientLoginScreen parentWindow;
	
	private JButton btnRegisterJourney;
	private JButton btnFindJourney; 
	private JButton btnOtherClients;
	private JButton btnGiveAccess;
	private JButton btnChangePassword;	
	private JButton btnLogout;
	private JPanel panelClientFunc;
	private JFrame frame;
	MainScreen mainScreen;


	public ClientFunctionalitiesScreen(LogisticCompanyApp logisticCompanyApp, ClientLoginScreen parentWindow, JFrame frame, MainScreen mainScreen) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.mainScreen = mainScreen;
		this.frame = frame;
		initialize();
	}
	
	private void initialize() {
		
		panelClientFunc = new JPanel();
		parentWindow.addPanel(panelClientFunc);
		panelClientFunc.setLayout(null);
		panelClientFunc.setBorder(BorderFactory.createTitledBorder(
                "Client functionalities"));
		
		
		btnRegisterJourney = new JButton("Register Journey");
		btnRegisterJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				registerJourneyScreen.setVisible(true);
			}
		});
		btnRegisterJourney.setBounds(104, 93, 193, 29);
		panelClientFunc.add(btnRegisterJourney);	
		
		

		btnFindJourney = new JButton("Find Existing Journey");
		btnFindJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				clientFindJourneyScreen.setVisible(true);
			}
		});
		btnFindJourney.setBounds(104, 133, 193, 29);
		panelClientFunc.add(btnFindJourney);
		
		btnOtherClients = new JButton("View Other Clients");
		btnOtherClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				otherClientScreen.setVisible(true);
			}
		});
		btnOtherClients.setBounds(104, 173, 193, 29);
		panelClientFunc.add(btnOtherClients);
		
		btnGiveAccess = new JButton("Give Access to Other Clients");
		btnGiveAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				giveAccessScreen.setVisible(true);
			}
		});
		btnGiveAccess.setBounds(104, 213, 193, 29);
		panelClientFunc.add(btnGiveAccess);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				changePasswordScreen.setVisible(true);
			}
		});
		btnChangePassword.setBounds(104, 253, 193, 29);
		panelClientFunc.add(btnChangePassword);
		
		btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainScreen.setVisible(true);
				// logout from app. 
			}
		});
		btnLogout.setBounds(21, 28, 65, 29);
		panelClientFunc.add(btnLogout);
		
		
		registerJourneyScreen = new RegisterJourneyScreen(logisticCompanyApp, this);
		clientFindJourneyScreen = new ClientFindJourneyScreen(logisticCompanyApp, this);
		otherClientScreen = new OtherClientScreen(logisticCompanyApp, this);
		giveAccessScreen = new GiveAccessScreen(logisticCompanyApp, this);
		changePasswordScreen = new ChangePasswordScreen(logisticCompanyApp, this);
		
	}
	
	public void setVisible(boolean aFlag) {
		panelClientFunc.setVisible(aFlag);
		
	}
	public void addPanel(JPanel panel) {
		frame.getContentPane().add(panel);
	}
	

}
