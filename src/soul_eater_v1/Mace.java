package soul_eater_v1;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Mace {
    
    public ImageIcon mace = new ImageIcon(this.getClass().getResource("s.png"));
    public int y=420;
    public int x=0;
    public int count=0;
    Mace(){
        
    }
    public void move(){
	this.x-=10;
    }
    
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,25,25));
    }
}
