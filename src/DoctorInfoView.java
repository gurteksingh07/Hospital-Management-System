import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class DoctorInfoView implements ActionListener
{
	static Connection cn=null;
	static Connection cn2=null;
	Statement st=null;
	Statement st2=null;
	ResultSet rs=null;
	ResultSet rs2=null;

	JLabel lmain,ldi,lname,ladd,ltel,lspecial,ldid,ldspec,lwork,lworkfrom,lworkto,lpatlist;
	JTextField tfname,tftel,tfdid,tfworkf,tfworkt;
	TextArea taadd,taspecial,tapatlist;
	JButton bsub,bclr,bback;
	JFrame jf;
	
	DoctorInfoView()
	{
	 jf = new JFrame("Doctor Information");
	 jf.setSize(1024,768);
	 jf.setVisible(true);
	 jf.setLayout(null);

	 lmain=new JLabel("Doctor Information");
	 lmain.setBounds(440,35,140,15);
	 jf.add(lmain);
	 
	 lname=new JLabel("Insert Name :");
	 lname.setBounds(104,137,150,20);
	 jf.add(lname);

	 tfname=new JTextField(30);
	 tfname.setBounds(250,137,250,20);
	 jf.add(tfname);
	 
	 ldid=new JLabel("Insert Doctor ID :");
	 ldid.setBounds(104,97,150,20);
	 jf.add(ldid);

	 tfdid=new JTextField(30);
	 tfdid.setBounds(250,97,50,20);
	 jf.add(tfdid);
	 
	 bsub=new JButton("SEARCH",new ImageIcon("images/search.png"));
	 bsub.setBounds(300,643,110,30);
	 jf.add(bsub);	

	 bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
	 bclr.setBounds(470,643,100,30);
	 jf.add(bclr);

	 bback=new JButton("BACK",new ImageIcon("images/restore.png"));
	 bback.setBounds(580,643,100,30);
	 jf.add(bback);
	 
	 bclr.addActionListener(new clear());
	 bsub.addActionListener(new submit());
	 bback.addActionListener(new back());
    }  

class clear implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			tfname.setText("");
			tfdid.setText("");
		}
	}

class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new docStart();
			jf.dispose();
		}
	}

public void actionPerformed(ActionEvent ae)
	{}

class submit implements ActionListener
{
	JFrame jf1;
	Integer num;
	
	class back1 implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new docStart();
			jf1.dispose();
		}
	}

	public void actionPerformed(ActionEvent ae)
	{	
	num=Integer.parseInt(tfdid.getText());
	jf.dispose();
    jf1 = new JFrame("Doctor Information");
	jf1.setSize(1024,768);
	jf1.setVisible(true);
	jf1.setLayout(null);

	lmain=new JLabel("Doctor Information");
	lmain.setBounds(440,35,107,15);
	jf1.add(lmain);

	ldi=new JLabel("Doctor Information");
	ldi.setBounds(40,70,120,15);
	jf1.add(ldi);

	lname=new JLabel("Name :");
	lname.setBounds(104,97,70,25);
	jf1.add(lname);

	tfname=new JTextField(30);
	tfname.setBounds(270,97,250,20);
	jf1.add(tfname);

	ladd=new JLabel("Address :");
	ladd.setBounds(104,138,70,15);
	jf1.add(ladd);

	taadd=new TextArea();
	taadd.setBounds(270,138,250,100);
	jf1.add(taadd);

	ltel=new JLabel("Contact :");
	ltel.setBounds(575,138,50,25);
	jf1.add(ltel);

	tftel=new JTextField(30);
	tftel.setBounds(640,138,200,20);
	jf1.add(tftel);

	ldspec=new JLabel("Specialization :");
	ldspec.setBounds(104,310,100,25);
	jf1.add(ldspec);

	taspecial=new TextArea();
	taspecial.setBounds(270,310,250,100);
	jf1.add(taspecial);

	lwork=new JLabel("Working hours :");
	lwork.setBounds(570,200,100,15);
	jf1.add(lwork);

	lworkfrom=new JLabel("From :");
	lworkfrom.setBounds(670,200,37,25);
	jf1.add(lworkfrom);

	tfworkf=new JTextField(30);
	tfworkf.setBounds(710,200,30,20);
	jf1.add(tfworkf);
	
	lworkto=new JLabel("to :");
	lworkto.setBounds(747,200,20,25);
	jf1.add(lworkto);

	tfworkt=new JTextField(30);
	tfworkt.setBounds(775,200,30,20);
	jf1.add(tfworkt);

	lpatlist=new JLabel("Patient List");
	lpatlist.setBounds(570,290,80,25);
	jf1.add(lpatlist);

	tapatlist=new TextArea();
	tapatlist.setBounds(570,310,250,100);
	jf1.add(tapatlist);

	bback=new JButton("BACK",new ImageIcon("images/restore.png"));
	bback.setBounds(580,643,100,30);
	jf1.add(bback);

	try{	
		Class.forName("com.mysql.jdbc.Driver");
     	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pat","root","root");
	    
		Class.forName("com.mysql.jdbc.Driver");
     	cn2=DriverManager.getConnection("jdbc:mysql://localhost:3306/pat","root","root");
	   
	   }

	catch(Exception e)
		{
			System.out.println(e);
		}	
	    bback.addActionListener(new back1());
		
		try{

		tapatlist.setText("");			
		String name;
		String addr;
		String contact;
		String spec;
		String workf;
		String workt;
		
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM DOC WHERE id="+num);
		
		if(rs.next())
			{
				num=rs.getInt("id");
				name=rs.getString("name");
				addr=rs.getString("addr");
				contact=rs.getString("contact");
				spec=rs.getString("spec");
				workf=rs.getString("workf");
				workt=rs.getString("workt");
	
				tfname.setText(name);
				taadd.setText(addr);
				tftel.setText(contact);
				taspecial.setText(spec);
				tfworkf.setText(workf);
				tfworkt.setText(workt);	
			}
			else
			 { 
			   JOptionPane.showMessageDialog(null,"Doctor Not Found!");
			   jf1.dispose();
			   new DoctorInfoView();
             }
		}
		catch(SQLException sq)
		{
			System.out.println(sq);
		}

		try{

			String docname=tfname.getText();
			System.out.println(docname);
			Statement st2=cn2.createStatement();
		    ResultSet rs2=st2.executeQuery("SELECT pno,name FROM PAT WHERE docname='"+docname+"'");
			ResultSetMetaData rsmt=rs2.getMetaData();
			int ctr=rsmt.getColumnCount();
			while(rs2.next())
			{
				for(int i=1;i<=ctr;i++)
				{
					tapatlist.append(rs2.getString(i)+"  ");
				}
				tapatlist.append("\n");
			}
		   }
		   catch(SQLException sq)
		   {
				System.out.println(sq);
		   }
		
	}
 }
	public static void main(String[] args) 
	{
		new DoctorInfoView();
		System.out.println("Doctors Info Add");
	}
}