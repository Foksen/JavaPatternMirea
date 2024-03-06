package Builder;

public class Student {
    private final int id;
    private final String firstname;
    private final String lastName;
    private final double avgMark;

    public Student(int id, String firstname, String lastName, double avgMark) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.avgMark = avgMark;
    }

    @Override
    public String toString() {
        return "Студент: ИД: " + id + ", Имя: " + firstname + ", Фамилия: " + lastName + ", Ср. оценка: " + avgMark;
    }

    interface Builder {
        Builder setId(int id);
        Builder setFirstname(String firstname);
        Builder setLastname(String lastname);
        Builder setAvgMark(double avgMark);
    }
}
