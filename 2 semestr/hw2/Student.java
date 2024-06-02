package hw2;

public class Student {
    public String firstName;
    public String secondName;
    public int mark;
    public Student(String firstName, String secondName, int mark) {
        if (mark < 0 || mark > 100){
            throw new IllegalArgumentException("Mark is out of bounds");
        }
        this.firstName = firstName;
        this.secondName = secondName;
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public String getSurname() {
        return secondName;
    }

    @Override
    public String toString(){
        return secondName + " " + mark;
    }
}
