import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Telephone extends JFrame{
	private JList lstData;
	private JTextField txtCityName1,txtCityName2,txtCode;
	private JButton btnAdd,btnSearch,btnRemove;
	private TreeMap tm;
	private JScrollPane jsp;

	public Telephone(){
		tm = new TreeMap();

		lstData = new JList();
		jsp = new JScrollPane(lstData);
		txtCityName1 = new JTextField();
		txtCityName2 = new JTextField();
		txtCode = new JTextField(30);

		btnAdd = new JButton("Add");
		btnSearch = new JButton("Search");
		btnRemove = new JButton("Remove");

		jsp.setBounds(10,10,100,200);
		txtCityName1.setBounds(115,10,100,25);
		txtCode.setBounds(220,10,100,25);
		btnAdd.setBounds(175,50,70,25);
		txtCityName2.setBounds(115,100,100,25);
		btnSearch.setBounds(220,100,100,25);
		btnRemove.setBounds(330,100,100,25);
	
		setTitle("Name & STD");
		setSize(500,300);
		setLayout(null);
		add(jsp);
		add(txtCityName1);
		add(txtCode);
		add(txtCityName2);
		add(btnAdd);
		add(btnSearch);
		add(btnRemove);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				tm.put(txtCityName1.getText(),txtCode.getText());
				Vector v = new Vector();
				Set s = tm.keySet();
				for(Object key:s){
					Object val = tm.get(key);
					v.add(key+"  "+val);
				}
				lstData.setListData(v);
				txtCityName1.setText("");
				txtCode.setText("");
			}
		});

		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String k = txtCityName2.getText();
				if(tm.containsKey(k))
					JOptionPane.showMessageDialog(null,"Code:"+tm.get(k));
				else
					JOptionPane.showMessageDialog(null,"City "+k+" not found.");
			}
		});


		btnRemove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String k = txtCityName2.getText();
				tm.remove(k);
				Vector v = new Vector();
				Set s = tm.keySet();
				for(Object key:s){
					Object val = tm.get(key);
					v.add(key+"  "+val);
				}
				lstData.setListData(v); 			}
		});

	}

	public static void main(String args[]){
		new Telephone();
	}
}
