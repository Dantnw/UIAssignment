import javax.swing.*;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class LicenseUI extends JFrame implements ActionListener{
	
	JLabel topText;
	//JPanel preview;
	JButton refreshButton;
	JButton confirmButton;
	JPanel license;
	NewCustomer cust;
	CustomerProfile custProf;
	JLabel nextText;
	
	public LicenseUI(JPanel license, NewCustomer cust){
		
		super("Driver's License");
		this.license = license;
		this.cust = cust;
		
		setSize(700, 600);
		setLocation(0, 50);
		
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		GridBagConstraints constraint = new GridBagConstraints();
		
		topText = new JLabel("Place License on Scanner");
		topText.setFont(new Font("Times", Font.BOLD, 30));
		addComponent(topText, 0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
			
		nextText = new JLabel("Then Click Refresh");
		nextText.setFont(new Font("Times", Font.BOLD, 30));
		addComponent(nextText, 0, 1, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
		
		
		//preview = new JPanel();
		addComponent(license, 0, 2, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
		
		refreshButton = new JButton("Refresh");
		refreshButton.setFont(new Font("Times", Font.BOLD, 40));
		addComponent(refreshButton, 0, 3, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
		
		confirmButton = new JButton("Confirm and Save");
		confirmButton.setFont(new Font("Times", Font.BOLD, 40));
		addComponent(confirmButton, 0, 4, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
			
		refreshButton.addActionListener(this);
		confirmButton.addActionListener(this);
			
		setVisible(true);
		
		
	}
	
	
		public LicenseUI(JPanel license, CustomerProfile custProf){
		
		super("Driver's License");
		this.license = license;
		this.custProf = custProf;
		
		setSize(700, 600);
		setLocation(0, 50);
		
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		GridBagConstraints constraint = new GridBagConstraints();
		
		topText = new JLabel("Place License on Scanner");
		topText.setFont(new Font("Times", Font.BOLD, 30));
		addComponent(topText, 0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
			
		nextText = new JLabel("Then Click Refresh");
		nextText.setFont(new Font("Times", Font.BOLD, 30));
		addComponent(nextText, 0, 1, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
		
		//preview = new JPanel();
		addComponent(license, 0, 2, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
		
		refreshButton = new JButton("Refresh");
		refreshButton.setFont(new Font("Times", Font.BOLD, 40));
		addComponent(refreshButton, 0, 3, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
		
		confirmButton = new JButton("Confirm and Save");
		confirmButton.setFont(new Font("Times", Font.BOLD, 40));
		addComponent(confirmButton, 0, 4, 1, 1, 1, 1, GridBagConstraints.BOTH,
			GridBagConstraints.CENTER, gridbag);
			
		refreshButton.addActionListener(this);
		confirmButton.addActionListener(this);
			
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == refreshButton){
			System.out.println("refresh");
			
			
					
			try{
				ImageIcon picture = new ImageIcon("license.png");
				JLabel image = new JLabel("", picture, JLabel.CENTER);
				license.add(image, BorderLayout.CENTER);
				license.repaint();
				setVisible(true);
				System.out.println("refresh successful");
							
				
			}catch(Exception x){
				System.out.println("Something went wrong!");
			}

			
		}
		else if(e.getSource() == confirmButton && cust != null){
			System.out.println("confirm");
			
			cust.addComponent(license, 1, 3, 2, 2, 1, 1, 
				GridBagConstraints.BOTH, GridBagConstraints.LINE_END, 
				cust.gridbag);
			
			cust.setSize(1000, 900);
			
			cust.repaint();
			
			this.dispatchEvent(new WindowEvent(
				this, WindowEvent.WINDOW_CLOSING));
		}
		
		else if(e.getSource() == confirmButton && custProf != null){
			System.out.println("confirm");
			
			custProf.addComponent(license, 3, 2, 2, 3, 1, 1, 
				GridBagConstraints.BOTH, GridBagConstraints.CENTER, 
				custProf.gridbag);
			
			custProf.setSize(1000, 900);
			
			custProf.repaint();
			
			this.dispatchEvent(new WindowEvent(
				this, WindowEvent.WINDOW_CLOSING));
		}	
		
		
		
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
	
	
	
}
	
	
	
	
	
	
	