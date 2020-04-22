package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LogisticCompany.App.LogisticCompanyApp;

public class OtherClientScreen {
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelOtherClient;


	public OtherClientScreen(LogisticCompanyApp logisticCompanyApp, ClientFunctionalitiesScreen parentWindow) {
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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelOtherClient.add(btnBack);
	}
	
	public void setVisible(boolean aFlag) {
		panelOtherClient.setVisible(aFlag);
		
	}
	
}
