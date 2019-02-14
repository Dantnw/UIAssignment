import javax.swing.*;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.event.*;

public class MonthEnd extends JFrame implements ActionListener{

	JLabel estRev = new JLabel("Total Estimated Revenue: ");
	JLabel actRev = new JLabel("Revenue Received: ");
	JLabel owed = new JLabel("Revenue Owed: ");
	
	JLabel estInt;
	JLabel actInt;
	JLabel owedInt;
	
	JLabel inArrears = new JLabel("Customers in arrears:");
	
	JScrollPane customers;
	
	public MonthEnd(){
		
		super("Month End Report");
		
		setSize(700, 600);
	
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		GridBagConstraints constraint = new GridBagConstraints();
		
		estInt = new JLabel("$12 000");
		actInt = new JLabel("$11 000");
		owedInt = new JLabel("-" + "1000");
		
		JList customerList = new JList();
		customerList.setModel(new AbstractListModel(){
			String[] custList = {"Customer 1, Locker S001, -$25",
				"Customer 2, Locker S015, -$175",
				"Customer 3, Locker L125, -$800"};
			public int getSize(){
				return custList.length;
			}
			public Object getElementAt(int i){
				return custList[i];
			}
		});
		
		customers = new JScrollPane(customerList);
		
		addComponent(estRev, 0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(actRev, 0, 1, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(owed, 0, 2, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(new JLabel(), 0, 3, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
		
		addComponent(inArrears, 0, 4, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(estInt, 1, 0, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
		
		
		addComponent(actInt, 1, 1, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(owedInt, 1, 2, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
			
		addComponent(customers, 0, 5, 2, 4, 5, 5, GridBagConstraints.BOTH,
			GridBagConstraints.LINE_START, gridbag);
		
		
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
			constraint.insets = new Insets(10, 10, 10, 10);
			gridbag.setConstraints(component, constraint);
			add(component);
	}		
	
	public void actionPerformed(ActionEvent e){
	}



}