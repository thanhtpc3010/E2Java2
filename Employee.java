package Entity;

import java.time.LocalDate;

public class Employee {
    private int Id;
    private String Name;
    private Department department;
    private LocalDate DoB;
    private Gender Gender;
    private String City;
    private String Province;
    private String PhoneNumber;

    public Employee() {;}

    public Employee(int Id,String Name,Department department){
        this.Id=Id;
        this.Name=Name;
        this.department=department;
    }

    public Employee(int id, String name, Department department, LocalDate doB, Entity.Gender gender, String city, String province, String phoneNumber) {
        Id = id;
        Name = name;
        this.department = department;
        DoB = doB;
        Gender = gender;
        City = city;
        Province = province;
        PhoneNumber = phoneNumber;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate doB) {
        DoB = doB;
    }

    public Entity.Gender getGender() {
        return Gender;
    }

    public void setGender(Entity.Gender gender) {
        Gender = gender;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", deptld='" + department + '\'' +
                ", DoB=" + DoB +
                ", Gender=" + Gender +
                ", City='" + City + '\'' +
                ", Province='" + Province + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}
