package LogisticCompany.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import LogisticCompany.App.LogisticCompanyApp;

public class FindClientScreen {
	LogisticCompanyApp logisticCompanyApp;
	private LogisticCompanyFunctionalitiesScreen parentWindow;
	private JPanel panelFindClient;

	
	
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
	
	public void setVisible(boolean aFlag) {
		panelFindClient.setVisible(aFlag);
		
	}
}
