package PLDataBase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class choseUserDialog extends JDialog{
	private JButton CoachButton=null;
	private JButton ManagerButton=null;
	private JButton FAButton=null;
	
	private JLabel choseLabel=new JLabel("Please chose your identity as User:");
	public JButton getCoachButton(){
		if(CoachButton==null){
			CoachButton=new JButton("Coach");
			Font f=new Font("Times New Roman",Font.BOLD,15);
			CoachButton.setFont(f);
			CoachButton.setBounds(50, 400, 150, 100);
			CoachButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CoachFrame CF=new CoachFrame();
					dispose();
				}
			});
		}
		return CoachButton;
	}
	public JButton getManagerButton(){
		if(ManagerButton==null){
			ManagerButton=new JButton("Club Manager");
			Font f=new Font("Times New Roman",Font.BOLD,15);
			ManagerButton.setFont(f);
			ManagerButton.setBounds(400,400, 150, 100);
			ManagerButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ManagerFrame MF=new ManagerFrame();
					dispose();
				}
			});
		}
		return ManagerButton;
	}
	public JButton getFAButton(){
		if(FAButton==null){
			FAButton=new JButton("The FA");
			Font f=new Font("Times New Roman",Font.BOLD,15);
			FAButton.setFont(f);
			FAButton.setBounds(225, 250, 150, 100);
			FAButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					FAFrame FF=new FAFrame();
					dispose();
				}
			});
		}
		return FAButton;
	}
	public choseUserDialog(){
		setLayout(null);
		setSize(600,600);
		setTitle("Chose User");
		setLocationRelativeTo(null);//把界面设置在中间
		choseLabel.setBounds(160,100, 300, 100);
		Font f=new Font("Times New Roman",Font.PLAIN,20);
		choseLabel.setFont(f);
		add(choseLabel);
		
		add(getCoachButton());
		add(getManagerButton());
		add(getFAButton());
		setVisible(true);
	}

}
