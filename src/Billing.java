import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.text.*;

class Billing implements ActionListener
{	
	static Connection cn=null;
	Statement st=null;
	ResultSet rs=null;
	
	JLabel lmain,lpname,lpno,ldad,lddis,lrt,ltamt,temp;
	JTextField tfname,tfno,tfdateadd,tfrtype,tftamt;
	JButton bsub,bclr,bback;
	JFrame jf;
  Billing()
   {
    jf = new JFrame("Billing Information");
	jf.setSize(1024,768);
	jf.setVisible(true);
	jf.setLayout(null);

	lmain=new JLabel("Billing Information");
	lmain.setBounds(440,35,140,15);
	jf.add(lmain);

	lpno=new JLabel("Insert Patient Number");
	lpno.setBounds(104,97,150,20);
	jf.add(lpno);
	
	tfno=new JTextField(30);
	tfno.setBounds(250,97,50,20);
	jf.add(tfno);
	
	lpname=new JLabel("Insert Patient Name :");
	lpname.setBounds(104,137,150,20);
	jf.add(lpname);
	
	tfname=new JTextField(30);
	tfname.setBounds(250,137,250,20);
	jf.add(tfname);
	
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
	
	class clear implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
			{
				tfname.setText("");
				tfno.setText("");	
			}
	}

	class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new Start();
			jf.dispose();
		}
	}

class submit implements ActionListener
{   
    JFrame jf1;
	Integer num;
	
	class back1 implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new Billing();
			jf1.dispose();
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{	
	    num=Integer.parseInt(tfno.getText());
		jf.dispose();
		jf1 = new JFrame("Billing Information");
		jf1.setSize(1024,768);
		jf1.setVisible(true);
		jf1.setLayout(null);
		
		lmain=new JLabel("Billing Information");
		lmain.setBounds(440,35,107,15);
		jf1.add(lmain);

		lpname=new JLabel("Patient Name :");
		lpname.setBounds(104,97,85,25);
		jf1.add(lpname);

		tfname=new JTextField(30);
		tfname.setBounds(230,100,225,20);
		jf1.add(tfname);

		ldad=new JLabel("Date of Admission :");
		ldad.setBounds(104,175,120,25);
		jf1.add(ldad);

		tfdateadd=new JTextField(20);
		tfdateadd.setBounds(230,178,80,20);
		jf1.add(tfdateadd);
	
		lddis=new JLabel("Date of Discharge :");
		lddis.setBounds(570,175,120,25);
		jf1.add(lddis);
		
		lrt=new JLabel("Room Type :");
		lrt.setBounds(104,242,70,25);
		jf1.add(lrt);

		tfrtype=new JTextField(20);
		tfrtype.setBounds(230,242,80,20);
		jf1.add(tfrtype);

		ltamt=new JLabel("Total Amount :");
		ltamt.setBounds(104,380,85,25);
		jf1.add(ltamt);

		tftamt=new JTextField(20);
		tftamt.setBounds(230,380,120,20);
		jf1.add(tftamt);
		
		try
		{
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		df.setLenient(false);
        java.util.Date d = new java.util.Date();		
		String dd1=df.format(d.getTime());
		
		temp=new JLabel(dd1);
		temp.setBounds(694,178,80,20);
		jf1.add(temp);

		}
		catch (Exception e)
			{
				new ErrorDialog2();
			}
		
		bback=new JButton("BACK",new ImageIcon("images/restore.png"));
		bback.setBounds(580,643,100,30);
		jf1.add(bback);

	try{
		Class.forName("com.mysql.jdbc.Driver");
	    cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pat","root","root");
	   }

	catch(Exception e)
		{
			System.out.println(e);
		}	

		bback.addActionListener(new back1());
		
		
		try
		{
			Integer no;
			String name,room,dateadd="",rtype;

			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM PAT WHERE pno="+num);

			if(rs.next())
			{
				no=rs.getInt("pno");
				name=rs.getString("name");
				dateadd=rs.getString("dadd");
				rtype=rs.getString("rtype");
								
				tfname.setText(name);
				tfdateadd.setText(dateadd);
				tfrtype.setText(rtype);					
			}
			else
               { 
			    JOptionPane.showMessageDialog(null,"Patient Not Found!");
			    jf1.dispose();
				new Billing();
               }	

			try
			{
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				df.setLenient(false);
				java.util.Date cdate = new java.util.Date();
                String date = df.format(cdate);
				java.util.Date d1= df.parse(date);
				java.util.Date d2= df.parse(dateadd);
				long diff = d2.getTime() - d1.getTime();
		        long days = Math.round((diff/(1000*60*60*24)));
                days = -(days);
				long bill=0;
				String rt=tfrtype.getText();
				if(rt.equals("Deluxe"))
				{
					int m=2000;			
					bill=days*m;
				}
				if(rt.equals("Private"))
				{
					int m=800;			
					bill=days*m;
				}
				if(rt.equals("Semi-Private"))
				{
					int m=600;			
					bill=days*m;
				}
				if(rt.equals("General"))
				{
					int m=400;		
					bill=days*m;
				}

				//Final Bill
				String FinalBill=(new Long(bill)).toString();
				tftamt.setText(FinalBill);

			}

		catch (Exception e)
			{
				System.out.println(e);
			}
		}
		catch (SQLException sq)
		{
			System.out.println(sq);
		}
	}
}

	public static void main(String[] args) 
	{
		new Billing();
	}
}



