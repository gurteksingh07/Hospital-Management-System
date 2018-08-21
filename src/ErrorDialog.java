import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog 
	{
		ErrorDialog()
		{
		 String message = "Patient Number and Contact Number Must Contain Digits.";
		 JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",JOptionPane.ERROR_MESSAGE);
		}

  public static void main(String argv[])
	  {
			new ErrorDialog();
	  }
}
