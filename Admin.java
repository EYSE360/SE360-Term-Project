public class Admin extends User {

    private int govNum;
    private String department;
    private String position;

    public Admin(){
        super();
        department = "Unknown";
        position = "Unknown";
        govNum = 0;
    }

    public Admin(String name, String surname, int IDNumber, int govNum, String department, String position){
        super(name, surname, IDNumber);
        this.govNum = govNum;
        this.department = department;
        this.position=position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
    @Override
    public void display(){
        System.out.println("Name: "+getName()+"\nSurname: "+getSurname()+"\nID Number: "+getIDNumber()+"\nGovernment Number: "+getGovNum()+"\nDepartment: "+getDepartment()+"\nPosition: "+getPosition());
    }

}
