/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.codideep.app.async;

import static java.lang.Thread.sleep;
import com.codideep.app.global.Global;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// Importaciones necesarias para la reproducción de música
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProcessEat implements Runnable {
     JPanel panelGamer;
     JPanel panelEat;
     JPanel panelContainer;
     JLabel lblTime;
     JLabel Puntos;
     JLabel Muertes;
    
       
    private int x = 0, y = 0, width = 0, height = 0;
    private int minRandX = 0, maxRandX = 0, minRandY = 0, maxRandY = 0;
    private int positionX = 0, positionY;
    private int puntos;
    private int collisionCount = 0; 
     Point originalPosition; 
    
     Random random;
    private long currentTime;
     List<JPanel> wormSegments; 
     int segmentSize = 25; 
    
   
    public ProcessEat(JPanel panelGamer, JPanel panelEat, JPanel panelContainer, JLabel lblTime, JLabel Puntos, JLabel Muertes) {
        this.panelGamer = panelGamer;
        this.panelEat = panelEat;
        this.panelContainer = panelContainer;
        this.lblTime = lblTime;
        this.Puntos = Puntos;
        this.Muertes = Muertes;
        this.puntos = 0;

        random = new Random();
        this.currentTime = System.currentTimeMillis() / 1000;
        this.lblTime.setText(this.currentTime + "");
        
        
        this.originalPosition = this.panelGamer.getLocation();
        
        wormSegments = new ArrayList<>();
        
        wormSegments.add(panelGamer);
        panelGamer.setSize(segmentSize, segmentSize);
       
        
    //C:/Users/pc/Documents/NetBeansProjects/11.01-appdeskpp20241/appdeskpp20241/src/main/java/com/codideep/app/async/fondo.mp3
        playMusicInLoop();
     
         
    }
    private void playCollisionSound() {
    new Thread(() -> {
        try {
            InputStream is = new FileInputStream("C:/Users/pc/Documents/NetBeansProjects/11.01-appdeskpp20241/11.01-appdeskpp20241/appdeskpp20241/src/main/java/com/codideep/app/async/comerbot.mp3");
            AdvancedPlayer player = new AdvancedPlayer(is);
            player.play();
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }).start();
}
     private void playCollisionborderSound() {
    new Thread(() -> {
        try {
            InputStream is = new FileInputStream("C:/Users/pc/Documents/NetBeansProjects/11.01-appdeskpp20241/11.01-appdeskpp20241/appdeskpp20241/src/main/java/com/codideep/app/async/colisiones.mp3");
            AdvancedPlayer player = new AdvancedPlayer(is);
            player.play();
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }).start();
}
 private void playMusicInLoop() {
        new Thread(() -> {
            while (true) {
                try {
                    InputStream is = new FileInputStream("C:/Users/pc/Documents/NetBeansProjects/11.01-appdeskpp20241/11.01-appdeskpp20241/appdeskpp20241/src/main/java/com/codideep/app/async/fondo.mp3");
                    AdvancedPlayer player = new AdvancedPlayer(is);
                    player.play();
                } catch (FileNotFoundException | JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }).start();
 }

    
    private boolean minutesElapsed(long initTime, int secondsQuantity) {
        long currentTimeTemp = System.currentTimeMillis() / 1000;
        return ((currentTimeTemp - initTime) >= secondsQuantity);
    }
    
    private void setNewPosition() {
        // Obtener los límites del panelContainer
        this.x = this.panelContainer.getBounds().x;
        this.y = this.panelContainer.getBounds().y;
        this.width = this.panelContainer.getBounds().width;
        this.height = this.panelContainer.getBounds().height;

        this.minRandX = this.x;
        this.maxRandX = this.width - this.panelEat.getBounds().width;

        this.minRandY = this.y;
        this.maxRandY = this.height - this.panelEat.getBounds().height;

        
        int step = 25;

        // Calcular la posición aleatoria dentro de los límites 
        int rangeX = (this.maxRandX - this.minRandX) / step;
        int rangeY = (this.maxRandY - this.minRandY) / step;

        
        this.positionX = this.minRandX + (random.nextInt(rangeX + 1)) * step;
        this.positionY = this.minRandY + (random.nextInt(rangeY + 1)) * step;

       
        this.positionX = Math.round(this.positionX / step) * step;
        this.positionY = Math.round(this.positionY / step) * step;

        // Asegurarse de que la posición no se desplace fuera de los límites
        if (this.positionX + this.panelEat.getBounds().width > this.width) {
            this.positionX = this.width - this.panelEat.getBounds().width;
        }
        
        if (this.positionY + this.panelEat.getBounds().height > this.height) {
            this.positionY = this.height - this.panelEat.getBounds().height;
        }

        // Establecer la nueva posición para panelEat
        this.panelEat.setBounds(this.positionX, this.positionY, this.panelEat.getBounds().width, this.panelEat.getBounds().height);
        
        // Actualizar las coordenadas y dimensiones en la clase Global
        Global.eatX = this.positionX;
        Global.eatY = this.positionY;
        Global.eatWidth = this.panelEat.getBounds().width;
        Global.eatHeight = this.panelEat.getBounds().height;
    }

    private boolean checkCollision() {
        
        Global.gamerX = this.panelGamer.getBounds().x;
        Global.gamerY = this.panelGamer.getBounds().y;
        Global.gamerWidth = this.panelGamer.getBounds().width;
        Global.gamerHeight = this.panelGamer.getBounds().height;

        
        boolean collidesX = Global.gamerX < (Global.eatX + Global.eatWidth) && (Global.gamerX + Global.gamerWidth) > Global.eatX;
        boolean collidesY = Global.gamerY < (Global.eatY + Global.eatHeight) && (Global.gamerY + Global.gamerHeight) > Global.eatY;
        return collidesX && collidesY;
    }

    private void growWorm() {
        
        JPanel newSegment = new JPanel();
        newSegment.setSize(segmentSize, segmentSize);
        newSegment.setBackground(Color.WHITE); 
        newSegment.setOpaque(true); 

        
        this.panelContainer.add(newSegment);
        this.panelContainer.revalidate(); 
        this.panelContainer.repaint();

        
        wormSegments.add(newSegment);

        
        if (wormSegments.size() == 1) {
            newSegment.setLocation(panelGamer.getX() - segmentSize, panelGamer.getY());
        } else {
            
            JPanel previousSegment = wormSegments.get(wormSegments.size() - 2);
            newSegment.setLocation(previousSegment.getLocation());
        }
    }

    private void resetGamer() {
        
        while (wormSegments.size() > 1) {
            JPanel segment = wormSegments.remove(wormSegments.size() - 1);
            this.panelContainer.remove(segment);
        }

    int containerWidth = panelContainer.getWidth();
    int containerHeight = panelContainer.getHeight();

   
    int centerX = containerWidth / 2;
    int centerY = containerHeight / 2;

    
    centerX = (centerX / segmentSize) * segmentSize;
    centerY = (centerY / segmentSize) * segmentSize;

    
    panelGamer.setLocation(centerX, centerY);
       
        
        this.panelContainer.revalidate();
        this.panelContainer.repaint();
    }
  

    @Override
    public void run() {
        playMusicInLoop();
        try {
            for (;;) {
              
                this.lblTime.setText(((System.currentTimeMillis() / 1000) - this.currentTime) + "");
                
                if (Global.collision || this.minutesElapsed(this.currentTime, 5)) {
                    this.currentTime = System.currentTimeMillis() / 1000;
                    Global.collision = false;
                    
                    this.setNewPosition();
                    
                }
                
                Point mousePositionOnScreen = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(mousePositionOnScreen, panelContainer);
                
                int mouseXRelativeToContainer = mousePositionOnScreen.x;
                int mouseYRelativeToContainer = mousePositionOnScreen.y;
                
                int prevX = this.panelGamer.getBounds().x;
                int prevY = this.panelGamer.getBounds().y;

                if (this.panelGamer.getBounds().x < mouseXRelativeToContainer) {
                    this.panelGamer.setBounds(this.panelGamer.getBounds().x + 25, this.panelGamer.getBounds().y, segmentSize, segmentSize);
                }
                
                if (this.panelGamer.getBounds().x > mouseXRelativeToContainer) {
                    this.panelGamer.setBounds(this.panelGamer.getBounds().x - 25, this.panelGamer.getBounds().y, segmentSize, segmentSize);
                }
                
                if (this.panelGamer.getBounds().y < mouseYRelativeToContainer) {
                    this.panelGamer.setBounds(this.panelGamer.getBounds().x, this.panelGamer.getBounds().y + 25, segmentSize, segmentSize);
                }
                
                if (this.panelGamer.getBounds().y > mouseYRelativeToContainer) {
                    this.panelGamer.setBounds(this.panelGamer.getBounds().x, this.panelGamer.getBounds().y - 25, segmentSize, segmentSize);
                }

                // Mover segmentos del gusano
                for (int i = wormSegments.size() - 1; i > 0; i--) {
                    JPanel currentSegment = wormSegments.get(i);
                    JPanel previousSegment = wormSegments.get(i - 1);
                    currentSegment.setLocation(previousSegment.getLocation());
                  
                }
                
                if (wormSegments.size() > 1) {
                    wormSegments.get(1).setLocation(prevX, prevY);
                }

                if (checkCollision()) {
                     playCollisionSound();
                    Global.collision = true;
                    growWorm();
                    puntos++;
                    Puntos.setText(String.valueOf(puntos));
                }
                
                // Check if panelGamer is out of bounds
                if (this.panelGamer.getBounds().x < 0 || 
                    this.panelGamer.getBounds().y < 0 || 
                    this.panelGamer.getBounds().x + this.panelGamer.getBounds().width > this.panelContainer.getBounds().width ||
                    this.panelGamer.getBounds().y + this.panelGamer.getBounds().height > this.panelContainer.getBounds().height) {
                    
                    
                      playCollisionborderSound();
                    collisionCount++;
                    Muertes.setText(String.valueOf(collisionCount));
                    
                    
                    resetGamer();
                }
                sleep(100);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcessEat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
