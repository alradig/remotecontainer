package LogisticCompany.gui;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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

public class ClientFunctionalitiesScreen extends Screen {
	
	private LogisticCompanyApp logisticCompanyApp;
	private Screen registerJourneyScreen;
	private ClientFindJourneyScreen clientFindJourneyScreen;
	private ClientViewOtherClientsScreen clientViewOtherClientsScreen;
	private GiveAccessScreen giveAccessScreen;
	private ChangePasswordScreen changePasswordScreen;
	private Screen updateClientInfoScreen;
	private Screen parentWindow;
	private JButton btnRegisterJourney;
	private JButton btnFindJourney; 
	private JButton btnOtherClients;
	private JButton btnGiveAccess;
	private JButton btnChangePassword;
	private JButton btnLogout;
	private JButton updateClientInfo;
	private JPanel panelClientFunc;
	private Screen mainScreen;


	public ClientFunctionalitiesScreen(LogisticCompanyApp logisticCompanyApp, Screen parentWindow, JFrame frame, Screen mainScreen) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.mainScreen = mainScreen;
		initialize();
	}
	
	public ClientFunctionalitiesScreen(LogisticCompanyApp logisticCompanyApp, Screen parentWindow, Screen mainScreen) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.mainScreen = mainScreen;
		initialize();
	}
	@Override
	public void initialize() {
		
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
		btnRegisterJourney.setBounds(95, 93, 210, 29);
		panelClientFunc.add(btnRegisterJourney);	
		
		

		btnFindJourney = new JButton("Find Existing Journey");
		btnFindJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				clientFindJourneyScreen.setVisible(true);

			}
		});
		btnFindJourney.setBounds(95, 133, 210, 29);
		panelClientFunc.add(btnFindJourney);
		
		btnOtherClients = new JButton("View Other Clients");
		btnOtherClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				clientViewOtherClientsScreen.setVisible(true);
			}
		});
		btnOtherClients.setBounds(95, 173, 210, 29);
		panelClientFunc.add(btnOtherClients);
		
		btnGiveAccess = new JButton("Give Access to Other Clients");
		btnGiveAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				giveAccessScreen.setVisible(true);
			}
		});
		btnGiveAccess.setBounds(95, 213, 210, 29);
		panelClientFunc.add(btnGiveAccess);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				changePasswordScreen.setVisible(true);
			}
		});
		btnChangePassword.setBounds(95, 253, 210, 29);
		panelClientFunc.add(btnChangePassword);
		
		updateClientInfo = new JButton("Update Profile");
		updateClientInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				updateClientInfoScreen.setVisible(true);
			}
		});
		updateClientInfo.setBounds(95, 293, 210, 29);
		panelClientFunc.add(updateClientInfo);
		
		btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainScreen.setVisible(true);
				logisticCompanyApp.clientLogout();
			}
		});
		btnLogout.setBounds(21, 28, 80, 29);
		panelClientFunc.add(btnLogout);
		
		
		
		
		registerJourneyScreen = new RegisterJourneyScreen(logisticCompanyApp, this);
		clientFindJourneyScreen = new ClientFindJourneyScreen(logisticCompanyApp, this);
		clientViewOtherClientsScreen = new ClientViewOtherClientsScreen(logisticCompanyApp, this);
		giveAccessScreen = new GiveAccessScreen(logisticCompanyApp, this);
		changePasswordScreen = new ChangePasswordScreen(logisticCompanyApp, this);
		updateClientInfoScreen = new UpdateClientInfoScreen(logisticCompanyApp, this);
		
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		panelClientFunc.setVisible(aFlag);
		
	}
	
	@Override
	public void addPanel(JPanel panel) {
//		frame.getContentPane().add(panel);
		parentWindow.addPanel(panel);
	}
}
