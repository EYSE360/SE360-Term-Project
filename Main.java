import models.Admin;
import models.Bar;
import models.Beer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.awt.*;
//import javax.swing.*;
public class Main {
    static List<Admin> adminList = new ArrayList<>();
    static List<Bar> barList = new ArrayList<>();
    public static void main(String[] args) {
        //SimpleFrame frame = new SimpleFrame();
        while(true){
            System.out.println("WELCOME TO OUR PROGRAM. PRESS 1 FOR ADMIN LOG IN AND 2 FOR USER LOG IN: ");
            Scanner sc1 = new Scanner(System.in);
            int decision = sc1.nextInt();
            switch (decision){
                case 1: {
                    System.out.println("Please press 1 if you are new and 2 if you have logged in before: ");
                    int dec2 = sc1.nextInt();
                    switch (dec2) {
                        case 1:
                            adminLogInFirst();
                            break;
                        case 2:
                            adminLogIn();
                            break;
                    }
                    break;
                }
                case 2:{
                    System.out.println("Please press 1 if you are new and 2 if you have logged in before: ");
                    int dec = sc1.nextInt();
                    switch (dec){
                        case 1:{
                            barUserLogInFirst();
                            break;
                        }
                        case 2:{
                            barUserLogIn();
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void adminLogInFirst(){
        Admin a = new Admin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome! Since this is your first time logging in our system, please enter your information below:");
        System.out.println("Name: \nSurname: \nID Number: \nGovernment Number: \nDepartment: \nPosition: ");
        a.setName(sc.next());
        a.setSurname(sc.next());
        a.setIDNumber(sc.nextInt());
        a.setGovNum(sc.nextInt());
        a.setDepartment(sc.next());
        a.setPosition(sc.next());
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please check your information below. Click Y if your accept: ");
        a.display();
        String decision = sc1.nextLine();
        if(decision.equals("Y")) {
            System.out.println("Welcome "+a.getName()+". Your username and password are set to 'models.Admin' and '123' as default. Please don't forget to change.");
            BufferedWriter bw = null;
            try {
                String mycontent = getAdminsProperties(a);
                File file = new File("C:\\Users\\Erel\\IdeaProjects\\SE360_TermProject\\src\\admins.txt");
                FileWriter fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                bw.write(mycontent);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            finally
            {
                try{
                    if(bw!=null)
                        bw.close();
                }catch(Exception ex){
                    System.out.println("Error in closing the BufferedWriter"+ex);
                }
            }
            adminList.add(a);
        }
        else  System.out.println("Process terminated...");
    }
    public static void adminLogIn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Username: ");
        String tempID = sc.next();
        System.out.println("Password: ");
        int tempPW = sc.nextInt();

        for(Admin a : adminList) {
            if (tempID.equals(a.getUserName()) && tempPW == a.getPassword()) {
                System.out.println("Welcome " + a.getName()+"\nWhat would you like to do?\n1)Edit information\n2)Display bars\n3)Send warning to a bar\n4)Report a bar");
                int admindec = sc.nextInt();
                switch (admindec){
                    case 1:{
                        System.out.println("What would you like to edit?\n1)Name\n2)Surname\n3)Department\n4)Position\n5)Username\n6)Password");
                        int admindec2 = sc.nextInt();
                        sc.nextLine();
                        switch (admindec2){
                            case 1:{
                                System.out.println("Please enter the new name: ");
                                String newName = sc.nextLine();
                                a.setName(newName);
                                System.out.println("Your name is successfully changed to "+newName);
                                break;
                            }
                            case 2:{
                                System.out.println("Please enter the new surname: ");
                                String newSName=sc.nextLine();
                                a.setSurname(newSName);
                                System.out.println("Your surname is successfully changed to "+newSName);
                                break;
                            }
                            case 3:{
                                System.out.println("Please enter the new department: ");
                                String newDep = sc.nextLine();
                                a.setDepartment(newDep);
                                System.out.println("Your department is successfully changed to "+newDep);
                                break;
                            }
                            case 4:{
                                System.out.println("Pleas enter the new position: ");
                                String newPos = sc.nextLine();
                                a.setPosition(newPos);
                                System.out.println("Your position is successfully changed to "+newPos);
                                break;
                            }
                            case 5:{
                                System.out.println("Please enter your new username: ");
                                String newUserName = sc.nextLine();
                                a.setUserName(newUserName);
                                System.out.println("Your username is successfully changed to "+newUserName);
                                break;
                            }
                            case 6:{
                                System.out.println("Please enter your new password: ");
                                int newPW = sc.nextInt();
                                sc.nextLine();
                                a.setPassword(newPW);
                                System.out.println("Your password is successfully changed to "+newPW);
                                break;
                            }
                        }
                        break;
                    }
                    case 2:{
                        for(int i=0;i<barList.size();i++){
                            barList.get(i).display();
                        }
                        System.out.println("Please enter the name of the bar if you want to display it's menu: ");
                        sc.nextLine();
                        String tempName = sc.nextLine();
                        for(Bar bar:barList){
                            if(bar.getName().equals(tempName)){
                                bar.displayMenu();
                                return;
                            }
                            else System.out.println("Wrong entry.");
                        }
                        break;
                    }
                }
            } else System.out.println("Wrong Username or password.\nTerminating the program...");
        }
    }
    public static void barUserLogInFirst(){
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        System.out.println("Please enter your information below: ");
        System.out.println("models.Bar's name: ");
        System.out.println("City that bar is located: ");
        System.out.println("Do you have alcohol permission? Y/N");
        Bar b = new Bar();
        b.setName(input.nextLine());
        b.setCity(input.nextLine());
        String permission = input.next();
        if(permission.equals("Y")) b.setAlcoholPermission(true);
        else if(permission.equals("N")) b.setAlcoholPermission(false);
        System.out.println("Please check your information below. Do you accept? Y/N");
        b.display();
        String yn = input1.nextLine();
        if(yn.equals("Y")) {
            barList.add(b);
            System.out.println("Your bar is successfully saved! Your user name and password are set to 'models.Bar' and 123. Please don't forget to change those later.");
        }
        else{
            System.out.println("Process terminated...");
            System.exit(1);
        }
    }
    public static void barUserLogIn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Pleas enter your bar username: ");
        String tempUser = sc.nextLine();
        System.out.println("Please enter your password: ");
        int tempPw = sc.nextInt();
        for(Bar b: barList){
            if(b.getBarUserName().equals(tempUser)&&b.getBarPassword()==tempPw){
                System.out.println("Successfully logged in as "+b.getName()+"\nWhat would you like to do?\n1)Edit information of the bar.\n2)Enter a new beer\n3)Edit a beer\n4)Delete a beer\nD5)isplay my menu");
                int decision = sc.nextInt();
                switch (decision){
                    case 1:{
                        System.out.println("Select the information that you want to edit:\n1)models.Bar name\n2)City\n3)Alcohol Permission\n4)Username\n5)Password");
                        Scanner s = new Scanner(System.in);
                        int val = s.nextInt();
                        s.nextLine();
                        switch (val){
                            case 1:{
                                System.out.println("Please enter the new name of the bar: ");
                                String newName=s.nextLine();
                                b.setName(newName);
                                System.out.println("Your bar's name is successfully changed to "+newName);
                                break;
                            }
                            case 2:{
                                System.out.println("Pleas enter the new city: ");
                                String newCity = s.nextLine();
                                b.setCity(newCity);
                                System.out.println("Location is successfully changed to "+newCity);
                                break;
                            }
                            case 3:{
                                System.out.println("Are you eligible to sell alcohol products? Y/N");
                                String initVal = s.nextLine();
                                if(initVal.equals("Y")){
                                    b.setAlcoholPermission(true);
                                    System.out.println("Successfully set! You are eligible to sell alcohol.");
                                }
                                else if(initVal.equals("N")){
                                    b.setAlcoholPermission(false);
                                    System.out.println("Successfully set! You are no longer eligible to sell alcohol.");
                                }
                                break;
                            }
                            case 4:{
                                System.out.println("Please enter your new username: ");
                                String newUser = s.nextLine();
                                b.setBarUserName(newUser);
                                System.out.println("Your bar's username is successfully changed to "+newUser);
                                break;
                            }
                            case 5:{
                                System.out.println("Please enter your new password: ");
                                int newPw = s.nextInt();
                                b.setBarPassword(newPw);
                                System.out.println("Your password is successfully changed to "+newPw);
                                break;
                            }
                        }

                        break;
                    }
                    case 2:{
                        checkForPermission(b);
                        Scanner sc1 = new Scanner(System.in);
                        System.out.println("Please enter your new beer's information below: ");
                        System.out.println("Brand: ");
                        String brand = sc1.nextLine();
                        System.out.println("Type: ");
                        String type = sc1.nextLine();
                        System.out.println("Alcohol Volume: ");
                        float alcVol = sc.nextFloat();
                        System.out.println("Price: ");
                        float price = sc.nextFloat();
                        System.out.println("Serial Number: ");
                        int sNumber = sc.nextInt();
                        Beer beer = new Beer(brand, type, alcVol, price, sNumber);
                        System.out.println("Do you approve the following beer?  Y/N");
                        beer.display();
                        String choice = sc1.nextLine();
                        if(choice.equals("Y")){
                            System.out.println("Your beer is successfully created and added to your menu.");
                            b.getBeerList().add(beer);
                        }
                        else{
                            System.out.println("Process terminated...");
                            System.exit(1);
                        }
                        break;
                    }
                    case 3:{
                        System.out.println("Please enter the serial number of the beer that you want to edit: ");
                        int tempSNumber = sc.nextInt();
                        for(Beer beer:b.getBeerList()){
                            if(beer.getSerialNumber()==tempSNumber){
                                System.out.println("What would you like to edit?\n1)Brand\n2)Type\n3)Alcohol Volume\n4)Price");
                                int choicee = sc.nextInt();
                                sc.nextLine();
                                switch (choicee){
                                    case 1:{
                                        System.out.println("Please enter the new brand: ");
                                        String newBrand = sc.nextLine();
                                        beer.setBrand(newBrand);
                                        System.out.println("The brand is successfully changed to "+newBrand);
                                        break;
                                    }
                                    case 2:{
                                        System.out.println("Please enter the new type: ");
                                        String newType = sc.nextLine();
                                        beer.setType(newType);
                                        System.out.println("Type successfully changed to "+newType);
                                        break;
                                    }
                                    case 3:{
                                        System.out.println("Please enter the new alcohol volume: ");
                                        float newVolume = sc.nextFloat();
                                        beer.setAlcoholVol(newVolume);
                                        System.out.println("Alcohol volume successfully changed to "+newVolume);
                                        break;
                                    }
                                    case 4:{
                                        System.out.println("Please enter the new price: ");
                                        int newPrice = sc.nextInt();
                                        beer.setPrice(newPrice);
                                        System.out.println("Price successfully changed to "+newPrice);
                                        break;
                                    }
                                }
                            }
                            else System.out.println("There is no beer with this serial number. Please check your data.");
                        }
                        break;
                    }
                    case 4:{
                        System.out.println("Please enter the serial number of beer that you want to delete: ");
                        int tempSerial = sc.nextInt();
                        for(Beer beer:b.getBeerList()){
                            if(beer.getSerialNumber()==tempSerial){
                                b.getBeerList().remove(beer);
                                System.out.println("This beer is removed successfully!");
                            }
                            else{
                                System.out.println("There is no beer with this serial number. Please check your data.");
                                System.exit(1);
                            }
                        }
                        break;
                    }
                    case 5:{
                        b.displayMenu();
                        break;
                    }
                }
            }
            else {
                System.out.println("Wrong username or password. Terminating...");
                System.exit(1);
            }
        }
    }
    public static String getAdminsProperties(Admin a){
        String ret = a.getName()+" "+a.getSurname()+" "+a.getGovNum()+" "+a.getDepartment()+" "+a.getPosition()+" "+a.getUserName()+" "+a.getPassword();
        return ret;
    }
    public static void checkForPermission(Bar b){
        if(b.getAlcoholPermission()==false){
            System.out.println("Your bar is not eligible for selling beers. Please get a licence. Terminating the process...");
            System.exit(1);
        }
    }
    /*static class SimpleFrame
            extends JFrame {
        public SimpleFrame(){


// change the size otherwise it is 0x0 pixels!
            setSize(1920,1080);
// when the user closes the frame, the program will exit
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);}
    }*/
}
