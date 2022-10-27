import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class AedLab6GUI {
    // Component
    private JButton calBtn;
    private JLabel jcomp2;
    private JTextField totPtr;
    private JLabel jcomp4;
    private JTextField earnedPtr;
    private JTextField percentage;
    private JLabel jcomp7;
    private JLabel jcomp8;
    private JLabel resField;

    // Business logic
    private DecimalFormat df = new DecimalFormat("#.00");
    private AedLab6Func func;

    public void run() {
        // calculate
        func = new AedLab6Func();
        // create main frame
        JFrame frame = new JFrame("AedLab6");
        // Setting the width and height of frame
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        // add main panel
        frame.add(panel);
        this.placeComponents(panel);

        // visible GUI
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {

        panel.setLayout(null);

        // construct components
        calBtn = new JButton("Calculate");
        jcomp2 = new JLabel("Total Assignment Points ");
        totPtr = new JTextField(5);
        jcomp4 = new JLabel("Earned Points");
        earnedPtr = new JTextField(5);
        percentage = new JTextField(5);
        jcomp7 = new JLabel("Percentage of class");
        jcomp8 = new JLabel("Weighted Score");
        resField = new JLabel("Waiting for calculation");

        // add components
        panel.add(calBtn);
        panel.add(jcomp2);
        panel.add(totPtr);
        panel.add(jcomp4);
        panel.add(earnedPtr);
        panel.add(percentage);
        panel.add(jcomp7);
        panel.add(jcomp8);
        panel.add(resField);

        // set component bounds (only needed by Absolute Positioning)
        calBtn.setBounds(170, 230, 120, 50);
        jcomp2.setBounds(20, 20, 150, 30);
        totPtr.setBounds(20, 60, 200, 40);
        jcomp4.setBounds(240, 20, 150, 30);
        earnedPtr.setBounds(240, 60, 200, 40);
        percentage.setBounds(20, 160, 200, 40);
        jcomp7.setBounds(20, 120, 150, 30);
        jcomp8.setBounds(120, 300, 100, 40);
        resField.setBounds(240, 300, 200, 40);

        // add event listern
        calBtn.addActionListener(new ButtonActionListener());
    }

    // Mouse click event listener
    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                // get inputs and remove spaces
                String totalPoints = totPtr.getText().trim();
                String earnedPoints = earnedPtr.getText().trim();
                String perc = percentage.getText().trim();

                // check empty
                if (totalPoints == null || totalPoints.equals("")
                        || earnedPoints == null || earnedPoints.equals("")
                        || perc == null || perc.equals("")) {
                    resField.setText("Invalid Input! Check your inputs!");
                    return;
                }
                // convert to int
                int totP = Integer.parseInt(totalPoints), earnP = Integer.parseInt(earnedPoints),
                        pertg = Integer.parseInt(perc);

                // check legal
                if (pertg > 100 || earnP > totP || earnP < 0 || totP < 0 || pertg < 0) {
                    resField.setText("Invalid Input! Check your inputs!");
                    return;
                }
                // set the results
                String res = df.format(func.getGrade(earnP, totP, pertg));

                // show the results
                // System.out.println(res);
                resField.setText(res);
            } catch (Exception except) {
                resField.setText("Invalid Input! Check your inputs!");
            }
        }
    }
}