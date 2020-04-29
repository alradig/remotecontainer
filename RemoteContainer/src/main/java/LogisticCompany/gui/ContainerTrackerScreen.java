package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import LogisticCompany.App.LogisticCompanyApp;

public class ContainerTrackerScreen  implements PropertyChangeListener {
	
	LogisticCompanyApp logisticCompanyApp;
	private ClientFindJourneyScreen parentWindow;
	private JPanel panelContainerTracker;
	private JPanel panelPressure;
	private JLabel lblSearchResultDetail;

	public ContainerTrackerScreen(LogisticCompanyApp logisticCompanyApp, ClientFindJourneyScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		
		initialize();
	}
	
	private void initialize() {
		panelContainerTracker = new JPanel();
		parentWindow.addPanel(panelContainerTracker);
		panelContainerTracker.setLayout(null);
		panelContainerTracker.setBorder(BorderFactory.createTitledBorder(
                "Find Existing Journey"));
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnShow.setBounds(148, 58, 107, 29);
		panelContainerTracker.add(btnShow);
		btnShow.getRootPane().setDefaultButton(btnShow);
	
		JPanel panelTemperature = new JPanel();
		panelTemperature.setBounds(25, 100, 100, 400);
		panelContainerTracker.add(panelTemperature);
		panelTemperature.setBorder(BorderFactory.createTitledBorder(
                "Temperature"));
		panelTemperature.setLayout(null);	
	
		JPanel panelHumid = new JPanel();
		panelHumid.setBounds(150, 100, 100, 400);
		panelContainerTracker.add(panelHumid);
		panelHumid.setBorder(BorderFactory.createTitledBorder(
                "Humidity"));
		panelHumid.setLayout(null);	
		
		panelPressure = new JPanel();
		panelPressure.setBounds(275, 100, 100, 400);
		panelContainerTracker.add(panelPressure);
		panelPressure.setBorder(BorderFactory.createTitledBorder(
                "Air pressure"));
		panelPressure.setLayout(null);
		

		lblSearchResultDetail = new JLabel("");
		lblSearchResultDetail.setVerticalAlignment(SwingConstants.TOP);
		lblSearchResultDetail.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearchResultDetail.setBounds(23, 19, 100, 137);
		panelPressure.add(lblSearchResultDetail);
		
		lblSearchResultDetail.setText(new ContainerPrinter(logisticCompanyApp).printSl());

			
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			parentWindow.setVisible(true);
		}
	});
	btnBack.setBounds(21, 28, 65, 29);
	panelContainerTracker.add(btnBack);
	
	}
	
	public void setVisible(boolean aFlag) {
		panelContainerTracker.setVisible(aFlag);
		
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}
	
	
	
}
