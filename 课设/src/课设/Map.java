package ����;

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
	boolean lock=false;
	transient Image image;//image���������л���������Ҫimage����ͼ, 
	transient Image image2;
	NPC[] N=new NPC[10];
	NPC T[]=new NPC[3];
	transient Rectangle[] door=new Rectangle[3];//����Ϊһ���¼��Ĵ�������,һ����ͼ�����3���ţ�ÿ�����������ٶ���һ������Ȼ���׳���ָ���쳣
	//Map[] destination=new Map[3];
}
