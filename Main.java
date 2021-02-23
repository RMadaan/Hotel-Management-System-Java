//Topic: Hotel Management System; Name: Ritik Madaan, Registration Number: 11801737, Roll Number: 61.
//Covered Topics: Inheritance, Overriding Methods, Polymorphism, Abstract Classes, Interfaces, Exception Handling and I/O Fundamentals.
//Admin Login- username: admin, password: admin123
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
class Details{
    protected String uname = "username";
    protected String password = "password";
}

interface Hdetails{       //interface has to be in separate Hdetails.java but its not in this case that is why we are getting a warning, however the complete code is working fine please try and run it.
    int staff(int count1);
    int rooms(int count2);
}

class Hoteldetails implements Hdetails{
    int count;

    @Override
    public int staff(int count1) {
        this.count = count1;
        return this.count;
    }

    @Override
    public int rooms(int count2) {
        return count2;
    }
}
class Afterlogin extends Hoteldetails {
    Scanner sc = new Scanner(System.in);
    void staff() throws IOException {
        Hoteldetails hd = new Hoteldetails();
        System.out.println("Please select one of the option to enter the particular category");
        System.out.println("1. Set Staff Count \n2. Set Available Rooms Count \n3. Customer Interface \n4. Exit");
        System.out.print("Your Selection: ");
        int input = sc.nextInt();
        if(input==1){
            System.out.print("Please set currently staff count: ");
            int curr = sc.nextInt();
            System.out.println("Updated available staff count: "+hd.staff(curr));
            staff();
        }
        else if(input==2){
            System.out.print("Please set currently available rooms count: ");
            int curr = sc.nextInt();
            System.out.println("Updated available Rooms count: "+hd.staff(curr));
            staff();
        }
        else if(input==3){
            Customer cu = new Customer();
            cu.custom();
        }
        else if(input==4){
            System.exit(0);
        }
        else{
            System.out.println("Invalid input, please try again");
            staff();
        }
    }
}

class Login extends Details{
    Scanner sc = new Scanner(System.in);

    void login() throws IOException {
        Login lg = new Login();
        System.out.print("\nEnter your Username: ");
        lg.uname = sc.nextLine();
        System.out.print("Enter your Password: ");
        lg.password = sc.nextLine();
        if (lg.uname.equals("admin") && lg.password.equals("admin123")){
            System.out.println("\nYou have logged in successfully");
            LocalDate ob1 = LocalDate.now();
            System.out.println("Current Date: "+ob1);
            Afterlogin af = new Afterlogin();
            af.staff();
        }
        else {
            System.out.println("Sorry wrong Username or Password, please try again");
            login();
        }
    }
}

class Customer extends Hoteldetails{
    Scanner sc = new Scanner(System.in);
    void custom() throws IOException {
        System.out.println("\nWelcome To Hotel Customer Interface!");
        System.out.println("Please select one of the following options to enter a particular category:");
        System.out.println("1. Book Rooms \n2. Rate Us \n3. Give a Review \n4. Exit");
        System.out.print("Your Selection: ");
        int val = sc.nextInt();
        if (val == 1){
            System.out.println("Please confirm your age before continue...");
            System.out.print("Age: ");
            int age = sc.nextInt();
            if(age>=18) {
                book();
            }
            else {
                System.out.println("\nSorry you are not eligible to book a room, your age must be greater then or equal to 18.");
            }
            custom();
        }
        else if(val == 2){
            rating();
            custom();
        }
        else if(val == 3){
            feedback();
            custom();
        }
        else if(val == 4){
            System.out.println("\nThank you for using the system!");
            System.exit(0);
        }
    }
    void book() throws IOException {
        System.out.println("Please select the type of room you want to book");
        System.out.println("1. Deluxe Room  - Rs 2000 per night \n2. Super Deluxe Room  - Rs 3500 per night \n3. Ultra Deluxe Room  - Rs 4000 per night");
        System.out.print("Your Selection: ");
        int in = sc.nextInt();
        Scanner sn = new Scanner(System.in);
        if(in==1){
            System.out.println("Please enter your details, for booking deluxe room");
            System.out.print("Name: ");
            String name = sn.nextLine();
            cus(name);
            System.out.print("State: ");
            String state = sn.nextLine();
            cus(state);
            System.out.print("Phone Number: ");
            String number = sn.nextLine();
            cus(number);
            System.out.println("Congratulations your deluxe room has been booked successfully!");
            System.out.println("Saved Details are: ");
            System.out.println("Name: "+name);
            System.out.println("State: "+state);
            System.out.println("Phone Number: "+number);
        }
        else if(in==2){
            System.out.println("Please enter your details, for booking super deluxe room");
            System.out.print("Name: ");
            String name = sn.nextLine();
            cus(name);
            System.out.print("State: ");
            String state = sn.nextLine();
            cus(state);
            System.out.print("Phone Number: ");
            String number = sn.nextLine();
            cus(number);
            System.out.println("Congratulations your super deluxe room has been booked successfully!");
            System.out.println("Saved Details are: ");
            System.out.println("Name: "+name);
            System.out.println("State: "+state);
            System.out.println("Phone Number: "+number);
        }
        else if(in==3){
            System.out.println("Please enter your details, for booking ultra deluxe room");
            System.out.print("Name: ");
            String name = sn.nextLine();
            cus(name);
            System.out.print("State: ");
            String state = sn.nextLine();
            cus(state);
            System.out.print("Phone Number: ");
            String number = sn.nextLine();
            cus(number);
            System.out.println("Congratulations your ultra deluxe room has been booked successfully!");
            System.out.println("Saved Details are: ");
            System.out.println("Name: "+name);
            System.out.println("State: "+state);
            System.out.println("Phone Number: "+number);
        }
        System.out.println("\nPlease press e to book a new room, else press c to continue.");
        Scanner sf = new Scanner(System.in);
        String sel = sf.nextLine();
        if(sel.equals("e")){
            book();
        }
        else if(sel.equals("c")){
            custom();
        }
    }
    static void cus(String a) throws IOException {
        File f = new File("customer.txt");
        FileWriter fr = new FileWriter(f, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(a);
        br.write("\n");
        br.close();
        fr.close();
    }
    void rating(){
        System.out.println("\nPlease rate the hotel on the scale of 1 to 5, where 1 -> Very Bad and 5-> Very Good.");
        Scanner s = new Scanner(System.in);
        double rate = s.nextDouble();
        if(rate>=1 && rate<=5) {
            double[] a = {5.0, 3.98, 4.21, 4.56, 3.43,5.00};
            double j = 0;
            for (double v : a) {
                j = j + v;
            }
            double sc = j + rate;
            double avg = sc / (a.length + 1);
            System.out.println("Your rating are valuable to us, you have rated: " + rate);
            System.out.printf("Overall ratings of the hotel: %.2f", avg);
        }
        else {
            System.out.println("Invalid ratings, please rate again");
            rating();
        }
    }
    void feedback() throws IOException {
        System.out.println("Please Enter your review");
        Scanner sx = new Scanner(System.in);
        String a = sx.nextLine();

        File f = new File("review.txt");
        FileWriter fr = new FileWriter(f);
        fr.write("very good rooms");
        fr.write("\n");
        fr.write("nice staff");
        fr.write("\n");
        fr.write("excellent services");
        fr.write("\n");
        fr.close();

        File fl = new File("review.txt");
        FileWriter fc = new FileWriter(fl, true);
        BufferedWriter br = new BufferedWriter(fc);
        br.write(a);
        br.write("\n");
        br.close();
        fr.close();

        System.out.println("Your review is valuable to us, Thank you.\n");
        System.out.println("All Reviews:");

        File ob = new File("review.txt");
        Scanner fread = new Scanner(ob);
        while (fread.hasNextLine()) {
            String content = fread.nextLine();
            System.out.println(content);
        }
        fread.close();
    }

}

public class Main{
    public static void main(String[] args) throws IOException {

            System.out.println("Welcome To The Hotel Management System");
            System.out.println("Please type one of the option number to enter the particular category");
            System.out.println("1. Admin Login \n2. Customer Interface \n3. Exit");
            Scanner sc = new Scanner(System.in);
            System.out.print("Your Selection: ");
            int input = sc.nextInt();
            if (input == 1) {
                Login lo = new Login();
                lo.login();
            } else if (input == 2) {
                Customer cu = new Customer();
                cu.custom();

            } else if (input == 3) {
                System.out.println("\nThank you for using the System!");
                System.exit(2);
            }
    }
}