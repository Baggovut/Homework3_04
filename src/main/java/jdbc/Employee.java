package jdbc;

public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private String gender;
    private int city_id;

    public Employee(String first_name, String last_name, int age, String gender, int city_id) {
        this.id = 0;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
        this.city_id = city_id;
    }

    public Employee(int id, String first_name, String last_name, int age, String gender, int city_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", city_id=" + city_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getCity_id() {
        return city_id;
    }
}
