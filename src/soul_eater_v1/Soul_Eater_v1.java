package soul_eater_v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class Soul_Eater_v1 extends JFrame implements  ActionListener {
    
    Enterstar enter = new Enterstar();
    Misstion1 m1 = new Misstion1();
    Misstion2 m2 = new Misstion2();
    Misstion3 m3 = new Misstion3();
    Soul_Eater_v1(){
        this.setSize(1024, 700);
        this.add(enter);     
        enter.BExit1.addActionListener(this);
        enter.start.addActionListener(this);
        enter.requestFocusInWindow();
        m1.nx.addActionListener(this);
        m1.BExitl.addActionListener(this);
        m2.nx.addActionListener(this);
        m2.BExitl.addActionListener(this);
        m3.BExitl.addActionListener(this);
    }
    
    
     public static void main(String[] args) {
        JFrame gui = new Soul_Eater_v1();
        gui.setSize(1024,700);
        
        gui.setVisible(true);
        gui.setTitle("Soul Eater");
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
        
        
    }
     
     public void actionPerformed(ActionEvent e) {
        if(e.getSource() == enter.start){
            this.setLocationRelativeTo(null);
            this.remove(enter);
            this.setSize(1024,700);
            this.setTitle("Soul Eater Level 1");
            this.add(m2);
    
            m2.score = m1.score;
            m2.chater.hp =m1.chater.hp;
            m2.times = 60;
            m2.requestFocusInWindow();
        }
        else if(e.getSource() == enter.BExit1){
            System.exit(0);
        }
        else if(e.getSource() == m1.nx){
            this.setLocationRelativeTo(null);
            this.remove(m1);
            this.setSize(1024,700);
            this.setTitle("Soul Eater Level 2");
            this.add(m2);
            m2.score = m1.score;
            m2.chater.hp =m1.chater.hp;
            m2.times = 60;
            m2.requestFocusInWindow();
            
        }
        else if(e.getSource() == m1.BExitl){
            System.exit(0);
        }
        else if(e.getSource() == m2.nx){
            this.setLocationRelativeTo(null);
            this.remove(m2);
            this.setSize(1024,700);
            this.setTitle("Soul Eater Level 3");
            this.add(m3);
            m3.score = m2.score;
            m3.chater.hp =m2.chater.hp;
            m3.times = 60;
            m3.requestFocusInWindow();  
        }
        else if(e.getSource() == m2.BExitl){
            System.exit(0);
        }
        
        else if(e.getSource() == m3.BExitl){
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }

}
    
    
    

