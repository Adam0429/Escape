package 课设;

import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JToggleButton;

public class Client {
	JFrame f;
	JTextField tf;
	JTextArea ta;
	JButton b;
	JButton b2;
	JScrollPane qScroller;
	BufferedReader br;
	PrintWriter pw;
	Socket s;
	MainFrame frame;
	public Client(MainFrame Frame){
		frame=Frame;
		f=new JFrame("chatroom");
		tf=new JTextField();
		ta=new JTextArea(10,20);
		b=new JButton("发送");
		b2=new JButton("Help");
		ta.setLineWrap(true);//激活自动换行功能 			
        ta.setWrapStyleWord(true);// 激活断行不断字功能	
        ta.setEditable(false);	
        qScroller = new JScrollPane(ta);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		f.setSize(450, 450);
		f.getContentPane().setLayout(null);
		b.setBounds(270,300,90,30);
		b2.setBounds(50,340,310,30);
		b.addActionListener(new MyButton());
		b2.addActionListener(new MyButton2());
		qScroller.setBounds(50,50,300,230);
		//ta.setBounds(50,50,300,230);	
		tf.setBounds(50,300,200,20);
		f.getContentPane().add(qScroller);
		f.getContentPane().add(tf);
		f.getContentPane().add(b);
		f.getContentPane().add(b2);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public void go(){
		try{
			s=new Socket("139.199.94.77", 8888);//这里是要获取与服务器端口的连接，所以要先运行服务器程序	
			InputStreamReader is=new InputStreamReader(s.getInputStream());			
			br=new BufferedReader(is);
			pw=new PrintWriter(s.getOutputStream());
			Thread readthread=new Thread(new incomingReader());
			readthread.start();
			JOptionPane.showMessageDialog(null, "连接成功！");
			/*
			 * 字节流读取单位为一个字节，字符流读取单位为一个字符 所以读取汉字的时候，如果用字节流就会导致读出来乱码
			 * 所以这里不用stream而用reader。但读进来的是stream所以要用InputStreamReader转换成字符型
			 */
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public class MyButton implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			String string=tf.getText();
			String ip;
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
				pw.println(ip+"说:"+string+"[Client No.1]");
				pw.flush();
				tf.setText("");
				tf.requestFocus();//光标进入这个控件中
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}

		}
	}
	
	public class MyButton2 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			String ip;
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
				pw.println(InetAddress.getLocalHost().getHostAddress()+"说:I need Help!!!");
				pw.flush();
				tf.requestFocus();//光标进入这个控件中
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}

		}
	}
	public class incomingReader implements Runnable{
		public void run() {
			String message;             
	           try {
	             while ((message = br.readLine()) != null) { 
	            	//readline读到换行符才算读到一行,而且还需要flush()或close()。因为输入流缓冲区不满，他是不会接收到数据的
	            	//System.out.println("read " + message);
	                ta.append(message + "\n");
	                int height=15;								//自动换行
	                Point p = new Point();
	                p.setLocation(0,ta.getLineCount()*height);
	                qScroller.getViewport().setViewPosition(p);
	             }
	           }
	           catch(Exception e) {
	        	   e.printStackTrace();
	           }
		}
		
	}
}
