package 课设;

import java.awt.Image;
import java.io.Serializable;

public abstract class NPC implements Serializable{
	int x;
	int y;
	int width;
	int height;
	//int triggerwidth;
	//因为图片的外观大小和trigger类中判断是否接触的大小不能一起满足，故设一个专门用来判断是否接触的大小
	//int triggerheight;
	Image img1;//放在地图上图
	Image img2;//触发之后的图
	int state=0;//0是初始，1是正在对话
	public void function(hero h) {
	}
}
