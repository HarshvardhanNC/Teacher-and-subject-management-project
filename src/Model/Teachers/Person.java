package Model.Teachers;

public class Person {
    String fname;
    String lname;
    String email;
    String address;
    String mobile;

    public Person()
    {
        System.out.println("Creating a Person");
    }

    public Person(String fname, String lname, String email, String address, String mobile)
    {
        this.setFname(fname);
        this.setLname(lname);
        this.setEmail(email);
        this.setAddress(address);
        this.setMobile(mobile);
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public void display()
    {
        System.out.println("Teacher First Name: "+getFname());
        System.out.println("Teacher Last Name: "+getLname());
        System.out.println("Teacher Email: "+getEmail());
        System.out.println("Teacher Address: "+getAddress());
        System.out.println("Teacher Mobile No: "+getMobile());
    }
}

