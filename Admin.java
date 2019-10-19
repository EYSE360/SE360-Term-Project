public class Admin {

    private String userName;
    private int password;
    private String name;
    private String surname;
    private int govNum;
    private String department;
    private String position;

    public Admin(){
        userName = "Admin";
        password = 123;
        name = "Unknown";
        surname = "Unknown";
        department = "Unknown";
        position = "Unknown";
        govNum = 0;
    }

    public Admin(String name, String surname, String department, String position, int govNum, String userName, int password){
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.position = position;
        this.govNum = govNum;
        this.userName = userName;
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public int getGovNum() {
        return govNum;
    }

    public void setGovNum(int govNum) {
        this.govNum = govNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void display(){
        System.out.println("Name: "+getName()+"\nSurname: "+getSurname()+"\nGovernment Number: "+getGovNum()+"\nDepartment: "+getDepartment()+"\nPosition: "+getPosition());
    }

}
