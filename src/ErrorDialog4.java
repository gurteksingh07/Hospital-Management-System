import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog4 
	{
		ErrorDialog4()
		{
		 String message = "Patient Number is invalid.";
		 JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",JOptionPane.ERROR_MESSAGE);
		}

  public static void main(String argv[])
	  {
			new ErrorDialog4();
	  }
}
