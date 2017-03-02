package 课设;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class hero extends Thread{
	int x=0;
	int y=250;
	int speed=3;
	int jumpspeed=1;
	boolean jumpFlag=true;
	int money;
	Image img;
	Bag bag=new Bag();
	int width;
	int height;
	public boolean left=false,right=false,down=false,up=false; 
	//java.net.URL imgURL1 = hero.class.getResource("1.png");
    //ImageIcon image1 = new ImageIcon(imgURL1);
    //java.net.URL imgURL2 = hero.class.getResource("2.png");
    //ImageIcon image2 = new ImageIcon(imgURL2);
    Image img1 = new ImageIcon(this.getClass().getResource("./1.png")).getImage();
    Image img2 = new ImageIcon(this.getClass().getResource("./2.png")).getImage();
	//ImageIcon icon = new ImageIcon("D:/学习/workspace/课设/src/课设/1.png");
	//Image img1= image1.getImage();
	//ImageIcon icon2 = new ImageIcon("D:/学习/workspace/课设/src/课设/2.png");
	//Image img2= image2.getImage();
    public void run(){ 
    	while(true){
    	if(left){
    		this.x=this.x-speed;
    	}
    	if(right){
    		this.x=this.x+speed;
    	}
    	if(up){  
    		 new Thread(){  
                 public void run(){  
                     jump();  
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
    void step(){
    	Random r=new Random();
		if(r.nextInt(2)==0){
			img=img1;
		}
		else 
			img=img2;
	}
    
	void jump(){
	        for (int i = 0; i <3 ; i++) {  
	           y-=this.jumpspeed;  
	           try {  
	                Thread.sleep(5);  
	           } catch (InterruptedException e) {  
	                e.printStackTrace();  
	           }  
	        }  
	}
}


