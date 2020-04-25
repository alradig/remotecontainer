package LogisticCompany.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Address;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;
import LogisticCompany.persistence.SQLRepository;

public class MainScreen {
	
	LogisticCompanyApp logisticCompanyApp;
	ClientLoginScreen clientLoginScreen;
	LogisticCompanyLoginScreen logisticCompanyLoginScreen;

	private JFrame frame;
	private JPanel panelMenu;
	private JButton btnClientLogin;
	private JButton btnLogisticCompanyLogin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen screen = new MainScreen();
					screen.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public MainScreen() throws Exception {
		SQLRepository repository = new SQLRepository(false);
		logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);
		logisticCompanyApp.clearDatabase();
		
		
		try {
			createExampleData();
		} catch (OperationNotAllowedException e) {
			
		}
		
		initialize();
	}

	private void createExampleData() throws Exception {
		
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		
		ClientInfo client1 = new ClientInfo("Expresso","expresso@exp.com","Nach Jicholson");
		Address address = new Address("The street 3","1700","Aarhus");
		client1.setAddress(address);
		
		ClientInfo client2 = new ClientInfo("Wurth","wurth@wrt.com","Mika McNuggets");
		Address address2 = new Address("The german strasse 5","27645","Berlin");
		client2.setAddress(address2);
		
		ClientInfo client3 = new ClientInfo("Embraer","embraer@emb.com","Bhristian Cale");
		Address address3 = new Address("The brasilian rua 34","27645","Rio de Janeiro");
		client3.setAddress(address3);
		
		logisticCompanyApp.registerClient(client1, "client");
		logisticCompanyApp.registerClient(client2, "client");
		logisticCompanyApp.registerClient(client3, "client");
		
		
		
		JourneyInfo journey1 = new JourneyInfo("Bananas","Copenhagen","Moscow");
		JourneyInfo journey2 = new JourneyInfo("Chairs","London","Sydney");
		JourneyInfo journey3 = new JourneyInfo("Tables","Johannesburg","Beijing");
		JourneyInfo journey4 = new JourneyInfo("Paper","New York","Hanoi");
		JourneyInfo journey5 = new JourneyInfo("Computers","Rio de Janeiro","Madrid");
		JourneyInfo journey6 = new JourneyInfo("Apples","Nuuk","Mexico City");
		
		logisticCompanyApp.registerJourney(journey1);
		logisticCompanyApp.registerJourney(journey2);
		logisticCompanyApp.registerJourney(journey3);
		logisticCompanyApp.registerJourney(journey4);
		logisticCompanyApp.registerJourney(journey5);
		logisticCompanyApp.registerJourney(journey6);
		
		logisticCompanyApp.registerJourneyToClient(client1, journey1);
		logisticCompanyApp.registerJourneyToClient(client1, journey2);
		logisticCompanyApp.registerJourneyToClient(client2, journey3);
		logisticCompanyApp.registerJourneyToClient(client2, journey4);
		logisticCompanyApp.registerJourneyToClient(client3, journey5);
		logisticCompanyApp.registerJourneyToClient(client3, journey6);
		
//		logisticCompanyApp.registerContainer(new ContainerInfo(""));
//		logisticCompanyApp.registerContainerToJourney(new ContainerInfo(""), journey1);
		
		List<JourneyInfo> journeysList = Arrays.asList(journey1,journey2,journey3,journey4,journey5,journey6);
		for (int i=0 ; i<6 ; i++) {
			ContainerInfo container = new ContainerInfo("");
			logisticCompanyApp.registerContainer(container);
			logisticCompanyApp.registerContainerToJourney(container, journeysList.get(i));
		}
		
		logisticCompanyApp.logisticCompanyLogout();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Remote Container Tracking");
		frame.setBounds(100, 100, 404, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, "name_160236068959176");
		panelMenu.setLayout(null);
		panelMenu.setBorder(BorderFactory.createTitledBorder(
                "Login Page"));
		
		btnClientLogin = new JButton("Client login");
		btnClientLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				clientLoginScreen.setVisible(true);	
			}
		});
		btnClientLogin.setBounds(104, 52, 193, 29);
		panelMenu.add(btnClientLogin);
		
		btnLogisticCompanyLogin = new JButton("Logistic Company login");
		btnLogisticCompanyLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				logisticCompanyLoginScreen.setVisible(true);
			}
		});
		btnLogisticCompanyLogin.setBounds(104, 93, 193, 29);
		panelMenu.add(btnLogisticCompanyLogin);	
		
		clientLoginScreen = new ClientLoginScreen(logisticCompanyApp, this, frame);

		logisticCompanyLoginScreen = new LogisticCompanyLoginScreen(logisticCompanyApp, this, frame);
		
	}
	
	public void setVisible(boolean aFlag) {
		panelMenu.setVisible(aFlag);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void addPanel(JPanel panel) {
		frame.getContentPane().add(panel);
	}


}
