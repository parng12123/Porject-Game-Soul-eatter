
package soul_eater_v1;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class hero {
    
    public ImageIcon[] im = new ImageIcon[7];
    public ImageIcon[] bim = new ImageIcon[7];
    
    public ImageIcon sw   = new ImageIcon("SlashFX.png");
    public ImageIcon sw1   = new ImageIcon("SlashFX2.png");
    
    public boolean alive = true;
    public int x;
    public int y=510;
    public int hp = 100;
    public int ak =10;
    public int count = 0;
    public int countak =0;
    public int distanceP;
    public int distancePP;
    public int score;
    hero(){
        
        for(int i=0;i<im.length;i++){
            im[i] = new ImageIcon(this.getClass().getResource("w"+(i+1)+".png"));
        }
        
        for(int j=0;j<bim.length;j++){
            bim[j] = new ImageIcon(this.getClass().getResource("b"+(j+1)+".png"));
        }
        
    }
    public void move(){
        this.y-=10;  
    }
    public void Dows(){
        this.y+=10;
    }
    public void setscore(int num){
        this.score +=num;
    }
}
