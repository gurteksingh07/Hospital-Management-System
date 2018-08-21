import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SuccessDialog1 
	{
		SuccessDialog1()
		{
		 String message = "Data Modified Successfully!";
		 JOptionPane.showMessageDialog(new JFrame(), message, "Done!",JOptionPane.INFORMATION_MESSAGE);
		}

  public static void main(String argv[])
	  {
			new SuccessDialog1();
	  }
}