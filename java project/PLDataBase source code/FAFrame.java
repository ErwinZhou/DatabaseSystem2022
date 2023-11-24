package PLDataBase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FAFrame extends JFrame{
	
    private JLabel TraLabel=new JLabel("value:");
    private JTextField TraTextField = new JTextField();
    
    
    //��ѯ������ǩ
    private JLabel MatLabel=new JLabel("match:");
    //��ѯ���б�����ť
    private JButton ShowMatchButton=null;
    
    
    //��ѯ���ֲ���ǩ
    private JLabel ClubLabel=new JLabel("club:");
    //��ѯ���о��ֲ���ť
    private JButton ShowClubButton=null;
    
    //��ѯ������ǩ
    private JLabel CoachLabel=new JLabel("coach:");
    //��ѯ���н�����ť
    private JButton ShowCoachButton=null;
    
    //��ѯ���б�ǩ
    private JLabel RefLabel=new JLabel("referee:");
    //��ѯ���в��а�ť
    private JButton ShowRefButton=null;
    
    
    
    //������ͼ�Ĳ�ѯ��������ʹ����ͼ��ѯ����ǰ����ϸ��Ϣ��ǩfor_info
    private JLabel ForwardInfoLabel=new JLabel("for_info:");
    //��ѯ����ǰ����ϸ��Ϣ��ť
    private JButton ForwardInfoButton=null;
    
    //������ͼ�Ĳ�ѯ��������ʹ����ͼ��ѯ�����г���ϸ��Ϣ��ǩmid_info
    private JLabel MidfielderInfoLabel=new JLabel("mid_info:");
    //��ѯ�����г���ϸ��Ϣ��ť
    private JButton MidfielderInfoButton=null;
    
    //������ͼ�Ĳ�ѯ��������ʹ����ͼ��ѯ���к�����ϸ��Ϣ��ǩmid_info
    private JLabel DefenderInfoLabel=new JLabel("def_info:");
    //��ѯ���к�����ϸ��Ϣ��ť
    private JButton DefenderInfoButton=null;
     
   //������ͼ�Ĳ�ѯ��������ʹ����ͼ��ѯ�����Ž���ϸ��Ϣ��ǩgoa_info
    private JLabel GoalkeeperInfoLabel=new JLabel("goa_info:");
    //��ѯ�����г���ϸ��Ϣ��ť
    private JButton GoalkeeperInfoButton=null;
    
    
    //Ӣ�ھ��ֲ���������Ӣ�����¼���һ�����ֲ���
    private JLabel ClubNameLabel1 = new JLabel("club_name:");
    private JTextField ClubNameTextField1 = new JTextField();
    
    private JLabel AreaLabel = new JLabel("area:");
    private JTextField AreaTextField = new JTextField();
    
    private JLabel HomStaLabel = new JLabel("home_stadium:");
    private JTextField HomStaTextField = new JTextField();
    
    private JButton PromotionButton=null;
    
    //Ӣ�����ֲ���������Ӣ�ڣ�ɾ�����ֲ�������������Ӧ�õ�ɾ��������ɾ���þ��ֲ���������Ա����ʹ���������
    private JLabel ClubNameLabel2 = new JLabel("club_name:");
    private JTextField ClubNameTextField2 = new JTextField();
    
    
    //������ť
    private JButton RelegationButton=null;
    

    private JTable jTable=null;
    private JScrollPane jScrollPane=null;
    
    
  //�洢������ݵ�Vector<Vector<Object>>���ͱ��������ͷVector<Object>���ͱ���
    private Vector<Vector<Object>> contextList = new Vector<>();
    private Vector<Object> titleList = new Vector<>();
    private DefaultTableModel model=null;
    
    private Object defaultData[][] = new Object[200][200];
    private Integer defaultSize=0;//defaultDataSize
    void generateDefaultData(){//Ĭ���������б�������
    	Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
			try {
				conn = JDBCUtils.getConnection();
				String sql="SELECT * FROM `match`;";
				stat=conn.createStatement();
				rs=stat.executeQuery(sql);
				while(rs.next()){
					Timestamp kot=rs.getTimestamp("kick_off_time");
					defaultData[defaultSize][0]=kot;
					String pi=rs.getString("pitch");
					defaultData[defaultSize][1]=pi;
					String re=rs.getString("referee");
					defaultData[defaultSize][2]=re;
					String ht=rs.getString("home_team");
					defaultData[defaultSize][3]=ht;
					String vt=rs.getString("visting_team");
					defaultData[defaultSize][4]=vt;
					defaultSize++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				// �ͷ���Դ
	            JDBCUtils.close(rs,stat,conn);
			}
		
    }
    
  //��ʾ���б���
  	public JButton getShowMatchButton(){
  		if(ShowMatchButton==null){
  			ShowMatchButton=new JButton("Show");
  			Font f=new Font("Times New Roman",Font.BOLD,20);
  			ShowMatchButton.setFont(f);
  			ShowMatchButton.setBounds(130,700,80,40);
  			ShowMatchButton.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					// TODO Auto-generated method stub
  					Integer dataSize=0;
  					contextList.clear();
  					Vector<Object> newTitleList = new Vector<>();
  					newTitleList.add("kick_off_time");
  					newTitleList.add("pitch");
  					newTitleList.add("referee");
  					newTitleList.add("home_team");
  					newTitleList.add("visting_team");
  					model.setColumnIdentifiers(newTitleList);
  	
  					Connection conn=null;
  					Statement stat=null;
  					ResultSet rs=null;
  					//��ȡ����
  						try {
  							conn=JDBCUtils.getConnection();
  							String sql="SELECT * FROM `match`;";
  							stat=conn.createStatement();
  							rs=stat.executeQuery(sql);
  							Object showData[][] =new Object[200][200];
  							while(rs.next()){
  								Timestamp kot=rs.getTimestamp("kick_off_time");
  								showData[dataSize][0]=kot;
  								String pi=rs.getString("pitch");
  								showData[dataSize][1]=pi;
  								String re=rs.getString("referee");
  								showData[dataSize][2]=re;
  								String ht=rs.getString("home_team");
  								showData[dataSize][3]=ht;
  								String vt=rs.getString("visting_team");
  								showData[dataSize][4]=vt;
  								dataSize++;
  							}
  								Integer dataSize_=dataSize-1;
  								while(dataSize_>=0){
  									Vector<Object> list = new Vector<>();
  									int j=0;
  									while(j<=4){
  										list.addElement(showData[dataSize_][j]);
  										j++;
  									}
  									//�����ݷ�������������
  									model.addRow(list);
  									dataSize_--;
  								}
  						} catch (Exception e1) {
  							// TODO Auto-generated catch block
  							e1.printStackTrace();
  						}finally{//�Է���conn close֮ǰ�����쳣�޷��ر�
  							JDBCUtils.close(rs, stat, conn);
  					}
  				}

  			});
  		}
  		return ShowMatchButton;
  	}
  	
  //��ʾ���о��ֲ�
  	public JButton getShowClubButton(){
  		if(ShowClubButton==null){
  			ShowClubButton=new JButton("Show");
  			Font f=new Font("Times New Roman",Font.BOLD,20);
  			ShowClubButton.setFont(f);
  			ShowClubButton.setBounds(320,700,80,40);
  			ShowClubButton.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					Integer dataSize=0;
  					contextList.clear();
  					Vector<Object> newTitleList = new Vector<>();
  					newTitleList.add("name");
  					newTitleList.add("coach");
  					newTitleList.add("rank");
  					newTitleList.add("area");
  					newTitleList.add("points");
  					newTitleList.add("home_stadium");
  					model.setColumnIdentifiers(newTitleList);
  	
  					Connection conn=null;
  					Statement stat=null;
  					ResultSet rs=null;
  					//��ȡ����
  						try {
  							conn=JDBCUtils.getConnection();
  							String sql="SELECT * FROM club;";
  							stat=conn.createStatement();
  							rs=stat.executeQuery(sql);
  							Object showData[][] =new Object[200][200];
  							while(rs.next()){
  								String na=rs.getString("name");
  								showData[dataSize][0]=na;
  								String co=rs.getString("coach");
  								showData[dataSize][1]=co;
  								Integer ra=rs.getInt("rank");
  								showData[dataSize][2]=ra;
  								String ar=rs.getString("area");
  								showData[dataSize][3]=ar;
  								Integer po=rs.getInt("points");
  								showData[dataSize][4]=po;
  								String ho=rs.getString("home_stadium");
  								showData[dataSize][5]=ho;
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
  									//�����ݷ�������������
  									model.addRow(list);
  									dataSize_--;
  								}
  						} catch (Exception e1) {
  							e1.printStackTrace();
  						}finally{//�Է���conn close֮ǰ�����쳣�޷��ر�
  							JDBCUtils.close(rs, stat, conn);
  					}
  				}

  			});
  		}
  		return ShowClubButton;
  	}
  	
  //��ʾ���н���
  	public JButton getShowCoachButton(){
  		if(ShowCoachButton==null){
  			ShowCoachButton=new JButton("Show");
  			Font f=new Font("Times New Roman",Font.BOLD,20);
  			ShowCoachButton.setFont(f);
  			ShowCoachButton.setBounds(525,700,80,40);
  			ShowCoachButton.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					// TODO Auto-generated method stub
  					Integer dataSize=0;
  					contextList.clear();
  					Vector<Object> newTitleList = new Vector<>();
  					newTitleList.add("name");
  					newTitleList.add("club");
  					newTitleList.add("nationality");
  					newTitleList.add("age");
  					model.setColumnIdentifiers(newTitleList);
  	
  					Connection conn=null;
  					Statement stat=null;
  					ResultSet rs=null;
  					//��ȡ����
  						try {
  							conn=JDBCUtils.getConnection();
  							String sql="SELECT * FROM coach;";
  							stat=conn.createStatement();
  							rs=stat.executeQuery(sql);
  							Object showData[][] =new Object[200][200];
  							while(rs.next()){
  								String na=rs.getString("name");
  								showData[dataSize][0]=na;
  								String cl=rs.getString("club");
  								showData[dataSize][1]=cl;
  								String nat=rs.getString("nationality");
  								showData[dataSize][2]=nat;
  								Integer ag=rs.getInt("age");
  								showData[dataSize][3]=ag;
  								dataSize++;
  							}
  								Integer dataSize_=dataSize-1;
  								while(dataSize_>=0){
  									Vector<Object> list = new Vector<>();
  									int j=0;
  									while(j<=3){
  										list.addElement(showData[dataSize_][j]);
  										j++;
  									}
  									//�����ݷ�������������
  									model.addRow(list);
  									dataSize_--;
  								}
  						} catch (Exception e1) {
  							e1.printStackTrace();
  						}finally{//�Է���conn close֮ǰ�����쳣�޷��ر�
  							JDBCUtils.close(rs, stat, conn);
  					}
  				}

  			});
  		}
  		return ShowCoachButton;
  	}
  	
    //��ʾ���в���
  	public JButton getShowRefButton(){
  		if(ShowRefButton==null){
  			ShowRefButton=new JButton("Show");
  			Font f=new Font("Times New Roman",Font.BOLD,20);
  			ShowRefButton.setFont(f);
  			ShowRefButton.setBounds(745,700,80,40);
  			ShowRefButton.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					// TODO Auto-generated method stub
  					Integer dataSize=0;
  					contextList.clear();
  					Vector<Object> newTitleList = new Vector<>();
  					newTitleList.add("name");
  					newTitleList.add("sex");
  					model.setColumnIdentifiers(newTitleList);
  	
  					Connection conn=null;
  					Statement stat=null;
  					ResultSet rs=null;
  					//��ȡ����
  						try {
  							conn=JDBCUtils.getConnection();
  							String sql="SELECT * FROM referee;";
  							stat=conn.createStatement();
  							rs=stat.executeQuery(sql);
  							Object showData[][] =new Object[200][200];
  							while(rs.next()){
  								String na=rs.getString("name");
  								showData[dataSize][0]=na;
  								String se=rs.getString("sex");
  								showData[dataSize][1]=se;
  								dataSize++;
  							}
  								Integer dataSize_=dataSize-1;
  								while(dataSize_>=0){
  									Vector<Object> list = new Vector<>();
  									int j=0;
  									while(j<=1){
  										list.addElement(showData[dataSize_][j]);
  										j++;
  									}
  									//�����ݷ�������������
  									model.addRow(list);
  									dataSize_--;
  								}
  						} catch (Exception e1) {
  							// TODO Auto-generated catch block
  							e1.printStackTrace();
  						}finally{//�Է���conn close֮ǰ�����쳣�޷��ر�
  							JDBCUtils.close(rs, stat, conn);
  					}
  				}

  			});
  		}
  		return ShowRefButton;
  	}
  	
  	public JButton getRelegationReButton(){
		if(RelegationButton==null){
			RelegationButton=new JButton("Relegation");
			Font f=new Font("Times New Roman",Font.BOLD,14);
			RelegationButton.setFont(f);
			RelegationButton.setBounds(260,755,100,40);
			RelegationButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Connection conn=null;
					PreparedStatement ps1=null;
					PreparedStatement ps2=null;
					try {
						conn=JDBCUtils.getConnection();
						conn.setAutoCommit(false);
						String cl=ClubNameTextField2.getText();
						ClubNameTextField2.setText("");
						//ɾ�����1
						String sql1="DELETE FROM club WHERE `name`=?;";
						ps1=conn.prepareStatement(sql1);
						ps1.setString(1, cl);
						//ɾ�����2
						String sq2="DELETE FROM coach WHERE club=?;";
						ps2=conn.prepareStatement(sq2);
						ps2.setString(1, cl);
						//ִ��ɾ�����
						ps1.executeUpdate();
						ps2.executeUpdate();			
						//�ύ����
						conn.commit();
					} catch (Exception e1) {
						//�����쳣���ع�����
						try {
							conn.rollback();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
						e1.printStackTrace();
					}finally{//�Է���conn close֮ǰ�����쳣�޷��ر�
						JDBCUtils.close(ps1, conn);
						JDBCUtils.close(ps2, null);
					}
				}

			});
		}
		return RelegationButton;
	}
  	
    //������ͼ�Ĳ�ѯ����������ѯǰ���������ϸ��Ϣ
  	public JButton getShowForwardInfoButton(){
  		if(ForwardInfoButton==null){
  			ForwardInfoButton=new JButton("Show");
  			Font f=new Font("Times New Roman",Font.BOLD,20);
  			ForwardInfoButton.setFont(f);
  			ForwardInfoButton.setBounds(130,650,80,40);
  			ForwardInfoButton.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					// TODO Auto-generated method stub
  					Integer dataSize=0;
  					contextList.clear();
  					Vector<Object> newTitleList = new Vector<>();
  					newTitleList.add("name");
  					newTitleList.add("club");
  					newTitleList.add("age");
  					newTitleList.add("nationality");
  					newTitleList.add("transfer_value");
  					newTitleList.add("shoot");
  					newTitleList.add("goal");
  					newTitleList.add("assist");
  					newTitleList.add("penalty_kick");
  					model.setColumnIdentifiers(newTitleList);
  					
  					Connection conn=null;
  					Statement stat=null;
  					ResultSet rs=null;
  					//��ȡ����
  						try {
  							conn=JDBCUtils.getConnection();
  							String sql="SELECT * FROM forward_info;";
  							stat=conn.createStatement();
  							rs=stat.executeQuery(sql);
  							Object showData[][] =new Object[200][200];
  							while(rs.next()){
  								String na=rs.getString("name");
  								showData[dataSize][0]=na;
  								String cl=rs.getString("club");
  								showData[dataSize][1]=cl;
  								Integer ag=rs.getInt("age");
  								showData[dataSize][2]=ag;
  								String nat=rs.getString("nationality");
  								showData[dataSize][3]=nat;
  								Integer tra=rs.getInt("transfer_value");
  								showData[dataSize][4]=tra;
  								Integer sh=rs.getInt("shoot");
  								showData[dataSize][5]=sh;
  								Integer go=rs.getInt("goal");
  								showData[dataSize][6]=go;
  								Integer as=rs.getInt("assist");
  								showData[dataSize][7]=as;
  								Integer pen=rs.getInt("penalty_kick");
  								showData[dataSize][8]=pen;
  								dataSize++;
  							}
  								Integer dataSize_=dataSize-1;
  								while(dataSize_>=0){
  									Vector<Object> list = new Vector<>();
  									int j=0;
  									while(j<=8){
  										list.addElement(showData[dataSize_][j]);
  										j++;
  									}
  									//�����ݷ�������������
  									model.addRow(list);
  									dataSize_--;
  								}
  						} catch (Exception e1) {
  							// TODO Auto-generated catch block
  							e1.printStackTrace();
  						}finally{//�Է���conn close֮ǰ�����쳣�޷��ر�
  							JDBCUtils.close(rs, stat, conn);
  					}
  				}

  			});
  		}
  		return ForwardInfoButton;
  	}
  	

  //������ͼ�Ĳ�ѯ����������ѯ�г���������ϸ��Ϣ(��δʵ��)
  	public JButton getMidfielderInfoButton(){
  		if(MidfielderInfoButton==null){
  			MidfielderInfoButton=new JButton("Show");
  			Font f=new Font("Times New Roman",Font.BOLD,20);
  			MidfielderInfoButton.setFont(f);
  			MidfielderInfoButton.setBounds(320,650,80,40);
//  			MidfielderInfoButton.addActionListener(new ActionListener() {
//  				
//  				@Override
//  				public void actionPerformed(ActionEvent e) {
//  					// TODO Auto-generated method stub
//  					Integer dataSize=0;
//  					contextList.clear();
//  					Vector<Object> newTitleList = new Vector<>();
//  					newTitleList.add("name");
//  					newTitleList.add("club");
//  					newTitleList.add("age");
//  					newTitleList.add("nationality");
//  					newTitleList.add("transfer_value");
//  					newTitleList.add("shoot");
//  					newTitleList.add("goal");
//  					newTitleList.add("assist");
//  					newTitleList.add("penalty_kick");
//  					model.setColumnIdentifiers(newTitleList);
//  					
//  					Connection conn=null;
//  					Statement stat=null;
//  					ResultSet rs=null;
//  					//��ȡ����
//  						try {
//  							conn=JDBCUtils.getConnection();
//  							String sql="SELECT * FROM forward_info;";
//  							stat=conn.createStatement();
//  							rs=stat.executeQuery(sql);
//  							Object showData[][] =new Object[200][200];
//  							while(rs.next()){
//  								String na=rs.getString("name");
//  								showData[dataSize][0]=na;
//  								String cl=rs.getString("club");
//  								showData[dataSize][1]=cl;
//  								Integer ag=rs.getInt("age");
//  								showData[dataSize][2]=ag;
//  								String nat=rs.getString("nationality");
//  								showData[dataSize][3]=nat;
//  								Integer tra=rs.getInt("transfer_value");
//  								showData[dataSize][4]=tra;
//  								Integer sh=rs.getInt("shoot");
//  								showData[dataSize][5]=sh;
//  								Integer go=rs.getInt("goal");
//  								showData[dataSize][6]=go;
//  								Integer as=rs.getInt("assist");
//  								showData[dataSize][7]=as;
//  								Integer pen=rs.getInt("penalty_kick");
//  								showData[dataSize][8]=pen;
//  								dataSize++;
//  							}
//  								Integer dataSize_=dataSize-1;
//  								while(dataSize_>=0){
//  									Vector<Object> list = new Vector<>();
//  									int j=0;
//  									while(j<=8){
//  										list.addElement(showData[dataSize_][j]);
//  										j++;
//  									}
//  									//�����ݷ�������������
//  									model.addRow(list);
//  									dataSize_--;
//  								}
//  						} catch (Exception e1) {
//  							// TODO Auto-generated catch block
//  							e1.printStackTrace();
//  						}finally{//�Է���conn close֮ǰ�����쳣�޷��ر�
//  							JDBCUtils.close(rs, stat, conn);
//  					}
//  				}
//
//  			});
  		}
  		return MidfielderInfoButton;
  	}
	
  //������ͼ�Ĳ�ѯ����������ѯ������������ϸ��Ϣ����δʵ�֣�
	public JButton getDefenderInfoButton(){
  		if(DefenderInfoButton==null){
  			DefenderInfoButton=new JButton("Show");
  			Font f=new Font("Times New Roman",Font.BOLD,20);
  			DefenderInfoButton.setFont(f);
  			DefenderInfoButton.setBounds(525,650,80,40);
//  			MidfielderInfoButton.addActionListener(new ActionListener() {
//  				
//  				@Override
//  				public void actionPerformed(ActionEvent e) {
//  					// TODO Auto-generated method stub
//  					Integer dataSize=0;
//  					contextList.clear();
//  					Vector<Object> newTitleList = new Vector<>();
//  					newTitleList.add("name");
//  					newTitleList.add("club");
//  					newTitleList.add("age");
//  					newTitleList.add("nationality");
//  					newTitleList.add("transfer_value");
//  					newTitleList.add("shoot");
//  					newTitleList.add("goal");
//  					newTitleList.add("assist");
//  					newTitleList.add("penalty_kick");
//  					model.setColumnIdentifiers(newTitleList);
//  					
//  					Connection conn=null;
//  					Statement stat=null;
//  					ResultSet rs=null;
//  					//��ȡ����
//  						try {
//  							conn=JDBCUtils.getConnection();
//  							String sql="SELECT * FROM forward_info;";
//  							stat=conn.createStatement();
//  							rs=stat.executeQuery(sql);
//  							Object showData[][] =new Object[200][200];
//  							while(rs.next()){
//  								String na=rs.getString("name");
//  								showData[dataSize][0]=na;
//  								String cl=rs.getString("club");
//  								showData[dataSize][1]=cl;
//  								Integer ag=rs.getInt("age");
//  								showData[dataSize][2]=ag;
//  								String nat=rs.getString("nationality");
//  								showData[dataSize][3]=nat;
//  								Integer tra=rs.getInt("transfer_value");
//  								showData[dataSize][4]=tra;
//  								Integer sh=rs.getInt("shoot");
//  								showData[dataSize][5]=sh;
//  								Integer go=rs.getInt("goal");
//  								showData[dataSize][6]=go;
//  								Integer as=rs.getInt("assist");
//  								showData[dataSize][7]=as;
//  								Integer pen=rs.getInt("penalty_kick");
//  								showData[dataSize][8]=pen;
//  								dataSize++;
//  							}
//  								Integer dataSize_=dataSize-1;
//  								while(dataSize_>=0){
//  									Vector<Object> list = new Vector<>();
//  									int j=0;
//  									while(j<=8){
//  										list.addElement(showData[dataSize_][j]);
//  										j++;
//  									}
//  									//�����ݷ�������������
//  									model.addRow(list);
//  									dataSize_--;
//  								}
//  						} catch (Exception e1) {
//  							// TODO Auto-generated catch block
//  							e1.printStackTrace();
//  						}finally{//�Է���conn close֮ǰ�����쳣�޷��ر�
//  							JDBCUtils.close(rs, stat, conn);
//  					}
//  				}
//
//  			});
  		}
  		return DefenderInfoButton;
  	}
	
	 //������ͼ�Ĳ�ѯ����������ѯ�Ž���������ϸ��Ϣ
  	public JButton getGoalkeeperInfoButton(){
  		if(GoalkeeperInfoButton==null){
  			GoalkeeperInfoButton=new JButton("Show");
  			Font f=new Font("Times New Roman",Font.BOLD,20);
  			GoalkeeperInfoButton.setFont(f);
  			GoalkeeperInfoButton.setBounds(745,650,80,40);
  			GoalkeeperInfoButton.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					// TODO Auto-generated method stub
  					Integer dataSize=0;
  					contextList.clear();
  					Vector<Object> newTitleList = new Vector<>();
  					newTitleList.add("name");
  					newTitleList.add("club");
  					newTitleList.add("age");
  					newTitleList.add("nationality");
  					newTitleList.add("transfer_value");
  					newTitleList.add("save");
  					newTitleList.add("clean_sheets");
  					model.setColumnIdentifiers(newTitleList);
  					
  					Connection conn=null;
  					Statement stat=null;
  					ResultSet rs=null;
  					//��ȡ����
  						try {
  							conn=JDBCUtils.getConnection();
  							String sql="SELECT * FROM goalkeeper_info;";
  							stat=conn.createStatement();
  							rs=stat.executeQuery(sql);
  							Object showData[][] =new Object[200][200];
  							while(rs.next()){
  								String na=rs.getString("name");
  								showData[dataSize][0]=na;
  								String cl=rs.getString("club");
  								showData[dataSize][1]=cl;
  								Integer ag=rs.getInt("age");
  								showData[dataSize][2]=ag;
  								String nat=rs.getString("nationality");
  								showData[dataSize][3]=nat;
  								Integer tra=rs.getInt("transfer_value");
  								showData[dataSize][4]=tra;
  								Integer sa=rs.getInt("save");
  								showData[dataSize][5]=sa;
  								Integer cle=rs.getInt("clean_sheets");
  								showData[dataSize][6]=cle;
  								dataSize++;
  							}
  								Integer dataSize_=dataSize-1;
  								while(dataSize_>=0){
  									Vector<Object> list = new Vector<>();
  									int j=0;
  									while(j<=6){
  										list.addElement(showData[dataSize_][j]);
  										j++;
  									}
  									//�����ݷ�������������
  									model.addRow(list);
  									dataSize_--;
  								}
  						} catch (Exception e1) {
  							e1.printStackTrace();
  						}finally{//�Է���conn close֮ǰ�����쳣�޷��ر�
  							JDBCUtils.close(rs, stat, conn);
  					}
  				}

  			});
  		}
  		return GoalkeeperInfoButton;
  	}
	
	FAFrame(){
		setTitle("Premier League Database:The Football Association");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		MatLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
		MatLabel.setBounds(40, 700, 80, 40);
		ClubLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
		ClubLabel.setBounds(260, 700, 50, 40);
		CoachLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
		CoachLabel.setBounds(450, 700, 65, 40);
		RefLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
		RefLabel.setBounds(655, 700, 70, 40);
		
		ForwardInfoLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
		ForwardInfoLabel.setBounds(40, 640,80, 60);
		MidfielderInfoLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
		MidfielderInfoLabel.setBounds(220, 640, 80, 60);
		DefenderInfoLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
		DefenderInfoLabel.setBounds(430, 640, 80, 60);
		GoalkeeperInfoLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
		GoalkeeperInfoLabel.setBounds(645, 640, 80, 60);
		
//		ClubNameLabel1.setFont(new Font("Times New Roman",Font.BOLD,20));
//		ClubNameLabel1.setBounds(40, 750,100,40);
//		ClubNameTextField1.setBounds(150, 755, 100, 40);
//		ClubNameLabel2.setFont(new Font("Times New Roman",Font.BOLD,20));
//		ClubNameLabel2.setBounds(40, 800, 100, 40);
//		ClubNameTextField2.setBounds(150,805, 100, 40);
		ClubNameLabel2.setFont(new Font("Times New Roman",Font.BOLD,20));
		ClubNameLabel2.setBounds(40, 750, 100, 40);
		ClubNameTextField2.setBounds(150,755, 100, 40);
		
		titleList.add("kick_off_time");
		titleList.add("pitch");
		titleList.add("referee");
		titleList.add("home_team");
		titleList.add("visting_team");
		
		// ����DefaultTableModeģ�� ������������
		model = new DefaultTableModel(contextList, titleList);
		generateDefaultData();
		Integer defaultSize_=defaultSize-1;
		while(defaultSize_>=0){
			Vector<Object> list = new Vector<>();
			int j=0;
			while(j<=4){
				list.addElement(defaultData[defaultSize_][j]);
				j++;
			}
			//�����ݷ�������������
			model.addRow(list);
			defaultSize_--;
		}
		// �������
		JTable table = new JTable(model);
		// ����table��������
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40,30,900,600);
		
		add(MatLabel);
		add(getShowMatchButton());
		add(ClubLabel);
		add(getShowClubButton());
		add(CoachLabel);
		add(getShowCoachButton());
		add(RefLabel);
		add(getShowRefButton());
		
		
		add(ForwardInfoLabel);
		add(getShowForwardInfoButton());
		add(MidfielderInfoLabel);
		add(getMidfielderInfoButton());
		add(DefenderInfoLabel);
		add(getDefenderInfoButton());
		add(GoalkeeperInfoLabel);
		add(getGoalkeeperInfoButton());
//		
//		add(ClubNameLabel1);
//		add(ClubNameTextField1);
		add(ClubNameLabel2);
		add(ClubNameTextField2);
		add(getRelegationReButton());

		add(scrollPane);
		
		
		
		setSize(1000,1000);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}

