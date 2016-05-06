import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by linuxsagar on 4/28/16.
 */
public class MainApp extends JFrame {

    public MainApp(){
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.setMnemonic('F');
        JMenuItem fileItem = new JMenuItem("Open");
        fileItem.setMnemonic('O');
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('E');

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text","txt"));
            }
        });

        file.add(fileItem);
        file.add(exitItem);
        menuBar.add(file);
        setJMenuBar(menuBar);
    }


    public static void main(String[] args) {
        MainApp app = new MainApp();
    }
}
