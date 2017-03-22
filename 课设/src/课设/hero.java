package 课设;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;

public class hero extends Thread implements Serializable{
	int x=0;
	int y=400;							
	
	transient Image stateimage = new ImageIcon(this.getClass().getResource("./状态条.png")).getImage();
	int speed=3;
	int jumpspeed=1;
	int downspeed=2;				
	int floorhigh=400;					//地面的高度
	int jumphigh=350;					//跳跃到的最大坐标
	boolean jumpFlag=false;				//是否达到跳跃顶点
	int money;  
	Bag bag=new Bag();
	int width=120;
	int height=160;
	public boolean left=false,right=false,down=false,up=false; 
	//java.net.URL imgURL1 = hero.class.getResource("1.png");
    //ImageIcon image1 = new ImageIcon(imgURL1);
    //java.net.URL imgURL2 = hero.class.getResource("2.png");
    //ImageIcon image2 = new ImageIcon(imgURL2);
	transient Image img = new ImageIcon(this.getClass().getResource("./hero.png")).getImage();
	transient Image imgleft = new ImageIcon(this.getClass().getResource("./heroleft.gif")).getImage();
	transient Image imgright = new ImageIcon(this.getClass().getResource("./heroright.gif")).getImage();
	//public String Dir_Up="Up",Dir_Left="Left",Dir_Right="Right",Dir_Down="Down";
	//ImageIcon icon = new ImageIcon("D:/学习/workspace/课设/src/课设/1.png");
	//Image img1= image1.getImage();
	//ImageIcon icon2 = new ImageIcon("D:/学习/workspace/课设/src/课设/2.png");
	//Image img2= image2.getImage();
    public void run(){ 
    	while(true){
    	if(left){
    		img=imgleft;
    		if(this.x>0)
    			this.x=this.x-speed;
    	}
    	if(right){
    		img=imgright;
    		if(this.x<1120)
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


