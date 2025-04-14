public class RegularMember extends GymMember{

    //Private attributes (only exclusive for this class)
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade  ;
    private final String removalReason ;
    private final String referralSource;
    private String plan ;
    private double price ;

    //parameterised constructor 
    public RegularMember (int id, String name, String location, String phone, String email, String gender, 
    String dob, String membershipStartDate, String referralSource){
        super(id, name, location,phone, email, gender, dob, membershipStartDate);
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;
        this.removalReason = "";
        this.plan = "basic";
        this.price = 6500;
        this.attendanceLimit = 30;

    }

    // accessor methods for the attributes
    public int getAttendanceLimit(){
        return this.attendanceLimit;
    }

    public boolean getIsEligibleForUpgrade(){
        return this.isEligibleForUpgrade;
    }

    public String getRemovalReason(){
        return this.removalReason;
    }

    public String getReferralSource(){
        return this.referralSource;
    }

    public String getPlan(){
        return this.plan;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public void markAttendance(){
        this.attendance = attendance + 1;
        this.loyaltyPoints +=5;
    }

    //plan checker 
    public double getPlanPrice(String plan1){

        // variable will stored the value according to the condition 

        double price = 0;
        String plan = plan1.toLowerCase();//The entered value is converted to the lower case

        // switch is used for setting the price value accordingly and passed the price variable 
        switch(plan){

            case "basic":
                price = 6500;
                break;

            case "standard":
                price = 12500;
                break;

            case "delux":
                price = 18500;
                break;

            default :
                System.out.println("Please enter the appropriate plan.");
                return -1;
        }

        return price;
    }

    //upgrading the plan 

    public String upgradePlan(String plan1){
        //Upgrading the plan of the user 

        //the condition will only run when the eligibility is true 
        if (super.getAttendance() >= this.attendanceLimit){

            this.isEligibleForUpgrade = true;
            //Plan1 from parameter is passed and set to lowercase 
            String plan = plan1.toLowerCase();

            if(this.isEligibleForUpgrade == true){
                if (plan == "standard"){
                    if (this.plan == "standard"){
                        System.out.println("You are already subscribed to this plan.");
                    }
                    this.plan = "standard";
                    this.price = 12500;
                }else if (plan == "delux"){
                    if (this.plan == "delux"){
                        System.out.println("You are already subscribed to this plan.");
                    }
                    this.plan = "delux";
                    this.price = 18500;
                }
            }

            return plan;
        }
        return "You are not Eligible for upgrade. Fullfill the attendace requirement";
    }

    /*Reverting methods where all the removal reason and resetting
    member is done */

    public void revertRegularMember(){
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;

    }

    //displaying  all infor about regular member

    public void display(){
        super.display();
        System.out.println("Plan: "+this.plan);
        System.out.println("Price: "+this.price);
        if(this.removalReason != ""){
            System.out.println("Removal reason: "+this.removalReason);
        }

    }

}
