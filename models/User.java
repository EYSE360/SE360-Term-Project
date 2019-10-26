package models;

public abstract class User {
    private String name;
    private String surname;
    private int IDNumber;
    private String userName;
    private int password;

   public User(){
       this.name = "Unknown";
       this.surname = "Unknown";
       this.IDNumber = 0;
       this.userName ="models.Admin";
       this.password = 123;
   }
    public User(String name, String surname, int IDNumber){
        this.name = name;
        this.surname = surname;
        this.IDNumber = IDNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    public abstract void display();
}
