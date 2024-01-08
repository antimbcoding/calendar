package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalendarPanel extends JPanel{

    private JLabel monthHeader;
    private JPanel daysPanel;
    private JPanel dayHeader;
    private final CalendarManager calendar;
    private JPanel topContainer;

    //constructor
    public CalendarPanel(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setBackground(new Color(198, 202, 228));

        topContainer = new JPanel(new GridLayout(1, 3, 5, 5));
        JButton prevMonthButton = new JButton("Previous Month");
        prevMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.prevMonth();
                update();
            }
        });

        JButton nextMonthButton = new JButton("Next Month >");
        nextMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.nextMonth();
                update();
            }
        });

        monthHeader = new JLabel("MONTH", SwingConstants.CENTER);
        monthHeader.setFont(new Font("SansSerif", Font.BOLD, 32));

        dayHeader = new JPanel(new GridLayout(1, 5, 3, 5));
        dayHeader.setBackground(new Color(198, 202, 228));

        daysPanel = new JPanel(new GridLayout(6, 7, 3, 3));
        daysPanel.setBackground(new Color(198, 202, 228));
        calendar = new CalendarManager();

        for (String day : calendar.getDayNames()) {
            JLabel dayLabel = createDayLabel(day);
            dayHeader.add(dayLabel);
        }

        update();

        topContainer.add(prevMonthButton);
        topContainer.add(monthHeader);
        topContainer.add(nextMonthButton);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.ipady = 80;
        add(topContainer, c);
        c.gridy = 1;
        c.ipady = 0;
        add(dayHeader, c);
        c.ipady = 320;
        c.gridy = 2;

        add(daysPanel, c);
    }

    private void update() {
        monthHeader.setText(calendar.getCurrentMonthName());
        daysPanel.removeAll();
        int count = 0;
        int paddingFront = calendar.getFirstDayOfMonth() - 1;
        for(int i = 0; i<paddingFront; i++){
            JLabel blank = createDayLabel("");
            daysPanel.add(blank);
            count++;
        }

        for (int day : calendar.getCurrentMonthDays()) {
            JLabel dayLabel = createDayLabel(String.valueOf(day));
            daysPanel.add(dayLabel);
            count++;
        }
        
        for(int i = count; i<42; i++){
            JLabel blank = createDayLabel("");
            daysPanel.add(blank);
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
