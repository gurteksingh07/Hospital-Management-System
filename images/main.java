import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class  main implements ActionListener
{
    private String username;
    private String password;
    private JFrame jf;
    JButton loginBtn;
    JButton exitBtn;
    int dialogtype = JOptionPane.PLAIN_MESSAGE;
	
    String dialogmessage;
    String dialogs;
    JLabel userLbl,passwordLbl;
    private JTextField userTxt;
    private JPasswordField passwordTxt;
     
    Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
   main()
  {
   jf= new JFrame("Hospital Managment System");
   jf.setLayout(new FlowLayout());
    
   userLbl = new JLabel("Username :");
   userLbl.setBounds(400,200,150,30);
   jf.add(userLbl);
   
   userTxt = new JTextField(20);
   userTxt.setBounds(480,200,200,30);
   jf.add(userTxt);
  
   passwordLbl = new JLabel("Password :");
   passwordLbl.setBounds(400,270,150,30);
   jf.add(passwordLbl);
   
   passwordTxt = new JPasswordField(20);
   passwordTxt.setBounds(480,270,200,30);
   jf.add(passwordTxt);
   
   loginBtn = new JButton("Login", new ImageIcon("images/key.gif"));
   loginBtn.setBounds(520,300,120,30);
   jf.add(loginBtn);
   loginBtn.addActionListener(this);
   
   exitBtn = new JButton("Exit", new ImageIcon("images/Keys.gif"));
   exitBtn.setBounds(600,300,120,30);
   jf.add(exitBtn);
   exitBtn.addActionListener(this);
	
   jf.setSize(800,600);
   jf.setLocation((screen.width - 500)/2,((screen.height-350)/2));	
   jf.setVisible(true);
   jf.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

	}

	public void actionPerformed(ActionEvent event)
     {   Object source = event.getSource(); 
        if(source.equals(loginBtn))
        {
            username = userTxt.getText().trim();
           	password = passwordTxt.getText().trim();
           	 if(username.equals("gurtek") && password.equals("12345"))
					{
					dialogmessage = "Welcome - " +username;
                    dialogtype = JOptionPane.INFORMATION_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                    userTxt.setText("");
						new Start();
						jf.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Invaild User name and Password" , "WARNING!!!",JOptionPane.INFORMATION_MESSAGE);
						userTxt.setText("");
                        passwordTxt.setText("");
					}
						
        } 
        else if(source.equals(exitBtn))
        {
            		System.exit(0);
        }
	}
      
	public static void main(String[] args)
	{
		new main();
	}
}
