/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainui;

/* swing and awt classes */
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

/* external classes */
import mainui.graphnetwork.ui.ext.BareBonesBrowserLaunch;

/* PEND: replace org.graphnetwork.ui.ext.BareBonesBrowserLaunch
 * by the time Sun will create a standard way for launching web browsers in a portable
 * manner... */

/**
 *
 * @author  faif
 */
public class AboutUI extends javax.swing.JDialog
        implements MouseMotionListener {
    
    /** Creates new form AboutUI */
    public AboutUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ateiBut.addMouseMotionListener(this);
        itBut.addMouseMotionListener(this);
        freeSoftBut.addMouseMotionListener(this);
    }
    
    /**
     * {@inheritDoc}
     */
    public void setVisible(boolean set) {
        /* center the dialog */
        pack();
        setLocationRelativeTo(this.getParent());
        
        /* call the parent setVisible */
        super.setVisible(set);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        ateiBut = new javax.swing.JButton();
        itBut = new javax.swing.JButton();
        graphLab = new javax.swing.JLabel();
        freeSoftBut = new javax.swing.JButton();
        closeB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About GraphNetwork");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        ateiBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/graphnetwork/ui/resources/graphics/teithe.png")));
        ateiBut.setToolTipText("http://www.teithe.gr/");
        ateiBut.setActionCommand("http://www.teithe.gr/");
        ateiBut.setBorderPainted(false);
        ateiBut.setContentAreaFilled(false);
        ateiBut.setFocusPainted(false);
        ateiBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ateiButActionPerformed(evt);
            }
        });

        itBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/graphnetwork/ui/resources/graphics/it.png")));
        itBut.setToolTipText("http://www.it.teithe.gr/");
        itBut.setActionCommand("http://www.it.teithe.gr/");
        itBut.setBorderPainted(false);
        itBut.setContentAreaFilled(false);
        itBut.setFocusPainted(false);
        itBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itButActionPerformed(evt);
            }
        });

        graphLab.setText("GraphNetwork is");

        freeSoftBut.setMnemonic('R');
        freeSoftBut.setText("free software");
        freeSoftBut.setToolTipText("http://www.gnu.org/philosophy/free-sw.html");
        freeSoftBut.setActionCommand("http://www.gnu.org/philosophy/free-sw.html");
        freeSoftBut.setFocusPainted(false);
        freeSoftBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freeSoftButActionPerformed(evt);
            }
        });

        closeB.setMnemonic('O');
        closeB.setText("Close");
        closeB.setToolTipText("Exit");
        closeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(131, 131, 131)
                        .add(graphLab)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(freeSoftBut))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(ateiBut, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 156, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 58, Short.MAX_VALUE)
                        .add(itBut, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 263, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(212, Short.MAX_VALUE)
                .add(closeB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ateiBut, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(itBut))
                .add(25, 25, 25)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(freeSoftBut, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(graphLab))
                .add(31, 31, 31)
                .add(closeB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void closeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBActionPerformed
        dispose();
    }//GEN-LAST:event_closeBActionPerformed
    
    private void freeSoftButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freeSoftButActionPerformed
        BareBonesBrowserLaunch.openURL(evt.getActionCommand());
    }//GEN-LAST:event_freeSoftButActionPerformed
    
    private void itButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itButActionPerformed
        BareBonesBrowserLaunch.openURL(evt.getActionCommand());
    }//GEN-LAST:event_itButActionPerformed
    
    private void ateiButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ateiButActionPerformed
        BareBonesBrowserLaunch.openURL(evt.getActionCommand());
    }//GEN-LAST:event_ateiButActionPerformed
    
    public void mouseDragged(MouseEvent e) {}
    
    public void mouseMoved(MouseEvent e) {
        e.getComponent().setCursor(Cursor.getPredefinedCursor
                (Cursor.HAND_CURSOR));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ateiBut;
    private javax.swing.JButton closeB;
    private javax.swing.JButton freeSoftBut;
    private javax.swing.JLabel graphLab;
    private javax.swing.JButton itBut;
    // End of variables declaration//GEN-END:variables
    
}
