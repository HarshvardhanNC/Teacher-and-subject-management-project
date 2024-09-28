package Model.Teachers;

public class Teacher extends Person{
    private static int teacher_count = 0;
    int teacher_id;

    double cet_percentage;


    public static int getTeacher_count()
    {
        return teacher_count;
    }

    public Teacher()
    {
        teacher_count++;
        this.setTeacher_id(teacher_count);
    }

    public Teacher(double cet_percentage, String teacher_fname, String teacher_lname, String teacher_email, String teacher_address, String teacher_mobile)
    {
        super(teacher_fname, teacher_lname, teacher_email, teacher_address,teacher_mobile);
        teacher_count++;
        this.setTeacher_id(teacher_count);
        this.setCet_percentage(cet_percentage);
    }

    public Teacher(int teacher_id, double cet_percentage, String teacher_fname, String teacher_lname, String teacher_email, String teacher_address, String teacher_mobile)
    {
        super(teacher_fname, teacher_lname, teacher_email, teacher_address,teacher_mobile);
        teacher_count++;
        this.setTeacher_id(teacher_id);
        this.setCet_percentage(cet_percentage);
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public void setCet_percentage(double cet_percentage) {
        this.cet_percentage = cet_percentage;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public double getCet_percentage() {
        return cet_percentage;
    }

    public void display()
    {
        System.out.println("Teacher Id: "+getTeacher_id());
        System.out.println("Teacher CET Percentage: "+getCet_percentage());
        super.display();
    }
}


