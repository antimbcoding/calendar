package Window;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarHandler {
    private Frame frame;

    public MenuBarHandler(Frame frame) {
        this.frame = frame;
    }

    public void setup() {
        //create the menu bar
        MenuBar bar = new MenuBar();

        //create the menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu viewMenu = new Menu("View");

        //create the items in the menus
        MenuItem addEvent = new MenuItem("Add Event");
        MenuItem addTask = new MenuItem("Add Task");
        MenuItem exitFrame = new MenuItem("Exit");
        exitFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        //add items to the menus
        fileMenu.add(addEvent);
        fileMenu.add(addTask);
        fileMenu.insertSeparator(2);
        fileMenu.add(exitFrame);

        //add menus to the menu bar
        bar.add(fileMenu);
        bar.add(editMenu);
        bar.add(viewMenu);

        //set the menu bar for the frame
        frame.setMenuBar(bar);
    }
}
