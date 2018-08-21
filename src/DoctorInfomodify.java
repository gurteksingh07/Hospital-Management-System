import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class DoctorInfomodify implements ActionListener
{
	static Connection cn=null;
	Statement st=null;
	ResultSet rs=null;
	
	JLabel lmain,ldi,lname,ladd,ltel,lspecial,ldid,ldspec,lwork,lworkfrom,lworkto;
	JTextField tfname,tftel,tfdid,tfworkf,tfworkt;
	TextArea taadd,taspecial;
	JButton bsub,bclr,bmod,bback;
    JFrame jf;
	clsSettings settings = new clsSettings();
	
	DoctorInfomodify()
   {
    jf= new JFrame("Modify Doctor Information");
	jf.setSize(1024,768);
	jf.setVisible(true);
	jf.setLayout(null);
	
	lname=new JLabel("Insert Doctor Name :");
	lname.setBounds(104,137,150,20);
	jf.add(lname);

	tfname=new JTextField(30);
	tfname.setBounds(250,137,250,20);
	jf.add(tfname);
   
    ldid=new JLabel("Insert Doctor ID:");
	ldid.setBounds(104,97,150,20);
	jf.add(ldid);

	tfdid=new JTextField(30);
	tfdid.setBounds(250,97,50,20);
	jf.add(tfdid);
	
	bsub=new JButton("SEARCH",new ImageIcon("images/search.png"));
	bsub.setBounds(250,643,110,30);
	jf.add(bsub);	

	bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
	bclr.setBounds(390,643,100,30);
	jf.add(bclr);
	
	bback=new JButton("BACK",new ImageIcon("images/restore.png"));
	bback.setBounds(700,643,100,30);
	jf.add(bback);
	
	bclr.addActionListener(new clear());
	bsub.addActionListener(new submit());
	bback.addActionListener(new back());
	
   }

	public void actionPerformed(ActionEvent ae)
	{}


class clear implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			tfname.setText("");
			tfdid.setText("");		
		}
	}


public static void main(String[] args) 
	{
		new DoctorInfomodify();
		System.out.println("Doctors Info Mod");
	}

class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new docStart();
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
			tfdid.setText("");
			tfworkf.setText("");
			tfworkt.setText("");
			taadd.setText("");
			taspecial.setText("");
			
		}
	}
	
	class back1 implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new DoctorInfomodify();
			jf1.dispose();
		}
	}


	public void actionPerformed(ActionEvent ae)
	{ 
	num=Integer.parseInt(tfdid.getText());
	jf.dispose();
    jf1= new JFrame("Modify Doctor Information");
	jf1.setSize(1024,768);
	jf1.setVisible(true);
	jf1.setLayout(null);

	lmain=new JLabel("Modify Doctor Information");
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
	settings.Numvalidator(tftel);

	ldspec=new JLabel("Specialization :");
	ldspec.setBounds(104,310,100,25);
	jf1.add(ldspec);

	taspecial=new TextArea();
	taspecial.setBounds(270,310,250,100);
	jf1.add(taspecial);

	lwork=new JLabel("Working hours :");
	lwork.setBounds(570,310,100,15);
	jf1.add(lwork);

	lworkfrom=new JLabel("From :");
	lworkfrom.setBounds(670,305,37,25);
	jf1.add(lworkfrom);

	tfworkf=new JTextField(30);
	tfworkf.setBounds(710,310,30,20);
	jf1.add(tfworkf);
	settings.Numvalidator(tfworkf);
	
	lworkto=new JLabel("to :");
	lworkto.setBounds(747,305,20,25);
	jf1.add(lworkto);

	tfworkt=new JTextField(30);
	tfworkt.setBounds(775,310,30,20);
	jf1.add(tfworkt);
	settings.Numvalidator(tfworkt);
	
	bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
	bclr.setBounds(390,643,100,30);
	jf1.add(bclr);

	bmod=new JButton("MODIFY",new ImageIcon("images/modify.png"));
	bmod.setBounds(530,643,100,30);
	jf1.add(bmod);

	bback=new JButton("BACK",new ImageIcon("images/restore.png"));
	bback.setBounds(700,643,100,30);
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
			   new DoctorInfomodify();
             }
		}
		catch(SQLException sq)
		{
			String message = "Enter Valid Doctor ID!!";
			JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",JOptionPane.ERROR_MESSAGE);
			System.out.println(sq);
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
				System.out.println("num");
				throw new BlankException();
			}


			String name1=tfname.getText();
			int a;
			 a=name1.charAt(0);
			if(name1.equals("") || a==32)
				{
					throw new BlankException();
				}
			else
			{
				for(int i=0; i<name1.length(); i++)
				{
					boolean check = Character.isLetter(name1.charAt(i));
					a=name1.charAt(i);
					System.out.print("  "+a);
					if(!((a>=65 && a<=90) || (a>=97 && a<=122) || (a==32) || (a==46)))
					{
					  throw new NameEx();
					}

				}
			}


			String addr1=taadd.getText();
			if(addr1.equals(null))
			{
				System.out.println("addr");
				throw new BlankException();
			}

			String contact1=tftel.getText();


			String spec1=taspecial.getText();
			String workf1=tfworkf.getText();
			String workt1=tfworkt.getText();
		
			String str="UPDATE DOC SET name=?,addr=?,contact=?,spec=?,workf=?,workt=? WHERE id=?";
			
			PreparedStatement psmt=cn.prepareStatement(str);
			psmt.setString(1,name1);
			psmt.setString(2,addr1);
			psmt.setString(3,contact1);
			psmt.setString(4,spec1);
			psmt.setString(5,workf1);
			psmt.setString(6,workt1);
			psmt.setInt(7,num1);
			
			psmt.executeUpdate();

			new SuccessDialog1();
	
	     }
		 catch(SQLException sq)
		{
			String message = "Enter Valid Doctor ID and Contact.";
			JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",
			JOptionPane.ERROR_MESSAGE);
			System.out.println(sq);
		}
		catch(BlankException be)
		{
			new ErrorDialog2();
		}
		catch(NumberFormatException nfe)
		{
			new ErrorDialog();
		}
		catch(NameEx ne)
		{
			new ErrorDialog1();
		}
		catch(Exception e)
		{
			System.out.println(e);
			new EDt();
		}
		
	}
 }
}

}