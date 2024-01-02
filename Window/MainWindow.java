package Window;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainWindow extends Frame{
    
    //constructor (has to be public so it can be called by calendar) 
    public MainWindow(){
        super("Calendar");

        addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        } );

        CalendarPanel calendar = new CalendarPanel();
        add(calendar, BorderLayout.CENTER);

        setResizable(false);
        setSize(960, 640);
        setVisible(true);

        MenuBarHandler menuBar = new MenuBarHandler(this);
        menuBar.setup();
         
    }
}
