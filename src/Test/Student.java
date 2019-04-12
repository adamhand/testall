package Test;

public class Student extends Person{
    String id;
    String gender;
    String address;

    public void setId(String id){
        this.id = id;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getId(){
        return this.id;
    }

    public String getGender(){
        return this.gender;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }
}
