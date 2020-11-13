
package soul_eater_v1;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ghost2 {
    public ImageIcon im = new ImageIcon(this.getClass().getResource("gg2.png"));
    public ImageIcon imb = new ImageIcon(this.getClass().getResource("gg1.png"));
    
    public boolean back = false;
    public boolean alive = true;
    
    public int x = 0;
    public int y = 350;
    public int x1;
    public int y1;
    public int count = 0;
    public int hp = 50;
    public int daman = 10;
    public int distanceP;
    public int distancePm2;
   
    
    ghost2(){
        
        
    }
    ghost2(int m){
        if(m==1){
             this.x = 600;
             this.y = 530;
        }
        else if(m==2){
            this.x=0;
            this.y=100;
        }
    }
}
