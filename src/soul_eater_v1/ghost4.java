
package soul_eater_v1;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ghost4 {
    
    public ImageIcon im = new ImageIcon(this.getClass().getResource("g4wgif.gif"));
    public ImageIcon imb = new ImageIcon(this.getClass().getResource("bg4gif.gif"));
    
    public int x = 900;
    public int y = 450;
    public int count = 0;
    public int hp = 150;
    public int daman = 10;
    public int distanceP;
    public boolean alive = true;
    public boolean back = false;
    
    ghost4(){
        
        
    }
    
}
