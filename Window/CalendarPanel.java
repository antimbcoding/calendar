package Window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class CalendarPanel extends JPanel{

    private JLabel monthHeader;
    private JPanel daysPanel;
    private JPanel dayHeader;
    private final CalendarManager calendar;

    //constructor
    public CalendarPanel(){
        setLayout(new GridBagLayout());

        monthHeader = new JLabel("MONTH", SwingConstants.CENTER);
        monthHeader.setPreferredSize(new Dimension(960, 20));
        monthHeader.setFont(new Font("SansSerif", Font.BOLD, 14));

        dayHeader = new JPanel(new GridLayout(1, 5, 5, 5));
        dayHeader.setPreferredSize(new Dimension(100, 20));

        daysPanel = new JPanel(new GridLayout(5, 7, 5, 5));
        daysPanel.setPreferredSize(new Dimension(100, 100));
        calendar = new CalendarManager();

        for (String day : calendar.getDayNames()) {
            JLabel dayLabel = createDayLabel(day);
            dayHeader.add(dayLabel);
        }

        update();

        add(monthHeader);
        add(dayHeader);
        add(daysPanel);
    }

    private void update() {
        monthHeader.setText(calendar.getCurrentMonthName());
        daysPanel.removeAll();
        
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
