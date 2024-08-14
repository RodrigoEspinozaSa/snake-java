/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.codideep.app.form;

import com.codideep.app.async.ProcessEat;
import com.codideep.app.global.Global;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

/**
 *
 * @author KAAF0
 */
public class Principal extends javax.swing.JFrame {
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        initGeneral();
    }
     
    private void initGeneral() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.panelContainer.setLayout(null);
        
        // Agrega un ComponentListener al JFrame
    this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            // Ajusta el tamaño del panelContainer
            int ancho = Principal.this.getWidth();
            int alto = Principal.this.getHeight();

            int anchoAjustado = (ancho / 25) * 25;
            int altoAjustado = (alto / 25) * 25;

            panelContainer.setBounds(0, 0, anchoAjustado, altoAjustado);
            panelContainer.revalidate();
            panelContainer.repaint();
        }
    });
        
        new Thread(new ProcessEat(
                this.panelGamer,
                this.panelEat,
                this.panelContainer,
                this.lblTime,
                this.Puntos,
                this.Muertes
                
        )).start();
                     
                    
    }
  
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelContainer = new javax.swing.JPanel();
        panelEat = new javax.swing.JPanel();
        panelGamer = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Muertes = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Puntos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelContainer.setBackground(new java.awt.Color(0, 0, 0));
        panelContainer.setDoubleBuffered(false);
        panelContainer.setPreferredSize(new java.awt.Dimension(25, 325));

        panelEat.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout panelEatLayout = new javax.swing.GroupLayout(panelEat);
        panelEat.setLayout(panelEatLayout);
        panelEatLayout.setHorizontalGroup(
            panelEatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        panelEatLayout.setVerticalGroup(
            panelEatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        panelGamer.setBackground(new java.awt.Color(255, 0, 0));
        panelGamer.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout panelGamerLayout = new javax.swing.GroupLayout(panelGamer);
        panelGamer.setLayout(panelGamerLayout);
        panelGamerLayout.setHorizontalGroup(
            panelGamerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        panelGamerLayout.setVerticalGroup(
            panelGamerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelGamer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addComponent(panelEat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                .addComponent(panelGamer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 700;
        gridBagConstraints.ipady = 325;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 66, 6);
        getContentPane().add(panelContainer, gridBagConstraints);

        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTime.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 12, 0, 0);
        getContentPane().add(lblTime, gridBagConstraints);

        jLabel1.setText("Tiempo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 12, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        Muertes.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 12, 0, 0);
        getContentPane().add(Muertes, gridBagConstraints);

        jLabel3.setText("Muertes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 6, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        Puntos.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 12, 0, 0);
        getContentPane().add(Puntos, gridBagConstraints);

        jLabel5.setText("Puntos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 60, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        Global.mousePositionX = evt.getX();
        Global.mousePositionY = evt.getY();
        
       // lblMousePosition.setText("X: " + evt.getX() + " | Y: " + evt.getY());
    }//GEN-LAST:event_formMouseMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Muertes;
    private javax.swing.JLabel Puntos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JPanel panelEat;
    private javax.swing.JPanel panelGamer;
    // End of variables declaration//GEN-END:variables
}
