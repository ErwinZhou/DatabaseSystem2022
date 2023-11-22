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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CoachFrame extends JFrame{

	//��ʾ�����
	private JLabel TopGoalScores=new JLabel("Top Goal Scorers:");
	private JButton showTopGoalScoresButton=null;
	
    private JTable jTable=null;
    private JScrollPane jScrollPane=null;
    
    private Vector<Vector<Object>> contextList = new Vector<>();
    private Vector<Object> titleList = new Vector<>();
    DefaultTableModel model=null;
    
    private Object defaultData[][] = new Object[100][100];
    private Integer defaultSize=0;//defaultDataSize
    void generateDefaultData(){
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		//��ȡ����
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
		}finally{//�Է���conn close֮ǰ�����쳣�޷��ر�
			JDBCUtils.close(rs, stat, conn);
		}
    }

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
				//�����ݷ�������������
				model.addRow(list);
				dataSize_--;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//�Է���conn close֮ǰ�����쳣�޷��ر�		
			JDBCUtils.close(rs, stat, conn);
		}
	}
    
    //���������ɽ����ť
    public JButton getshowTopGoalScoresButton(){
		if(showTopGoalScoresButton==null){
			showTopGoalScoresButton=new JButton("Show");
			Font f=new Font("Times New Roman",Font.BOLD,13);
			showTopGoalScoresButton.setFont(f);
			showTopGoalScoresButton.setBounds(150,410,80,40);
			showTopGoalScoresButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Integer dataSize=0;
					contextList.clear();
					Vector<Object> newTitleList = new Vector<>();
  					newTitleList.add("name");
  					newTitleList.add("club");
  					newTitleList.add("goal");
  					newTitleList.add("ranking");
  					model.setColumnIdentifiers(newTitleList);
					Connection conn=null;
					Statement stat=null;
					ResultSet rs=null;
					try {
						conn=JDBCUtils.getConnection();
						
						String sql="SELECT * from top_goal_scorers;";
						stat=conn.createStatement();
						rs=stat.executeQuery(sql);
						Object showData[][] =new Object[200][200];
						while(rs.next()){
							String na=rs.getString("name");
							showData[dataSize][0]=na;
							String cl=rs.getString("club");
							showData[dataSize][1]=cl;
							Integer go=rs.getInt("goal");
							showData[dataSize][2]=go;
							Integer ra=rs.getInt("ranking");
							showData[dataSize][3]=ra;
							dataSize++;
						}
						Integer dataSize_=dataSize-1;
						Integer k=0;
						while(k<=dataSize_){
							Vector<Object> list = new Vector<>();
							int j=0;
							while(j<=3){
								list.addElement(showData[k][j]);
								j++;
							}
							//�����ݷ�������������
							model.addRow(list);
							k++;
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
		return showTopGoalScoresButton;
	}

	CoachFrame(){
		setTitle("Premier League Database:Coach");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		TopGoalScores.setBounds(40, 410, 110,40);
		
		titleList.add("name");
		titleList.add("age");
		titleList.add("nationality");
		titleList.add("position");
		titleList.add("transfer_value");
		titleList.add("club");
		
		// ����DefaultTableModeģ�� ������������
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
			//�����ݷ�������������
			model.addRow(list);
			defaultSize_--;
		}
		// �������
		JTable table = new JTable(model);
		// ����table��������
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 30,700,370);
		
		add(TopGoalScores);
		add(getshowTopGoalScoresButton());
		add(scrollPane);
		
		
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
