import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UIMain extends JFrame implements ActionListener{
	
	JButton newCustomer;
	JButton manageLockers;
	JButton viewReport;
	JComboBox selectCustomer;
	JButton goButton;
	
	
	
	public UIMain(){
		super("Home Page");
		setSize(700, 600);
		setLocation(0, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		GridBagConstraints constraint = new GridBagConstraints();
				
		JLabel topLine = new JLabel("Yuri's You-Store-It", SwingConstants.CENTER);
		topLine.setFont(new Font("Times", Font.BOLD, 50));
		addComponent(topLine, 1, 0, 2, 2, 2, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER, gridbag);
		
		//JLabel secondLine = new JLabel("Home Page", SwingConstants.CENTER);
		//secondLine.setFont(new Font("Times", Font.BOLD, 35));
		//addComponent(secondLine, 1, 2, 2, 2, 2, 2, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, gridbag);
		
		newCustomer = new JButton("Create New Customer");
		addComponent(newCustomer, 0, 4, 2, 2, 2, 2, GridBagConstraints.BOTH, GridBagConstraints.LINE_START, gridbag);
		
		manageLockers = new JButton("Manage Lockers");
		addComponent(manageLockers, 0, 6, 2, 2, 2, 2, GridBagConstraints.BOTH, GridBagConstraints.LINE_START, gridbag);
		
		viewReport = new JButton("View Month-End Report");
		addComponent(viewReport, 0, 8, 2, 2, 2, 2, GridBagConstraints.BOTH, GridBagConstraints.LINE_START, gridbag);
	
		System.out.println(topLine.getFont());
		String[] customers = {"Steve", "Mike", "Hector", "Snarfu", "Perseus"};

		
		JLabel customerProfile = new JLabel ("Manage Customer Profile:", SwingConstants.CENTER);
		customerProfile.setFont(new Font("Times", Font.BOLD, 25));
		addComponent(customerProfile, 2, 5, 2, 1, 2, 1, GridBagConstraints.NONE, GridBagConstraints.CENTER, gridbag);
		
		selectCustomer = new JComboBox(customers);
		addComponent(selectCustomer, 2, 6, 2, 1, 2, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_END, gridbag);
		
		goButton = new JButton("Go to customer!");
		addComponent(goButton, 2, 8, 4, 2, 2, 2, GridBagConstraints.NONE, GridBagConstraints.LINE_END, gridbag);
		
		//Action listeners
		newCustomer.addActionListener(this);
		manageLockers.addActionListener(this);
		viewReport.addActionListener(this);
		goButton.addActionListener(this);
		
		//set visible
		setVisible(true);	

	
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == newCustomer){
			System.out.println("new customer");
			NewCustomer cust = new NewCustomer();
		}
		if(e.getSource() == manageLockers){
			System.out.println("Manage lockers");
			LockersUI lockers = new LockersUI();
		}
		if(e.getSource() == viewReport){
			System.out.println("View Report");
			MonthEnd end = new MonthEnd();
		}
		if(e.getSource() == goButton){
			System.out.println("Selected: " 
				+ selectCustomer.getSelectedItem());
			CustomerProfile c = new CustomerProfile(
				(String)selectCustomer.getSelectedItem());
		}
	}
			
		
		
	
	public void addComponent(Component component, int gridx, int gridy,
		int gridwidth, int gridheight, int weightx, int weighty, int fill,
		int anchor, GridBagLayout gridbag){
			
			GridBagConstraints constraint = new GridBagConstraints();
			constraint.insets = new Insets(15, 15, 15, 15);
			constraint.gridx = gridx;
			constraint.gridy = gridy;
			constraint.gridwidth = gridwidth;
			constraint.gridheight = gridheight;
			constraint.weightx = weightx;
			constraint.weighty = weighty;
			constraint.fill = fill;
			constraint.anchor = anchor;
			gridbag.setConstraints(component, constraint);
			add(component);
	}
	
	public static void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel(
			"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
			);
		}
		catch(Exception ex){
		}
	}
	
	public static void main(String[] args){
		
		UIMain main = new UIMain();
	}	
			
	
}