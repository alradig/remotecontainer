package LogisticCompany.gui;

import static org.junit.Assert.assertFalse;

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
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Journey;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;

public class FindClientScreen extends Screen {
	private LogisticCompanyApp logisticCompanyApp;
	private Screen parentWindow;
	private JPanel panelFindClient;
	private JTextField searchField;
	private DefaultListModel<ClientInfo> searchResults;
	private JList<ClientInfo> listSearchResult;
	private JLabel lblSearchResultDetail;
	private JButton	btnUnregister;
	private JLabel lblUnregisterClientStatus;

	public FindClientScreen(LogisticCompanyApp logisticCompanyApp, Screen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	private void enableButtons() {
		this.btnUnregister.setEnabled(true);

	}
	private void disableButtons() {
		this.btnUnregister.setEnabled(false);

	}
	@Override
	public void initialize() {
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
				lblUnregisterClientStatus.setText("");
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
		            	lblUnregisterClientStatus.setText("");
		            	lblSearchResultDetail.setText(new ClientPrinter(listSearchResult.getSelectedValue()).printDetail());
		            	enableButtons();
		            	logisticCompanyApp.setSelectedClient(listSearchResult.getSelectedValue());
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
		
		
		lblUnregisterClientStatus = new JLabel("");
		lblUnregisterClientStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnregisterClientStatus.setBounds(40, 450, 350, 29);
		panelFindClient.add(lblUnregisterClientStatus);
		
		btnUnregister = new JButton("Unregister Client");
		btnUnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					unregisterClient();
				} catch (Exception e1) {
					lblUnregisterClientStatus.setText(e1.getMessage());
				}
			}
		});
		btnUnregister.setBounds(215, 500, 170, 29);
		btnUnregister.setEnabled(false);
		panelFindClient.add(btnUnregister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
				disableButtons();
				resetScreen();
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
	@Override
	public void setVisible(boolean aFlag) {
		panelFindClient.setVisible(aFlag);
		
	}
	public void clear() {
		searchField.setText("");
		searchResults.clear();
	}
	public void resetScreen() {
		lblSearchResultDetail.setText("");
		lblSearchResultDetail.setText("");
		searchField.setText("");
		searchResults.clear();
		lblUnregisterClientStatus.setText("");
	}
	protected void unregisterClient() throws Exception {
		ClientInfo cl = logisticCompanyApp.getSelectedClientInfo();
		logisticCompanyApp.unregisterClient(cl);
		searchResults.remove(listSearchResult.getSelectedIndex());
		lblUnregisterClientStatus.setText("Successfully unregistered the client!");
	}
	@Override
	public void addPanel(JPanel panel) {
		parentWindow.addPanel(panel);
	}
}
