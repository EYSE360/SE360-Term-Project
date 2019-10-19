import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static List<Admin> adminList = new ArrayList<>();
    static List<Bar> barList = new ArrayList<>();
    public static void main(String[] args) {
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
        System.out.println("Name: \nSurname: \nGovernment Number: \nDepartment: \nPosition: ");
        a.setName(sc.next());
        a.setSurname(sc.next());
        a.setGovNum(sc.nextInt());
        a.setDepartment(sc.next());
        a.setPosition(sc.next());
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please check your information below. Click Y if your accept: ");
        a.display();
        String decision = sc1.nextLine();
        if(decision.equals("Y")) {
            System.out.println("Welcome "+a.getName()+". Your username and password are set to 'Admin' and '123' as default. Please don't forget to change.");
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
                System.out.println("Welcome " + a.getName());
            } else System.out.println("Wrong Username or password.\nTerminating the program...");
        }
    }
    public static void barUserLogInFirst(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your information below: ");
        System.out.println("Bar's name: ");
        System.out.println("City that bar is located: ");
        System.out.println("Do you have alcohol permission? Y/N");
        Bar b = new Bar();
        b.setName(input.nextLine());
        b.setCity(input.nextLine());
        if(input.next().equals("Y")) b.setAlcoholPermission(true);
        else if(input.next().equals("N")) b.setAlcoholPermission(false);
        System.out.println("Please check your information below. Do you accept? Y/N");
        b.display();
        String yn = input.nextLine();
        if(yn.equals("Y")) {
            barList.add(b);
            System.out.println("Your bar is successfully saved! Your user name and password are set to 'Admin' and 123. Please don't forget to change those later.");
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
            if(b.getBarPassword()==tempPw&&b.getBarUserName().equals(tempUser)){
                System.out.println("Successfully logged in as "+b.getName()+"\nWhat would you like to do?\n1)Edit information of the bar.\n2)Enter a new beer\n3)Edit a beer\n4)Delete a beer");
                int decision = sc.nextInt();
                switch (decision){
                    case 1:{
                        System.out.println("Select the information that you want to edit:\n1)Bar name\n2)City\n3)Alcohol Permission\n4)Username\n5)Password");
                        Scanner s = new Scanner(System.in);
                        int val = s.nextInt();
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
                                switch (choicee){
                                    case 1:{
                                        System.out.println("Pleas enter the new brand: ");
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

}
