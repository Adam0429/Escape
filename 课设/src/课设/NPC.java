package 课设;

import java.awt.Image;
import java.io.Serializable;

public abstract class NPC implements Serializable{
	int x;
	int y;
	Image img1;//放在地图上图
	Image img2;//触发之后的图
	boolean uesd;
	public abstract void function();
}
