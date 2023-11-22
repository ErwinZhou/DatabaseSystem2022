package PLDataBase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.NameList;

public class ManagerFrame extends JFrame{
	
    private JButton SellPlayerButton=null;
    private JButton BuyPlayerButton=null;
    private JButton QueryPlayerButton=null;
    private JButton UpdatePlayerButton=null;
    
    private JLabel NamLabel=new JLabel("name:");
    private JTextField NamTextField = new JTextField();
    
    private JLabel ClubLabel = new JLabel("club:");
    private JTextField ClubTextField = new JTextField();
    
    private JLabel AgeLabel = new JLabel("age:");
    private JTextField AgeTextField = new JTextField();
    
    private JLabel NatLabel = new JLabel("nationality:");
    private JTextField NatTextField = new JTextField();
    
    
    private JLabel ClubLabel1 = new JLabel("club:");
    private JTextField ClubTextField1 = new JTextField();
    
    private JLabel NamLabel1=new JLabel("name:");
    private JTextField NamTextField1 = new JTextField();
    
    private JLabel ClubLabel2 = new JLabel("club:");
    private JTextField ClubTextField2 = new JTextField();
    
    private JLabel ClubLabel3 = new JLabel("club:");
    private JTextField ClubTextField3 = new JTextField();
    
    private JLabel NamLabel2=new JLabel("name:");
    private JTextField NamTextField2 = new JTextField();
    
    private JLabel PosLabel=new JLabel("pos:");
    private JTextField PosTextField = new JTextField();
    
    private JLabel TraLabel=new JLabel("value:");
    private JTextField TraTextField = new JTextField();
    
    private JTable jTable=null;
    private JScrollPane jScrollPane=null;
    
    //存储表格数据的Vector<Vector<Object>>类型变量与表格表头Vector<Object>类型变量
    private Vector<Vector<Object>> contextList = new Vector<>();
    private Vector<Object> titleList = new Vector<>();
    DefaultTableModel model=null;
    
    private Object defaultData[][] = new Object[200][200];
    private Integer defaultSize=0;//defaultDataSize
    
    //表格中默认显示所有球员数据
    void generateDefaultData(){
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		//获取连接
		try {
			conn=JDBCUtils.getConnection();
			String sql="SELECT * from player;";
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				String sn=rs.getString("name");
				defaultData[defaultSize][0]=sn;
				String sa=rs.getString("age");
				defaultData[defaultSize][1]=Integer.parseInt(sa);
				String sna=rs.getString("nationality");
				defaultData[defaultSize][2]=sna;
				String sp=rs.getString("position");
				defaultData[defaultSize][3]=sp;
				String st=rs.getString("transfer_value");
				defaultData[defaultSize][4]=Integer.parseInt(st);
				String sc=rs.getString("club");
				defaultData[defaultSize][5]=sc;
				defaultSize++;
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//以防在conn close之前出现异常无法关闭
			JDBCUtils.close(rs, stat, conn);
		}
    }

    //显示所有球员数据——在插入删除等操作用用于更新刷新界面
    void showPlayer(){
		Integer dataSize=0;
		contextList.clear();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="SELECT * from player;";
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			Object showData[][] =new Object[200][200];
			while(rs.next()){
				String sn=rs.getString("name");
				showData[dataSize][0]=sn;
				Integer ia=rs.getInt("age");
				showData[dataSize][1]=ia;
				String sna=rs.getString("nationality");
				showData[dataSize][2]=sna;
				String sp=rs.getString("position");
				showData[dataSize][3]=sp;
				Integer it=rs.getInt("transfer_value");
				showData[dataSize][4]=it;
				String sc=rs.getString("club");
				showData[dataSize][5]=sc;
				dataSize++;
			}
			Integer dataSize_=dataSize-1;
			while(dataSize_>=0){
				Vector<Object> list = new Vector<>();
				int j=0;
				while(j<=5){
					list.addElement(showData[dataSize_][j]);
					j++;
				}
				//将数据放入数据容器中
				model.addRow(list);
				dataSize_--;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//以防在conn close之前出现异常无法关闭		
			JDBCUtils.close(rs, stat, conn);
		}
	}
    
    //购买球员
	public JButton getBuyPlayerButton(){
		if(BuyPlayerButton==null){
			BuyPlayerButton=new JButton("Buy");
			Font f=new Font("Times New Roman",Font.BOLD,13);
			BuyPlayerButton.setFont(f);
			BuyPlayerButton.setBounds(630,400,80,40);
			BuyPlayerButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Connection conn=null;
					PreparedStatement ps=null;
					ResultSet rs=null;
					try {
						conn=JDBCUtils.getConnection();
						String na=NamTextField.getText();
						NamTextField.setText("");
						String cl=ClubTextField.getText();
						ClubTextField.setText("");
						String ag=AgeTextField.getText();
						AgeTextField.setText("");
						String nat=NatTextField.getText();
						NatTextField.setText("");

						String sql="INSERT INTO player(name,age,nationality,position,transfer_value,club) VALUES(?,?,?,?,?,?);";
						ps=conn.prepareStatement(sql);
						ps.setString(1, na);
						ps.setInt(2, Integer.parseInt(ag));
						ps.setString(3, nat);
						ps.setString(4, "forward");//默认position=forward
						ps.setInt(5, -1);
						ps.setString(6, cl);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Buy successfully!", "Buy successfully", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e1) {
						//若违反了触发器的条件，即输入的俱乐部不存在，则违反触发器，弹出窗口报错
						JOptionPane.showMessageDialog(null,"Violated Trigger:BuyPlayerTrig","Insert failed!", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}finally{//以防在conn close之前出现异常无法关闭
						JDBCUtils.close(rs, ps, conn);
					}
					showPlayer();//刷新界面并显示
				}

			});
		}
		return BuyPlayerButton;
	}
	
	public JButton getSellPlayerButton(){
		if(SellPlayerButton==null){
			SellPlayerButton=new JButton("Sell");
			Font f=new Font("Times New Roman",Font.BOLD,13);
			SellPlayerButton.setFont(f);
			SellPlayerButton.setBounds(370,450,80,40);
			SellPlayerButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Connection conn=null;
					PreparedStatement ps=null;
					ResultSet rs=null;
					try {
						conn=JDBCUtils.getConnection();
						String cl=ClubTextField1.getText();
						ClubTextField1.setText("");
						String na=NamTextField1.getText();
						NamTextField1.setText("");

						String sql="DELETE FROM player where club=? AND name=?;";
						ps=conn.prepareStatement(sql);
						ps.setString(1, cl);
						ps.setString(2, na);
						ps.executeUpdate();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{//以防在conn close之前出现异常无法关闭
						JDBCUtils.close(rs, ps, conn);
					}
					showPlayer();//刷新界面
				}

			});
		}
		return SellPlayerButton;
	}
	
	public JButton getQueryPlayerButton(){
		if(QueryPlayerButton==null){
			QueryPlayerButton=new JButton("Query");
			Font f=new Font("Times New Roman",Font.BOLD,13);
			QueryPlayerButton.setFont(f);
			QueryPlayerButton.setBounds(630,450,80,40);
			QueryPlayerButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Integer dataSize=0;
					contextList.clear();
					Connection conn=null;
					PreparedStatement ps=null;
					ResultSet rs=null;
					try {
						conn=JDBCUtils.getConnection();
						String cl=ClubTextField2.getText();
						ClubTextField2.setText("");
						
						String sql="SELECT * from player where club=?;";
						ps=conn.prepareStatement(sql);
						ps.setString(1, cl);
						rs=ps.executeQuery();
						Object showData[][] =new Object[200][200];
						while(rs.next()){
							String sn=rs.getString("name");
							showData[dataSize][0]=sn;
							Integer ia=rs.getInt("age");
							showData[dataSize][1]=ia;
							String sna=rs.getString("nationality");
							showData[dataSize][2]=sna;
							String sp=rs.getString("position");
							showData[dataSize][3]=sp;
							Integer it=rs.getInt("transfer_value");
							showData[dataSize][4]=it;
							String sc=rs.getString("club");
							showData[dataSize][5]=sc;
							dataSize++;
						}
						Integer dataSize_=dataSize-1;
						while(dataSize_>=0){
							Vector<Object> list = new Vector<>();
							int j=0;
							while(j<=5){
								list.addElement(showData[dataSize_][j]);
								j++;
							}
							//将数据放入数据容器中
							model.addRow(list);
							dataSize_--;
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}finally{//以防在conn close之前出现异常无法关闭
						JDBCUtils.close(rs, ps, conn);
					}
				}

			});
		}
		return QueryPlayerButton;
	}
	
	public JButton getUpdatePlayerButton(){
		if(UpdatePlayerButton==null){
			UpdatePlayerButton=new JButton("Update");
			Font f=new Font("Times New Roman",Font.BOLD,13);
			UpdatePlayerButton.setFont(f);
			UpdatePlayerButton.setBounds(630,500,80,40);
			UpdatePlayerButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Connection conn=null;
					PreparedStatement ps=null;
					CallableStatement cs=null;
					ResultSet rs=null;
					try {
						conn=JDBCUtils.getConnection();
						String cl=ClubTextField3.getText();
						ClubTextField3.setText("");
						String na=NamTextField2.getText();
						NamTextField2.setText("");
						String po=PosTextField.getText();
						PosTextField.setText("");
						String ta=TraTextField.getText();
						TraTextField.setText("");
						
						
						String sql1="CALL UpdatePlayerPosition1(?,?,?);";
						cs=conn.prepareCall(sql1);
						cs.setString(1, cl);
						cs.setString(2, na);
						cs.setString(3, po);
						
						cs.execute();
						
						
						JOptionPane.showMessageDialog(null,"Update successfully!","Update successfully!",JOptionPane.INFORMATION_MESSAGE);
					
						String sql2="UPDATE player SET transfer_value=? WHERE club=? AND name=?;";
						ps=conn.prepareStatement(sql2);
						ps.setString(1, ta);
						ps.setString(2, cl);
						ps.setString(3, na);
						
						ps.executeUpdate();
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Violated Procedure:UpdatePlayerPosition1","Update failed!",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}finally{//以防在conn close之前出现异常无法关闭
						JDBCUtils.close(rs, cs, conn);
						JDBCUtils.close(ps, null);
					}
					showPlayer();
				}

			});
		}
		return UpdatePlayerButton;
	}
	ManagerFrame(){
		setTitle("Premier League Database:Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		
		ClubLabel.setBounds(30, 400,40, 40);
		ClubTextField.setBounds(70,400, 80, 40);
		
		NamLabel.setBounds(170, 400,40, 40);
		NamTextField.setBounds(210,400,100, 40);
		
		AgeLabel.setBounds(330, 400,40, 40);
		AgeTextField.setBounds(370,400, 80, 40);
		
		NatLabel.setBounds(470, 400,80, 40);
		NatTextField.setBounds(530,400, 80, 40);
		
		ClubLabel1.setBounds(30, 450,40, 40);
		ClubTextField1.setBounds(70,450, 80, 40);
		
		NamLabel1.setBounds(170, 450,40, 40);
		NamTextField1.setBounds(210,450,100, 40);
		
		ClubLabel2.setBounds(470, 450,40,40);
		ClubTextField2.setBounds(530,450,80,40);
		
		ClubLabel3.setBounds(30, 500, 40, 40);
		ClubTextField3.setBounds(70, 500, 80, 40);
		
		NamLabel2.setBounds(170,500,40,40);
		NamTextField2.setBounds(210, 500, 100, 40);
		
		PosLabel.setBounds(330, 500, 40, 40);
		PosTextField.setBounds(370, 500, 80, 40);
		
		TraLabel.setBounds(470, 500, 80, 40);
		TraTextField.setBounds(530, 500, 80, 40);
		
		
		titleList.add("name");
		titleList.add("age");
		titleList.add("nationality");
		titleList.add("position");
		titleList.add("transfer_value");
		titleList.add("club");
		
		// 创建DefaultTableMode模型 管理数据容器
		model = new DefaultTableModel(contextList, titleList);
		generateDefaultData();
		Integer defaultSize_=defaultSize-1;
		while(defaultSize_>=0){
			Vector<Object> list = new Vector<>();
			int j=0;
			while(j<=5){
				list.addElement(defaultData[defaultSize_][j]);
				j++;
			}
			//将数据放入数据容器中
			model.addRow(list);
			defaultSize_--;
		}
		// 创建表格
		JTable table = new JTable(model);
		// 创建table滚动窗体
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 30,700, 350);
		
		
		
		
		add(ClubLabel);
		add(ClubTextField);
		add(NamLabel);
		add(NamTextField);
		add(AgeLabel);
		add(AgeTextField);
		add(NatLabel);
		add(NatTextField);
		add(getBuyPlayerButton());
		add(ClubLabel1);
		add(ClubTextField1);
		add(NamLabel1);
		add(NamTextField1);
		add(getSellPlayerButton());
		add(ClubLabel2);
		add(ClubTextField2);
		add(getQueryPlayerButton());
		add(ClubLabel3);
		add(ClubTextField3);
		add(NamLabel2);
		add(NamTextField2);
		add(PosLabel);
		add(PosTextField);
		add(TraLabel);
		add(TraTextField);
		add(getUpdatePlayerButton());
		add(scrollPane);
		
		
		
		
		
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
