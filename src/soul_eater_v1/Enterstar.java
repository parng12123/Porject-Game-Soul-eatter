
package soul_eater_v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Enterstar  extends JPanel{
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("win_1.gif"));
    private ImageIcon buttonwallpaper = new ImageIcon(this.getClass().getResource("start.png"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));   
    JButton start = new JButton(buttonwallpaper);
    JButton BExit1  = new JButton(exit);
    Enterstar(){
        setLayout(null);
        start.setBounds(350, 300, 300, 300); 
        start.setBorderPainted(false);
        start.setBorder(null);
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        add(start);
        BExit1.setBounds(350, 450, 300,300);
        BExit1.setBorderPainted(false);
        BExit1.setBorder(null);
        BExit1.setOpaque(false);
        BExit1.setContentAreaFilled(false);
        add(BExit1);

    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1024, 700, this);
        
    }
    
}

