import java.awt.*;       
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
 
class PatientTableFromDatabase extends JFrame
{
	static Connection cn=null;
	Statement st=null;
	ResultSet rs=null;

    PatientTableFromDatabase()
    {   super("Patient List");
        Vector columnNames = new Vector();
        Vector data = new Vector();

        try
        {
      
	try{
	
	Class.forName("com.mysql.jdbc.Driver");
	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pat","root","root");
	}

	catch(Exception e)
		{
			System.out.println(e);
		}	
 
            String sql = "Select * from PAT";
			Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
 
            for (int i = 1; i <= columns; i++)
            {
				columnNames.addElement(md.getColumnName(i));
            }
 
            while (rs.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
				row.addElement(rs.getObject(i)); 

                }
 
                data.addElement( row );
            }
        }
        catch(Exception e)
        {
            System.out.println( e );
        }
 
        //  Create table with database data
 
      JTable table = new JTable(data, columnNames);
      JScrollPane scrollPane = new JScrollPane(table);
      getContentPane().add( scrollPane );
 
      JPanel buttonPanel = new JPanel();
      getContentPane().add( buttonPanel, BorderLayout.SOUTH );
    }

 
    public static void main(String[] args)
    {
		PatientTableFromDatabase frame = new PatientTableFromDatabase();
		frame.setDefaultCloseOperation( EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

