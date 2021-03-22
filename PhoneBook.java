import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class PhoneBook extends JFrame{
	private JLabel lblName,lblAddress,lblPhone,lblEmail;
	private JTextField txtName,txtAddress,txtPhone,txtEmail;
	private JButton btnAdd,btnDelete,btnNext,btnPrev;
	
	private Connection con;
	private Statement s;
	private ResultSet rs;

	public PhoneBook(){
		lblName = new JLabel("Name:");
		lblAddress= new JLabel("Address:");
		lblPhone = new JLabel("Phone:");
		lblEmail = new JLabel("Email:");
	
		txtName = new JTextField();
		txtAddress = new JTextField();
		txtPhone = new JTextField();
		txtEmail = new JTextField();

		btnAdd = new JButton("Add");
		btnDelete = new JButton("Delete");
		btnNext = new JButton("Next");
		btnPrev = new JButton("Previous");

		setTitle("Phone Book");
		setSize(400,200);
		setLayout(new GridLayout(4,3));
		add(lblName);
		add(txtName);
		add(btnAdd);
		add(lblAddress);
		add(txtAddress);
		add(btnDelete);
		add(lblPhone);
		add(txtPhone);
		add(btnNext);
		add(lblEmail);
		add(txtEmail);
		add(btnPrev);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql:ty1",
							"postgres","");
		
			s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = s.executeQuery("select * from phone");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			System.exit(0);
		}

		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					String name = txtName.getText();
					String addr = txtAddress.getText();
					long ph = Long.parseLong(txtPhone.getText());
					String email = txtEmail.getText();
			
					if(name.trim().length()==0){
						JOptionPane.showMessageDialog(null,"Name cannot be blank.");
						return;
					}

					if(ph<0){
						JOptionPane.showMessageDialog(null,"Phone no cannot be negative.");
						return;
					}


					rs.moveToInsertRow();
					rs.updateString(1, name);
					rs.updateString(2, addr);
					rs.updateLong(3, ph);
					rs.updateString(4,email);
					rs.insertRow();
					rs.first();

					JOptionPane.showMessageDialog(null,"Record added successfully.");
					clearRow();				
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});

		btnNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					rs.next();
					if(rs.isAfterLast())
						rs.first();
					showRow();
				}			
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});

		btnPrev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					rs.previous();
					if(rs.isBeforeFirst())
						rs.last();
					showRow();
				}			
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});

		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					rs.deleteRow();
					JOptionPane.showMessageDialog(null,"Record deleted successfully.");
					clearRow();
				}			
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});

	}

	public static void main(String args[]){
		new PhoneBook();
	}

	public void clearRow(){
		txtName.setText("");
		txtAddress.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
	}

	public void showRow() throws Exception{
		txtName.setText(rs.getString(1));
		txtAddress.setText(rs.getString(2));
		txtPhone.setText(rs.getString(3));
		txtEmail.setText(rs.getString(4));
	}
}



