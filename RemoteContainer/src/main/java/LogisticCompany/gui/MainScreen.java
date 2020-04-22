package LogisticCompany.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import LogisticCompany.App.LogisticCompanyApp;



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
//		SqliteRepository repository = new SqliteRepository(true);
//		logisticCompanyApp = new LibraryApp(repository,repository);
		// createExampleData();
		initialize();
	}

//	private void createExampleData() throws Exception {
//		libraryApp.adminLogin("adminadmin");
//		UserInfo user = new UserInfo("050149-2833","Tom P. Davis","TomPDavis@rhyta.com");
//		Address address = new Address("Oakmound Drive",60062,"Northbrook");
//		user.setAddress(address);
//		libraryApp.registerUser(user);
//		BookInfo book = new BookInfo("Extreme Programming Explained", "Kent Beck","Beck99");
//		libraryApp.addMedium(book);
//		CdInfo cd = new CdInfo("A Fish Named Wanda","John Cleese","Cleese88");
//		libraryApp.addMedium(cd);
//		
//		libraryApp.borrowMedium(book, user);
//		libraryApp.borrowMedium(cd, user);
//		
//		libraryApp.adminLogout();		
//	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Remote Container Tracking");
		frame.setBounds(100, 100, 404, 486);
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
		
		clientLoginScreen = new ClientLoginScreen(logisticCompanyApp, this);
		logisticCompanyLoginScreen = new LogisticCompanyLoginScreen(logisticCompanyApp, this);
		
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
