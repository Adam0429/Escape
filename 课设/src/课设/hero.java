package ����;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;

public class hero extends Thread implements Serializable{
	int x=0;
	int y=400;							
	transient Image img;
	transient Image stateimage = new ImageIcon(this.getClass().getResource("./״̬��.png")).getImage();
	int speed=3;
	int jumpspeed=1;
	int downspeed=2;				
	int floorhigh=400;					//����ĸ߶�
	int jumphigh=350;					//��Ծ�����������
	boolean jumpFlag=false;				//�Ƿ�ﵽ��Ծ����
	int money;  
	Bag bag=new Bag();
	int width=400;
	int height=200;
	public boolean left=false,right=false,down=false,up=false; 
	//java.net.URL imgURL1 = hero.class.getResource("1.png");
    //ImageIcon image1 = new ImageIcon(imgURL1);
    //java.net.URL imgURL2 = hero.class.getResource("2.png");
    //ImageIcon image2 = new ImageIcon(imgURL2);
	transient Image img1 = new ImageIcon(this.getClass().getResource("./1.png")).getImage();
	transient Image img2 = new ImageIcon(this.getClass().getResource("./2.png")).getImage();
	//ImageIcon icon = new ImageIcon("D:/ѧϰ/workspace/����/src/����/1.png");
	//Image img1= image1.getImage();
	//ImageIcon icon2 = new ImageIcon("D:/ѧϰ/workspace/����/src/����/2.png");
	//Image img2= image2.getImage();
    public void run(){ 
    	while(true){
    	if(left){
    		if(hit("left")){
    			this.speed=0;
    		}
    		this.x=this.x-speed;
    	}
    	if(right){
    		this.x=this.x+speed;
    	}
    	if(up){
    		if(!jumpFlag){
    		new Thread(){  
                public void run(){  
                    jump();  
                }  
            }.start();  
    		}
    	}
    	if(down){
   		new Thread(){  
                public void run(){  
                    drop();  
                }  
            }.start();  
        }  
        try {  
            this.sleep(20);  
            } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    	}
    }	
   /* void step(){
    	Random r=new Random();
		if(r.nextInt(2)==0){
			img=img1;
		}
		else 
			img=img2;
	}*/    
	void jump(){
		for (int i = 0; i <3 ; i++) {  			
			y-=this.jumpspeed;
			if(y<=jumphigh){
				jumpFlag=true;
				up=false;
			}
				try {  
	        	Thread.sleep(5);  
	        } catch (InterruptedException e) {  
	        	e.printStackTrace();  
	        }  
	    }  
	}
	
	void drop(){
		for (int i = 0; i <3 ; i++) {  
			y+=this.downspeed;  
			if(y>jumphigh)
				jumpFlag=false;    
			if(y>=floorhigh)
				down=false;
	        try {  
	        	Thread.sleep(5);  
	        } catch (InterruptedException e) {  
	        	e.printStackTrace();  
	        }  
	    }  
	}
	boolean hit(String dir){
		Rectangle r=new Rectangle();
		return false;
	}
}


