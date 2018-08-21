import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SuccessDialog 
	{
		SuccessDialog()
		{
		 String message = "Data Added Successfully!";
		 JOptionPane.showMessageDialog(new JFrame(),message,"Done!",JOptionPane.INFORMATION_MESSAGE);
		}

  public static void main(String argv[])
	  {
			new SuccessDialog();
	  }
}
