


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Chat extends JFrame{
    JPanel jpN = new JPanel(new GridLayout());
    JPanel jpS = new JPanel(new GridLayout());

    JButton jb = new JButton("Отправить");
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jta);
    JTextField jtf = new JTextField();

    JMenuBar mainMenu = new JMenuBar();
    JMenu mFile = new JMenu("Файл");
    JMenu mHelp = new JMenu("Помощь");
    JMenuItem miFileExit = new JMenuItem("Выход");
    JMenuItem miHelpAbout = new JMenuItem("Инфо");

    PrintWriter pw = new PrintWriter(new FileWriter("1.txt"));

    Chat() throws IOException {
        super("Чат");
        setSize(300, 400);
        setMinimumSize(new Dimension(300, 400));

        jta.setLineWrap(true);
        jta.setEditable(false);

        //ACTIONS
        jb.addActionListener(e -> {
            sendMessage();
        });
        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
            }
        });

        jpN.add(jsp);
        jpS.add(jtf);
        jpS.add(jb);

        add(jpN);
        add("South", jpS);

        //MENU
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mHelp);
        mFile.add(miFileExit);
        mHelp.add(miHelpAbout);
        miFileExit.addActionListener(e -> System.exit(0));
        miHelpAbout.addActionListener(e -> JOptionPane.showMessageDialog(null,"Чатик", "Инфо", JOptionPane.INFORMATION_MESSAGE));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //SEND MESSAGE & WRITE TO FILE
    void sendMessage() {
        String out = jtf.getText();
        jta.append(getTime() + ": " + out + "\n");
        pw.append(getTime() + ": " + out + "\n");
        pw.flush();
        jtf.setText("");
        jtf.grabFocus();
    }

    //RETURN CURRENT TIME
    public String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

}

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        new Chat();
    }
}
