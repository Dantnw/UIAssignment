import javax.swing.*;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.event.*;

public class CustomerProfile extends JFrame implements ActionListener{
	
	Random rand = new Random();

	JLabel title = new JLabel("Customer Profile");
	
	JLabel name;
	JLabel tel;
	JLabel locker;
	
	JLabel balance;
	JLabel lastPay;
	JLabel nextPay;
	JLabel due;
	
	JLabel nameString;
	JLabel telString;
	JLabel lockerString;
	
	JLabel balanceString;
	JLabel lastPayString;
	JLabel nextPayString;
	JLabel dueString;
	
	JButton editName;
	JButton editTel;
	JButton editLocker;
	JButton recordPayment;
	
	JPanel licensePicture;
	
	JButton addLicense;
	JButton save;
	JButton cancel;
	
	String temp;
	String custName;
	
	GridBagLayout gridbag;
	
	public CustomerProfile(String custName){
		
		super("Customer Profile");
		
		setSize(700, 600);
		setLocation(0, 50);
		this.custName = custName;
		
		name = new JLabel("Name");
		tel = new JLabel("TEL: ");
		locker = new JLabel("Locker: ");
		
		balance = new JLabel("Current Balance: ");
		lastPay = new JLabel("Last payment: ");
		nextPay = new JLabel("Next payment: ");
		due = new JLabel("Payment Due: ");
		
		nameString = new JLabel(custName);
		int x = rand.nextInt(900) + 100;
		int y = rand.nextInt(900) + 100;
		int z = rand.nextInt(9000) + 1000;
		telString = new JLabel(x + "-" + y + "-" + z);
		
		lockerString = new JLabel("locker number");
		
		balanceString = new JLabel("$0.00");
		lastPayString = new JLabel("$25.00");
		nextPayString = new JLabel("25.00");
		dueString = new JLabel("07/22/2018");
		
		editName = new JButton("(edit)");
		editTel = new JButton("(edit)");
		editLocker = new JButton("(edit)");
		recordPayment = new JButton("Record a Payment");
		addLicense = new JButton("Add new Driver's License");
		cancel = new JButton("Cancel");
		save = new JButton("Save and Close");
		
		licensePicture = new JPanel(new BorderLayout());
		
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		GridBagConstraints constraint = new GridBagConstraints();
		
		//First column (title to record payment button)
		
		addComponent(title, 0, 0, 2, 2, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.CENTER, gridbag);
		
		addComponent(name, 0, 2, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(tel, 0, 3, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(locker, 0, 4, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(new JLabel(), 0, 5, 1, 2, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(balance, 0, 7, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(lastPay, 0, 8, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(nextPay, 0, 9, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(due, 0, 10, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(new JLabel(), 0, 10, 11, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(recordPayment, 0, 12, 2, 2, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.CENTER, gridbag);
		
		
		//second column (values associated with labels)
		
		addComponent(nameString, 1, 2, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(telString, 1, 3, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(lockerString, 1, 4, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
			
		
		addComponent(balanceString, 1, 7, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(lastPayString, 1, 8, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(nextPayString, 1, 9, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(dueString, 1, 10, 1, 1, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		//third column values
		
		addComponent(editName, 2, 2, 1, 1, 1, 1, GridBagConstraints.NONE, 
			GridBagConstraints.CENTER, gridbag);
		
		addComponent(editTel, 2, 3, 1, 1, 1, 1, GridBagConstraints.NONE, 
			GridBagConstraints.CENTER, gridbag);
			
		addComponent(editLocker, 2, 4, 1, 1, 1, 1, GridBagConstraints.NONE, 
			GridBagConstraints.CENTER, gridbag);
		
		//fourth column values
		
		addComponent(licensePicture, 3, 2, 2, 3, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.CENTER, gridbag);
			
		addComponent(addLicense, 3, 6, 2, 2, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.CENTER, gridbag);
			
		//misc buttons
		
		addComponent(save, 4, 12, 2, 2, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.CENTER, gridbag);
		
		addComponent(cancel, 4, 10, 2, 2, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.CENTER, gridbag);
			
		this.setVisible(true);
		
		editName.addActionListener(this);
		editLocker.addActionListener(this);
		editTel.addActionListener(this);
		recordPayment.addActionListener(this);
		addLicense.addActionListener(this);
		cancel.addActionListener(this);
		save.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == editName){
			temp = JOptionPane.showInputDialog(this,
				"Enter new name");
			if(temp == null){

			}
			else{
				nameString.setText(temp);
				custName = temp;
			}
			repaint();
			
		}
		
		if(e.getSource() == editTel){
			temp = JOptionPane.showInputDialog(this,
				"Enter new telephone number", null);
				
			if(temp == null){
			}
			
			else{
				telString.setText(temp);
			}
			
			repaint();
			
		}
		
		if(e.getSource() == editLocker){
			temp = JOptionPane.showInputDialog(this,
				"enter new locker number", null);
			if(temp == null){
			}
			else{
				lockerString.setText(temp);
			}
			repaint();
			
		}
		
		if(e.getSource() == recordPayment){
			System.out.println("Record new payment selected");
			AddPayment payment = new AddPayment(custName);
		}
		
		if(e.getSource() == addLicense){
			LicenseUI licenseer = new LicenseUI(licensePicture, this);
		}
		
		if(e.getSource() == cancel){
			this.dispatchEvent(new WindowEvent(this,
				WindowEvent.WINDOW_CLOSING));
			System.out.println("cancelled");
		}			
		
		if(e.getSource() == save){
			this.dispatchEvent(new WindowEvent(this,
				WindowEvent.WINDOW_CLOSING));
			System.out.println("Changes saved");
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
}