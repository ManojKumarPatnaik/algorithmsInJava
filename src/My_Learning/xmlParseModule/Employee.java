package My_Learning.xmlParseModule;

public class Employee {
	 
    private String ID;
    private String Firstname;
    private String Lastname;
    private int age;
    private double salary;
 
    public Employee(String ID, String Firstname, String Lastname, int age, double salary) {
         this.ID = ID;
         this.Firstname = Firstname;
         this.Lastname = Lastname;
         this.age = age;
         this.salary = salary;
    }
 
    @Override
    public String toString() {
         return "<" + ID + ", " + Firstname + ", " + Lastname + ", " + age + ", " + salary + ">";
    }
 
}
