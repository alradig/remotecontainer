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
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Journey;
import LogisticCompany.domain.JourneyStatusEntry;
import LogisticCompany.info.JourneyInfo;

public class FindJourneyScreen extends Screen implements ListSelectionListener, PropertyChangeListener {
	
	private LogisticCompanyApp logisticCompanyApp;
	private UpdateJourneyScreen updateJourneyScreen;
	private UpdateContainersScreen updateContainersScreen;
	private ContainerTrackerScreen containerTrackerScreen; 
	private Screen parentWindow;
	private JPanel panelFindJourney;
	private DefaultListModel<JourneyInfo> searchResults;
	private JList<JourneyInfo> listSearchResult;
	private JTextField searchField;
	private JLabel lblSearchResultDetail;
	private JourneyInfo selectedjourneyInfo;
    private JourneyStatusEntry journeyStatus;
	private String errorMessage;
	private JTextField updateField;
	private JButton btnUpdate;
	private JButton btnViewContainer;
	private JButton btnUpdateJourney;
	private JButton btnContainerHistory;

	public FindJourneyScreen(LogisticCompanyApp logisticCompanyApp, Screen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.updateContainersScreen = new UpdateContainersScreen(logisticCompanyApp, this);
		this.updateJourneyScreen = new UpdateJourneyScreen(logisticCompanyApp, this);
		this.containerTrackerScreen = new ContainerTrackerScreen(logisticCompanyApp, this);
		logisticCompanyApp.addObserver(this);
		initialize();
	}
	
	private void enableButtons() {
		this.btnViewContainer.setEnabled(true);
		this.btnUpdateJourney.setEnabled(true);
		this.btnContainerHistory.setEnabled(true);

	}
	private void disableButtons() {
		this.btnViewContainer.setEnabled(false);
		this.btnUpdateJourney.setEnabled(false);
		this.btnContainerHistory.setEnabled(false);
	}
	
	private void initialize() {

		panelFindJourney = new JPanel();
		parentWindow.addPanel(panelFindJourney);
		panelFindJourney.setLayout(null);
		panelFindJourney.setBorder(BorderFactory.createTitledBorder(
                "Find Existing Journey"));
		
		searchField = new JTextField();
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchJourney();
			}
		});
		searchField.setBounds(138, 28, 130, 26);
		panelFindJourney.add(searchField);
		searchField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchJourney();
				disableButtons();
			}
		});
		btnSearch.setBounds(148, 68, 117, 29);
		panelFindJourney.add(btnSearch);
		btnSearch.getRootPane().setDefaultButton(btnSearch);
		
		searchResults = new DefaultListModel<>();
		listSearchResult = new JList<>(searchResults);
		listSearchResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSearchResult.setSelectedIndex(0);
		

		listSearchResult.addListSelectionListener(this);
		listSearchResult.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(listSearchResult);
        

        listScrollPane.setBounds(21, 109, 361, 149);
        panelFindJourney.add(listScrollPane);
		
		JPanel panelSearchResult = new JPanel();
		panelSearchResult.setBounds(21, 270, 361, 175);
		panelFindJourney.add(panelSearchResult);
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
				resetScreen();
				parentWindow.setVisible(true);
				disableButtons();
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelFindJourney.add(btnBack);
		
		
		btnUpdateJourney = new JButton("Update journey");
		btnUpdateJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				updateJourneyScreen.setVisible(true);
				disableButtons();
			}
		});
		
		btnUpdateJourney.setBounds(20, 450, 180, 29);
		btnUpdateJourney.setEnabled(false);
		panelFindJourney.add(btnUpdateJourney);
		

		btnViewContainer = new JButton("Update container");
		btnViewContainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				updateContainersScreen.setVisible(true);
				disableButtons();
			}
		});
		
		btnViewContainer.setBounds(203, 450, 180, 29);
		btnViewContainer.setEnabled(false);
		panelFindJourney.add(btnViewContainer);
		
		btnContainerHistory = new JButton("Container History");
		btnContainerHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				containerTrackerScreen.setVisible(true);
			}
		});
		btnContainerHistory.setBounds(203, 487, 180, 29);
		btnContainerHistory.setEnabled(false);
		panelFindJourney.add(btnContainerHistory);
	
//		containerTrackerScreen = new ContainerTrackerScreen(logisticCompanyApp, this);
	}

	protected void searchJourney() {
		searchResults.clear();
		logisticCompanyApp.searchJourney(searchField.getText())
		          .forEach((m) -> {searchResults.addElement(m);});
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		panelFindJourney.setVisible(aFlag);
		
	}
	public void clear() {
		searchField.setText("");
		searchResults.clear();
	}
	
	@Override
	public void addPanel(JPanel panel) {
//		frame.getContentPane().add(panel);
		parentWindow.addPanel(panel);
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
		if(evt.getPropertyName().contentEquals("UpdatedContainer")){
			lblSearchResultDetail.setText("");
		}
		if(evt.getPropertyName().contentEquals("UpdatedJourney")){
			lblSearchResultDetail.setText("");
		}
		enableButtons();
	}
	
	public void resetScreen() {
		lblSearchResultDetail.setText("");
		lblSearchResultDetail.setText("");
		searchField.setText("");
		searchResults.clear();
	}

}
