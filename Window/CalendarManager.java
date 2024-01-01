package Window;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarManager {

    private Calendar current;

    String[] days = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    public CalendarManager() {
        current = new GregorianCalendar();
    }

    //methods for calendar traversal
    public void nextMonth(){
        current.add(current.MONTH, 1);
    }

    public void prevMonth(){
        current.add(current.MONTH, -1);
    }

    public String[] getDayNames(){
        return days;
    }

    public int[] getCurrentMonthDays() {
        int daysInMonth = current.getActualMaximum(Calendar.DAY_OF_MONTH);
        int[] days = new int[daysInMonth];

        for (int i = 0; i < daysInMonth; i++) {
            days[i] = i + 1;
        }

        return days;
    }

    public String getCurrentMonthName(){
        return new SimpleDateFormat("MMMMMMMMM yyyy").format(current.getTime());
    }
    
}