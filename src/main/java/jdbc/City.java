package jdbc;

public class City {
    private int city_id;
    private String city_name;

    public City(String city_name) {
        this.city_id = 0;
        this.city_name = city_name;
    }

    public City(int city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                '}';
    }

    public int getCity_id() {
        return city_id;
    }

    public String getCity_name() {
        return city_name;
    }
}
