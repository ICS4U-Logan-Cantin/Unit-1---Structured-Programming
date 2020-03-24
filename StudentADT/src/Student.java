public class Student {
    public String name;
    public int grade;
    public Boolean identified;

    Student (String firstName, String middleInitial, String lastName, int grade, Boolean identified) {
        this.name = String.format("%s %s %s", firstName, middleInitial, lastName);
        this.grade = grade;
        this.identified = identified;
    }

    public String StudentInfo() {
        return String.format("%s is in grade %d and %s.", name, grade, (identified) ? "is identified." : "is not identified");
    }

}
