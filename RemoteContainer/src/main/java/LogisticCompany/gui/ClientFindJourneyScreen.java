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
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Journey;
import LogisticCompany.info.JourneyInfo;


public class ClientFindJourneyScreen implements ListSelectionListener, PropertyChangeListener  {
	
	LogisticCompanyApp logisticCompanyApp;
	Client client;
	private ClientFunctionalitiesScreen parentWindow;
	private ContainerTrackerScreen containerTrackerScreen;
	private JPanel panelClientFindJourney;
	private DefaultListModel<JourneyInfo> searchResults;
	private JList<JourneyInfo> listSearchResult;
	private JTextField searchField;
	private JLabel lblSearchResultDetail;
	private JFrame frame;
	private JButton btnTracking;
	
	public ClientFindJourneyScreen(LogisticCompanyApp logisticCompanyApp, ClientFunctionalitiesScreen parentWindow, JFrame frame) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.frame = frame;
		
		initialize();
	}
	
	private void enableButtons() {
		this.btnTracking.setEnabled(true);

	}
	private void disableButtons() {
		this.btnTracking.setEnabled(false);
	}
	
	private void initialize() {
		panelClientFindJourney = new JPanel();
		parentWindow.addPanel(panelClientFindJourney);
		panelClientFindJourney.setLayout(null);
		panelClientFindJourney.setBorder(BorderFactory.createTitledBorder(
                "Find Existing Journey"));
		
		searchField = new JTextField();
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchJourney();
			}
		});
		searchField.setBounds(138, 28, 130, 26);
		panelClientFindJourney.add(searchField);
		searchField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchJourney();	
				disableButtons();
			}
		});
		btnSearch.setBounds(148, 68, 117, 29);
		panelClientFindJourney.add(btnSearch);
		btnSearch.getRootPane().setDefaultButton(btnSearch);
		
		searchResults = new DefaultListModel<>();
		listSearchResult = new JList<>(searchResults);
		listSearchResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSearchResult.setSelectedIndex(0);
		
		listSearchResult.addListSelectionListener(this);
		listSearchResult.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(listSearchResult);
        

        listScrollPane.setBounds(21, 109, 361, 149);
        panelClientFindJourney.add(listScrollPane);
		
		JPanel panelSearchResult = new JPanel();
		panelSearchResult.setBounds(21, 270, 361, 175);
		panelClientFindJourney.add(panelSearchResult);
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
				clear();
				setVisible(false);
				parentWindow.setVisible(true);
				disableButtons();
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelClientFindJourney.add(btnBack);
		
		btnTracking = new JButton("Container History");
		btnTracking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				containerTrackerScreen.setVisible(true);
			}
		});
		btnTracking.setBounds(120, 480, 157, 29);
		btnTracking.setEnabled(false);
		panelClientFindJourney.add(btnTracking);
	
		containerTrackerScreen = new ContainerTrackerScreen(logisticCompanyApp, this);
	}
	
	protected void searchJourney() {		
		
		searchResults.clear();		
		logisticCompanyApp.getSelectedClient().getJourneyList().stream().filter(j -> j.matchJourney(searchField.getText()))
		.map(j -> j.asJourneyInfo())
		.forEach((m) -> {searchResults.addElement(m);});

	}
	
	public void setVisible(boolean aFlag) {
		panelClientFindJourney.setVisible(aFlag);	
	}
	
	public void clear() {
		searchField.setText("");
		searchResults.clear();
	}
	
	public void addPanel(JPanel panel) {
		frame.getContentPane().add(panel);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (listSearchResult.getSelectedIndex() == -1) {
            	lblSearchResultDetail.setText("");

            } else {
            	logisticCompanyApp.setSelectedObjects(listSearchResult.getSelectedValue());
            	lblSearchResultDetail.setText(new JourneyPrinter(logisticCompanyApp).printDetail());
            	enableButtons();
            }
        }
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
//		if(evt.getPropertyName().contentEquals("UpdatedContainer")){
//			lblSearchResultDetail.setText("");
//		}
//		enableButtons();
	}
	
}
