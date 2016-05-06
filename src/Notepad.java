import javax.swing.*; // for the main JFrame design
import java.awt.*; // for the GUI stuff
import java.awt.event.*; // for the event handling
import java.util.Scanner; // for reading from a file
import java.io.*; // for writing to a file
/**
 * Created by linuxsagar on 5/3/16.
 */
public class Notepad extends JFrame implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.close){
            this.dispose();
        }else if(e.getSource() == this.openFile){
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                this.textArea.setText("");
                try{
                    Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                    while (scan.hasNext())
                        this.textArea.append(scan.nextLine()+"\n");
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }else if(e.getSource() == this.saveFile){
            JFileChooser save = new JFileChooser();
            int option = save.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION){
                try{
                    BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                    out.write(this.textArea.getText());
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private TextArea textArea = new TextArea("", 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);

    private MenuBar menuBar = new MenuBar(); // first, create a MenuBar item
    private Menu file = new Menu(); // our File menu
    // what's going in File? let's see...
    private MenuItem openFile = new MenuItem();  // an open option
    private MenuItem saveFile = new MenuItem(); // a save option
    private MenuItem close = new MenuItem(); // and a close option!

    public Notepad(){
        this.setSize(500,300);
        this.setTitle("Write something on notepad");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.textArea.setFont(new Font("Ubuntu", Font.BOLD, 12));
        this.getContentPane().add(textArea);
        this.setMenuBar(menuBar);
        this.menuBar.add(this.file);
        this.file.setLabel("File");

        this.openFile.setLabel("Open");
        this.openFile.addActionListener(this);
        this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false));
        this.file.add(openFile);

        this.saveFile.setLabel("Save");
        this.saveFile.addActionListener(this);
        this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
        this.file.add(saveFile);

        this.close.setLabel("Close");
        this.close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
        this.close.addActionListener(this);
        this.file.add(this.close);
    }

    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        notepad.setVisible(true);
    }
}
