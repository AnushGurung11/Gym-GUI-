/*
This abstract class consist of the getter and the setter methods. 
Reset method, Display method, marked attendace abstract method and active and deactive method
 */

import javax.swing.*;
public abstract class GymMember{
    //attributes
    protected int id;
    protected String name ;
    protected String location;
    protected String phone;
    protected String email;
    protected String dob;
    protected String membershipStartDate;
    protected String gender;
    protected int attendance  ;
    protected double loyaltyPoints  ;
    protected boolean activeStatus ;

    //Accessor Methods
    //get the of the user 
    public int getId(){
        return this.id;
    }

    //get the Name 
    public String getName(){
        return this.name;
    }

    //get the Location 
    public String getLocation(){
        return this.location;
    }

    //get the email 
    public String getEmail(){
        return this.email;
    }

    //get the Dob 
    public String getDob(){
        return this.dob;
    }

    //get the Phone 
    public String getPhone(){
        return this.phone;
    }

    //Get the gender 
    public String getGender(){
        return this.gender;

    }

    //get the membership Start date 
    public String getMembershipStartDate(){
        return this.membershipStartDate;
    }

    //get the Attendance

    public int getAttendance(){
        return this.attendance;
    }

    //get the Loyalty Points 

    public double getLoyaltyPoints(){
        return this.loyaltyPoints;
    }

    public boolean getActiveStatus(){
        return this.activeStatus;
    }

    //parameterised constructor 
    public GymMember(int id , String name, String location,
    String phone, String email, String gender, String dob, 
    String membershipStartDate){

        this.id = id ;
        this.name = name ; 
        this.location = location ; 
        this.phone = phone; 
        this.email = email;
        this.gender = gender; 
        this.dob = dob;
        this.membershipStartDate = membershipStartDate; 
        this.attendance = 0;
        this.loyaltyPoints = 0; 
        this.activeStatus = false;

    }

    //creating an abstract method for markAttendance which will calculate attendance and points
    public abstract void markAttendance();

    //Set the active status of the user to true when method is called 
    public void activeMembership(){
        this.activeStatus = true;
        System.out.println("Member Activated");

    }

    //Check the active status for the user 
    //when status is true on then the method is called 

    public void deactivateMembership(){
        if(this.activeStatus){
            this.activeStatus = false;
            System.out.println("Successfully Deactivated");

        }else{
            System.out.println("Member is not active");
        }

    }

    //Set the attendance, loyaltyPoints to 0 and activeStatus to false
    public void resetMember(){
        this.attendance = 0;
        this.loyaltyPoints = 0; 
        this.activeStatus = false;
    }

    //Display method for displaying the all the info of the user 

    public void display(){
        System.out.println("Id:" + getId());
        System.out.println("Name: "+getName());
        System.out.println("Phone number: "+getPhone());
        System.out.println("Address: "+ getLocation());
        System.out.println("Email: "+getEmail());
        System.out.println("Gender: "+ getGender());
        System.out.println("Date of Birth: "+ getDob());
        System.out.println("Membership Started: "+ getMembershipStartDate());
        System.out.println("Attendance: "+ getAttendance());
        System.out.println("Loyalty Points: "+ getLoyaltyPoints());
        System.out.println("Active Status: "+ getActiveStatus());
    }
}