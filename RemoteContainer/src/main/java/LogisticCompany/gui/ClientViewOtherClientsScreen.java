package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.stream.Collectors;

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

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;

public class ClientViewOtherClientsScreen implements PropertyChangeListener{
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelOtherClient;
	private JTextField searchField;
	private JButton btnUpdateJourney;
	private DefaultListModel<ClientInfo> ClientSearchResults;
	private DefaultListModel<JourneyInfo> JourneySearchResults;
	private JList<ClientInfo> clientListSearchResult;
	private JList<JourneyInfo> journeyListSearchResult;
	private JLabel lblSearchResultDetail;
	
	
	


	public ClientViewOtherClientsScreen(LogisticCompanyApp logisticCompanyApp, ClientFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		
		initialize();
	}
	
	private void initialize() {
		panelOtherClient = new JPanel();
		parentWindow.addPanel(panelOtherClient);
		panelOtherClient.setLayout(null);
		panelOtherClient.setBorder(BorderFactory.createTitledBorder(
                "View Other Clients"));
		
		searchField = new JTextField();
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// here a method needs to be created: ClientAccessList; ClientSteps: "the other client should be able to access the client data"
			}
		});
		searchField.setBounds(138, 28, 130, 26);
		panelOtherClient.add(searchField);
		searchField.setColumns(10);
		
		ClientSearchResults = new DefaultListModel<>();
		clientListSearchResult = new JList<>(ClientSearchResults);
		clientListSearchResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clientListSearchResult.setSelectedIndex(0);
		clientListSearchResult.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				valueChangedClientList(e);
			}
		});
		clientListSearchResult.setVisibleRowCount(5);
        JScrollPane clientListScrollPane = new JScrollPane(clientListSearchResult);
        clientListScrollPane.setBounds(21, 109, 361, 149);
        panelOtherClient.add(clientListScrollPane);
        
		JourneySearchResults = new DefaultListModel<>();
		journeyListSearchResult = new JList<>(JourneySearchResults);
		journeyListSearchResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		journeyListSearchResult.setSelectedIndex(0);
		journeyListSearchResult.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				valueChangedJourneyList(e);
			}
		});
		journeyListSearchResult.setVisibleRowCount(5);
        JScrollPane journeyJistScrollPane = new JScrollPane(journeyListSearchResult);
        journeyJistScrollPane.setBounds(21, 270, 361, 149);
        panelOtherClient.add(journeyJistScrollPane);
        
        JPanel panelSearchResult = new JPanel();
		panelSearchResult.setBounds(21, 431, 361, 175);
		panelOtherClient.add(panelSearchResult);
		panelSearchResult.setBorder(BorderFactory.createTitledBorder("Detail"));
		panelSearchResult.setLayout(null);
        
        lblSearchResultDetail = new JLabel("");
		lblSearchResultDetail.setVerticalAlignment(SwingConstants.TOP);
		lblSearchResultDetail.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearchResultDetail.setBounds(23, 19, 318, 137);
		panelSearchResult.add(lblSearchResultDetail);
        
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				resetScreen();
				parentWindow.setVisible(true);
			}});
		btnBack.setBounds(21, 28, 65, 29);
		panelOtherClient.add(btnBack);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchAccessibleClients();
			}});
		btnSearch.setBounds(148, 68, 117, 29);
		panelOtherClient.add(btnSearch);
		btnSearch.getRootPane().setDefaultButton(btnSearch);
		
		btnUpdateJourney = new JButton("Update journey");
		btnUpdateJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//here something similar needs to be implemented: updateJourneyScreen.setVisible(true);
			}
		});
		btnUpdateJourney.setBounds(20, 450, 180, 29);
		btnUpdateJourney.setEnabled(false);
		panelOtherClient.add(btnUpdateJourney);
		
		
	}
	
	public void setVisible(boolean aFlag) {
		panelOtherClient.setVisible(aFlag);	
	}
	
	public void resetScreen() {
		lblSearchResultDetail.setText("");
		searchField.setText("");
		ClientSearchResults.clear();
		JourneySearchResults.clear();
	}
	/*
	 * Methods to be implemented:
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//here needs to be some specification
	}
	
	public void valueChangedJourneyList(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
        		
	            if (journeyListSearchResult.getSelectedIndex() == -1) {
	            	lblSearchResultDetail.setText("");
	
	            } else {
	            	logisticCompanyApp.setSelectedJourney(journeyListSearchResult.getSelectedValue());
	            	lblSearchResultDetail.setText(new JourneyPrinter(logisticCompanyApp).printDetail());
	            	//lblSearchResultDetail.setText(new JourneyPrinter(listSearchResult.getSelectedValue(),logisticCompanyApp.getSelectedContainerInfo()).printDetail());
	            }

        	
//            if (clientListSearchResult.getSelectedIndex() == -1) {
//            	lblSearchResultDetail.setText("");
//
//            } else {
//            	logisticCompanyApp.setSelectedClient(clientListSearchResult.getSelectedValue());
//            	//lblSearchResultDetail.setText(new JourneyPrinter(listSearchResult.getSelectedValue(),logisticCompanyApp.getSelectedContainerInfo()).printDetail());
//            }
        }}
	
	
	public void valueChangedClientList(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

	            if (clientListSearchResult.getSelectedIndex() == -1) {
	            	lblSearchResultDetail.setText("");
	
	            } else {
	            	logisticCompanyApp.setSelectedClient(clientListSearchResult.getSelectedValue());
	            	logisticCompanyApp.getSelectedClient().getJourneyList().forEach(j -> {
	            		JourneySearchResults.addElement(j.asJourneyInfo());
	            	});
	            }

        }
	}
	
	protected void searchAccessibleClients() {
		ClientSearchResults.clear();
		logisticCompanyApp.getSelectedClient().getAccessList().stream()
		.filter(c -> c.matchClient(searchField.getText()))
		.forEach(c -> {
			ClientSearchResults.addElement(c.asClientInfo());
		});
		
//		journeyRepository.getAllJourneysStream()
//		.filter(j -> j.matchJourney(searchText))
//		.map(j -> j.asJourneyInfo())
//		.collect(Collectors.toList());
	}
	
}
