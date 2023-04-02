import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HomePage extends JFrame {
    private JMenuBar menuBar;
    private JMenu memberMenu, paymentMenu, trainerMenu, scheduleMenu, equipmentMenu, shopMenu;
    private JMenuItem addMember, viewMember, addPayment, viewPayment, addTrainer, viewTrainer, addSchedule, viewSchedule, addEquipment, viewEquipment, shopWithUs;
    private JLabel welcomeLabel, socialLabel, contactLabel, titleLabel, bottomLabel;
    private ImageIcon fbIcon, instaIcon, twitterIcon, phoneIcon, emailIcon, addressIcon;
    private ArrayList<Schedule> schedules;

    public ArrayList<Schedule> getSchedules() {
        return this.schedules;
    }
    
    public HomePage() {

        schedules = new ArrayList<>();
        // set window properties
        setTitle("Alpha Gym Management System");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        schedules = new ArrayList<Schedule>();
        
        // create menu bar and menus
        menuBar = new JMenuBar();
        memberMenu = new JMenu("Members");
        trainerMenu = new JMenu("Trainers");
        scheduleMenu = new JMenu("Schedule");
        equipmentMenu = new JMenu("Equipments");
        paymentMenu = new JMenu("Payment");
        shopMenu = new JMenu("Shop");
        
        // create menu items
        addMember = new JMenuItem("Add Member");
        viewMember = new JMenuItem("View Members");
        addTrainer = new JMenuItem("Add Trainer");
        viewTrainer = new JMenuItem("View Trainers");
        addEquipment = new JMenuItem("Add Equipment");
        viewEquipment = new JMenuItem("View Equipment");
        addPayment = new JMenuItem("Add Payments");
        shopWithUs = new JMenuItem("Products");
        
        // add menus to menu bar
        menuBar.add(memberMenu);
        menuBar.add(trainerMenu);
        menuBar.add(scheduleMenu);
        menuBar.add(equipmentMenu);
        menuBar.add(paymentMenu);
        menuBar.add(shopMenu);
        
        // add menu bar to frame
        setJMenuBar(menuBar);

        titleLabel = new JLabel("ALPHA");
        titleLabel.setBounds(300, 180, 300, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);
        
        // create bottom label with copyright text
        bottomLabel = new JLabel("© 2023 Alpha Gym Management System. All Rights Reserved.");
        bottomLabel.setHorizontalAlignment(JLabel.CENTER);
        bottomLabel.setVerticalAlignment(JLabel.CENTER);
        bottomLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        add(bottomLabel, BorderLayout.SOUTH);

        welcomeLabel = new JLabel("Welcome to Alpha Gym!");
        welcomeLabel.setBounds(300, 80, 200, 30);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 18));
        welcomeLabel.setForeground(Color.WHITE);
        add(welcomeLabel);
        
        // create social media links
        fbIcon = new ImageIcon("C:\\Users\\risha\\OneDrive\\Desktop\\JAVA\\Swing_Practice\\GMS\\fb.png");
        instaIcon = new ImageIcon("C:\\Users\\risha\\OneDrive\\Desktop\\JAVA\\Swing_Practice\\GMS\\insta.png");
        twitterIcon = new ImageIcon("C:\\Users\\risha\\OneDrive\\Desktop\\JAVA\\Swing_Practice\\GMS\\twitter.png");
        
        socialLabel = new JLabel("Follow us on:");
        socialLabel.setBounds(575, 25, 200, 20);
        socialLabel.setForeground(Color.WHITE);
        add(socialLabel);
        
        JLabel fbLabel = new JLabel(fbIcon);
        fbLabel.setBounds(650, 20, 30, 30);
        add(fbLabel);
        
        JLabel instaLabel = new JLabel(instaIcon);
        instaLabel.setBounds(690, 20, 30, 30);
        add(instaLabel);
        
        JLabel twitterLabel = new JLabel(twitterIcon);
        twitterLabel.setBounds(730, 20, 30, 30);
        add(twitterLabel);
        
        // create contact information
        
        JLabel phoneLabel = new JLabel(phoneIcon);
        phoneLabel.setBounds(getWidth()-150, getHeight()-60, 30, 30);
        add(phoneLabel);
        
        JLabel emailLabel = new JLabel(emailIcon);
        emailLabel.setBounds(getWidth()-100, getHeight()-60, 30, 30);
        add(emailLabel);
        
        JLabel addressLabel = new JLabel(addressIcon);
        addressLabel.setBounds(getWidth()-50, getHeight()-60, 30, 30);
        add(addressLabel);
        
        contactLabel = new JLabel("<html><center>Hosur Road, Bengaluru - 560029<br/>+91-8052483585, info@alphagym.com</center></html>");
        contactLabel.setBounds(270, 450, 250, 80);
        contactLabel.setForeground(Color.WHITE);
        add(contactLabel);

        JMenuItem addMemberItem = new JMenuItem("Add Member");
        addMemberItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            AddMember addMember = new AddMember(HomePage.this);
            addMember.setVisible(true);
            }
        });
        memberMenu.add(addMemberItem);

        JMenuItem viewMemberMenuItem = new JMenuItem("View Member");
        viewMemberMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewMember viewMember = new ViewMember();
                viewMember.setVisible(true);
            }
        });
        memberMenu.add(viewMemberMenuItem);
        
        JMenuItem addTrainerItem = new JMenuItem("Add Trainer");
        addTrainerItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            AddTrainer addTrainer = new AddTrainer();
            addTrainer.setVisible(true);
            }
        });
        trainerMenu.add(addTrainerItem);

        JMenuItem viewTrainerItem = new JMenuItem("View Trainer");
        viewTrainerItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewTrainer viewTrainer = new ViewTrainer();
                viewTrainer.setVisible(true);
            }
        });
        trainerMenu.add(viewTrainerItem);

        JMenuItem addScheduleItem = new JMenuItem("Add Schedule");
        addScheduleItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            AddSchedule addSchedule = new AddSchedule();
            addSchedule.setVisible(true);
            }
        });
        scheduleMenu.add(addScheduleItem);

        JMenuItem viewScheduleItem = new JMenuItem("View Schedule");
        viewScheduleItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewSchedule viewSchedule = new ViewSchedule();
                viewSchedule.setVisible(true);
            }
        });
        scheduleMenu.add(viewScheduleItem);

        JMenuItem addPaymentItem = new JMenuItem("Add Payments");
        addPaymentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddPayment addPayment = new AddPayment();
                addPayment.setVisible(true);
            }
        });
        paymentMenu.add(addPaymentItem);

        JMenuItem addEquipmentItem = new JMenuItem("Add Equipments");
        addEquipmentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddEquipment addEquipment = new AddEquipment();
                addEquipment.setVisible(true);
            }
        });
        equipmentMenu.add(addEquipmentItem);

        JMenuItem viewEquipmentItem = new JMenuItem("View Equipments");
        viewEquipmentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewEquipment viewEquipment = new ViewEquipment();
                viewEquipment.setVisible(true);
            }
        });
        equipmentMenu.add(viewEquipmentItem);

        JMenuItem shopMenuItem = new JMenuItem("Products");
        shopMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShopWithUs shopWithUs = new ShopWithUs();
                shopWithUs.setVisible(true);
            }
        });
        shopMenu.add(shopMenuItem);

        // set background image
        ImageIcon backgroundIcon = new ImageIcon("bg1.jpg");
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        add(backgroundLabel, BorderLayout.CENTER);
        }
    
    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
    }
}
