package LogisticCompany.gui;

import LogisticCompany.App.LogisticCompanyApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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

public class LogisticCompanyFunctionalitiesScreen extends Screen {


	private LogisticCompanyApp logisticCompanyApp;
	private RegisterClientScreen registerClientScreen;
	private FindClientScreen findClientScreen; 
	private FindJourneyScreen findJourneyScreen;
	private Screen parentWindow;
	
	private JButton btnRegisterClient;
	private JButton btnFindJourney; 
	private JButton btnFindClient;
	private JButton btnLogout;
	private JPanel panelLogisticCompanyFunc;
	private JFrame frame;
	private Screen mainScreen;


	public LogisticCompanyFunctionalitiesScreen(LogisticCompanyApp logisticCompanyApp, Screen parentWindow, JFrame frame, Screen mainScreen) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.mainScreen = mainScreen;
		this.frame = frame;
		initialize();
	}
	@Override
	public void initialize() {
		
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
		btnFindJourney = new JButton("Find Journey");
		btnFindJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				findJourneyScreen.setVisible(true);
			}
		});
		btnFindJourney.setBounds(104, 133, 193, 29);
		panelLogisticCompanyFunc.add(btnFindJourney);
		
		btnFindClient = new JButton("Find Client");
		btnFindClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				findClientScreen.setVisible(true);
			}
		});
		btnFindClient.setBounds(104, 173, 193, 29);
		panelLogisticCompanyFunc.add(btnFindClient);
		
		btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainScreen.setVisible(true);
				logisticCompanyApp.logisticCompanyLogout();
			}
		});
		btnLogout.setBounds(21, 28, 80, 29);
		panelLogisticCompanyFunc.add(btnLogout);
		
		
		registerClientScreen = new RegisterClientScreen(logisticCompanyApp, this);
		findClientScreen = new FindClientScreen(logisticCompanyApp, this);
		findJourneyScreen = new FindJourneyScreen(logisticCompanyApp, this);
		
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		panelLogisticCompanyFunc.setVisible(aFlag);
	}
	
	@Override
	public void addPanel(JPanel panel) {
//		frame.getContentPane().add(panel);
		parentWindow.addPanel(panel);
	}
	
	

}
