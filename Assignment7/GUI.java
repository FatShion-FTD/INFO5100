import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JPanel {
    // Component
    private JButton rBtn;
    private JButton wBtn;
    private JTextArea rOut;
    private JTextField rText;
    private JTextField wText;
    private JTextArea wOut;
    private JLabel jcomp7;
    private JLabel jcomp8;
    private JLabel jcomp9;
    private JLabel jcomp10;

    // Event hanlder
    private ButtonActionListener btnEvent;

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // construct components
        btnEvent = new ButtonActionListener();
        rBtn = new JButton("READ");
        wBtn = new JButton("WRITE");
        rOut = new JTextArea(5, 5);
        rText = new JTextField(5);
        wText = new JTextField(5);
        wOut = new JTextArea(5, 5);
        jcomp7 = new JLabel("Reading File Name");
        jcomp8 = new JLabel("File Name to write");
        jcomp9 = new JLabel("First 5 lines of file");
        jcomp10 = new JLabel("First 5 lines of new file");

        // set components properties
        rText.setText("annual.csv");
        rText.setToolTipText("Write the read file location");
        wText.setText("default_output.csv");
        wText.setToolTipText("Write the write file location");

        // add components
        panel.add(rBtn);
        panel.add(wBtn);
        panel.add(rOut);
        panel.add(rText);
        panel.add(wText);
        panel.add(wOut);
        panel.add(jcomp7);
        panel.add(jcomp8);
        panel.add(jcomp9);
        panel.add(jcomp10);

        // set component bounds (only needed by Absolute Positioning)
        rBtn.setBounds(80, 110, 150, 40);
        wBtn.setBounds(325, 110, 150, 40);
        rOut.setBounds(60, 200, 200, 100);
        rText.setBounds(60, 70, 200, 25);
        wText.setBounds(300, 70, 200, 25);
        wOut.setBounds(300, 200, 200, 100);
        jcomp7.setBounds(60, 30, 120, 25);
        jcomp8.setBounds(300, 30, 120, 25);
        jcomp9.setBounds(60, 165, 120, 25);
        jcomp10.setBounds(300, 165, 150, 25);

        // add event listern
        rBtn.addActionListener(btnEvent);
        wBtn.addActionListener(btnEvent);


        // add scroll 
        JScrollPane scroll = new JScrollPane(rOut); 
        JScrollPane scroll1 = new JScrollPane(wOut); 

        scroll.setBounds(60, 200, 210, 110);
        scroll1.setBounds(300, 200, 210, 110);

        // auto show scroller
        scroll.setHorizontalScrollBarPolicy( 
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        scroll.setVerticalScrollBarPolicy( 
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        scroll1.setHorizontalScrollBarPolicy( 
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        scroll1.setVerticalScrollBarPolicy( 
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

        // add to panel
        panel.add(scroll);
        panel.add(scroll1);
    }

    public void run() {
        // create main frame
        JFrame frame = new JFrame("AedLab7");
        // Setting the width and height of frame
        frame.setLocationRelativeTo(null);
        frame.setSize(560, 370);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        // add main panel
        frame.add(panel);
        this.placeComponents(panel);

        // visible GUI
        frame.setVisible(true);
    }

    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {    
            try {
                if (event.getSource() == rBtn) {            // read file
                    String inputFileName = rText.getText();
                    String s = FileProcess.readFile(inputFileName);
                    rOut.setText(s);
                } else {                                    // wirte file
                    String t = FileProcess.writeFile(rText.getText(), wText.getText());
                    wOut.setText(t);
                }
            } catch (Exception e) {
                System.err.println("ERROR");
                e.printStackTrace();
            }
        }
    }
}
