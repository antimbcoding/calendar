package Window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class CalendarPanel extends JPanel{

    private JLabel monthHeader;
    private JPanel daysPanel;
    private final CalendarManager calendar;

    //constructor
    public CalendarPanel(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.RED);

        monthHeader = new JLabel("MONTH", SwingConstants.CENTER);
        daysPanel = new JPanel(new GridLayout(5, 7, 5, 5));
        calendar = new CalendarManager();

        update();

        add(monthHeader, BorderLayout.NORTH);
        add(daysPanel, BorderLayout.CENTER);
    }

    private void update() {
        monthHeader.setText(calendar.getCurrentMonthName());
        daysPanel.removeAll();
    
        for (String day : calendar.getDayNames()) {
            JLabel dayLabel = createDayLabel(day);
            daysPanel.add(dayLabel);
        }
    
        for (int day : calendar.getCurrentMonthDays()) {
            JLabel dayLabel = createDayLabel(String.valueOf(day));
            daysPanel.add(dayLabel);
        }
    
        revalidate();
        repaint();
    }
    
    private JLabel createDayLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add a border
        label.setBackground(Color.WHITE); // Set a background color
        label.setOpaque(true); // Ensure the label is opaque to show the background color
        return label;
    }

}
