package Model.Subjects;

public class Subject {
    private static int subject_count = 0;
    int subject_id;
    String subject_name;
    String subject_duration;
    int subject_credits;

    public static int getSubject_count()
    {
        return subject_count;
    }

    public Subject()
    {
        subject_count++;
        this.setSubject_id(subject_count);
    }

    public Subject(String subject_name, String subject_duration, int subject_credits)
    {
        subject_count++;
        this.setSubject_id(subject_count);
        this.setSubject_name(subject_name);
        this.setSubject_duration(subject_duration);
        this.setSubject_credits(subject_credits);
    }

    public Subject(int subject_id, String subject_name, String subject_duration, int subject_credits)
    {
        subject_count++;
        this.setSubject_id(subject_id);
        this.setSubject_name(subject_name);
        this.setSubject_duration(subject_duration);
        this.setSubject_credits(subject_credits);
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public void setSubject_duration(String subject_duration) {
        this.subject_duration = subject_duration;
    }

    public void setSubject_credits(int subject_credits) {
        this.subject_credits = subject_credits;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public String getSubject_duration() {
        return subject_duration;
    }

    public int getSubject_credits() {
        return subject_credits;
    }

    public void display()
    {
        System.out.println("Subject Id: "+getSubject_id());
        System.out.println("Subject Name: "+getSubject_name());
        System.out.println("Subject Duration: "+getSubject_duration());
        System.out.println("Subject Credits: "+getSubject_credits());
    }
}

