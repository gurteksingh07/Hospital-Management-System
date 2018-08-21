import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


class DoctorInfoAdd implements ActionListener
{
	static Connection cn=null;
	Statement st=null;
	ResultSet rs=null;
	
	JLabel lmain,ldi,lname,ladd,ltel,lspecial,ldid,ldspec,lwork,lworkfrom,lworkto,lfee;
	JTextField tfname,tftel,tfdid,tfworkf,tfworkt,tffee;
	TextArea taadd,tacur,taspecial;
	JButton bsub,bclr,bback;
    JFrame jf;
	
	clsSettings settings = new clsSettings();
	
	DoctorInfoAdd()
	{
	jf = new JFrame("Doctor Information");
	jf.setSize(1024,768);
	jf.setVisible(true);
	jf.setLayout(null);

	lmain=new JLabel("Doctor Information");
	lmain.setBounds(440,35,107,15);
	jf.add(lmain);

	ldi=new JLabel("Doctor Information");
	ldi.setBounds(40,70,120,15);
	jf.add(ldi);

	lname=new JLabel("Name :");
	lname.setBounds(104,97,70,25);
	jf.add(lname);

	tfname=new JTextField(30);
	tfname.setBounds(270,97,250,20);
	jf.add(tfname);

	ladd=new JLabel("Address :");
	ladd.setBounds(104,138,70,15);
	jf.add(ladd);

	taadd=new TextArea();
	taadd.setBounds(270,138,250,100);
	jf.add(taadd);

	ltel=new JLabel("Contact :");
	ltel.setBounds(575,138,50,25);
	jf.add(ltel);

	ldid=new JLabel("Doctor ID:");
	ldid.setBounds(570,97,70,25);
	jf.add(ldid);

	tfdid=new JTextField(30);
	tfdid.setBounds(643,97,50,20);
	jf.add(tfdid);

	tftel=new JTextField(30);
	tftel.setBounds(640,138,200,20);
	jf.add(tftel);
	settings.Numvalidator(tftel);

	ldspec=new JLabel("Specialization :");
	ldspec.setBounds(104,310,100,25);
	jf.add(ldspec);

	taspecial=new TextArea();
	taspecial.setBounds(270,310,250,100);
	jf.add(taspecial);

	lwork=new JLabel("Working hours :");
	lwork.setBounds(570,310,100,15);
	jf.add(lwork);

	lworkfrom=new JLabel("From :");
	lworkfrom.setBounds(670,305,37,25);
	jf.add(lworkfrom);

	tfworkf=new JTextField(30);
	tfworkf.setBounds(710,310,30,20);
	jf.add(tfworkf);
	settings.Numvalidator(tfworkf);
	
	lworkto=new JLabel("to :");
	lworkto.setBounds(747,305,20,25);
	jf.add(lworkto);
	
	tfworkt=new JTextField(30);
	tfworkt.setBounds(775,310,30,20);
	jf.add(tfworkt);
    settings.Numvalidator(tfworkt);
      	
	bsub=new JButton("ADD",new ImageIcon("images/add.gif"));
	bsub.setBounds(362,643,100,30);
	jf.add(bsub);	

	bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
	bclr.setBounds(470,643,100,30);
	jf.add(bclr);

	bback=new JButton("BACK",new ImageIcon("images/restore.png"));
	bback.setBounds(580,643,100,30);
	jf.add(bback);

	try{
	
	Class.forName("com.mysql.jdbc.Driver");
	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pat","root","root");
	}

	catch(Exception e)
		{
			System.out.println(e);
		}	

	bclr.addActionListener(new clear());
	bsub.addActionListener(new submit());
	bback.addActionListener(new back());
	}

class clear implements ActionListener
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
		public void actionPerformed(ActionEvent ae)
	{			
		try{
			
		String num=tfdid.getText();
		if(num.equals(null))
			{
				System.out.println("num");
				throw new BlankException();
			}

		String name=tfname.getText();	
		int a;
		a=name.charAt(0);
		if(name.equals("") || a==32)
			{
				throw new BlankException();
			}
		else
			{
				for(int i=0; i<name.length(); i++)
				{
					boolean check = Character.isLetter(name.charAt(i));
					a=name.charAt(i);
					System.out.print("  "+a);
					if(!((a>=65 && a<=90) || (a>=97 && a<=122) || (a==32) || (a==46)))
					{
					  throw new NameEx();
					}
				}
			}

		String addr=taadd.getText();
			if(addr.equals(null))
			{
				System.out.println("addr");
				throw new BlankException();
			}

		String contact=tftel.getText();
		String spec=taspecial.getText();
		String workf=tfworkf.getText();
		String workt=tfworkt.getText();
	
		Statement st=cn.createStatement();	
    	st.executeUpdate("INSERT INTO DOC VALUES('"+num+"','"+name+"','"+addr+"','"+contact+"','"+spec+"','"+workf+"','"+workt+"');");
		new SuccessDialog();		
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

public void actionPerformed(ActionEvent ae)
	{}

	public static void main(String[] args) 
	{
		new DoctorInfoAdd();
	}
}
