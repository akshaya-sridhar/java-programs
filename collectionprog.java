import java.util.*;

class employee{
    int empid; // emp ID primary key
    String f_name; // first name
    String l_name; // last name
    String empname;
    String empaddress;
    long empphno;
    String email;
    String designation;

    public void fullname(String f_name, String l_name)
    {
        this.empname=f_name+" "+l_name;
        System.out.println("Name: "+empname);
    }

    public void allotment(int empid, String empaddress, String designation)
    {
        this.empid=empid;
        this.empaddress=empaddress;
        this.designation=designation;
    }

    public void displayemp()
    {
        System.out.println("\nEmployee ID: "+this.empid+
                            "\nEmployee name: "+this.empname+
                            "\nAddress: "+this.empaddress+
                            "\nDesignation: "+this.designation);  
    }

    public void emailalloc(String fname, String lname)
    {
        this.email=fname+lname+"@indianrestaurant.in";
        this.email.toLowerCase();
        System.out.println("Email ID: " +this.email);
    }
}

// inheritance to take employee attributes and calculate emp sal

class empsal extends employee  {
    double basic;
    double hra; // 40 percent of base salary
    double special_allowance;
    double da; // 50 percent of basic 
    double gross_sal;
    double pf; //12 percent of base 
    double net; 

    public void allotment(double basic){
        this.basic=basic;
        this.hra=0.40*(this.basic);
        this.special_allowance=0.10*this.basic;
        this.da=0.50*this.basic;
        this.pf=0.12*this.basic;
    }


    public void calcgrosssal()
    {
        this.gross_sal=this.basic+this.hra+this.special_allowance+this.da;
    }
    public void calcnetsal()
    {
        this.net=this.gross_sal-(this.pf);
    }

    public int net(){
        int IntValue = (int) this.net;
        return IntValue;
    }

    

    public void display()
    {
        super.displayemp();
        System.out.println("Salary details: ");
        System.out.print("\nBasic: "+basic+
                            "\nHRA: "+hra+
                            "\nSpecial Allowance: "+special_allowance+
                            "\nDA: "+da+
                            "\nGross Salary: "+gross_sal+
                            "\nPF: "+pf+
                            "\nNet: "+net);  
    }
    
}

public class collectionprog{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("\n-------- EMPLOYEE 1 --------");
        empsal emp1=new empsal();
        System.out.print("Enter employee first name: ");
        String fname=sc.nextLine();
        System.out.print("Enter employee second name: ");
        String lname=sc.nextLine();
        emp1.fullname(fname, lname);
        System.out.print("Enter employeeID: ");
        int eid=sc.nextInt();
        System.out.print("Enter employee address: ");
        sc.nextLine();
        String eadd=sc.nextLine();
        System.out.print("Enter employee designation: ");
        String edesig=sc.nextLine();
        emp1.emailalloc(fname,lname);
        emp1.allotment(eid, eadd, edesig);
        System.out.println("Enter basic salary: ");
        double basic1=sc.nextDouble();
        emp1.allotment(basic1);

        System.out.println("\n-------- EMPLOYEE 2 --------");
        empsal emp2=new empsal();
        sc.nextLine();
        System.out.print("Enter employee first name: ");
        String fname2=sc.nextLine();
        System.out.print("Enter employee second name: ");
        String lname2=sc.nextLine();
        emp2.fullname(fname2, lname2);
        System.out.print("Enter employeeID: ");
        int eid2=sc.nextInt();
        System.out.print("Enter employee address: ");
        sc.nextLine();
        String eadd2=sc.nextLine();
        System.out.print("Enter employee designation: ");
        String edesig2=sc.nextLine();
        emp2.emailalloc(fname2,lname2);
        emp2.allotment(eid2, eadd2, edesig2);
        System.out.println("Enter basic salary: ");
        double basic2=sc.nextDouble();
        emp2.allotment(basic2);

        List<empsal> arr=new ArrayList<>();
        arr.add(emp1);
        arr.add(emp2);

        Iterator<empsal> it = arr.iterator();

        while(it.hasNext())
        System.out.println(it.next()); 

        arr.get(0).display();
        arr.get(1).display();

        List<Integer> array=new ArrayList();
        int a=emp1.net();
        int b=emp2.net();
        array.add(a);
        array.add(b);
        array.get(0);
        array.get(1);

    }
}