import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class PatientInfomodify implements ActionListener
{
	static Connection cn=null;
	Statement st=null;
	ResultSet rs=null;

    JLabel lmain,lpi,lname,ladd,ltel,lmi,lbg,ldob,lhis,lcur,lpno,lnote,lroom,ldateadd,lgender,lrtype,ldtip,ldtip2,ldocname;
    JTextField tfname,tftel,tfdob,tfpno,tfroom,tfdateadd,tfdocname;
    TextArea taadd,tahis,tacur;
    JButton bsub,bclr,bback,bmod;
    Choice chbg,chrt;
    CheckboxGroup cbmf;
    Checkbox cbm,cbf;
    JFrame jf;
    clsSettings settings = new clsSettings();

PatientInfomodify()
{
	jf= new JFrame("Modify Patient Information");
	jf.setSize(1024,768);
	jf.setVisible(true);
	jf.setLayout(null);
	
	lmain=new JLabel("Modify Patient Information");
	lmain.setBounds(440,35,140,15);
	jf.add(lmain);

	lname=new JLabel("Insert Patient Name :");
	lname.setBounds(104,137,150,20);
	jf.add(lname);

	tfname=new JTextField(30);
	tfname.setBounds(250,137,250,20);
	jf.add(tfname);

	lpno=new JLabel("Insert Patient No.:");
	lpno.setBounds(104,97,150,20);
	jf.add(lpno);

	tfpno=new JTextField(30);
	tfpno.setBounds(250,97,50,20);
	jf.add(tfpno);

	lroom=new JLabel("Insert Room No.:");
	lroom.setBounds(104,177,150,20);
	jf.add(lroom);

	tfroom=new JTextField(30);
	tfroom.setBounds(250,177,60,20);
	jf.add(tfroom);
	
	bsub=new JButton("SEARCH",new ImageIcon("images/search.png"));
	bsub.setBounds(152,643,120,30);
	jf.add(bsub);	

	bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
	bclr.setBounds(340,643,100,30);
	jf.add(bclr);

	bback=new JButton("BACK",new ImageIcon("images/restore.png"));
	bback.setBounds(680,643,90,30);
	jf.add(bback);
			
	bclr.addActionListener(new clear());
	bsub.addActionListener(new submit());
	bback.addActionListener(new back());
	
	
}

public void actionPerformed(ActionEvent ae)
	{}
	
public static void main(String[] args)
	{
		new PatientInfomodify();
		
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
	JFrame jf1;
	Integer num;
	class clear1 implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{   
			tfname.setText("");
			tftel.setText("");
			tfdob.setText("");
			taadd.setText("");
			tahis.setText("");
			tacur.setText("");
			tfpno.setText("");
			tfroom.setText("");
			tfdateadd.setText("");
			tfdocname.setText("");
		}
	}


    class back1 implements ActionListener
	 {
		public void actionPerformed(ActionEvent ae)
		{
			new PatientInfomodify();
			jf1.dispose();
		}
	 }
	 
	public void actionPerformed(ActionEvent ae)
	{ num=Integer.parseInt(tfpno.getText());
	  String pano = tfpno.getText(); 
	  if(pano.equals(null))
		{   new ErrorDialog2();
		}
	else {
	jf.dispose();	
    jf1= new JFrame("Modify Patient Information");
	jf1.setSize(1024,768);
	jf1.setVisible(true);
	jf1.setLayout(null);
	
	lmain=new JLabel("Modify Patient Information");
	lmain.setBounds(440,35,200,15);
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
	settings.Numvalidator(tftel);

	lmi=new JLabel("Medical Information");
	lmi.setBounds(40,268,120,15);
	jf1.add(lmi);
	
	lbg=new JLabel("Blood Group :");
	lbg.setBounds(104,306,79,15);
	jf1.add(lbg);

	chbg=new Choice();
	chbg.setBounds(270,306,53,15);
	chbg.addItem("A -ve");
	chbg.addItem("A +ve");
	chbg.addItem("B -ve");
	chbg.addItem("B +ve");
	chbg.addItem("AB -ve");
	chbg.addItem("AB +ve");
	chbg.addItem("O +ve");
	chbg.addItem("O -ve");
	jf1.add(chbg);
	
	ldob=new JLabel("Date of Birth :");
	ldob.setBounds(575,306,135,15);
	jf1.add(ldob);

	tfdob=new JTextField(15);
	tfdob.setBounds(720,305,80,20);
	jf1.add(tfdob);

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
	
	ldateadd=new JLabel("Date Of Admission :");
	ldateadd.setBounds(575,180,120,25);
	jf1.add(ldateadd);

	tfdateadd=new JTextField(40);
	tfdateadd.setBounds(696,180,80,20);
	jf1.add(tfdateadd);

	lgender=new JLabel("Gender :");
	lgender.setBounds(596,223,50,15);
	jf1.add(lgender);

	cbmf=new CheckboxGroup();
	cbm=new Checkbox("Male",cbmf,true);
	cbf=new Checkbox("Female",cbmf,false);
	cbm.setBounds(698,223,50,15);
	jf1.add(cbm);
	cbf.setBounds(760,223,60,15);
	jf1.add(cbf);

	lrtype=new JLabel("Type Of Room : ");
	lrtype.setBounds(104,510,120,25);
	jf1.add(lrtype);

	chrt=new Choice();
	chrt.setBounds(270,510,80,15);
	chrt.addItem("Deluxe");
	chrt.addItem("Private");
	chrt.addItem("Semi-Private");
	chrt.addItem("General");
	jf1.add(chrt);

	ldtip=new JLabel("(dd-mm-yyyy)");
	ldtip.setBounds(810,305,100,20);
	jf1.add(ldtip);

	ldocname=new JLabel("Attending Doctor :");
	ldocname.setBounds(575,510,130,15);
	jf1.add(ldocname);

	tfdocname=new JTextField(100);
	tfdocname.setBounds(720,510,250,20);
	jf1.add(tfdocname);

	ldtip2=new JLabel("(dd-mm-yyyy)");
	ldtip2.setBounds(782,180,100,20);
	jf1.add(ldtip2);

	bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
	bclr.setBounds(340,643,100,30);
	jf1.add(bclr);

	bmod=new JButton("MODIFY",new ImageIcon("images/modify.png"));
	bmod.setBounds(480,643,100,30);
	jf1.add(bmod);

	bback=new JButton("BACK",new ImageIcon("images/restore.png"));
	bback.setBounds(680,643,90,30);
	jf1.add(bback);
		
	try{
	
	Class.forName("com.mysql.jdbc.Driver");
	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pat","root","root");
	}

	catch(Exception e)
		{
			System.out.println(e);
		}	

	   

	   bclr.addActionListener(new clear1());
	   bmod.addActionListener(new modify());
	   bback.addActionListener(new back1());	
		
		try{
	    Integer no=0;
		String name;
		String addr;
		String contact;
		String blgr;
		String hist;
		String dob;
		String current;
		String room;
		String dateadd;
		String rtype;
		String gender;
		String docname;


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
				gender=rs.getString("gender");
				docname=rs.getString("docname");

				tfname.setText(name);
				tftel.setText(contact);
				tfdob.setText(dob);
				taadd.setText(addr);
				tahis.setText(hist);
				tacur.setText(current);
				chbg.select(blgr);
				tfroom.setText(room);
				tfdateadd.setText(dateadd);
				tfdocname.setText(docname);
				chrt.select(rtype);
				if(gender.equals("male"))
				{
					System.out.println(gender);
					cbm.setState(true);
				}
				if(gender.equals("female"))
				{
					System.out.println(gender);
					cbf.setState(true);
				}
				
				
			}
             else
               { 
			    JOptionPane.showMessageDialog(null,"Patient Not Found!");
			    jf1.dispose();
				new PatientInfomodify();
               }			 
	        }
		catch(SQLException sq)
		{
			System.out.println(sq);
		}
	  }	  
	}
	class modify implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{  
			try{
			Integer num1=num;
			if(num1.equals(null))
			{
				throw new BlankException();
			}
            
			String name1=tfname.getText();
			int a=name1.charAt(0);
			if(name1.equals("") || a==32)
			{
				throw new BlankException();
			}
			 for(int i=0; i<name1.length(); i++)
				{
					boolean check = Character.isLetter(name1.charAt(i));
					a=name1.charAt(i);
					System.out.print(a);
					if(!((a>=65 && a<=90) || (a>=97 && a<=122) || (a==32)))
					{
					  throw new NameEx();
					}

				}

			String addr1=taadd.getText();
			if(addr1.equals(null))
			{
				throw new BlankException();
			}
			
			String contact1=tftel.getText();

			String blgr1=chbg.getSelectedItem();

			String hist1=tahis.getText();
	
			String dob1=tfdob.getText();
			if(dob1.equals(null))
			{
				throw new BlankException();
			}

			String current1=tacur.getText();
			if(current1.equals(null))
			{
				throw new BlankException();
			}

			String roomno1=tfroom.getText();

			String dateadd1=tfdateadd.getText();
			if(dateadd1.equals(null))
			{
				throw new BlankException();
			}

			String rtype1=chrt.getSelectedItem();

			String gender1="";

			String docname=tfdocname.getText();

			if(cbm.getState()==true)
				{
					gender1="male";
				}
			if(cbf.getState()==true)
				{
					gender1="female";
				}

			String str="UPDATE PAT SET name=?,addr=?,contact=?,hist=?,bg=?,dob=?,current=?,room=?,dadd=?,rtype=?,gender=?,docname=? WHERE pno=?";
			
			PreparedStatement psmt=cn.prepareStatement(str);
			psmt.setString(1,name1);
			psmt.setString(2,addr1);
			psmt.setString(3,contact1);
			psmt.setString(4,hist1);
			psmt.setString(5,blgr1);
			psmt.setString(6,dob1);
			psmt.setString(7,current1);
			psmt.setString(8,roomno1);
			psmt.setString(9,dateadd1);
			psmt.setString(10,rtype1);
			psmt.setString(11,gender1);
			psmt.setString(12,docname);
			psmt.setInt(13,num1);

			psmt.executeUpdate();
			new SuccessDialog1();

			}
			catch(BlankException be)
			{
				new ErrorDialog2();
			}
			catch(SQLException sq)
				{
					System.out.println(sq);
				}
				catch(NameEx ne)
					{
						new ErrorDialog1();
					}
					
		}
	}
 }

}
