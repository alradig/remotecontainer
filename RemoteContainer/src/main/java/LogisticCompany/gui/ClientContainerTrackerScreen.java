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

public class ClientContainerTrackerScreen extends Screen implements PropertyChangeListener {
	
	LogisticCompanyApp logisticCompanyApp;
	private Screen parentWindow;
	private JPanel panelContainerTracker;
	private JPanel panelPressure;
	private JLabel lblPressure;
	private JLabel lblTemp;
	private JLabel lblHum;

	public ClientContainerTrackerScreen(LogisticCompanyApp logisticCompanyApp, Screen parentWindow) {
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
				lblTemp.setText(new ContainerPrinter(logisticCompanyApp).printTemperatureDetail());
				lblPressure.setText(new ContainerPrinter(logisticCompanyApp).printPressureDetail() );
				lblHum.setText(new ContainerPrinter(logisticCompanyApp).printAirHumDetail());
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
		
		lblTemp = new JLabel("");
		lblTemp.setVerticalAlignment(SwingConstants.TOP);
		lblTemp.setHorizontalAlignment(SwingConstants.LEFT);
		lblTemp.setBounds(5, 19, 100, 137);
		panelTemperature.add(lblTemp);
	
		JPanel panelHumid = new JPanel();
		panelHumid.setBounds(150, 100, 100, 400);
		panelContainerTracker.add(panelHumid);
		panelHumid.setBorder(BorderFactory.createTitledBorder(
                "Humidity"));
		panelHumid.setLayout(null);	
		
		lblHum = new JLabel("");
		lblHum.setVerticalAlignment(SwingConstants.TOP);
		lblHum.setHorizontalAlignment(SwingConstants.LEFT);
		lblHum.setBounds(5, 19, 100, 137);
		panelHumid.add(lblHum);
		
		panelPressure = new JPanel();
		panelPressure.setBounds(275, 100, 100, 400);
		panelContainerTracker.add(panelPressure);
		panelPressure.setBorder(BorderFactory.createTitledBorder(
                "Air pressure"));
		panelPressure.setLayout(null);
		

		lblPressure = new JLabel("");
		lblPressure.setVerticalAlignment(SwingConstants.TOP);
		lblPressure.setHorizontalAlignment(SwingConstants.LEFT);
		lblPressure.setBounds(5, 19, 100, 137);
		panelPressure.add(lblPressure);

			
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			parentWindow.setVisible(true);
			lblTemp.setText("");
			lblPressure.setText("" );
			lblHum.setText("");
			
		}
	});
	btnBack.setBounds(21, 28, 65, 29);
	panelContainerTracker.add(btnBack);
	
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		panelContainerTracker.setVisible(aFlag);
		
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}

	@Override
	public void addPanel(JPanel panel) {
		parentWindow.addPanel(panel);
	}
	
}
