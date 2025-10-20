package awt;

import java.awt.*;
import java.awt.event.*;

class Panel1 extends Panel {
    Label la1, la2, la3;
    TextField te1, te2, te3;
    Button bu1, bu2, bu3, bu4, bu5;

    public Panel1() {
        setLayout(new GridLayout(4, 2, 5, 5)); // Added layout

        la1 = new Label("Number 1:");
        la2 = new Label("Number 2:");
        la3 = new Label("Result:");
        te1 = new TextField(10);
        te2 = new TextField(10);
        te3 = new TextField(10);
        te3.setEditable(false);

        bu1 = new Button("Add");
        bu2 = new Button("Sub");
        bu3 = new Button("Mul");
        bu4 = new Button("Div");
        bu5 = new Button("Exit");

        add(la1); add(te1);
        add(la2); add(te2);
        add(la3); add(te3);
        add(bu1); add(bu2);
        add(bu3); add(bu4);
        add(bu5);

        // Add logic
        bu1.addActionListener(e -> compute('+'));
        bu2.addActionListener(e -> compute('-'));
        bu3.addActionListener(e -> compute('*'));
        bu4.addActionListener(e -> compute('/'));
        bu5.addActionListener(e -> System.exit(0));
    }

    private void compute(char op) {
        try {
            double n1 = Double.parseDouble(te1.getText());
            double n2 = Double.parseDouble(te2.getText());
            double result = switch (op) {
                case '+' -> n1 + n2;
                case '-' -> n1 - n2;
                case '*' -> n1 * n2;
                case '/' -> n2 != 0 ? n1 / n2 : Double.NaN;
                default -> 0;
            };
            te3.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            te3.setText("Invalid input");
        }
    }
}

class Panel2 extends Panel {
    Checkbox ch1, ch2, ch3, ch4;

    public Panel2() {
        setLayout(new GridLayout(2, 2));
        ch1 = new Checkbox("Windows 8");
        ch2 = new Checkbox("Linux Ubuntu");
        ch3 = new Checkbox("Android");
        ch4 = new Checkbox("macOS");
        add(ch1); add(ch2); add(ch3); add(ch4);
    }
}

class Panel3 extends Panel {
    TextArea tax;
    TextField te1, te2;
    Label la1, la2;
    Button bu1, bu2, bu3, bu4;

    public Panel3() {
        setLayout(new GridLayout(5, 2, 5, 5)); // Added layout
        tax = new TextArea(5, 40);
        te1 = new TextField(10);
        te2 = new TextField(10);
        la1 = new Label("Find What:");
        la2 = new Label("Replace With:");
        bu1 = new Button("Find");
        bu2 = new Button("Replace");
        bu3 = new Button("Replace All");
        bu4 = new Button("Cancel");

        add(tax);
        add(la1); add(te1);
        add(la2); add(te2);
        add(bu1); add(bu2);
        add(bu3); add(bu4);

        bu1.addActionListener(e -> findText());
        bu2.addActionListener(e -> replaceText(false));
        bu3.addActionListener(e -> replaceText(true));
        bu4.addActionListener(e -> tax.setText(""));
    }

    private void findText() {
        String content = tax.getText();
        String target = te1.getText();
        int index = content.indexOf(target);
        if (index >= 0) {
            tax.select(index, index + target.length());
        }
    }

    private void replaceText(boolean all) {
        String content = tax.getText();
        String target = te1.getText();
        String replacement = te2.getText();
        if (all) {
            tax.setText(content.replace(target, replacement));
        } else {
            int index = content.indexOf(target);
            if (index >= 0) {
                String updated = content.substring(0, index) + replacement + content.substring(index + target.length());
                tax.setText(updated);
            }
        }
    }
}

public class CardLayoutDemo extends Frame implements ActionListener {
    Button bu1, bu2;
    Panel cards;
    CardLayout c;
    Panel1 pa1;
    Panel2 pa2;
    Panel3 pa3;

    public CardLayoutDemo(String title) {
        super(title);
        bu1 = new Button("Next");
        bu2 = new Button("Previous");

        cards = new Panel();
        c = new CardLayout();
        cards.setLayout(c);

        pa1 = new Panel1();
        pa2 = new Panel2();
        pa3 = new Panel3();

        cards.add("Panel1", pa1);
        cards.add("Panel2", pa2);
        cards.add("Panel3", pa3);

        bu1.addActionListener(this);
        bu2.addActionListener(this);

        Panel p = new Panel();
        p.add(bu1);
        p.add(bu2);

        add(p, BorderLayout.NORTH);
        add(cards, BorderLayout.CENTER);

        setSize(500, 400);
        setVisible(true);

        // Close window properly
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bu1)
            c.next(cards);
        else
            c.previous(cards);
    }

    public static void main(String[] args) {
        new CardLayoutDemo("Card Layout Demo");
    }
}
