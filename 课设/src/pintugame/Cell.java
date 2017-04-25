package pintugame;

import javax.swing.Icon;
import javax.swing.JButton;

public class Cell extends JButton{
	
	public Cell(Icon icon){
		super(icon);
		this.setSize(150, 150);
	}
	
	public Cell(String text,Icon icon){
		super(text,icon);
		this.setSize(150, 150);
		this.setHorizontalTextPosition(CENTER);
		this.setVerticalTextPosition(CENTER);
	}
	public void move(String direction){//direction of move
		switch (direction) {
		case "up":
			this.setLocation(this.getBounds().x, this.getBounds().y-150);
			break;
		case "down":
			this.setLocation(this.getBounds().x, this.getBounds().y+150);
			break;
		case "left":
			this.setLocation(this.getBounds().x-150, this.getBounds().y);
			break;
		case "right":
			this.setLocation(this.getBounds().x+150, this.getBounds().y);
			break;
		default:
			break;
		}
	}
}
