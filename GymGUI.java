/*
The GUI component of the Project where awt and swing components are bring added
1. An Array List is created to store objects of Premium and Regular members
2. The objects in array list are stored in the GYM main class array
3. Adding Components : Text field, Combo box , radio button and Button
4. Buttons perform respective actions

 */
//importing required package and implementing them.

// Array is used to store the objects of regular and premium member
//The table is used to display the output in a different panel for regular members and premium members
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GymGUI{
    public static void main (String[] args){
        //Creating an array list of the Gym member class
        //All the objects of the regular and premium members are stored in the array list of class Gym Member
        ArrayList<GymMember> gymMembers = new ArrayList<GymMember>();


        // Creating frame for the Interface
        //This is the main Frame where all the elements are shown
        JFrame frame = new JFrame("Pokhara Gym");


        //setting properties of the interface

        //size of the frame is set in pixcles
        frame.setSize(700,800);
        //The frame is visible when the program runs
        frame.setVisible(true);
        //setting the Layout of the frame
        frame.setLayout(new GridLayout(4,1));
        //When the interface window is closed the program also terminates
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //Creating 4 panels for containing various parts of the interface

        //Panel 1 for the Header of the interface
        JPanel panel1 = new JPanel();
        //setting layout of the Panel 1
        panel1.setLayout(new BorderLayout());


        //panel2 for the form part of the GUI
        JPanel panel2 = new JPanel();
        //setting the layout of the panel
        panel2.setLayout(new FlowLayout());  //____________>> try using insert in Grid layout


        //panel 3 for the buttons of the GUI
        JPanel panel3 = new JPanel();
        //setting the layout of the panel
        panel3.setLayout(new GridBagLayout());

        //For the Grid bag layout we need grid bag constrains
        GridBagConstraints gbc = new GridBagConstraints();



        //In Panel 1

        //Header in panel 1
        //Creating a Label  for the header and placing it at the centre of the panel
        JLabel header = new JLabel("Pokhara Gym",SwingConstants.CENTER);
        //Creating an object for font (Style: Arial , Bold and size is 40 pix)
        Font headerFont = new Font("Arial",Font.BOLD,40);
        //Implementing the font object for the header
        header.setFont(headerFont);
        //setting panel1 background (A soft green Color )
        panel1.setBackground(new Color(172,209,175));
        //Adding header on the panel
        panel1.add(header);

        //In panel 2

        // The Elements in panel 2
        // Adding labels for each element on the interface
        JLabel idLabel = new JLabel("ID :");
        JLabel nameLabel = new JLabel("Name :" );
        JLabel locationLabel = new JLabel("Location :");
        JLabel phoneLabel = new JLabel("Phone number :");
        JLabel emailLabel = new JLabel("Email");
        JLabel genderLabel = new JLabel("Gender :");
        JLabel dobLabel = new JLabel("DOB :");
        JLabel membershipLabel = new JLabel("Membership Start Date : ");
        JLabel referralLabel = new JLabel("Referral Source :");
        JLabel paidAmountLabel = new JLabel("Paid Amount :");
        JLabel removalLabel = new JLabel("Removal Reason :");
        JLabel trainerLabel = new JLabel("Trainer's Name :");
        JLabel regularMemberPlanLabel = new JLabel("Regular Member Plans :");

        //Adding text field for each element
        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField locationField = new JTextField(10);
        JTextField phoneField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JTextField referralField = new JTextField(10);
        JTextField paidAmountField = new JTextField(10);
        JTextField removalField = new JTextField(10);
        JTextField trainerField = new JTextField(10);

        //Text Field for the Price of membership
        JTextField regularPriceField = new JTextField("Regular Price : Amount");
        //Cannot be edited
        regularPriceField.setEditable(false);
        JTextField premiumPriceField = new JTextField("Regular Price : Amount");
        premiumPriceField.setEditable(false);
        JTextField deluxePriceField = new JTextField("Regular Price : Amount");
        deluxePriceField.setEditable(false);
        //----------------------------------------------------------------------------------------------------------------------
        //Adding  Combo Box
        //Creating array for the combo box used for
        Integer[] yearsArray = {2002, 2003, 2004, 2005, 2006, 2007 ,2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024};
        String[] monthArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Integer[] dayArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        String[] optionArray = {"Basic","Standard","Deluxe"};

        //Now Creating a combo box Object for DOB
        JComboBox<Integer> dobYearComboBox = new JComboBox<Integer>(yearsArray);
        JComboBox<Integer> dobDayComboBox = new JComboBox<>(dayArray);
        JComboBox<String> dobMonthComboBox = new JComboBox<>(monthArray);


        //Now Creating a combo box Object for Membership Start Date
        JComboBox<Integer> membershipYearComboBox = new JComboBox<>(yearsArray);
        JComboBox<Integer> membershipDayComboBox  = new JComboBox<>(dayArray);
        JComboBox<String> membershipMonthComboBox = new JComboBox<>(monthArray);

        //Combo Box for the regular member plan
        JComboBox<String> additionalComboBox = new JComboBox<>(optionArray);

        //Here I ran into a problem of using primitive data type in array.
        //Solution, I changed the raw primitive type into Integer class.
        //----------------------------------------------------------------------------------------------------------------------
        //In panel 3
        //Adding Buttons
        //For type adding type of member
        JButton regularMemberButton = new JButton("Add Regular Member");
        JButton premiumMemberButton = new JButton("Add Premium Member");

        //Active Member
        JButton activeMembershipButton = new JButton("Activate Membership ");

        //Deactivate member
        JButton deactivateMembershipButton = new JButton("Deactivate Membership ");

        //Mark Attendance
        JButton markAttendanceButton = new JButton("Mark Attendance ");

        //Revert Regular Member
        JButton revertRegularMemberButton = new JButton("Revert Regular Member");

        //Revert Premium Member
        JButton revertPremiumMemberButton = new JButton("Revert Premium Member");

        //Display Member
        JButton displayButton = new JButton("Display");

        //Clear Member
        JButton clearButton = new JButton("Clear");

        //Adding radio Button
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");


        //Grouping the radioButtons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        //Adding elements on the panel2
        panel2.add(idLabel);
        panel2.add(idField);
        panel2.add(nameLabel);
        panel2.add(nameField);
        panel2.add(locationLabel);
        panel2.add(locationField);
        panel2.add(phoneLabel);
        panel2.add(phoneField);
        panel2.add(emailLabel);
        panel2.add(emailField);
        panel2.add(genderLabel);
        panel2.add(maleRadioButton);
        panel2.add(femaleRadioButton);
        panel2.add(dobLabel);
        panel2.add(dobYearComboBox);
        panel2.add(dobMonthComboBox);
        panel2.add(dobDayComboBox);
        panel2.add(membershipLabel);
        panel2.add(membershipYearComboBox);
        panel2.add(membershipMonthComboBox);
        panel2.add(membershipDayComboBox);
        panel2.add(referralLabel);
        panel2.add(referralField);
        panel2.add(paidAmountLabel);
        panel2.add(paidAmountField);
        panel2.add(removalLabel);
        panel2.add(removalField);
        panel2.add(trainerLabel);
        panel2.add(trainerField);
        panel2.add(regularPriceField);
        panel2.add(premiumPriceField);
        panel2.add(deluxePriceField);
        panel2.add(regularMemberPlanLabel);
        panel2.add(additionalComboBox);

        //Adding Buttons in Panel 3
        panel3.add(regularMemberButton);
        panel3.add(premiumMemberButton);
        panel3.add(activeMembershipButton);
        panel3.add(deactivateMembershipButton);
        panel3.add(markAttendanceButton);
        panel3.add(revertRegularMemberButton);
        panel3.add(revertPremiumMemberButton);
        panel3.add(displayButton);
        panel3.add(clearButton);

        //----------------------------------------------------------------------------------------------------------------------
        //Action Listener to the buttons

        //For Buttons adding action listener

        regularMemberButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Implementing try catch for the button
                    try {
                        //IF the ID field is empty then the corresponding error message will be shown

                        if (idField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "ID field is empty");
                        }

                        //Getting all the values from the textFields

                        //Here Type casting is being done: We get string form the text field so now we are type casting it to Integer
                        int fetchID = Integer.parseInt(idField.getText());
                        String fetchName = nameField.getText();
                        String fetchLocation = locationField.getText();
                        String fetchPhone = phoneField.getText();
                        String fetchEmail = emailField.getText();
                        //If the selected radio button is of male it will pass male else female
                        String fetchGender = maleRadioButton.isSelected() ? "Male" : "Female";//Using ternary operators

                        //The selected item in the comboBox extracted, they are converted into String
                        String fetchDOBYear = dobYearComboBox.getSelectedItem().toString();
                        String fetchDOBMonth = dobMonthComboBox.getSelectedItem().toString();
                        String fetchDOBDay = dobDayComboBox.getSelectedItem().toString();

                        //Making a single DOB for storage so that they can be stored as one variable
                        String fetchDob = fetchDOBYear+"-"+ fetchDOBMonth+"-" + fetchDOBDay;

                        String fetchMembershipYear = membershipYearComboBox.getSelectedItem().toString();
                        String fetchMembershipMonth = membershipMonthComboBox.getSelectedItem().toString();
                        String fetchMembershipDay = membershipDayComboBox.getSelectedItem().toString();
                        //Doing the same thing for MemberShip start date

                        String fetchMembershipDate = fetchMembershipYear + fetchMembershipMonth + fetchMembershipDay;

                        String fetchReferral = referralField.getText();

                        //Setting a boolean value for keeping track of the existing Member

                        boolean exist = false;

                        //From the array list of gym member, each object is taken and its ID is checked with the Entered value in Field

                        for (GymMember check : gymMembers) {
                            if (check.getId() == fetchID) {

                                //If the value already exist in the array then Boolean value will be set to true
                                exist = true;
                                //For each loop will break
                                break;
                            }
                        }
                        //If the ID does not match then only the new member will be created and added in the array list
                        if (!exist) {

                            //Creating an object for the regular gym member and passing all the fetched values as the parameter.
                            RegularMember regularMember1 = new RegularMember(fetchID, fetchName, fetchLocation, fetchPhone, fetchEmail, fetchGender, fetchDob, fetchMembershipDate, fetchReferral);

                            //Now a regular member object is created so, the object is now going to be added in the Gym member array list
                            gymMembers.add(regularMember1);
                            JOptionPane.showMessageDialog(frame, "Regular member added Successfully");

                        } else {
                            //If the member exist already then a dialogue box will appear
                            JOptionPane.showMessageDialog(frame, "The Member already exist");
                        }
                    }

                        //IF the entered value in the text field is not a number i.e. String, then It will generate an error
                    catch (NumberFormatException numberFormatException){
                        //For String value error input following message will show in the screen
                        JOptionPane.showMessageDialog(frame, "Enter a valid number input in ID");


                    }
                    
                }
            });

        premiumMemberButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Implementing try catch for the button
                    try {
                        //IF the ID field is empty then the corresponding error message will be shown

                        if (idField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "ID field is empty");
                        }

                        //Getting all the values from the textFields
                        int fetchID = Integer.parseInt(idField.getText());
                        String fetchName = nameField.getText();
                        String fetchLocation = locationField.getText();
                        String fetchPhone = phoneField.getText();
                        String fetchEmail = emailField.getText();
                        String fetchGender = maleRadioButton.isSelected() ? "Male" : "Female";

                        String fetchDOBYear = dobYearComboBox.getSelectedItem().toString();
                        String fetchDOBMonth = dobMonthComboBox.getSelectedItem().toString();
                        String fetchDOBDay = dobDayComboBox.getSelectedItem().toString();
                        //Making a single DOB for storage
                        String fetchDob = fetchDOBYear + fetchDOBMonth + fetchDOBDay;

                        String fetchMembershipYear = membershipYearComboBox.getSelectedItem().toString();
                        String fetchMembershipMonth = membershipMonthComboBox.getSelectedItem().toString();
                        String fetchMembershipDay = membershipDayComboBox.getSelectedItem().toString();
                        //Doing the same thing for MemberShip start date

                        String fetchMembershipDate = fetchMembershipYear + fetchMembershipMonth + fetchMembershipDay;

                        String fetchTrainer = trainerField.getText();
                        //Setting a boolean value for keeping track of the existing Member

                        boolean exist = false;

                        for (GymMember check : gymMembers) {
                            if (check.getId() == fetchID) {
                                exist = true;
                                break;
                            }
                        }
                        if (!exist) {

                            //Creating an object for the regular gym member and passing all the fetched values as the parameter.
                            PremiumMember premiumMember1 = new PremiumMember(fetchID, fetchName, fetchLocation, fetchPhone, fetchEmail, fetchGender, fetchDob, fetchMembershipDate, fetchTrainer);

                            //Now a regular member object is created so, the object is now going to be added in the Gym member array list
                            gymMembers.add(premiumMember1);
                            JOptionPane.showMessageDialog(frame, "Premium member added Successfully");

                        } else {
                            JOptionPane.showMessageDialog(frame, "The Member already exist");
                        }
                    }


                    catch (NumberFormatException numberFormatException){
                        JOptionPane.showMessageDialog(frame, "Enter a valid number input in ID");


                    }

                }
            });

        activeMembershipButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Taking the ID of the member form the ID field of the GUI and checking, if the member is present in the array list or not
                    try {
                        //IF the ID field is empty then the corresponding error message will be shown

                        if (idField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "ID field is empty");
                        }
                        boolean exist = false;

                        //Taking the user entered id form the filed
                        int fetchID = Integer.parseInt(idField.getText());

                        for (GymMember check : gymMembers) {
                            if (check.getId() == fetchID) {
                                exist = true;
                                check.activeMembership();
                                JOptionPane.showMessageDialog(frame,"Member activated SuccessFully ");
                                break;
                            }
                        }
                        if (!exist) {
                            JOptionPane.showMessageDialog(frame,"Member does not exist");
                        }

                    }catch (NumberFormatException numberFormatException){
                        JOptionPane.showMessageDialog(frame,"Enter a valid ID");
                    }
                }
            });

        //for Deactivate  member
        deactivateMembershipButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        if (idField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "ID field is empty");
                        }
                        boolean exist = false;

                        //Taking the user entered id form the filed
                        int fetchID = Integer.parseInt(idField.getText());

                        for (GymMember check : gymMembers) {
                            if (check.getId() == fetchID) {
                                if(check.getActiveStatus() == true){
                                    exist = true;
                                    check.deactivateMembership();
                                    JOptionPane.showMessageDialog(frame,"Member deactivated SuccessFully ");
                                    break;
                                }
                            }else{
                                JOptionPane.showMessageDialog(frame,"Membership is not activated, activate your membership first.");
                            }
                        }
                        if (!exist) {
                            JOptionPane.showMessageDialog(frame,"Member does not exist");
                        }

                    }catch (NumberFormatException exception){
                        JOptionPane.showMessageDialog(frame,"Enter a valid Input ");
                    }
                }
            });

        markAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (idField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "ID field is empty");
                        return;
                    }

                    int fetchID = Integer.parseInt(idField.getText());
                    boolean found = false;

                    for (GymMember member : gymMembers) {
                        if (member.getId() == fetchID) {
                            found = true;
                            if (member.getActiveStatus()) {
                                member.markAttendance();
                                JOptionPane.showMessageDialog(frame, "Attendance Marked Successfully.");
                            } else {
                                JOptionPane.showMessageDialog(frame, "Member is not active.");
                            }
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(frame, "Member does not exist.");
                    }

                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(frame, "Enter a valid ID");
                }
            }
        });

        //Reverting the Premium and regular members
        revertRegularMemberButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        //IF the ID field is empty then the corresponding error message will be shown

                        if (idField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "ID field is empty");
                        }
                        boolean exist = false;

                        //Taking the user entered id form the filed
                        int fetchID = Integer.parseInt(idField.getText());

                        for (GymMember check : gymMembers) {
                            if (check.getId() == fetchID) {
                                exist = true;
                                //Here we are performing down casting where is being checked whether the check is an instance if Regular member class or not
                                if (check instanceof RegularMember) {
                                    //If the Check is an instance of Regular member then revertRegular member is true and code runs
                                    ((RegularMember) check).revertRegularMember();

                                    JOptionPane.showMessageDialog(frame, "Regular Member Reverted Successfully ");
                                    break;
                                }
                            }
                            if (!exist) {
                                JOptionPane.showMessageDialog(frame, "Member does not exist");
                            }
                        }

                    }catch (NumberFormatException numberFormatException){
                        JOptionPane.showMessageDialog(frame,"Enter a valid ID");
                    }
                }


            });

        revertPremiumMemberButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        //IF the ID field is empty then the corresponding error message will be shown

                        if (idField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "ID field is empty");
                        }
                        boolean exist = false;

                        //Taking the user entered id form the filed
                        int fetchID = Integer.parseInt(idField.getText());

                        for (GymMember check : gymMembers) {
                            if (check.getId() == fetchID) {
                                exist = true;
                                //Here we are performing down casting where is being checked whether the check is an instance if Regular member class or not
                                if (check instanceof PremiumMember) {
                                    //If the Check is an instance of Regular member then revertRegular member is true and code runs
                                    ((PremiumMember) check).revertPremiumMember();

                                    JOptionPane.showMessageDialog(frame, "Premium Member Reverted Successfully ");
                                    break;
                                }
                            }
                            if (!exist) {
                                JOptionPane.showMessageDialog(frame, "Member does not exist");
                            }
                        }

                    }catch (NumberFormatException numberFormatException){
                        JOptionPane.showMessageDialog(frame,"Enter a valid ID");
                    }
                }
            });


        /*
        For the Display button, 2 tables are created: one for the regular members and one for the Premium Members.
        Both are displayed in the same but different tables.
         */
        displayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //A new frame is created to display the output

                    JFrame display = new JFrame("Display");
                    //Dimensions of the frame is being set
                    display.setSize(500, 500);
                    //The Dispose on close operation will only close the window but not terminate the whole program
                    display.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    /*
                    The layout is of Box layout where the components are adjusted to appear vertically
                    the getContentPane allows the tables to stack on top of one another
                     */
                    display.setLayout(new BoxLayout(display.getContentPane(), BoxLayout.Y_AXIS));

                    // Create tables for both member types
                    //Table for regular member
                    DefaultTableModel infoTableModelRegular = new DefaultTableModel(new String[] {
                                "ID", "Name", "Location", "Number", "email", "Gender", "DOB",
                                "Membership Date", "Referral Source", "Removal Reason"}, 0);//There are the column headers
                    JTable infoTable = new JTable(infoTableModelRegular);//The column names and the structure of the table is given to infoTable
                    JScrollPane scrollPane = new JScrollPane(infoTable);//if the data are to many then they are scrollable

                    //Table for Premium member
                    DefaultTableModel infoTableModelPremium = new DefaultTableModel(new String[] {
                                "ID", "Name", "Location", "Number", "email", "Gender", "DOB",
                                "Membership Date", "Trainer"}, 0);
                    JTable infoTablePre = new JTable(infoTableModelPremium);
                    JScrollPane scrollPanePre = new JScrollPane(infoTablePre);

                    display.add(new JLabel("Regular Members:"));
                    display.add(scrollPane);
                    display.add(new JLabel("Premium Members:"));
                    display.add(scrollPanePre);

                    for (GymMember each : gymMembers) {
                        if (each instanceof RegularMember) {
                            RegularMember value = (RegularMember) each;
                            infoTableModelRegular.addRow(new Object[]{
                                    value.getId(), value.getName(), value.getLocation(),
                                    value.getPhone(), value.getEmail(), value.getGender(),
                                    value.getDob(), value.getMembershipStartDate(),
                                    value.getReferralSource(), value.getRemovalReason()});
                        } else if (each instanceof PremiumMember) {
                            PremiumMember value = (PremiumMember) each;
                            infoTableModelPremium.addRow(new Object[]{
                                    value.getId(), value.getName(), value.getLocation(),
                                    value.getPhone(), value.getEmail(), value.getGender(),
                                    value.getDob(), value.getMembershipStartDate(),
                                    value.getPersonalTrainer()});
                        }
                    }

                    display.setVisible(true);


                }
            });

        clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //All the fields are set as empty for new data entry
                    idField.setText("");
                    nameField.setText("");
                    locationField.setText("");
                    phoneField.setText("");
                    referralField.setText("");
                    emailField.setText("");
                    dobYearComboBox.setSelectedItem(2005);
                    dobMonthComboBox.setSelectedItem("Jan");
                    dobDayComboBox.setSelectedItem(1);
                    membershipYearComboBox.setSelectedItem(2005);
                    membershipMonthComboBox.setSelectedItem("Jan");
                    membershipDayComboBox.setSelectedItem(1);
                    removalField.setText("");
                    trainerField.setText("");
                    maleRadioButton.setSelected(true);
                }
            });







        //----------------------------------------------------------------------------------------------------------------------
        //Adding in frame
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);




    }

}