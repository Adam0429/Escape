package lock;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel{
	int time=0;
	public static JFrame a= new JFrame(); 
	public static Drawing d = new Drawing();
	boolean over = false;
	public static MouseListener mm = new MouseListener(d);
	static int[] number = new int[4];
	public password p = new password();
	Image Box = new ImageIcon(this.getClass().getResource("/picture/Box.png")).getImage();
	public void init()
	{
		a.setTitle("Password");
		a.setSize(1200,750);
		a.setResizable(false);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setLocationRelativeTo(null);
		a.getContentPane().add(d);
		a.addMouseListener(mm);
		a.setVisible(true);	
	}
	public void paint(Graphics g)
	{
		g.drawImage(p.img, p.x, p.y,p.width,p.height, this);
		int i=0;
		int j=time;
		while(i<j)
		{
			g.drawImage(p.a1[i].img, p.a1[i].x, p.a1[i].y ,p.a1[i].width,p.a1[i].height,this);
			i++;
		}
		if(d.time==4)
		{
			boolean s = check();
			if(s)
			{
				g.setFont(new Font("¿¬Ìå", Font.BOLD, 55));
				g.setColor(Color.BLACK);
				g.drawImage(Box,200, 200, 558,202, this);
				g.drawString("Success",400,300);
				System.out.println(true);
				over=false;
			}
			a.setVisible(false);
			
		}
	}
	static boolean check()
	{
		for(int i=0;i<4;i++)
		{
			number[i] = MouseListener.number[i];	
		}
		if(number[0]==1&&number[1]==3&&number[2]==0&&number[3]==3)
		{
			d.over=true;
			return true;
		}
		d.reset(0);
		a.setVisible(false);
		return false;
	}
	void reset(int base)
	{
		for(int i=base;i<4;i++)
		{
			number[i]=0;
			mm.number[i]=0;
		}
		time=base;
		mm.count=base;
	}
}
