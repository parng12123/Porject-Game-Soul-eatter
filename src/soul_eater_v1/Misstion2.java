package soul_eater_v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Misstion2 extends JPanel implements ActionListener {
   
    
    hero chater = new hero ();
    Mace mc = new Mace();
    ghost2 glv2 = new ghost2(1);
    ghost2 glv2_1 = new ghost2(2);
    
    private ImageIcon bg = new ImageIcon(this.getClass().getResource("mission2.png"));
    private ImageIcon gmaeover= new ImageIcon(this.getClass().getResource("youdied.png"));
    private ImageIcon sw = new ImageIcon(this.getClass().getResource("SlashFX.png"));
    private ImageIcon sw1 = new ImageIcon(this.getClass().getResource("SlashFX2.png"));
    
    private ImageIcon box= new ImageIcon(this.getClass().getResource("box2.png"));
    private ImageIcon stair= new ImageIcon(this.getClass().getResource("stair.png"));
    private ImageIcon zombi= new ImageIcon(this.getClass().getResource("zombies1.png"));
    private ImageIcon youwin = new ImageIcon(this.getClass().getResource("youwin.png"));
    private ImageIcon gonext = new ImageIcon(this.getClass().getResource("Next-level.png"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("exit.png"));
    
    private ArrayList<Fireball> fireball = new ArrayList<Fireball>();
    
    JButton nx = new JButton(gonext);
    JButton BExitl = new JButton(exit);
    
    public boolean walk = true;
    public boolean chackak = false;
    public boolean startball = false;
    public boolean checkonstair = false;
    public boolean chackhpg1 = false;
    public boolean nextlv = false;
    public boolean alive = true;
    public boolean checktime = false;
    public int checkattack;
    public int score ;
    public int checkbacktofront;
    public int chackhight=0;
    public int whatghost;
    public int times= 120;
    public int r;
    
    public boolean checkballfireout = false;
    

    private Timer timer = new Timer(5, new Listener());
    private Timer timercount = new Timer(1000, new Listener());
    
    Thread actor = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{
                    if(glv2.alive == false && glv2_1.alive ==false){
                        nextlv=true;
                    }
                    if(glv2.alive == true){
                  
                        if(glv2.hp==0){
                            chackhpg1 = true;
                            
                        }
                        if(glv2.x<=600){ 
                            glv2.back = true;
                        }
                        else if(glv2.x >= 900){
                            glv2.back = false;
                        }
                        if(glv2.back == true){
                            glv2.x += 5;
                        }
                        else if(glv2.back == false){
                            glv2.x -= 5;
                        }  
                        glv2.distanceP = (int)Math.sqrt((Math.pow(Math.abs(glv2.x-chater.x),2))+(Math.pow(Math.abs(glv2.y-chater.y),2)));

                        if(checkonstair == false){
                            if(glv2.distanceP <= 100){
                                
                                whatghost =3;
                            }
                            else if(glv2.distanceP > 100){
                                whatghost =0;
                            }
                        }  
                        if(checkbacktofront == 1){

                            if(glv2.distanceP <= 20){
                               
                                chater.hp-=10;  
                            }
                        }
                        else if(checkbacktofront == 0){

                            if(glv2.distanceP <= 40){
                                
                                chater.hp-=10;
                            }
                        }
                    }
                    if(glv2_1.alive == true){

                        if(glv2_1.hp==0){
                            chackhpg1 = true;
                            
                        }
                        if(glv2_1.x<=0){ 
                            glv2_1.back = true;
                        }
                        else if(glv2_1.x >= 410){
                            glv2_1.back = false;
                        }
                        if(glv2_1.back == true){
                            glv2_1.x += 5;
                        }
                        else if(glv2_1.back == false){
                            glv2_1.x -= 5;
                        }   
                        glv2_1.distanceP = (int)Math.sqrt((Math.pow(Math.abs(glv2_1.x-chater.x),2))+(Math.pow(Math.abs(glv2_1.y-chater.y),2)));

                        if(checkonstair == false){
                            if(glv2_1.distanceP <= 100){
       
                                whatghost =2;
                            }
                            else if(glv2.distanceP > 100){
                                whatghost =0;
                            }
                            else{
                
                            } 
                        }  
                        if(checkbacktofront == 1){

                            if(glv2_1.distanceP <= 20){
                                //g1n1.x = chater.x+120;
                                chater.hp-=2;  
                            }
                        }
                        else if(checkbacktofront == 0){

                            if(glv2_1.distanceP <= 40){
                                //g1n1.x = chater.x-120;
                                chater.hp-=2;
                            }
                        }
                    }
                    if(chater.hp <=0){
                        chater.hp =0;
                        chater.alive = false;
                        
                    }
                    Thread.sleep(100);
                }catch(Exception e){}
                repaint();

            }
        }

    });
    
    
    Thread ball = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{
                    if(checkballfireout == false){
                        fireball.add(new Fireball(mc.x+50,mc.y));
                        checkballfireout = true;
                    }
                    
                    Thread.sleep(100);
                }catch(Exception e){ }
    }
        }
    });
    
    Misstion2() {
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
                            else if(chater.x >= 900){
                                chater.x = 900;
                            }
                        }
                        if(chackhight == 2){
                            if(chater.x <= 0){
                                chater.x = 0;
                            }
                            else if(chater.x >= 430){
                                chater.x = 430;
                            }
                        }
                        chater.x+=10;
                        chater.count++;
                        chater.countak++;
                        walk = true;
                    }
                    
                }
                if(a==KeyEvent.VK_W){
                    
                    if(chackhight==0 && chater.x >=710 && chater.x <=760){
                        if(chater.y > 360){
                            checkonstair = true;
                            chater.move();
                        }
                        else if(chater.y <= 360){
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

                    if(chackhight ==1 &&chater.x >=710 && chater.x <=760){
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
                
                
            }
        });
       
       chater.x = 0;
       
       
      
       actor.start();
       timercount.start();
       timer.start();
       ball.start();
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
           g.drawString("chater.dispp: "+chater.distancePP, 300, 50);
           g.drawImage(box.getImage(),0,160,500,100, this);
           g.drawImage(box.getImage(),0,420,1024,100, this);
           g.drawImage(stair.getImage(),650,400,300,300, this);
           g.drawImage(mc.mace.getImage(), 0, 420,100,80, this);
           g.drawImage(zombi.getImage(),900,400,100,100, this);
           g.drawImage(zombi.getImage(),400,140,100,100, this);  
           
           if(walk == true){
               g.drawString("HP: "+chater.hp, chater.x+35, chater.y+30);
               g.drawImage(chater.im[chater.count].getImage(), chater.x, chater.y,110,160, this);
           }
           if(walk == false){
               g.drawString("HP: "+chater.hp, chater.x+35, chater.y+30);
               g.drawImage(chater.bim[chater.count].getImage(), chater.x, chater.y,110,160, this);
            
           }
           if(walk == true){
               checktime =true;
               if(chackak == true){
                   g.drawImage(sw.getImage(), chater.x+50, chater.y+20,110,100, this);

                   if(whatghost==2){
                      glv2_1.hp -=chater.ak;
                       if(glv2_1.hp <=0){
                           glv2_1.hp =0;
                           glv2_1.alive = false;
                           score =score+10;
                           
                       }
                       
                       whatghost=0;
                   }
                   else if(whatghost ==3){
                       glv2.hp -=chater.ak;
                       if(glv2.hp <=0){
                           glv2.hp =0;
                           glv2.alive = false;
                           score =score+10;
                           
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
                   
                   if(whatghost==2){
                       glv2_1.hp -=chater.ak;
                       if(glv2_1.hp <=0){
                           glv2_1.hp =0;
                           glv2_1.alive = false;
                           score =score+10;
                       }
                       whatghost=0;
                   }
                   else if(whatghost ==3){
                     glv2.hp -=chater.ak;
                       if(glv2.hp <=0){
                           glv2.hp =0;
                           glv2.alive = false;
                           score =score+10;
                       }
                       whatghost=0;
                   }
                   chackak = false;
               }
               else if(chackak == false){
                  
                   
                }
               
           }
           
           if(chater.x<0){
                    
                    chater.x=0;
   		}
   		if(chater.x>900){
                    chater.x=900;
                   
                    
   		}
           if(chater.x >=900 && chackhight==1){
               
              chater.y = 100;
              chater.x = 390;
              chackhight = 2;
              
           }
           if(chater.x >=410 && chackhight==2){
               
              chater.y = 360;
              chater.x = 890;
              chackhight = 1;
              
           }
           
           ///
          for(int i=0;i<fireball.size();i++){
              
              Fireball ball = fireball.get(i);  
              g.drawImage(ball.imfire[ball.count%5].getImage(), (ball.x-r),(ball.y+400-r),50,50, null);
              ball.x++;
              ball.y = (int) (50 * Math.sin(Math.toDegrees(ball.x/20)));
              ball.move();
              ball.count++;
              chater.distancePP = (int)Math.sqrt((Math.pow(Math.abs(chater.x-ball.x),2))+(Math.pow(Math.abs(chater.y-ball.y),2)));
                if(chater.distancePP <= 360){
                    chater.hp-=10;
                    fireball.remove(i);
                    checkballfireout = false;
                }
              
              if(ball.x>900){
                fireball.remove(i);
                checkballfireout = false;
              } 
          }           
          if(glv2.alive == true){
               
               g.drawString("HP: "+glv2.hp, glv2.x+50, glv2.y-10);
               if(glv2.back == true){
                   g.drawImage(glv2.im.getImage(), glv2.x, glv2.y-10, 150, 150, this); 
               }
               else{
                   g.drawImage(glv2.imb.getImage(), glv2.x, glv2.y-10, 150, 150, this); 
               }   
           }
          if(glv2_1.alive == true){
               
               g.drawString("HP: "+glv2_1.hp, glv2_1.x+50, glv2_1.y+10);
               if(glv2_1.back == true){
                   g.drawImage(glv2_1.im.getImage(), glv2_1.x, glv2_1.y+10, 150, 150, this); 
               }
               else{
                   g.drawImage(glv2_1.imb.getImage(), glv2_1.x, glv2_1.y+10, 150, 150, this); 
               }   
           }
          if(chater.alive == false || times==0){
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
            timercount.stop();
            timer.stop();
            add(BExitl);
            
         }
          
         if(nextlv == true){
            if(chater.x >=900 && chater.y==510){
                g.drawImage(youwin.getImage(), 0, 0, 1024, 700, this);
                setLayout(null);
                nx.setBounds(370, 400, 300, 300); // edit sizeg.setColor(Color.RED);
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
