package com.project.TakeNote;

/**
 * Created by linuxsagar on 5/7/16.
 */
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

//TODO not working
@SuppressWarnings("serial")
public class DefaultContextMenu extends JPopupMenu
{
    private JMenuItem delete;

    public DefaultContextMenu()
    {
        delete = new JMenuItem("Delete");
        delete.setEnabled(false);
        delete.addActionListener(event -> System.out.println("DELETE"));
        add(delete);
    }
}