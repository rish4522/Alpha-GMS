import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewSchedule extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JList<Schedule> scheduleList;
    private DefaultListModel<Schedule> scheduleListModel;
    private JScrollPane scrollPane;
    private JButton backButton;
    private HomePage homePage;

    public ViewSchedule(HomePage homepage) {
        super("View Schedule");
        HomePage homepage = new HomePage();
        ViewSchedule viewSchedule = new ViewSchedule(homePage);
        viewSchedule.setVisible(true);
        // set window properties
        setSize(500, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.homePage = homepage;

        // create components
        titleLabel = new JLabel("VIEW SCHEDULE");
        titleLabel.setBounds(180, 20, 150, 30);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        titleLabel.setForeground(Color.BLACK);
        add(titleLabel);

        scheduleListModel = new DefaultListModel<>();
        for (Schedule schedule : homePage.getSchedules()) {
            scheduleListModel.addElement(schedule);
        }

        scheduleList = new JList<>(scheduleListModel);
        scheduleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(scheduleList);
        scrollPane.setBounds(50, 60, 400, 200);
        add(scrollPane);

        backButton = new JButton("Back");
        backButton.setBounds(200, 270, 80, 25);
        backButton.addActionListener(this);
        add(backButton);

        // set background color
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            // close window
            dispose();
        }
    }
}
