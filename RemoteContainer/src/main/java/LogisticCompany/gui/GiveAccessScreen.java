package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import LogisticCompany.App.LogisticCompanyApp;

public class GiveAccessScreen {
	LogisticCompanyApp logisticCompanyApp;
	private ClientFunctionalitiesScreen parentWindow;
	private JPanel panelGiveAccess;
	

	public GiveAccessScreen(LogisticCompanyApp logisticCompanyApp, ClientFunctionalitiesScreen parentWindow) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		initialize();
	}
	
	private void initialize() {
		panelGiveAccess = new JPanel();
		parentWindow.addPanel(panelGiveAccess);
		panelGiveAccess.setLayout(null);
		panelGiveAccess.setBorder(BorderFactory.createTitledBorder(
                "Give Access to Other Clients"));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelGiveAccess.add(btnBack);
	}
	
	public void setVisible(boolean aFlag) {
		panelGiveAccess.setVisible(aFlag);
		
	}
	
}
