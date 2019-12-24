package models;

public class Waiter extends BarUser {
    @Override
    public String toString() {
        return "Waiter{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", SSN=" + SSN +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
