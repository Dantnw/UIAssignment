import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewCustomer extends JFrame implements ActionListener{
	
	JLabel newCustomer;
	JLabel name;
	JLabel TEL;
	JTextArea custName;
	JTextArea telNumber;
	JButton addLicense;
	JButton cancel;
	JButton finish;
	JPanel licensePicture;
	GridBagLayout gridbag;
	
	public NewCustomer(){
		super("New Customer Creation");
		
		setSize(700, 600);
		setLocation(0, 50);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gridbag = new GridBagLayout();
		setLayout(gridbag);
		GridBagConstraints constraint = new GridBagConstraints();
		
		newCustomer = new JLabel("Create New Customer");
		newCustomer.setFont(new Font("Times", Font.BOLD, 40));
		addComponent(newCustomer, 0, 0, 10, 1, 1, 1, GridBagConstraints.NONE, 
			GridBagConstraints.CENTER, gridbag);
		
		name = new JLabel("Name: ");
		name.setFont(new Font("Times", Font.BOLD, 20));
		addComponent(name, 0, 1, 1, 1, 1, 1, GridBagConstraints.NONE, 
			GridBagConstraints.LINE_END, gridbag);
		
		custName = new JTextArea();
		addComponent(custName, 1, 1, 8, 1, 8, 1, GridBagConstraints.HORIZONTAL, 
			GridBagConstraints.LINE_START, gridbag);
		
		TEL = new JLabel("TEL:");
		TEL.setFont(new Font("Times", Font.BOLD, 20));
		addComponent(TEL, 0, 2, 1, 1, 1, 1, GridBagConstraints.NONE, 
			GridBagConstraints.LINE_END, gridbag);
		
		telNumber = new JTextArea();
		addComponent(telNumber, 1, 2, 4, 1, 4, 1, GridBagConstraints.HORIZONTAL, 
			GridBagConstraints.LINE_START, gridbag);
		
		addLicense = new JButton("Add \nDriver's\nLicense");
		addComponent(addLicense, 0, 3, 2, 2, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		cancel = new JButton("Cancel");
		addComponent(cancel, 0, 6, 1, 2, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_START, gridbag);
		
		finish = new JButton("Finished!");
		addComponent(finish, 1, 6, 2, 2, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_END, gridbag); 
		
		licensePicture = new JPanel(new BorderLayout());
		addComponent(licensePicture, 1, 3, 2, 3, 1, 1, GridBagConstraints.BOTH, 
			GridBagConstraints.LINE_END, gridbag);
		
		cancel.addActionListener(this);
		finish.addActionListener(this);
		addLicense.addActionListener(this);
		
		
		setVisible(true);
	}
	
	//p//ublic static void main(String[] args){
		
	//	NewCustomer cust = new NewCustomer();
	//}
		
		

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
		if(e.getSource() == cancel){
			//close window
			System.out.println("cancel");
			this.dispatchEvent(new WindowEvent (this, 
				WindowEvent.WINDOW_CLOSING));
		}
		
		if(e.getSource() == addLicense){
			System.out.println("add license");
			//add license picture somehow
			LicenseUI licenseGetter = new LicenseUI(licensePicture, this);
			
			repaint();
			
		}
		
		if(e.getSource() == finish){
			//close window and save customer information
			String s = custName.getText();
			String t = telNumber.getText();
			System.out.println(s);
			if(s.equals("") || s.equals("<enter name>")){
				JOptionPane.showMessageDialog(new JFrame(), "Name invalid");
			}
			else if(t.equals("") || t.equals("<telephone number>")){
				JOptionPane.showMessageDialog(new JFrame(), "Tel number invalid");
			}
			
			else{
				System.out.println("Saved");
				this.dispatchEvent(new WindowEvent(this, 
					WindowEvent.WINDOW_CLOSING));
			}
				
		}
		repaint();
	}
		
}

