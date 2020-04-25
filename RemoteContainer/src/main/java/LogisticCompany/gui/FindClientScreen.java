package LogisticCompany.gui;

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

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;

public class FindClientScreen {
	
	LogisticCompanyApp logisticCompanyApp;
	private LogisticCompanyFunctionalitiesScreen parentWindow;
	private JPanel panelFindClient;
	private JTextField searchField;
	private DefaultListModel<ClientInfo> searchResults;
	private JList<ClientInfo> listSearchResult;
	private JLabel lblSearchResultDetail;

	public FindClientScreen(LogisticCompanyApp logisticCompanyApp,
		LogisticCompanyFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelFindClient = new JPanel();
		parentWindow.addPanel(panelFindClient);
		panelFindClient.setLayout(null);
		panelFindClient.setBorder(BorderFactory.createTitledBorder(
                "Find Client"));
		
		searchField = new JTextField();
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchClient();
			}
		});
		searchField.setBounds(138, 28, 130, 26);
		panelFindClient.add(searchField);
		searchField.setColumns(10);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchClient();
			}
		});
		btnSearch.setBounds(148, 68, 117, 29);
		panelFindClient.add(btnSearch);
		btnSearch.getRootPane().setDefaultButton(btnSearch);
		
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
		            	lblSearchResultDetail.setText(new ClientPrinter(listSearchResult.getSelectedValue()).printDetail());
		            }
		        }
			}
		});
		listSearchResult.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(listSearchResult);
        
        listScrollPane.setBounds(21, 109, 361, 149);
        panelFindClient.add(listScrollPane);
        
		
		JPanel panelSearchResult = new JPanel();
		panelSearchResult.setBounds(21, 270, 361, 175);
		panelFindClient.add(panelSearchResult);
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
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelFindClient.add(btnBack);
	
	}
	protected void searchClient() {
		searchResults.clear();
		logisticCompanyApp.searchClient(searchField.getText())
		          .forEach((m) -> {searchResults.addElement(m);});
	}
	
	public void setVisible(boolean aFlag) {
		panelFindClient.setVisible(aFlag);
		
	}
	public void clear() {
		searchField.setText("");
		searchResults.clear();
	}
}
