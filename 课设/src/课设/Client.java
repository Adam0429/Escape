package ����;

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
		b=new JButton("����");
		b2=new JButton("Help");
		ta.setLineWrap(true);//�����Զ����й��� 			
        ta.setWrapStyleWord(true);// ������в����ֹ���	
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
			s=new Socket("139.199.94.77", 8888);//������Ҫ��ȡ��������˿ڵ����ӣ�����Ҫ�����з���������	
			InputStreamReader is=new InputStreamReader(s.getInputStream());			
			br=new BufferedReader(is);
			pw=new PrintWriter(s.getOutputStream());
			Thread readthread=new Thread(new incomingReader());
			readthread.start();
			JOptionPane.showMessageDialog(null, "���ӳɹ���");
			/*
			 * �ֽ�����ȡ��λΪһ���ֽڣ��ַ�����ȡ��λΪһ���ַ� ���Զ�ȡ���ֵ�ʱ��������ֽ����ͻᵼ�¶���������
			 * �������ﲻ��stream����reader��������������stream����Ҫ��InputStreamReaderת�����ַ���
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
				pw.println(ip+"˵:"+string+"[Client No.1]");
				pw.flush();
				tf.setText("");
				tf.requestFocus();//����������ؼ���
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
				pw.println(InetAddress.getLocalHost().getHostAddress()+"˵:I need Help!!!");
				pw.flush();
				tf.requestFocus();//����������ؼ���
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
	            	//readline�������з��������һ��,���һ���Ҫflush()��close()����Ϊ���������������������ǲ�����յ����ݵ�
	            	//System.out.println("read " + message);
	                ta.append(message + "\n");
	                int height=15;								//�Զ�����
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
