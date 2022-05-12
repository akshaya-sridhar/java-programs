import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;  

class tasks {
    int taskid;
    String taskname;
    String timeassigned;
    String timedue;
    String person_fname;
    String person_lname;
    String personname;
    int age;
    String sex;
    String designation;

    public void fullname() {
        personname = person_fname + " " + person_lname;
    }

    public void display() {
        fullname();
        System.out.println("\nTask Name: " + taskname +
                "\nTime Assigned: " + timedue +
                "\nTime Due: " + timedue +
                "\nPerson name: " + personname +
                "\nDesignation: " + designation+
                "\nAge: "+age);
    }
}

class products {
    int stock_id;
    String productname;
    String producttype;
    String proexpirydate;
    double proquantity;
    double propriceperunit;
    double prototalcost;
    String proresponsibleperson;
    String provendorname;

    protected void price() {
        prototalcost = propriceperunit * proquantity;
    }

    public void display() {
        System.out.println("\nName: " + productname +
                "\nType: " + producttype +
                "\nQuantity: " + proquantity +
                "\nPrice per unit: " + propriceperunit +
                "\nTotal cost: " + prototalcost);
    }


    public void expiryDates(String checkdate)
    {
        try{
            // Create 2 dates start
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = sdf.parse(checkdate);
            Date date2 = sdf.parse(proexpirydate);

            System.out.println("Check date: "+sdf.format(date1));
            System.out.println("Expiry date: "+sdf.format(date2));
            System.out.println();

            if(date1.after(date2)){
                System.out.println("Product has expired. ");
            }

            if(date1.before(date2) || date1.equals(date2)){
                System.out.println("Product has not expired. ");
            }

            System.out.println();
        }
        catch(ParseException ex){
            ex.printStackTrace();
        }
    }
}

// class representing custom exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String str) {
        // calling the constructor of parent Exception
        super(str);
    }
}

// class that uses custom exception InvalidAgeException
class TestCustomException1 {

    // method to check the age
    static void validateage(int age) throws InvalidAgeException {
        if (age < 18) {

            // throw an object of user defined exception
            throw new InvalidAgeException("age is not valid");
        }
    }
}

public class exceptionerror {
    public static void main(String[] args) {
        // task class
        tasks tas = new tasks();
        tas.person_fname = "Peter";
        tas.person_lname = "Mathew";
        tas.timedue = "11:00 AM";
        tas.taskname = "Cleaning Kitchen";
        tas.timeassigned = "10:00 AM";
        tas.designation = "Cleaner";
        int age=13;
        try  
        {  
            // calling the method   
            TestCustomException1.validateage(age);  
        }  
        catch (InvalidAgeException ex)  
        {  
            System.out.println("Caught the exception");  
    
            // printing the message from InvalidAgeException object  
            System.out.println("Exception occured: " + ex);  
        }  

        products pro = new products();
        pro.proexpirydate="05/05/2022";
        pro.expiryDates("06/05/2022");
        tas.display();

    }
}