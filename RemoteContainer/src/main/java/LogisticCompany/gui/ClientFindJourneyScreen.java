package LogisticCompany.gui;

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

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.info.JourneyInfo;

public class ClientFindJourneyScreen {
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelClientFindJourney;
	private DefaultListModel<JourneyInfo> searchResults;
	private JList<JourneyInfo> listSearchResult;
	private JTextField searchField;
	private JLabel lblSearchResultDetail;
	
	public ClientFindJourneyScreen(LogisticCompanyApp logisticCompanyApp, ClientFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelClientFindJourney = new JPanel();
		parentWindow.addPanel(panelClientFindJourney);
		panelClientFindJourney.setLayout(null);
		panelClientFindJourney.setBorder(BorderFactory.createTitledBorder(
                "Find Existing Journey"));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelClientFindJourney.add(btnBack);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchJourney();
			}
		});
		btnSearch.setBounds(148, 68, 117, 29);
		panelClientFindJourney.add(btnSearch);
		btnSearch.getRootPane().setDefaultButton(btnSearch);
		
		searchField = new JTextField();
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchJourney();
			}
		});
		searchField.setBounds(138, 28, 130, 26);
		panelClientFindJourney.add(searchField);
		searchField.setColumns(10);
		
		
		searchResults = new DefaultListModel<>();
		listSearchResult = new JList<>(searchResults);
		listSearchResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSearchResult.setSelectedIndex(0);
		listSearchResult.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
		        if (e.getValueIsAdjusting() == false) {

		            if (listSearchResult.getSelectedIndex() == -1) {
		            	lblSearchResultDetail.setText("");

		            } else {
		            	lblSearchResultDetail.setText(new JourneyPrinter(listSearchResult.getSelectedValue()).printDetail());
		            }
		        }
			}
		});
		listSearchResult.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(listSearchResult);
        
        lblSearchResultDetail = new JLabel("");
		lblSearchResultDetail.setVerticalAlignment(SwingConstants.TOP);
		lblSearchResultDetail.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearchResultDetail.setBounds(23, 19, 318, 137);
		panelClientFindJourney.add(lblSearchResultDetail);
	}
	
	protected void searchJourney() {
		searchResults.clear();
		logisticCompanyApp.searchJourney(searchField.getText())
		          .forEach((m) -> {searchResults.addElement(m);});
	}
	
	public void setVisible(boolean aFlag) {
		panelClientFindJourney.setVisible(aFlag);
		
	}
	public void clear() {
		searchField.setText("");
		searchResults.clear();
	}
	
}
