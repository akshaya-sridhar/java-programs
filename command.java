import java.util.*;

// employee attendence, 

class employee {
    int empid;
    String f_name;
    String l_name;
    String empname;
    String dob;
    String empaddress;
    long empphno;
    String email;
    String designation;
    public void fullname()
    {
        empname=f_name+" "+l_name;
    }

    public void display()
    {
        System.out.println("\nEmployee ID: "+empid+
                            "\nEmployee name: "+empname+
                            "\nAddress: "+empaddress+
                            "\nDesignation: "+designation);  
    }

    public void manager()
    {
        
    }
}

// inheritance to take employee attributes and calculate emp sal

class empsal extends employee {
    int empid;
    String f_name;
    String l_name;
    String empname;
    double basic;
    double hra; // 40 percent of base salary
    double special_allowance;
    double da; // 50 percent of basic 
    double gross_sal;
    double pf; //12 percent of base 
    double esic; //below 21000, 0.0075 
    double net; 

    public void allotment(double basic){
        hra=0.40*basic;
        special_allowance=0.10*basic;
        da=0.50*basic;
        pf=0.12*basic;
        if(basic<21000){
        esic=0.0075*basic;
        }
    }

    public void fullname()
    {
        empname=f_name+" "+l_name;
    }

    public void calcgrosssal(double basic, double hra, double special_allowance, double da)
    {
        //allotment(basic);
        gross_sal=basic+hra+special_allowance+da;
    }

    public void calcnetsal(double pf, double gross_sal, double esic)
    {
        //allotment(basic);
        net=gross_sal-(pf+esic);
    }

    public void calcnetsal(double pf, double gross_sal)
    {
        //allotment(basic);
        net=gross_sal-(pf);
        System.out.println("The net salary is: "+net);
    }

    public void display()
    {
        fullname(); 
        System.out.println("\nName: "+empname);
        System.out.println("\nBasic: "+basic+
                            "\nHRA: "+hra+
                            "\nSpecial Allowance: "+special_allowance+
                            "\nDA: "+da+
                            "\nGross Salary: "+gross_sal+
                            "\nPF: "+pf+
                            "\nNet: "+net);  
    }

    public void display(double esic)
    {
        fullname(); 
        System.out.println("\nBasic: "+basic+
                            "\nHRA: "+hra+
                            "\nSpecial Allowance: "+special_allowance+
                            "\nDA: "+da+
                            "\nGross Salary: "+gross_sal+
                            "\nPF: "+pf+
                            "\nESIC: "+esic+
                            "\nNet: "+net);  
    }   
}
public class command {

    public static void main(String[] a) {
        System.out.println("\n***********Restaurant Management System***********");

        // employee class
        employee emp = new employee();
        emp.empid = 001;
        emp.f_name = "Akshaya";
        emp.l_name = "Sridhar";
        emp.empaddress = "#4, RK Colony, Bangalore";
        emp.designation = "Manager";
        emp.display();

        // calculate salary
        empsal employ = new empsal();
        employ.empid = 001;
        employ.f_name = "Ramesh";
        employ.l_name = "Sharma";
        employ.basic = 15000;
        employ.allotment(employ.basic);
        employ.calcgrosssal(employ.basic, employ.hra, employ.special_allowance, employ.da);
        employ.calcnetsal(employ.pf, employ.gross_sal, employ.esic);
        employ.display(employ.esic);
    }
}
