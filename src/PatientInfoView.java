import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class PatientInfoView implements ActionListener
{

	static Connection cn=null;
	Statement st=null;
	ResultSet rs=null;

    JLabel lmain,lpi,lname,ladd,ltel,lmi,ldob,lbg,lhis,lcur,lpno,lnote,lroom,ldateadd,lgender,lrtype,ldtip2,ldocname;
    JTextField tfname,tftel,tfdob,tfpno,tfbg,tfroom,tfdateadd,tfmf,tfrtype,tfdocname;
    TextArea taadd,tahis,tacur;
    JButton bsub,bclr,bback;
    JFrame jf;
   PatientInfoView()
   {
	jf = new JFrame("View Patient Information");
	jf.setSize(1024,768);
	jf.setVisible(true);
	jf.setLayout(null);

	lmain=new JLabel("View Patient Information");
	lmain.setBounds(440,35,140,15);
	jf.add(lmain);

	lpno=new JLabel("Insert Patient Number");
	lpno.setBounds(104,97,150,20);
	jf.add(lpno);
	
	tfpno=new JTextField(30);
	tfpno.setBounds(250,97,50,20);
	jf.add(tfpno);
	
	lname=new JLabel("Insert Patient Name :");
	lname.setBounds(104,137,150,20);
	jf.add(lname);
	
	tfname=new JTextField(30);
	tfname.setBounds(250,137,250,20);
	jf.add(tfname);
	
	lroom=new JLabel("Insert Room No.:");
	lroom.setBounds(104,177,150,20);
	jf.add(lroom);

	tfroom=new JTextField(30);
	tfroom.setBounds(250,177,60,20);
	jf.add(tfroom);
	
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
   
   public void actionPerformed(ActionEvent ae)
	{}
	
   public static void main(String[] args)
	{
		PatientInfoView piv=new PatientInfoView();
		
	}

class clear implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			tfname.setText("");
			tfpno.setText("");
			tfroom.setText("");				
		}
	}

class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new patStart();
			jf.dispose();
		}
	}

class submit implements ActionListener
{
	Integer num,no=0;
	String name,addr,blgr,hist,contact,current,room,dateadd,rtype,mf,dob,docname;
	JButton bback1; 
	JFrame jf1;
  class back1 implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new PatientInfoView();
			jf1.dispose();
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{	
	num=Integer.parseInt(tfpno.getText());
	jf.dispose();
	jf1 = new JFrame("View Patient Information");
	jf1.setSize(1024,768);
	jf1.setVisible(true);
	jf1.setLayout(null);
	
	lmain=new JLabel("View Patient Information");
	lmain.setBounds(440,35,140,15);
	jf1.add(lmain);

	lpi=new JLabel("Personal Information");
	lpi.setBounds(40,70,120,15);
	jf1.add(lpi);

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
	tftel.setBounds(640,138,250,20);
	jf1.add(tftel);

	lmi=new JLabel("Medical Information");
	lmi.setBounds(40,268,120,15);
	jf1.add(lmi);
	
	lbg=new JLabel("Blood Group :");
	lbg.setBounds(104,306,79,15);
	jf1.add(lbg);

	tfbg=new JTextField(30);
	tfbg.setBounds(270,306,53,20);
	jf1.add(tfbg);

	lhis=new JLabel("History :");
	lhis.setBounds(104,365,50,15);
	jf1.add(lhis);

	tahis=new TextArea();
	tahis.setBounds(270,365,250,100);
	jf1.add(tahis);

	lcur=new JLabel("Current Problem :");
	lcur.setBounds(575,365,100,15);
	jf1.add(lcur);
	
	tacur=new TextArea();
	tacur.setBounds(720,365,250,100);
	jf1.add(tacur);		

	lroom=new JLabel("Room No.:");
	lroom.setBounds(720,97,60,20);
	jf1.add(lroom);

	tfroom=new JTextField(30);
	tfroom.setBounds(788,97,60,20);
	jf1.add(tfroom);
	
	lgender=new JLabel("Gender :");
	lgender.setBounds(575,223,50,15);
	jf1.add(lgender);

	tfmf=new JTextField(50);
	tfmf.setBounds(698,223,80,20);
	jf1.add(tfmf);

	lrtype=new JLabel("Type Of Room : ");
	lrtype.setBounds(104,510,120,25);
	jf1.add(lrtype);

	tfrtype=new JTextField();
	tfrtype.setBounds(270,510,80,20);
	jf1.add(tfrtype);
	
	ldob=new JLabel("Date of Birth :");
	ldob.setBounds(575,306,135,15);
	jf1.add(ldob);

	tfdob=new JTextField(15);
	tfdob.setBounds(720,305,80,20);
	jf1.add(tfdob);

	bback1=new JButton("BACK",new ImageIcon("images/restore.png"));
	bback1.setBounds(580,643,100,30);
	jf1.add(bback1);
		
	tfdocname=new JTextField(100);
	tfdocname.setBounds(720,510,250,20);
	jf1.add(tfdocname);

	ldocname=new JLabel("Attending Doctor :");
	ldocname.setBounds(575,510,130,15);
	jf1.add(ldocname);
	
	ldateadd=new JLabel("Date Of Admission :");
	ldateadd.setBounds(575,180,120,20);
	jf1.add(ldateadd);

	tfdateadd=new JTextField(20);
	tfdateadd.setBounds(696,180,80,20);
	jf1.add(tfdateadd);
	
	try{
	Class.forName("com.mysql.jdbc.Driver");
	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pat","root","root");
	}
	catch(Exception e)
		{
			System.out.println(e);
		}	
		
	bback1.addActionListener(new back1());
	
		try{
		
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM PAT WHERE pno="+num);
		
		if(rs.next())
			{
				name=rs.getString("name");
				addr=rs.getString("addr");
				contact=rs.getString("contact");
				blgr=rs.getString("bg");
				hist=rs.getString("hist");
				dob=rs.getString("dob");
				current=rs.getString("current");
				room=rs.getString("room");
				dateadd=rs.getString("dadd");
				rtype=rs.getString("rtype");
				mf=rs.getString("gender");
				docname=rs.getString("docname");

				tfname.setText(name);
				tftel.setText(contact);
				tfdob.setText(dob);
				taadd.setText(addr);
				tahis.setText(hist);
				tacur.setText(current);
				tfbg.setText(blgr);
				tfroom.setText(room);
				tfdateadd.setText(dateadd);
				tfrtype.setText(rtype);
				tfmf.setText(mf);
				tfdocname.setText(docname);
			    
			}
            else
			 { 
			   JOptionPane.showMessageDialog(null,"Patient Not Found!");
			   jf1.dispose();
			   new PatientInfoView();
             }
		}
		catch(SQLException sq)
		{
			System.out.println(sq);
		}	
	  			
	}
}

}
