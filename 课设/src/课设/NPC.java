package ����;

import java.awt.Image;
import java.io.Serializable;

public abstract class NPC implements Serializable{
	int x;
	int y;
	Image img1;//���ڵ�ͼ��ͼ
	Image img2;//����֮���ͼ
	boolean uesd;
	public abstract void function();
}
