package by.it.academy.Mk_JD2_88_22.model.airpotsDB;

public class Point {
    private String coordinate1;
    private String coordinate2;

    public Point(String coordinate1, String coordinate2) {
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
    }

    public String getCoordinate1() {
        return coordinate1;
    }

    public String getCoordinate2() {
        return coordinate2;
    }

    @Override
    public String toString() {
        return "{" +
                "coordinate1='" + coordinate1 + '\'' +
                ", coordinate2='" + coordinate2 + '\'' +
                '}';
    }
}
