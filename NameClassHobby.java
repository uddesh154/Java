import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class NameClassHobby extends JFrame{
	private JLabel lblName,lblClass,lblHobby,lblMsg;
	private JTextField txtName;
	private JRadioButton rbFY,rbSY,rbTY;
	private JCheckBox cbMusic,cbDance,cbSports;
	private ButtonGroup bg;
	private JPanel panNorth,panCenter1,panCenter2,panCenter;

	public NameClassHobby(){
		lblName = new JLabel("Name:");
		txtName = new JTextField();

		panNorth = new JPanel(new GridLayout(1,2));
		panNorth.add(lblName);
		panNorth.add(txtName);

		lblClass = new JLabel("Your Class:");
		bg = new ButtonGroup();
		rbFY = new JRadioButton("FY");
		rbSY = new JRadioButton("SY");
		rbTY = new JRadioButton("TY");
		
		bg.add(rbFY);
		bg.add(rbSY);
		bg.add(rbTY);

		panCenter1 = new JPanel(new GridLayout(4,1));
		panCenter1.add(lblClass);
		panCenter1.add(rbFY);
		panCenter1.add(rbSY);
		panCenter1.add(rbTY);
		
		lblHobby = new JLabel("Your Hobbies:");
		cbMusic = new JCheckBox("Music");
		cbDance = new JCheckBox("Dance");
		cbSports = new JCheckBox("Sports");
	
		panCenter2 = new JPanel(new GridLayout(4,1));
		panCenter2.add(lblHobby);
		panCenter2.add(cbMusic);
		panCenter2.add(cbDance);
		panCenter2.add(cbSports);
			
		panCenter = new JPanel(new GridLayout(1,2));
		panCenter.add(panCenter1);
		panCenter.add(panCenter2);
		
		lblMsg = new JLabel();

		setTitle("Personal Information");
		setSize(300,250);
		add(panNorth,"North");
		add(panCenter,"Center");
		add(lblMsg,"South");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		EventHandler eh = new EventHandler();
		rbFY.addItemListener(eh);
		rbSY.addItemListener(eh);
		rbTY.addItemListener(eh);
		cbMusic.addItemListener(eh);
		cbDance.addItemListener(eh);
		cbSports.addItemListener(eh);
	}

	class EventHandler implements ItemListener{
		public void itemStateChanged(ItemEvent ie){
			String name = txtName.getText();
			String cls="",hobby="";
			if(rbFY.isSelected())
				cls="FY";
			if(rbSY.isSelected())
				cls="SY";
			if(rbTY.isSelected())
				cls="TY";
			if(cbMusic.isSelected())
				hobby=" Music";
			if(cbDance.isSelected())
				hobby+=" Dance";
			if(cbSports.isSelected())
				hobby+=" Sports";
			lblMsg.setText("Name:"+name+",Class:"+cls+",Hobby:"+hobby);
		}
	}
	
	public static void main(String args[]){
		new NameClassHobby();
	}
}
