import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EDt 
	{
		EDt()
		{
		 String message ="Enter Valid Date";
		  JOptionPane.showMessageDialog(new JFrame(), message, "Error",JOptionPane.ERROR_MESSAGE);
		}

  public static void main(String argv[])
	  {
			new EDt();
	  }
}
