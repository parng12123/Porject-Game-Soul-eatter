package soul_eater_v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Misstion1 extends JPanel implements ActionListener {
    
    hero chater = new hero ();
    ghost g1 = new ghost();
    ghost3 g11 = new ghost3();
    ghost2 g1n1 = new ghost2(); 

    private ImageIcon bg = new ImageIcon(this.getClass().getResource("mission1.png"));
    private ImageIcon gmaeover= new ImageIcon(this.getClass().getResource("youdied.png"));
    private ImageIcon sw = new ImageIcon(this.getClass().getResource("SlashFX.png"));
    private ImageIcon sw1 = new ImageIcon(this.getClass().getResource("SlashFX2.png"));
    private ImageIcon box= new ImageIcon(this.getClass().getResource("box1.png"));
    private ImageIcon stair= new ImageIcon(this.getClass().getResource("stair.png"));
    private ImageIcon zombi= new ImageIcon(this.getClass().getResource("zombies1.png"));
    private ImageIcon youwin = new ImageIcon(this.getClass().getResource("youwin.png"));
    private ImageIcon gonext = new ImageIcon(this.getClass().getResource("Next-level.png"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));
    
    JButton nx = new JButton(gonext);
    JButton BExitl = new JButton(exit);
    
    public boolean walk = true;
    public boolean chackak = false;
    public boolean startball = false;
    public boolean timestart = false;
    public boolean checkonstair = false;
    public boolean chackhpg1 = false;
    public boolean nextlv = false;
    public boolean alive = true;
    public boolean checktime = false;
    public int checkattack;
    public int score;
    public int checkbacktofront;
    public int chackhight=0;
    public int whatghost=0;
    public int times =60;

    private Timer timer = new Timer(10, new Listener());
    private Timer timercount = new Timer(1000, new Listener());
    //Thread ghost
    Thread actor = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{
                    if(g1.alive==false && g11.alive==false &&g1n1.alive==false ){
                        nextlv = true;
                    }
                    if(g1.alive == true){
                  
                        if(g1.hp==0){
                            chackhpg1 = true;
                        }
                        if(g1.x<=700){ 
                            g1.back = true;
                        }
                        else if(g1.x >= 900){
                            g1.back = false;
                        }
                        if(g1.back == true){
                            g1.x += 5;
                        }
                        else if(g1.back == false){
                            g1.x -= 5;
                        }

                        g1.distanceP = (int)Math.sqrt((Math.pow(Math.abs(g1.x-chater.x),2))+(Math.pow(Math.abs(g1.y-chater.y),2)));

                        if(checkonstair == false){
                            if(g1.distanceP <= 100){
                                
                                whatghost =1;
                            }
                            else if(g11.distanceP > 100){
                                whatghost =0;
                            }
                  
                        }   
                        if(checkbacktofront == 1){

                            if(g1.distanceP <= 60){
                                g1.x = chater.x+120;
                                chater.hp-=10;
                            }
                        }
                        else if(checkbacktofront == 0){

                            if(g1.distanceP <= 60){
                                g1.x = chater.x-120;
                                chater.hp-=10;
                            }
                        }
                    }
                    if(g11.alive == true){
                        if(g11.hp==0){
                            chackhpg1 = true;
                        }
                        if(g11.x<=0){ 
                            g11.back = true;
                        }
                        else if(g11.x >= 900){
                            g11.back = false;
                        }
                        if(g11.back == true){
                            g11.x += 5;
                        }
                        else if(g11.back == false){
                            g11.x -= 5;
                        }

                        g11.distanceP = (int)Math.sqrt((Math.pow(Math.abs(g11.x-chater.x),2))+(Math.pow(Math.abs(g11.y-chater.y),2)));

                        if(checkonstair == false){
                            if(g11.distanceP <= 100){
                                
                                whatghost =2;
                            }
                            else if(g1.distanceP >100){
                                whatghost =0;
                            }
                             
                        }   
                        if(checkbacktofront == 1){

                            if(g11.distanceP <= 20){
                                g11.x = chater.x+120;
                                chater.hp-=10;
                            }
                        }
                        else if(checkbacktofront == 0){
                            if(g11.distanceP <= 40){
                                g11.x = chater.x-120;
                                chater.hp-=10;
                            }
                        }
                    }
                    //ghost Brown
                    if(g1n1.alive == true){

                        if(g1n1.hp==0){
                            chackhpg1 = true;
                        }
                        if(g1n1.back == false){
                            if(g1n1.x >= 0){
                                g1n1.x= g1n1.x+5;
                            }
                        }
                        else{
                            if(g1n1.x <= 300){
                                g1n1.x= g1n1.x-5;
                            }
                        }   
                        g1n1.distanceP = (int)Math.sqrt((Math.pow(Math.abs(g1n1.x-chater.x),2))+(Math.pow(Math.abs(g1n1.y-chater.y),2)));

                        if(checkonstair == false){
                            if(g1n1.distanceP <= 100){
                                
                                whatghost =3;
                            }
                            else if(g1.distanceP > 100){
                                whatghost =0;
                            }
                             
                        }  
                        if(checkbacktofront == 1){

                            if(g1n1.distanceP <= 20){
                               
                                chater.hp-=2;  
                            }
                        }
                        else if(checkbacktofront == 0){

                            if(g1n1.distanceP <= 40){
                          
                                chater.hp-=2;
                            }
                        }
                        if(g1n1.x >= 300){
                            g1n1.back = true;
                        }
                        if(g1n1.x <= 0){
                            g1n1.back = false;
                        }

                    }
                    if(chater.hp<=0){
                        chater.hp=0;
                        alive = false;
                    }
                    Thread.sleep(50);
                }catch(Exception e){}
                repaint();

            }
        }

    });
    Thread time = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{
                    Thread.sleep(10);
                }catch(Exception e){ }

                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    
    Misstion1() {
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
                
            }
        });
       
       chater.x = 0;
       actor.start();
       time.start();
       timercount.start();
       
    }
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timercount){
                if(times != 0 &&checktime ==true){
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
             
           g.drawImage(box.getImage(),0,410,400,100, this);
           g.drawImage(box.getImage(),0,160,1024,100, this);
           g.drawImage(stair.getImage(),170,400,300,300, this);
           g.drawImage(stair.getImage(),-90,140,300,300, this);
           g.drawImage(stair.getImage(),-90,200,300,310, this);
           g.drawImage(stair.getImage(),-90,220,300,320, this);
           
           g.drawImage(zombi.getImage(),900,140,100,100, this);
           g.drawImage(zombi.getImage(),600,560,100,100, this);
           //Hero walk
           if(walk == true){
               g.drawString("HP: "+chater.hp, chater.x+35, chater.y+30);
               g.drawImage(chater.im[chater.count].getImage(), chater.x, chater.y,110,160, this);
               
           }
           if(walk == false){
               g.drawString("HP: "+chater.hp, chater.x+35, chater.y+30);
               g.drawImage(chater.bim[chater.count].getImage(), chater.x, chater.y,110,160, this);
           
           }
           //Attack
           if(walk == true){
               checktime =true;
               if(chackak == true){
                   g.drawImage(sw.getImage(), chater.x+50, chater.y+20,110,100, this);
                  
                   if(whatghost ==1){
                       
                       g1.hp -=chater.ak;
                       if(g1.hp <=0){
                           g1.hp =0;
                           g1.alive = false;
                           score+=10;
                       }
                       
                       whatghost=0;
                   }
                   else if(whatghost==2){
                       
                       g11.hp -=chater.ak;
                       if(g11.hp <=0){
                           g11.hp =0;
                           g11.alive = false;
                           score+=10;
                       }
                       
                       whatghost=0;
                   }
                   else if(whatghost ==3){
                       
                       g1n1.hp -=chater.ak;
                       if(g1n1.hp <=0){
                           g1n1.hp =0;
                           g1n1.alive = false;
                           score+=10;
                       }
                       
                       whatghost=0;
                   }
                   chackak = false;
               }

           }
           else if(walk == false){
               checktime =true;
               if(chackak == true){
                   g.drawImage(sw1.getImage(), chater.x-50, chater.y+20,110,100, this);
                   chackak = false;
                   if(whatghost == 1){
                       
                       g1.hp -=chater.ak;
                       if(g1.hp <=0){
                           g1.hp =0;
                           g1.alive = false;
                           score+=50;
                       }
                       
                       whatghost=0;
                   }
                   else if(whatghost==2){
                       
                       g11.hp -=chater.ak;
                       if(g11.hp <=0){
                           g11.hp =0;
                           g11.alive = false;
                           score+=50;
                       }
                       
                       whatghost=0;
                   }
                   else if(whatghost ==3){
                       
                       g1n1.hp -=chater.ak;
                       if(g1n1.hp <=0){
                           g1n1.hp =0;
                           g1n1.alive = false;
                           score+=50;
                       }
                       
                       whatghost=0;
                   }
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
           if(g1.alive == true){
               
               g.drawString("HP: "+g1.hp, g1.x+50, g1.y+10);
               if(g1.back == true){
                   g.drawImage(g1.im.getImage(), g1.x, g1.y, 150, 150, this); 
               }
               else{
                   g.drawImage(g1.imb.getImage(), g1.x, g1.y, 150, 150, this); 
               }   
           }
           
           if(g1n1.alive == true){
               g.drawString("HP: "+g1n1.hp, g1n1.x+50, g1n1.y+10);
               if(g1n1.back == true){
                   g.drawImage(g1n1.imb.getImage(), g1n1.x, g1n1.y, 150, 150, this); 
               }
               else{
                   g.drawImage(g1n1.im.getImage(), g1n1.x, g1n1.y, 150, 150, this); 
               }
           }
           if(g11.alive == true){
               g.drawString("HP: "+g11.hp, g11.x+50, g11.y+10);
               if(g11.back == true){
                   g.drawImage(g11.im.getImage(), g11.x, g11.y, 150, 150, this); 
               }
               else{
                   g.drawImage(g11.imb.getImage(), g11.x, g11.y, 150, 150, this); 
               }
           }
          if(alive == false || times==0){
            this.setLayout(null);
            g.drawImage(gmaeover.getImage(), 0, 0, 1024, 700, this);
            g.setColor(Color.RED);
            g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 100));
            g.drawString("score: "+score, 300, 400);   
            setLayout(null);
            BExitl.setBounds(360, 400, 300, 300); 
            BExitl.setBorderPainted(false);
            BExitl.setBorder(null);
            BExitl.setOpaque(false);
            BExitl.setContentAreaFilled(false);
            timercount.stop();
            timer.stop();
            add(BExitl);
            
         }
         if(nextlv == true){
            if(chater.x >=900 && chater.y==510){
                g.drawImage(youwin.getImage(), 0, 0, 1024, 700, this);
                setLayout(null);
                nx.setBounds(370, 400, 300, 300); // edit size
                g.setColor(Color.RED);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 100));
                g.drawString("score: "+score, 300, 400);   
                nx.setBorderPainted(false);
                nx.setBorder(null);
                nx.setOpaque(false);
                nx.setContentAreaFilled(false);
                timercount.stop();
                timer.stop();
                add(nx);
                
            }
         }
         
     }
    

    
    
}
