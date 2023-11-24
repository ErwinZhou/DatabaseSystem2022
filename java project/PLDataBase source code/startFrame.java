package PLDataBase;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GoBangFinal.Controllor;

public class startFrame extends JFrame {
	private JButton startButton=null;
	private JButton exitButton=null;
	private JLabel welcomeLabel=new JLabel("Welcome to the best League in the world!");
	private ImageIcon bi=new ImageIcon("src\\PLDataBase\\Premier League1.jpg");
	private JLabel ImageLabel = new JLabel(bi);
	private JButton playMusicButton=null;
	private JButton stopMusicButton=null;
	

	public JButton getStartButton(){
		if(startButton==null){
			startButton=new JButton("Log in");
			Font f=new Font("Times New Roman",Font.BOLD,20);
			startButton.setFont(f);
			startButton.setBounds(150,641,200,100);
			startButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JDialog Dialog=new choseUserDialog();
					dispose();
				}
			});
		}
		return startButton;
	}
	public JButton getExitButton(){
		if(exitButton==null){
			exitButton=new JButton("Exit");
			Font f=new Font("Times New Roman",Font.BOLD,20);
			exitButton.setFont(f);
			exitButton.setBounds(650, 641,200,100);
			exitButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			});
		}
		return exitButton;
	}
	
	public JButton getPlayMusicButton(){
		if(playMusicButton==null){
			playMusicButton=new JButton("Play Music");
			Font f=new Font("Times New Roman",Font.BOLD,15);
			playMusicButton.setFont(f);
			playMusicButton.setBounds(50,50,130,50);
			playMusicButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new BackgroundMusic().start();
				}
			});
		}
		return playMusicButton;
	}
	public JButton getStopMusicButton(){
		if(stopMusicButton==null){
			stopMusicButton=new JButton("Stop Music");
			Font f=new Font("Times New Roman",Font.BOLD,15);
			stopMusicButton.setFont(f);
			stopMusicButton.setBounds(820, 50, 130, 50);
			stopMusicButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					BackgroundMusic.clip.stop();	
				}
			});
			
		}
		return stopMusicButton;
	}
	
	
	startFrame(){
		setSize(1000,791);
		setTitle("Permier League Database");
		setLocationRelativeTo(null);//把界面设置在中间
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeLabel.setBounds(290,50,500,100);
		Font f=new Font("Times New Roman",Font.BOLD+Font.ITALIC,25);
		welcomeLabel.setFont(f);
		add(welcomeLabel);
		ImageLabel.setSize(this.getWidth(),this.getHeight());
		this.getLayeredPane().add(ImageLabel,new Integer(Integer.MIN_VALUE));
		//把窗口面板设为内容面板并设为透明、无布局。
		JPanel pan=(JPanel)this.getContentPane();
		pan.setOpaque(false);
		pan.setLayout(null);
		pan.add(getStartButton());
		pan.add(getExitButton());
		pan.add(getPlayMusicButton());
		pan.add(getStopMusicButton());
		setVisible(true);
	}
		
		
	}
