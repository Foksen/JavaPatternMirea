package Builder;

public class StudentBuilder implements Student.Builder {
    private int id;
    private String firstname;
    private String lastname;
    private double avgMark;

    @Override
    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public StudentBuilder setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    @Override
    public StudentBuilder setLastname(String lastName) {
        this.lastname = lastName;
        return this;
    }

    @Override
    public StudentBuilder setAvgMark(double avgMark) {
        this.avgMark = avgMark;
        return this;
    }

    public Student getResult() {
        return new Student(id, firstname, lastname, avgMark);
    }
}
