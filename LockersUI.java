import javax.swing.*;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.event.*;

public class LockersUI extends JFrame implements ActionListener{
	
	JScrollPane inventory;
	
	JTextArea search;
	
	JLabel jump;
	JLabel selected;
	JLabel locker;
	JLabel status;
	JLabel customer;
	JLabel filters;
	JLabel status2;
	JLabel customer2;
	JButton goButton;
	JButton exit;
	
	JComboBox statusBox;
	JComboBox custBox;
	JComboBox statusBox2;
	JComboBox custBox2;
	
	String[] statuses = {"Occupied", "Available", "Overdue", "Forfeit"};
	String[] customers = {"No Customer", "Customer 1", "Customer 2", "Customer 3"};
	String[] lockerList = {"S001", "S002", "S003", "M001", "M002", "L001", "L002"};
	JList lockerJList = new JList();
	
	public LockersUI(){

		super("Locker Inventory");
		
		setSize(700, 600);
		setLocation(0, 50);
	
		Font font = new Font("Times", Font.BOLD, 24);
				
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		/*
		This is borrowed from:
		http://www.java2s.com/Tutorials/Java/Swing_How_to/JList/Add_an_Action_Listener_to_JList.htm
		A Java tutorial on how to add an action listener to a JList embedded in
		a JScrollPane
		*/
		lockerJList.setModel(new AbstractListModel(){//Format the JList as an
													//abstract list model with
													//two methods
			String[] lockerList = {"S001", "S002", "S003", "M001", "M002", 
				"L001", "L002"};
			public int getSize(){
				return lockerList.length;
			}
			public Object getElementAt(int i){
				return lockerList[i];
			}
		});
			
		lockerJList.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent evt){
				jListValueChanged(evt);
			}
		});
				
		
		inventory = new JScrollPane(lockerJList);


		//search = new JTextArea("<enter locker number>");
		
		selected = new JLabel("<no locker selected>");
		locker = new JLabel("Locker ");
		status = new JLabel("Status: ");
		customer = new JLabel("Customer: ");
		filters = new JLabel("Filters");
		status2 = new JLabel("Status: ");
		customer2 = new JLabel("Customer: ");
		goButton = new JButton("Go!");
		//jump = new JLabel("Jump To: ");
		exit = new JButton("Exit");
		
		filters.setFont(new Font("Times", Font.BOLD, 20));
		
		statusBox = new JComboBox(statuses);
		statusBox2 = new JComboBox(statuses);
		
		custBox = new JComboBox(customers);
		custBox2 = new JComboBox(customers);
	
		addComponent(inventory, 0, 0, 1, 10, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.CENTER, gridbag);
		
		//addComponent(jump, 1, 1, 1, 1, 1, 1, GridBagConstraints.BOTH,
		//	GridBagConstraints.LINE_START, gridbag);
		
		addComponent(selected, 1, 2, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(status, 1, 3, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(customer, 1, 4, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);

		addComponent(filters, 1, 5, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
			
		addComponent(status2, 1, 6, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(customer2, 1, 7, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
			
		//addComponent(search, 2, 1, 1, 1, 1, 1, GridBagConstraints.BOTH,
		//	GridBagConstraints.CENTER, gridbag);
		
		addComponent(statusBox, 2, 3, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
			
		addComponent(custBox, 2, 4, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
			
		addComponent(statusBox2, 2, 6, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
			
		addComponent(custBox2, 2, 7, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
		
		addComponent(new JLabel(), 2, 8, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);

		addComponent(new JLabel(), 2, 9, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
			
		addComponent(exit, 2, 10, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
	
		//I tried to work with a caret listener but honestly I need
		//to get this thing done! It's clear I have no skill with UI design
		//or implementation and while that's a clear limitation for my future
		//work, there's no point to reach for the stars with these 
		//tiny little t-rex arms.
		
		goButton.addActionListener(this);
		statusBox.addActionListener(this);
		custBox.addActionListener(this);
		statusBox2.addActionListener(this);
		custBox2.addActionListener(this);
		exit.addActionListener(this);
		
		
		setVisible(true);
	}
	
	public void jListValueChanged(ListSelectionEvent evt){
		if(!lockerJList.getValueIsAdjusting()){
			selected.setText((String) lockerJList.getSelectedValue());
		}
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == goButton){
			System.out.println("Go Button Clicked!");
			System.out.println("Selection: " + search.getText());
		}
		else if(e.getSource() == statusBox){
			System.out.println("Locker status set to: " 
			+ statusBox.getSelectedItem());
			if(statusBox.getSelectedItem().equals("Available")){
				custBox.setSelectedItem("No Customer");
				repaint();
			}
			
		}
	
		else if(e.getSource() == custBox){
			System.out.println("Locker assigned to: " 
			+ custBox.getSelectedItem());
			
		}
		
		else if(e.getSource() == statusBox2){
			System.out.println("Filtering List by: " 
			+ statusBox2.getSelectedItem());			
			
		}
		else if(e.getSource() == custBox2){
			System.out.println("Showing only lockers rented by: " 
			+ custBox2.getSelectedItem());
		
		}
		
		else if(e.getSource() == exit){
			this.dispatchEvent(new WindowEvent(this,
				WindowEvent.WINDOW_CLOSING));
		}
	//	else if(e.getSource() == ){
	//		
	//	}
				
		
	}
		
	
	public void addComponent(Component component, int gridx, int gridy,
		int gridwidth, int gridheight, int weightx, int weighty, int fill,
		int anchor, GridBagLayout gridbag){
			
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = gridx;
		constraint.gridy = gridy;
		constraint.gridwidth = gridwidth;
		constraint.gridheight = gridheight;
		constraint.weightx = weightx;
		constraint.weighty = weighty;
		constraint.fill = fill;
		constraint.anchor = anchor;
		constraint.insets = new Insets(15, 15, 15, 15);
		gridbag.setConstraints(component, constraint);
		add(component);
	}	
}
		
		