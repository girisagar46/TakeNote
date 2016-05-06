import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by linuxsagar on 5/3/16.
 */
public class NoteFrame extends JFrame {

    private NoteFrame() throws Exception{

        initComponents();
    }

    private void initComponents(){
        setSize(new Dimension(684, 627));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                NoteFrame noteFrame = null;
                try {
                    noteFrame = new NoteFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                noteFrame.setVisible(true);
            }
        });
    }
}
