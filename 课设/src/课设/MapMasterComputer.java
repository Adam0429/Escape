package ����;

import javax.swing.JOptionPane;

import com.sun.swing.internal.plaf.metal.resources.metal_fr;

import lock.*;
public class MapMasterComputer extends NPC {
	MainFrame mainFrame;
	public MapMasterComputer(MainFrame mf){
		x=230;
		y=358;
		width=200;
		height=200;
		mainFrame=mf;
	}
		
	public void function(hero h) {
		new Drawing().d.init();
		mainFrame.Missoin=3;
		JOptionPane.showMessageDialog(null, "�򿪵��ݵ�����");//����1309������¥���ķ���
	}

}
