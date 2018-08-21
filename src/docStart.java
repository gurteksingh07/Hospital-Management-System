import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class docStart implements ActionListener
{
	JButton badd,bmod,bview,bback,bexit;
	JLabel linfo;
    JFrame jf;
	docStart()
	{
		jf= new JFrame("Doctor's Information");
		jf.setSize(1024,768);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setLayout(null);
		
		linfo=new JLabel("Doctor's  Information");
		linfo.setBounds(445,30,210,20);
		jf.add(linfo);

		badd=new JButton("Add Data",new ImageIcon("images/add.gif"));
		badd.setBounds(350,180,180,30);
		jf.add(badd);

		bmod=new JButton("Modify Data",new ImageIcon("images/bModify.png"));
		bmod.setBounds(350,280,180,30);
		jf.add(bmod);
		
		bview=new JButton("View Data",new ImageIcon("images/search.png"));
		bview.setBounds(350,380,180,30);
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
					new	DoctorInfoAdd();
					jf.dispose();
				}
		}

	class mod implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new DoctorInfomodify();
					jf.dispose();
				}
		}

	class view implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new DoctorInfoView();
					jf.dispose();
				}
		}

	public static void main(String[] args) 
	{
		new docStart();
	}
}
