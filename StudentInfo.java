import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class StudentInfo extends JFrame {
	private JLabel lblRollNo,lblName,lblPer;
	private JTextField txtRollNo,txtName,txtPer;
	private JButton btnAdd,btnView;
	private JPanel panCenter,panSouth;
	
	private Connection con;
	private PreparedStatement ps;

	public StudentInfo(){
		lblRollNo = new JLabel("Roll No:");
		lblName = new JLabel("Name:");
		lblPer = new JLabel("Percentage:");
		
		txtRollNo = new JTextField();
		txtName = new JTextField();
		txtPer = new JTextField();
		
		panCenter = new JPanel();
		panCenter.setLayout(new GridLayout(3,2));
		panCenter.add(lblRollNo);
		panCenter.add(txtRollNo);
		panCenter.add(lblName);
		panCenter.add(txtName);
		panCenter.add(lblPer);
		panCenter.add(txtPer);
		
		btnAdd = new JButton("Add");
		btnView = new JButton("View");
		
		btnAdd.setMnemonic('A');
		btnView.setMnemonic('V');
		
		btnAdd.setToolTipText("Save student record.");
		btnView.setToolTipText("Display student records in tabular format.");
		
		panSouth = new JPanel();
		panSouth.setLayout(new GridLayout(1,2));
		panSouth.add(btnAdd);
		panSouth.add(btnView);
		
		setTitle("Student Information");
		setSize(300,300);
		setLocation(100,100);
		add(panCenter,BorderLayout.CENTER);
		add(panSouth,BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(
					"jdbc:postgresql:ty1","postgres","");
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			System.exit(0);
		}
		
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try {
					if(txtRollNo.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Roll no cannot be blank.");
						txtRollNo.requestFocus();
						return;
					}

					if(txtName.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Name cannot be blank.");
						txtName.requestFocus();
						return;
					}

					if(txtPer.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Percentage cannot be blank.");
						txtPer.requestFocus();
						return;
					}
					
					int rno = Integer.parseInt(txtRollNo.getText());
					String name = txtName.getText();
					float per = Float.parseFloat(txtPer.getText());
					
					ps = con.prepareStatement("insert into student values(?,?,?)");
					
					ps.setInt(1, rno);
					ps.setString(2, name);
					ps.setFloat(3, per);
					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Student saved successfully.");
					
					txtRollNo.setText("");
					txtName.setText("");
					txtPer.setText("");
					
					txtRollNo.requestFocus();
				} 
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		
		btnView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new ViewAllStudents(con);
			}
		});
	}
	
	
	public static void main(String[] args) {
		new StudentInfo();
	}
}

class ViewAllStudents extends JFrame {
	private Statement s;
	private ResultSet rs;
	
	public ViewAllStudents(Connection con){
		try {
			s = con.createStatement();
			rs = s.executeQuery("select * from student");
			
			Vector rows = new Vector();
			while(rs.next()){
				Vector row = new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getString(2));
				row.add(rs.getFloat(3));
				
				rows.add(row);
			}
			
			Vector colNames = new Vector();
			colNames.add("Roll No");
			colNames.add("Name");
			colNames.add("Percentage");

			setTitle("View All Students");
			setSize(400,300);
			setLocation(200,200);
			add(new JScrollPane(new JTable(rows,colNames)));
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
