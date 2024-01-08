# Calendar by Antim Baru

Calendar is both functional as a calendar and a habit tracker implementation. It creates its GUI using Java.awt.

# Features

- Creates an accurate calendar based on your current month and year
- Allows traversal through months
- Has menu bar up top (useful for the implementation of a fully fledged calendar)

# Files and Breakdown

- Calendar.java - contains the main method and creates an instance of the window
- MainWindow.java - starts the GUI and also contains features such as closing the GUI, and creates instances for the CalendarPanel(the main calendar being shown) and the MenuBarHandler
- MenuBarHandler.java - creates a MenuBar, Menus and MenuItems (Exit item added) and showcase on dividers for the Menu items
- CalendarPanel.java - uses java Swing to create a calendar interface using the CalendarManager. Several layouts are used to mark where exactly everything goes. Also contains an update method which helps refresh the calendar. The CalendarPanel file uses mainly JPanels and JLabels to help the user visualize the calendar.
- CalendarManeger.java - represents a Gregorian calendar
