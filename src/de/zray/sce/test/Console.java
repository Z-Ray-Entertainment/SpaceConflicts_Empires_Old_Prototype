/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.test;

import de.zray.sce.game.Settings;
import de.zray.sce.test.cmds.ToogleDispatcherHook;
import de.zray.se.MainThread;
import de.zray.se.logger.SEDispatcherHook;
import de.zray.se.logger.SELogger;
import de.zray.coretex.exceptions.DublicateCommandException;
import de.zray.coretex.exceptions.InvalidParameterValueException;
import de.zray.coretex.exceptions.InvalidTypeException;
import de.zray.coretex.exceptions.ParameterAmountException;
import de.zray.coretex.exceptions.SyntaxException;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vortex Acherontic
 */
public class Console extends javax.swing.JFrame implements SEDispatcherHook{
    private boolean showHookedLogs = false;
    private de.zray.coretex.Console seConsole;
    
    /**
     * Creates new form Console
     */
    public Console() {
        initComponents();
        setTitle(Settings.name+" "+Settings.version);
        
        try {
            
            seConsole = MainThread.getConsole();
            seConsole.addCommand(new ToogleDispatcherHook(this));
        } catch (DublicateCommandException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTA_Input = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTA_Log = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTA_Input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTA_InputKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTA_InputKeyTyped(evt);
            }
        });

        jTA_Log.setEditable(false);
        jTA_Log.setColumns(20);
        jTA_Log.setRows(5);
        jScrollPane1.setViewportView(jTA_Log);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
                    .addComponent(jTA_Input))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTA_Input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTA_InputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTA_InputKeyTyped
        
    }//GEN-LAST:event_jTA_InputKeyTyped

    private void jTA_InputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTA_InputKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            send();
        }   
    }//GEN-LAST:event_jTA_InputKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Console().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTA_Input;
    private javax.swing.JTextArea jTA_Log;
    // End of variables declaration//GEN-END:variables

    private void send(){
        jTA_Log.append(issueCommand(jTA_Input.getText())+"\n");
        jTA_Input.setText("");
    }
    
    private String issueCommand(String input){
        try {
            return seConsole.executeScript(input);
        } catch (SyntaxException ex) {
            SELogger.get().dispatchMsg("SCEConsole", SELogger.SELogType.ERROR, new String[]{ex.getMessage()}, false);
        } catch (ParameterAmountException | InvalidTypeException | InvalidParameterValueException ex) {
            SELogger.get().dispatchMsg("SCEConsole", SELogger.SELogType.ERROR, new String[]{ex.getMessage()}, false);
        }
        return "Error while exectuing: "+input;
    }

    @Override
    public void dispatchMessage(String output) {
        if(showHookedLogs){
            jTA_Log.append(output+"\n");
        }
    }
    
    public void toogleHook(){
        showHookedLogs = !showHookedLogs;
    }
}
