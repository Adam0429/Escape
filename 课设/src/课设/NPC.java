package ����;

import java.awt.Image;
import java.io.Serializable;

public abstract class NPC implements Serializable{
	int x;
	int y;
	int width;
	int height;
	Image img1;//���ڵ�ͼ��ͼ
	Image img2;//����֮���ͼ
	int state=0;//0�ǳ�ʼ��1�����ڶԻ�
	public abstract void function();
}
