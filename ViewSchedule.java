import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.List;


public class ViewSchedule extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTable scheduleTable;
    private DefaultTableModel scheduleTableModel;
    private JButton addButton, editButton, deleteButton;

    private List<Schedule> scheduleList;

    public ViewSchedule() {
        setTitle("View Schedule");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        scheduleList = new ArrayList<>();
        scheduleTableModel = new DefaultTableModel(new Object[]{"ID", "Date", "Trainer Name", "Member Name"}, 0);
        scheduleTable = new JTable(scheduleTableModel);
        JScrollPane scrollPane = new JScrollPane(scheduleTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddScheduleDialog dialog = new AddScheduleDialog();
                dialog.setVisible(true);

                if (dialog.isConfirmed()) {
                    Schedule s = dialog.getSchedule();
                    scheduleList.add(s);
                    scheduleTableModel.addRow(new Object[]{s.getId(), s.getDate(), s.getTrainerName(), s.getMemberName()});
                }
            }
        });

        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = scheduleTable.getSelectedRow();
                if (rowIndex >= 0) {
                    int id = (int) scheduleTableModel.getValueAt(rowIndex, 0);
                    Schedule s = scheduleList.stream().filter(schedule -> schedule.getId() == id).findFirst().get();
                    AddScheduleDialog dialog = new AddScheduleDialog(s);
                    dialog.setVisible(true);

                    if (dialog.isConfirmed()) {
                        Schedule updatedSchedule = dialog.getSchedule();
                        s.setDate(updatedSchedule.getDate());
                        s.setTrainerName(updatedSchedule.getTrainerName());
                        s.setMemberName(updatedSchedule.getMemberName());
                        scheduleTableModel.setValueAt(updatedSchedule.getDate(), rowIndex, 1);
                        scheduleTableModel.setValueAt(updatedSchedule.getTrainerName(), rowIndex, 2);
                        scheduleTableModel.setValueAt(updatedSchedule.getMemberName(), rowIndex, 3);
                    }
                }
            }
        });

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = scheduleTable.getSelectedRow();
                if (rowIndex >= 0) {
                    int id = (int) scheduleTableModel.getValueAt(rowIndex, 0);
                    scheduleList.removeIf(schedule -> schedule.getId() == id);
                    scheduleTableModel.removeRow(rowIndex);
                }
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

private static class AddScheduleDialog extends JDialog {
    private JTextField dateField, trainerField, memberField;
    private JButton okButton, cancelButton;

    private Schedule schedule;
    private boolean confirmed;

    public AddScheduleDialog() {
        setTitle("Add Schedule");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        dateField = new JTextField(10);
        trainerField = new JTextField(10);
        memberField = new JTextField(10);

        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateField.getText());
                    String trainerName = trainerField.getText().trim();
                    String memberName = memberField.getText().trim();

                    Schedule s = new Schedule(date, trainerName, memberName);
                    setSchedule(s);
                    setConfirmed(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
                }
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setConfirmed(false);
                dispose();
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Date (dd-MM-yyyy)"));
        panel.add(dateField);
        panel.add(new JLabel("Trainer Name"));
        panel.add(trainerField);
        panel.add(new JLabel("Member Name"));
        panel.add(memberField);
        panel.add(okButton);
        panel.add(cancelButton);

        add(panel);

        setModal(true);
        setVisible(false);
    }

    public AddScheduleDialog(Schedule s) {
        this();
        setTitle("Edit Schedule");
        setSchedule(s);
        dateField.setText(new SimpleDateFormat("dd-MM-yyyy").format(s.getDate()));
        trainerField.setText(s.getTrainerName());
        memberField.setText(s.getMemberName());
    }

    public Schedule getSchedule() {
        return schedule;
    }
    
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }
    
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}

private static class Schedule {
    private static int nextId = 1;

    private int id;
    private Date date;
    private String trainerName;
    private String memberName;

    public Schedule(Date date, String trainerName, String memberName) {
        this.id = nextId++;
        this.date = date;
        this.trainerName = trainerName;
        this.memberName = memberName;
    }

    public Schedule(int id, Date date, String trainerName, String memberName) {
        this.id = id;
        this.date = date;
        this.trainerName = trainerName;
        this.memberName = memberName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSchedule().setVisible(true);
            }
        });
    }
}