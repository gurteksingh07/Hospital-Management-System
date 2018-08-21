import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class patStart implements ActionListener
{  
  JButton badd,bmod,bview,bback,bexit;
  JLabel linfo,linfo1;
  JFrame jf;
  patStart()
  { 
    jf = new JFrame("Patient's Details");
	jf.setSize(1024,768);
	jf.setLayout(null);
	jf.setVisible(true);
	
	linfo=new JLabel("PATIENT'S DETAILS");
	linfo.setBounds(30,100,250,50);
	jf.add(linfo);
	
	linfo1=new JLabel("SELECT THE APPROPRIATE OPTION");
	linfo1.setBounds(30,157,210,20);
	jf.add(linfo1);
	
	badd=new JButton("Add Data",new ImageIcon("images/add.gif"));
	badd.setBounds(340,180,180,30);
	jf.add(badd);
	
	bmod=new JButton("Modify Data",new ImageIcon("images/bModify.png"));
	bmod.setBounds(340,280,180,30);
	jf.add(bmod);
	
	bview=new JButton("View Data",new ImageIcon("images/search.png"));
	bview.setBounds(340,380,180,30);
	jf.add(bview);
	
	bback=new JButton("BACK",new ImageIcon("images/restore.png"));
	bback.setBounds(503,545,100,30);
	jf.add(bback);
	
	badd.addActionListener(new add());
	bmod.addActionListener(new mod());
	bview.addActionListener(new view());
	bback.addActionListener(new back());
  }
	public void actionPerformed(ActionEvent ae)
		{}

	class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new Start();
			jf.dispose();
		}
	}

	class add implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new PatientInfo();
					jf.dispose();
				}
		}

	class mod implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new PatientInfomodify();
					jf.dispose();
				}
		}

	class view implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new PatientInfoView();
					jf.dispose();
				}
		}
	
	public static void main(String[] args) 
	{
		new patStart();
	}
  
}
		