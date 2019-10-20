public class MinistryOfHealth extends User {
    public MinistryOfHealth(String name, String surname, int IDNumber){
        super(name,surname,IDNumber);
    }
    public MinistryOfHealth(){
        super();

    }
    @Override
    public void display(){
        System.out.println("Name: "+getName()+"\nSurname: "+getSurname()+"\nID Number: "+getIDNumber());
    }

}
