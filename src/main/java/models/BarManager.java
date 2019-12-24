package models;

public class BarManager extends BarUser {
    @Override
    public String toString() {
        return "BarManager{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", SSN=" + SSN +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
