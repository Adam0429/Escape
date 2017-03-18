package 课设;

import java.awt.Image;
import java.io.Serializable;

public abstract class NPC implements Serializable{
	int x;
	int y;
	int width;
	int height;
	Image img1;//放在地图上图
	Image img2;//触发之后的图
	int state=0;//0是初始，1是正在对话
	public abstract void function();
}
