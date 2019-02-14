import javax.swing.*;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.event.*;

public class AddPayment extends JFrame implements ActionListener{

	JLabel top;
	
	JLabel amountLabel = new JLabel("Payment Amount: ");
	JLabel type = new JLabel("Select payment type: ");
	
	JButton confirm = new JButton("Confirm payment");
	JButton cancel = new JButton("Cancel payment");
	
	String[] payTypes = {"Visa", "Mastercard", "Debit",	"Cash", 
		"American Express"};
	
	JComboBox paymentType = new JComboBox(payTypes);
	
	JTextArea payField = new JTextArea();
	//payField.setPromptText("Enter payment amount in dollars");
	
	
	String name;
	
	public AddPayment(String customerName){
		
		super("Add Payment");
		
		setSize(400, 400);
		setLocation(0, 50);
		
		this.name = customerName;
		
		top = new JLabel("Add Payment - " + customerName);
		top.setFont(new Font("Times", Font.BOLD, 24));
		
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		
		addComponent(top, 0, 0, 2, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
		
		addComponent(amountLabel, 0, 1, 1, 1, 1, 1, GridBagConstraints.NONE,
			GridBagConstraints.CENTER, gridbag);

		addComponent(new JLabel(), 0, 2, 1, 1, 1, 1, GridBagConstraints.NONE,
			GridBagConstraints.CENTER, gridbag);

		addComponent(type, 0, 3, 1, 1, 1, 1, GridBagConstraints.NONE,
			GridBagConstraints.CENTER, gridbag);
			
		addComponent(new JLabel(), 0, 4, 1, 1, 1, 1, GridBagConstraints.NONE,
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(confirm, 1, 5, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
			
		addComponent(cancel, 0, 5, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
			
		addComponent(payField, 1, 1, 1, 1, 1, 1, GridBagConstraints.HORIZONTAL,
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(paymentType, 1, 3, 1, 1, 1, 1, GridBagConstraints.NONE,
			GridBagConstraints.LINE_START, gridbag);
			
		
		cancel.addActionListener(this);
		confirm.addActionListener(this);
		
		setVisible(true);
		
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
		constraint.insets = new Insets(15, 10, 15, 10);
		gridbag.setConstraints(component, constraint);
		add(component);
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == confirm){
			this.dispatchEvent(new WindowEvent(this,
			WindowEvent.WINDOW_CLOSING));
			System.out.println("Payment Saved");
			System.out.println(name + " paid " + payField.getText() + 
				" on " + (String)paymentType.getSelectedItem());
		}
		
		if(e.getSource() == cancel){
			this.dispatchEvent(new WindowEvent(this,
			WindowEvent.WINDOW_CLOSING));
			System.out.println("Payment Cancelled");
		}
	}
}