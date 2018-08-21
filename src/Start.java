import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Start implements ActionListener
{
  JButton bpat,bdoc,bbill,bexit,breport;
  JLabel linfo,lmain;
  JFrame jf;
  Start()
  { 
    
    jf = new JFrame("Hospital Management System");
	linfo=new JLabel("Select The Appropriate Option");
	linfo.setBounds(430,137,210,20);
	jf.add(linfo);
	
    lmain=new JLabel("HOSPITAL MANGAGEMENT SYSTEM");
    lmain.setBounds(420,30,210,100);
    jf.add(lmain);
	
	bpat=new JButton("Patient", new ImageIcon("images/Advances.png"));
	bpat.setBounds(430,200,180,30);
	jf.add(bpat);

	bdoc=new JButton("Doctor",new ImageIcon("images/Advances.png"));
	bdoc.setBounds(430,270,180,30);
	jf.add(bdoc);

	bbill=new JButton("Billing",new ImageIcon("images/Attendance.png"));
	bbill.setBounds(430,340,180,30);
	jf.add(bbill);
	
	breport=new JButton("Reports",new ImageIcon("images/edit.png"));
	breport.setBounds(430,408,180,30);
	jf.add(breport);
		
	bexit=new JButton("EXIT" ,new ImageIcon("images/exits.png"));
	bexit.setBounds(465,515,100,30);
	jf.add(bexit);
	
	bpat.addActionListener(new patient());
	bdoc.addActionListener(new doctor());
	bbill.addActionListener(new billing());
	bexit.addActionListener(new exit());
	breport.addActionListener(new report());
	
	jf.setSize(1024,768);
	jf.setLayout(null);
	jf.setVisible(true);
   }
    public void actionPerformed(ActionEvent ae)
		{}
    class report implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new  Report();
			jf.dispose();
		}
	};
	
	class patient implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new patStart();
					jf.dispose();
				}
		}

	class doctor implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new docStart();
					jf.dispose();
				}
		}

	class billing implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new Billing();
					jf.dispose();
				}
		}


	class exit implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					System.exit(0);
				}
		}

	public static void main(String[] args) 
	{
		new Start();
	}
 
  }
  