import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog2 
	{
		ErrorDialog2()
		{
		 String message = "Please Enter All The Fields";
		 JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",JOptionPane.ERROR_MESSAGE);
		}

  public static void main(String argv[])
	  {
			new ErrorDialog2();
	  }
}
