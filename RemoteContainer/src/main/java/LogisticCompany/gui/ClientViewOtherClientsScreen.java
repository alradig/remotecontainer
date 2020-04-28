package LogisticCompany.gui;

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

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;

public class ClientViewOtherClientsScreen implements ListSelectionListener, PropertyChangeListener{
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelOtherClient;
	private JTextField searchField;
	private JButton btnUpdateJourney;
	private DefaultListModel<ClientInfo> searchResults;
	private JList<ClientInfo> listSearchResult;
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
		
		
		searchResults = new DefaultListModel<>();
		listSearchResult = new JList<>(searchResults);
		listSearchResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSearchResult.setSelectedIndex(0);
		listSearchResult.addListSelectionListener(this);
		listSearchResult.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(listSearchResult);
        listScrollPane.setBounds(21, 109, 361, 149);
        panelOtherClient.add(listScrollPane);
        
        JPanel panelSearchResult = new JPanel();
		panelSearchResult.setBounds(21, 270, 361, 175);
		panelOtherClient.add(panelSearchResult);
		panelSearchResult.setBorder(BorderFactory.createTitledBorder(
                "Detail"));
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
		lblSearchResultDetail.setText("");
		searchField.setText("");
		searchResults.clear();
	}
	/*
	 * Methods to be implemented:
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//here needs to be some specification
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (listSearchResult.getSelectedIndex() == -1) {
            	lblSearchResultDetail.setText("");

            } else {
            	logisticCompanyApp.setSelectedClient(listSearchResult.getSelectedValue());
            	//lblSearchResultDetail.setText(new JourneyPrinter(listSearchResult.getSelectedValue(),logisticCompanyApp.getSelectedContainerInfo()).printDetail());
            }
        }
        //this.selectedClientInfo = listSearchResult.getSelectedValue();
	}
	
	protected void searchAccessibleClients() {
		searchResults.clear();
		logisticCompanyApp.getSelectedClient().getAccessList().forEach(c -> {
			searchResults.addElement(c.asClientInfo());
		});
		
		
	
		//logisticCompanyApp.searchJourney(searchField.getText())
		         // .forEach((m) -> {searchResults.addElement(m);});
	}
	
}
