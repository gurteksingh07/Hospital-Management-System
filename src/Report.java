import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Report implements ActionListener
{
	JButton bpat,bdoc,bback;
	JLabel lpat,ldoc;
    JFrame jf;
	Report()
	{
		jf=new JFrame("Reports");
		jf.setSize(1024,768);
		jf.setVisible(true);
		jf.setLayout(null);
		

		lpat=new JLabel("For Patients Reports Click Here :");
		lpat.setBounds(100,200,400,30);
		jf.add(lpat);

		ldoc=new JLabel("For Doctors Reports Click Here :");
		ldoc.setBounds(100,350,400,30);
		jf.add(ldoc);

		bpat=new JButton("Display Patient's Report",new ImageIcon("images/emp.png"));
		bpat.setBounds(400,200,250,30);
		jf.add(bpat);

		bdoc=new JButton("Display Doctor's Report",new ImageIcon("images/users.png"));
		bdoc.setBounds(400,350,250,30);
		jf.add(bdoc);

		bback=new JButton("BACK",new ImageIcon("images/restore.png"));
		bback.setBounds(480,600,100,30);
		jf.add(bback);

		bpat.addActionListener(new patreport());
		bdoc.addActionListener(new docreport());
		bback.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()==bback)
		{
			new Start();
			jf.dispose();
		}
	
	}

class patreport implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{   
		PatientTableFromDatabase frame=new PatientTableFromDatabase();
		frame.setDefaultCloseOperation(1);
        frame.pack();
        frame.setVisible(true);
	}

}

class docreport implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{   
		new DoctorTableFromDatabase();
		DoctorTableFromDatabase frame=new DoctorTableFromDatabase();
		frame.setDefaultCloseOperation(1);
        frame.pack();
        frame.setVisible(true);
	}
}


	public static void main(String[] args) 
	{
		new Report();
	}
}
