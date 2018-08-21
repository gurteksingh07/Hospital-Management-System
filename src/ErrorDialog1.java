import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog1 
	{
		ErrorDialog1()
		{
		 String message = "Invalid Name";
		 JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",JOptionPane.ERROR_MESSAGE);
		}

  public static void main(String argv[])
	  {
			new ErrorDialog1();
	  }
}
