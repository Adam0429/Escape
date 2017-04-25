package pintugame;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class PictureMainFrame extends JFrame{
	//private String[] items={"a","b"};
	public PictureCanvas canvas;
	public JButton start;
	JPanel panel;
	JPanel leftPanel;
	JPanel rightPanel;
	JButton time;
	JButton j;
	public PictureMainFrame(){
		super();
		init();//interface initialize
		addPreviewImage();
		addComponent();//addcomponent
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}

	class mylistener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				canvas.start();
				//canvas.shoutcut();
				
			}
	}
	
	public void addPreviewImage(){
		//create table
		panel =new JPanel();
		panel.setLayout(new GridLayout(1,2));
	
		//puzzle
		canvas = new PictureCanvas();
		canvas.setBorder(new TitledBorder("puzzle"));
		//PicturePreview
		//PicturePreview preview=new PicturePreview();
		//preview.setBorder(new TitledBorder("pintuyulan"));
		panel.add(canvas,BorderLayout.WEST);
		//panel.add(preview,BorderLayout.EAST);
		this.add(panel,BorderLayout.CENTER);
	}

	public void addComponent() {//add component method
		j=new JButton();
		panel=new JPanel();//table(up)
		panel.setBackground(Color.yellow);
		panel.setLayout(new GridLayout(1,2));
		
		leftPanel=new JPanel();
		leftPanel.setBorder(new TitledBorder("button"));
		leftPanel.setBackground(Color.yellow);
		start = new JButton("Start");
		leftPanel.add(start);
		panel.add(leftPanel, BorderLayout.WEST);//right
		start.addActionListener(new mylistener());
		rightPanel=new JPanel();
		rightPanel.setBorder(new TitledBorder("game state"));
		rightPanel.setBackground(Color.yellow);
		time = new JButton("shoutcut");
		rightPanel.add(time);
		panel.add(rightPanel, BorderLayout.EAST);//right
		this.add(panel,BorderLayout.NORTH);
		
		
	}

	public void init() {//interface initialize method
		this.setTitle("puzzle");
		this.setSize(500, 720);
		this.setLocation(150, 10);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


