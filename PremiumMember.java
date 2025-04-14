public class PremiumMember extends GymMember{

    //attriburtes
    private final double premiumCharge = 50000.0;
    private String personalTrainer;
    private double paidAmount;
    private double discountAmount ;
    private boolean isFullPayment ; 

    //Constructor
    public PremiumMember(int id , String name, String location,
    String phone, String email, String gender, String dob, 
    String membershipStartDate, String personalTrainer){
        //calling Supperclass constructor 
        super(id,name,location,phone,email,gender,dob,membershipStartDate);

        //initializing the values 
        this.personalTrainer = personalTrainer;
        this.paidAmount = 0;
        this.discountAmount = 0;

    }
    //making accessor methods 
    public double getPremiumCharge(){
        return this.premiumCharge;
    }

    public String getPersonalTrainer(){
        return this.personalTrainer;
    }

    public double getPaidAmount(){
        return this.paidAmount;
    }

    private double getDiscountAmount (){
        return this.discountAmount;   
    }

    public boolean getIsFullPayment (){
        return this.isFullPayment;
    }

    //Due Amount method 

    public String payDueAmount(double paidAmount){

        //Checking if the amoubt is already paid
        if(this.isFullPayment){
            return "The amount is already paid. No due amount remaining"; 
        }

        //if the amount is not paid, it is being added in the paid amount lable 
        this.paidAmount += paidAmount; 

        //This is for the full Payment of the premium memership 
        if (paidAmount >= this.premiumCharge - this.discountAmount){
            this.isFullPayment = true;
            return "Fullpayment Completed, no due amount remaining";

        }

        //required message is being passed of the paid amount is successfully added to the account
        return "Amount: "+paidAmount+"recieved"+" Remaining amount: "+ (premiumCharge - this.paidAmount - this.discountAmount); 
    }

    // Creating a discount method and setting the value of discount amount 
    public String calculateDiscount(){
        if ( isFullPayment == true){

            this.discountAmount = (10/100)*getPremiumCharge();
            return "Your dicount amount is: "+this.discountAmount;

        }
        return "Your dicount amount is: "+this.discountAmount;
    }

    //A method for resetting the premiumMember 

    public String revertPremiumMember(){
        super.resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
        return "Resetting the premium member is successful";

    }

    //display method for showing all the info of member 

    public void display(){
        super.display();//aprent classed is called (Constructor is called)
        System.out.println("Assigned trainer: "+this.personalTrainer);
        System.out.println("Amount paid: "+this.paidAmount);
        System.out.println("Full payment: "+this.isFullPayment);
        double remainingAmount = this.premiumCharge - this.paidAmount ;

        if(this.isFullPayment == true){
            System.out.println("The payment is completed and the discountAmount is "+this.discountAmount);
        }else{
            System.out.println("The remaining amount to be paid is :"+remainingAmount);
        }

    }

    //overriding the method form parent class
    @Override
    public  void markAttendance(){
        this.attendance = attendance + 1;
        this.loyaltyPoints = loyaltyPoints + 5;
    }

}