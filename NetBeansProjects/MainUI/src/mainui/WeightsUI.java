/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainui;


/* swing and awt classes */
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/* jgrapht classes */
import org.jgrapht.graph.ListenableUndirectedWeightedGraph;


/**
 *
 * @author  faif
 */
public class WeightsUI<V, E> extends javax.swing.JDialog {
    
    /** Creates new form WeightsUI */
    public WeightsUI(java.awt.Frame parent, boolean modal,
            ListenableUndirectedWeightedGraph<V, E> gr) {
        super(parent, modal);
        initComponents();
        displayWeights(gr);
    }
    
    /**
     * Displays the weights of the graph in the dialog
     *
     * @param gr a graph instance
     *
     */
    private void displayWeights(ListenableUndirectedWeightedGraph<V, E> gr) {
        Object ob[] = gr.edgeSet().toArray();
        innerPane.setLayout(new GridLayout(ob.length, 0, 10, 5));
        for (int i=0; i<ob.length; i++) {
            JPanel tmp = new JPanel();
            tmp.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            tmp.add(new JLabel(ob[i].toString()));
            innerPane.add(tmp);
        }
        innerPane.revalidate();
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
        outerPane = new javax.swing.JPanel();
        borderPane = new javax.swing.JPanel();
        weightsScroll = new javax.swing.JScrollPane();
        innerPane = new javax.swing.JPanel();
        buttonPane = new javax.swing.JPanel();
        closeB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Display Weights");
        setResizable(false);
        outerPane.setMinimumSize(new java.awt.Dimension(141, 356));
        outerPane.setPreferredSize(new java.awt.Dimension(220, 166));
        borderPane.setLayout(new java.awt.BorderLayout(5, 5));

        borderPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Weights"));
        borderPane.setMinimumSize(new java.awt.Dimension(121, 346));
        borderPane.setPreferredSize(new java.awt.Dimension(180, 146));
        weightsScroll.setBorder(null);
        weightsScroll.setAutoscrolls(true);
        weightsScroll.setMinimumSize(new java.awt.Dimension(10, 5));
        weightsScroll.setPreferredSize(new java.awt.Dimension(10, 35));
        innerPane.setLayout(new java.awt.GridLayout(1, 0));

        weightsScroll.setViewportView(innerPane);

        borderPane.add(weightsScroll, java.awt.BorderLayout.CENTER);

        outerPane.add(borderPane);

        getContentPane().add(outerPane, java.awt.BorderLayout.CENTER);

        buttonPane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        closeB.setMnemonic('O');
        closeB.setText("Close");
        closeB.setToolTipText("Exit");
        closeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBActionPerformed(evt);
            }
        });

        buttonPane.add(closeB);

        getContentPane().add(buttonPane, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-335)/2, (screenSize.height-231)/2, 335, 231);
    }// </editor-fold>//GEN-END:initComponents
    
    private void closeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBActionPerformed
        dispose();
    }//GEN-LAST:event_closeBActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel borderPane;
    private javax.swing.JPanel buttonPane;
    private javax.swing.JButton closeB;
    private javax.swing.JPanel innerPane;
    private javax.swing.JPanel outerPane;
    private javax.swing.JScrollPane weightsScroll;
    // End of variables declaration//GEN-END:variables
    
}