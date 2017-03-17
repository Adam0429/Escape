package 课设;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Map implements Serializable{
	int x;
	int y;
	int height;
	int width;
	transient Image image;
	transient Rectangle[] door=new Rectangle[3];//门作为一个事件的触发区域,一个地图最多有3个门，每个子类里至少定义一个，不然会抛出空指针异常
	//Map[] destination=new Map[3];
}
