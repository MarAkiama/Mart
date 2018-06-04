/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainui;

/* swing and awt classes */
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.*;
import org.jgrapht.graph.ListenableUndirectedGraph;

/* jgrapht classes */
import org.jgrapht.graph.ListenableUndirectedWeightedGraph;

/* resolve ambiguity between jgrapht and this application */
import mainui.graphnetwork.generate.RandomGraphGenerator;
import mainui.graphnetwork.jgrapht.graph.DefaultWeightedEdge;

/**
 *
 * @author  faif
 */
public class RandomGraphUI extends javax.swing.JDialog
        implements mainui.graphnetwork.common.Constants {
    private MainUI m;
    
    
    /* check if the user pressed the create graph button */
    private boolean buttonClicked;
    
    
    public RandomGraphUI(java.awt.Frame parent, boolean modal, MainUI mu) {
        super(parent, modal);
        initComponents();
        assignListeners();
        /* initialize the graph (jgrapht) object */
        buttonClicked = false;
        m = mu;
    }
    
    
    /**
     * @return true if the create button was clicked
     */
    public boolean isCreateButtonClicked() {
        return buttonClicked;
    }
    
 
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
        fieldsP = new javax.swing.JPanel();
        weightsP = new javax.swing.JPanel();
        minT = new javax.swing.JTextField();
        minL = new javax.swing.JLabel();
        maxL = new javax.swing.JLabel();
        maxT = new javax.swing.JTextField();
        networkP = new javax.swing.JPanel();
        verticesT = new javax.swing.JTextField();
        maxEdgesT = new javax.swing.JTextField();
        verticesL = new javax.swing.JLabel();
        maxEdgesL = new javax.swing.JLabel();
        createB = new javax.swing.JButton();
        clearNWB = new javax.swing.JButton();
        closeB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Graph Parameters");
        setResizable(false);
        weightsP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Costs")));
        minT.setToolTipText("The minimum weight value of an edge (decimal)");
        minT.setFocusAccelerator('I');

        minL.setDisplayedMnemonic('I');
        minL.setText("Min");

        maxL.setDisplayedMnemonic('A');
        maxL.setText("Max");

        maxT.setToolTipText("The maximum weight value of an edge (decimal)");
        maxT.setFocusAccelerator('A');
        maxT.setNextFocusableComponent(createB);

        org.jdesktop.layout.GroupLayout weightsPLayout = new org.jdesktop.layout.GroupLayout(weightsP);
        weightsP.setLayout(weightsPLayout);
        weightsPLayout.setHorizontalGroup(
            weightsPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(weightsPLayout.createSequentialGroup()
                .addContainerGap()
                .add(weightsPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(minL)
                    .add(maxL))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(weightsPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(maxT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(minT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        weightsPLayout.setVerticalGroup(
            weightsPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(weightsPLayout.createSequentialGroup()
                .add(weightsPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(minT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(minL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 22, Short.MAX_VALUE)
                .add(weightsPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(maxL)
                    .add(maxT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        networkP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Network")));
        verticesT.setToolTipText("The number of vertices (integer)");
        verticesT.setFocusAccelerator('N');

        maxEdgesT.setToolTipText("The maximum number of edges per vertex (integer)");
        maxEdgesT.setFocusAccelerator('M');

        verticesL.setDisplayedMnemonic('N');
        verticesL.setText("Number of vertices");
        verticesL.setToolTipText("");

        maxEdgesL.setDisplayedMnemonic('M');
        maxEdgesL.setText("Maximum number of edges for each vertex");
        maxEdgesL.setToolTipText("Maximum number of edges for each vertex");

        org.jdesktop.layout.GroupLayout networkPLayout = new org.jdesktop.layout.GroupLayout(networkP);
        networkP.setLayout(networkPLayout);
        networkPLayout.setHorizontalGroup(
            networkPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, networkPLayout.createSequentialGroup()
                .addContainerGap()
                .add(networkPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(verticesL, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(maxEdgesL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(networkPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(verticesT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(maxEdgesT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        networkPLayout.setVerticalGroup(
            networkPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(networkPLayout.createSequentialGroup()
                .add(networkPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(verticesT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(verticesL))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 22, Short.MAX_VALUE)
                .add(networkPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(maxEdgesT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(maxEdgesL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        org.jdesktop.layout.GroupLayout fieldsPLayout = new org.jdesktop.layout.GroupLayout(fieldsP);
        fieldsP.setLayout(fieldsPLayout);
        fieldsPLayout.setHorizontalGroup(
            fieldsPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(fieldsPLayout.createSequentialGroup()
                .add(networkP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(weightsP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        fieldsPLayout.setVerticalGroup(
            fieldsPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(fieldsPLayout.createSequentialGroup()
                .addContainerGap()
                .add(fieldsPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, networkP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, weightsP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        createB.setMnemonic('C');
        createB.setText("Create");
        createB.setToolTipText("Create the graph");
        createB.setEnabled(false);
        createB.setNextFocusableComponent(clearNWB);
        createB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBActionPerformed(evt);
            }
        });

        clearNWB.setMnemonic('L');
        clearNWB.setText("Clear");
        clearNWB.setToolTipText("Clear the fields");
        clearNWB.setNextFocusableComponent(closeB);
        clearNWB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearNWBActionPerformed(evt);
            }
        });

        closeB.setMnemonic('O');
        closeB.setText("Close");
        closeB.setToolTipText("Exit");
        closeB.setNextFocusableComponent(verticesT);
        closeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .add(createB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17)
                .add(clearNWB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(21, 21, 21)
                .add(closeB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(69, 69, 69))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(fieldsP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(fieldsP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(createB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(clearNWB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(closeB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(13, 13, 13))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void closeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBActionPerformed
        dispose();
    }//GEN-LAST:event_closeBActionPerformed
    
    private void clearNWBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearNWBActionPerformed
        clearNetWeightTextFields();
        verticesT.requestFocus();
    }//GEN-LAST:event_clearNWBActionPerformed
    /**
     * Creates the random graph and adds it to the applet
     */
    private void createBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBActionPerformed
        ListenableUndirectedWeightedGraph gr = 
                new ListenableUndirectedWeightedGraph<java.lang.String,
                        DefaultWeightedEdge>(DefaultWeightedEdge.class);
        m.setGraph(gr);
        
        RandomGraphGenerator r = new RandomGraphGenerator(gr, getNumberOfVertices(),
                getMaxNumberOfEdges(), getMinWeightValue(), getMaxWeightValue());
        
        buttonClicked = true;
        
        /* close the dialog */
        dispose();
    }//GEN-LAST:event_createBActionPerformed
    
    /**
     * Assigns any listeners to the components
     */
    private void assignListeners() {
        DocumentEventsListener l=new DocumentEventsListener();
        verticesT.getDocument().addDocumentListener(l);
        maxEdgesT.getDocument().addDocumentListener(l);
        minT.getDocument().addDocumentListener(l);
        maxT.getDocument().addDocumentListener(l);
    }
    
    /**
     * Erases all the contents of the "Network"
     * and "Weights" fields
     */
    private void clearNetWeightTextFields() {
        verticesT.setText(EMPTY);
        minT.setText(EMPTY);
        maxT.setText(EMPTY);
        maxEdgesT.setText(EMPTY);
    }
    
    /**
     * Reads and returns the maximum accepted
     * number of edges per vertex for the graph
     * @return the maximum accepted number of edges
     * per vertex
     */
    public  int getMaxNumberOfEdges() {
        // convert the textfield's string to an integer
        int num = 0;
        try {
            num = Integer.parseInt(maxEdgesT.getText());
        } catch (Exception e) {
        }
        return num;
    }
    
    /**
     * Reads and returns the maximum accepted
     * weight value of an edge
     * @return the maximum accepted weight value
     */
    public  float getMaxWeightValue() {
        // convert the textfield's string to a float
        float num = 0f;
        try {
            num = Float.parseFloat(maxT.getText());
        } catch (Exception e) {
        }
        return num;
    }
    
    /**
     * Reads and returns the minimum accepted
     * weight value of an edge
     * @return the minimum weight value
     */
    public  float getMinWeightValue() {
        // convert the textfield's string to a float
        float num = 0f;
        try {
            num = Float.parseFloat(minT.getText());
        } catch (Exception e) {
        }
        return num;
    }
    
    /**
     * Reads and returns the number of the vertices to
     * be created
     * @return the number of the vertices to be created
     */
    public  int getNumberOfVertices() {
        // convert the textfield's string to an integer
        int vertices = 0;
        try {
            vertices = Integer.parseInt(verticesT.getText());
        } catch (Exception e) {
        }
        return vertices;
    }
    
    
    /* nested class to handle the document events */
    class DocumentEventsListener implements DocumentListener {
        public void insertUpdate(DocumentEvent de) { checkValidity(); }
        public void removeUpdate(DocumentEvent de) { checkValidity(); }
        public void changedUpdate(DocumentEvent de) {}
        
        /**
         * Checks if the appropriate values have been entered
         * to the components. If this is true, the action components
         * are enabled, otherwise they are disabled.
         */
        private void checkValidity() {
            try {
                int vertices = Integer.parseInt(verticesT.getText());
                int edges    = Integer.parseInt(maxEdgesT.getText());
                float minW   = Float.parseFloat(minT.getText());
                float maxW   = Float.parseFloat(maxT.getText());
                
                /* check if the user gave the appropriate values */
                /* ie do not allow minWeightValue > maxWeightValue */
                if(minW <= 0 || maxW <= 0)
                    throw new Exception("minw or maxw: 0");
                if(vertices < 2 || edges <= 0)
                    throw new Exception("vertices: < 2 or edges: <= 0");
                if(minW >= maxW)
                    throw new Exception("minw < maxw: false");
                
                createB.setEnabled(true);
                
            } catch (Exception e) {
                createB.setEnabled(false);
            }
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearNWB;
    private javax.swing.JButton closeB;
    private javax.swing.JButton createB;
    private javax.swing.JPanel fieldsP;
    private javax.swing.JLabel maxEdgesL;
    private javax.swing.JTextField maxEdgesT;
    private javax.swing.JLabel maxL;
    private javax.swing.JTextField maxT;
    private javax.swing.JLabel minL;
    private javax.swing.JTextField minT;
    private javax.swing.JPanel networkP;
    private javax.swing.JLabel verticesL;
    private javax.swing.JTextField verticesT;
    private javax.swing.JPanel weightsP;
    // End of variables declaration//GEN-END:variables
    
}