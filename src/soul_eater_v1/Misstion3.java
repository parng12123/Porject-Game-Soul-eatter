package soul_eater_v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Misstion3 extends JPanel implements ActionListener {
    
    hero chater = new hero ();
    ghost g1 = new ghost();
    ghost3 g11 = new ghost3();
    ghost2 g1n1 = new ghost2();
    ghost4 g4 = new ghost4();
 
    private ImageIcon bg = new ImageIcon(this.getClass().getResource("mission3.png"));
    private ImageIcon gmaeover= new ImageIcon(this.getClass().getResource("youdied.png"));
    private ImageIcon sw = new ImageIcon(this.getClass().getResource("SlashFX.png"));
    private ImageIcon sw1 = new ImageIcon(this.getClass().getResource("SlashFX2.png"));
    private ImageIcon box= new ImageIcon(this.getClass().getResource("box1.png"));
    private ImageIcon stair= new ImageIcon(this.getClass().getResource("stair.png"));
    private ImageIcon zombi= new ImageIcon(this.getClass().getResource("zombies1.png"));
    private ImageIcon youwin = new ImageIcon(this.getClass().getResource("youwin.png"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));
    
    private ArrayList<power_boss> power = new ArrayList<power_boss>();
    private ArrayList<power_boss> power1 = new ArrayList<power_boss>();
    private ArrayList<power_boss> power2 = new ArrayList<power_boss>();
    JButton BExitl = new JButton(exit);
    public boolean walk = true;
    public boolean chackak = false;
    public boolean startball = false;
    public boolean checkonstair = false;
    public boolean chackhpg1 = false;
    public boolean nextlv = false;
    public boolean alive = true;
    public boolean checkunti = false;
    public boolean startpower = false;
    public int checkattack;
    public int score;
    public int checkbacktofront;
    public int chackhight=0;
    public int whatghost=0;
    public int times= 120;
   
    private Timer timer = new Timer(10, new Listener());
    private Timer timercount = new Timer(1000, new Listener());

    Thread actor = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{
                    
                    if(g4.alive==false){
                        nextlv = true;
                    }
                    
                    if(g4.alive == true){
                  
                        if(g4.hp==0){
                            chackhpg1 = true;
                           
                        }
                        if(g4.x<=120){ 
                            g4.back = true;
                        }
                        else if(g4.x >= 500){
                            g4.back = false;
                        }
                        if(g4.back == true){
                            g4.x += 5;
                        }
                        else if(g1.back == false){
                            g4.x -= 5;
                            
                        }

                        g4.distanceP = (int)Math.sqrt((Math.pow(Math.abs(g4.x-chater.x),2))+(Math.pow(Math.abs(g4.y-chater.y),2)));
                        g11.distanceP = (int)Math.sqrt((Math.pow(Math.abs(g11.x-chater.x),2))+(Math.pow(Math.abs(g11.y-chater.y),2)));
                        if(checkonstair == false){
                            
                             
                        }   
                        if(checkbacktofront == 1){
                            
                            if(g4.distanceP <= 100){
                                
                                whatghost =1;
                            }
                            else if(g11.distanceP > 100){
                                whatghost =0;
                            }
                            
                            if(g4.distanceP <= 80){
                                
                                chater.hp-=1;
                            }
                        }
                        
                        else if(checkbacktofront == 0){
                            if(g4.distanceP <= 200){
                                
                                whatghost =1;
                            }
                            else if(g11.distanceP > 100){
                                whatghost =0;
                            }
                            
                            if(g4.distanceP <= 80){
                  
                                chater.hp-=1;
                            }
                        }
                    }
                    if(chater.hp <=0){
                        chater.hp =0;
                        chater.alive = false;
                        
                    }
                    Thread.sleep(25);
                }catch(Exception e){}
                repaint();

            }
        }

    }); 
    Thread timepower = new Thread(new Runnable(){
         public void run() {
             while(true){
                     try{
                         if(startpower == false){
                             Thread.sleep((long)(Math.random()*10000)+1000);
                         }
                         Thread.sleep(1);
                     }catch(InterruptedException e){
                         e.printStackTrace();
                     }
                     if(startpower == false){
                         power.add(new power_boss());
                     }
             }
         }
     });
    Misstion3() {
       this.setFocusable(true);
       this.setLayout(null);
        
       this.addKeyListener(new KeyAdapter(){
           
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(a==KeyEvent.VK_A){
                    checkbacktofront =0;
                    if(checkonstair == true){
                        chater.x = chater.x;
                    }
                    else{
                        chater.x-=10;
                        chater.count++;
                        chater.countak++;
                        walk = false;
                    }
                    
                }
                
                else if(a == KeyEvent.VK_D){
                    checkbacktofront =1;                
                    if(checkonstair == true){
                        chater.x = chater.x;
                    }
                    else{
                        
                        if(chackhight == 1){
                            if(chater.x <= 0){
                                chater.x = 0;
                            }
                            else if(chater.x >= 330){
                                chater.x = 330;
                            }
                        }
                        
                        chater.x+=10;
                        chater.count++;
                        chater.countak++;
                        walk = true;
                    }
                    
                }
                if(a==KeyEvent.VK_W){
                    
                    if(chackhight==0 && chater.x >=250 && chater.x <=270){
                        if(chater.y > 355){
                            checkonstair = true;
                            chater.move();
                        }
                        else if(chater.y <= 355){
                            checkonstair = false;
                            chackhight =1;
                        }
                    }
                    if(chackhight==1 && chater.x >=0 && chater.x <=20){
                        if(chater.y > 100){
                            checkonstair = true;
                            chater.move();
                        }
                        else if(chater.y <= 100){
                            checkonstair = false;
                            chackhight =2;
                        }
                    }
                    chater.count++;
                    chater.countak++;
                    walk = true;
                }
                if(a==KeyEvent.VK_S){

                    if(chackhight ==1 &&chater.x >=250 && chater.x <=270){
                        if(chater.y >= 350 && chater.y < 510){
                            checkonstair = true;
                            chater.Dows();
                        }
                        else if(chater.y >= 510){
                            checkonstair = false;
                            chackhight=0;
                        }
                    }
                    if(chackhight ==2 &&chater.x >=-10 && chater.x <=30){
                        if(chater.y >= 100 && chater.y < 350){
                            checkonstair = true;
                            chater.Dows();
                        }
                        else if(chater.y >= 350){
                            checkonstair = false;
                            chackhight=1;
                        }
                    }
                    chater.count++;
                    chater.countak++;
                    walk = true;
                }
                
                if(chater.count>3){
                    chater.count=0;
                }
                else if(a == KeyEvent.VK_SPACE){
                    
                    if(chackak == false){
                        chackak = true;
                    }
                    chater.count=2;
      
                }
                
                if(chater.countak>3){
                   chater.countak=0;
                }
            }
            public void keyReleased(KeyEvent e){
                chater.count=0;
                g4.distanceP = (int)Math.sqrt((Math.pow(Math.abs(g4.x-chater.x),2))+(Math.pow(Math.abs(g4.y-chater.y),2)));
            }
        });
       
       chater.x = 0;
       actor.start();
       timer.start();
       timercount.start();
       timepower.start();
    }
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timercount){
                if(times != 0){
                    times--;
                } 
            }
            repaint();
        }
    }
     public void actionPerformed(ActionEvent e){
         this.repaint();
     }
     public void  paintComponent(Graphics g){
           super.paintComponent(g);
           g.drawImage(bg.getImage(),0,0,1024,700,this);
           
           g.setColor(Color.WHITE);
           g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));
           g.drawString("score: "+score, 700, 50);    
           g.drawString("Time: "+times, 500, 50);
           g.drawString("Next LV: "+nextlv, 300, 50);
           
           if(walk == true){
               g.drawString("HP: "+chater.hp, chater.x+35, chater.y+30);
               g.drawImage(chater.im[chater.count].getImage(), chater.x, chater.y,110,160, this);
           }
           if(walk == false){
               g.drawString("HP: "+chater.hp, chater.x+35, chater.y+30);
               g.drawImage(chater.bim[chater.count].getImage(), chater.x, chater.y,110,160, this);
           }
           if(walk == true){
               if(chackak == true){
                   g.drawImage(sw.getImage(), chater.x+50, chater.y+20,110,100, this); 
                   if(whatghost ==1){
                       whatghost=0;
                       g4.hp -=chater.ak;
                       if(g4.hp <=0){
                           g4.hp =0;
                           g4.alive = false;
                           score+=10;
                       }
                       
                   }
                   chackak = false;
               }
           }
           else if(walk == false){
               if(chackak == true){
                   g.drawImage(sw1.getImage(), chater.x-50, chater.y+20,110,100, this);
                   
                   if(whatghost == 1){
                       whatghost=0;
                       g4.hp -=chater.ak;
                       if(g4.hp <=0){
                           g4.hp =0;
                           g4.alive = false;
                           score+=10;
                       }
                       
                   }
                   chackak = false;
               }
               
                
           }
           if(chater.x<0){
               chater.x=0;
           }
           if(chater.x>900){
               chater.x=900;
           }
           if(chater.x >=870 && chackhight==2){
               chater.y = 510;
               chater.x = 600;
               chackhight = 0; 
           }
           if(g4.alive == true){
               g.drawString("HP: "+g4.hp, g4.x+50, g4.y+10);
               if(g4.back == true){
                   g.drawImage(g4.im.getImage(), g4.x, g4.y, 250, 250, this); 
               }
               else{
                   g.drawImage(g4.imb.getImage(), g4.x, g4.y, 250, 250, this); 
               }
           }
           //power
           for(int i=0 ; i<power.size();i++){
            g.drawImage( power.get(i).getImage() ,power.get(i).getX(),power.get(i).getY(),90,60,this);
            chater.distanceP = (int)Math.sqrt((Math.pow(Math.abs(chater.x-power.get(i).getX()),2))+(Math.pow(Math.abs(chater.y-power.get(i).getY()),2)));
            
            if(chater.distanceP <= 50){
                power.remove(i);
                chater.hp -= 10;
            }
           }
          if(chater.alive == false || times==0 ){
            this.setLayout(null);
            g.drawImage(gmaeover.getImage(), 0, 0, 1024, 700, this); 
            g.setColor(Color.RED);
            g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 100));
            g.drawString("score: "+score, 300, 400);   
            BExitl.setBounds(350, 400, 300, 300); // edit size
            BExitl.setBorderPainted(false);
            BExitl.setBorder(null);
            BExitl.setOpaque(false);
            BExitl.setContentAreaFilled(false);
            add(BExitl);
            timercount.stop();
          }
          if(nextlv == true){
            if(chater.x >=900 && chater.y==510){
                g.drawImage(youwin.getImage(), 0, 0, 1024, 700, this);
                setLayout(null);
                g.setColor(Color.RED);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 100));
                g.drawString("scorc: "+score, 300, 400);    
                BExitl.setBounds(350, 400, 300, 300); // edit size
                BExitl.setBorderPainted(false);
                BExitl.setBorder(null);
                BExitl.setOpaque(false);
                BExitl.setContentAreaFilled(false);
                add(BExitl);
                timercount.stop();
            }
         }    
     }
}
