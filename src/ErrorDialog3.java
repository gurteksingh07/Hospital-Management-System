import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog3 
	{
		ErrorDialog3()
		{
		 String message = "One of the field is Blank";
		 JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",JOptionPane.ERROR_MESSAGE);
		}

  public static void main(String argv[])
	  {
			new ErrorDialog3();
	  }
}
