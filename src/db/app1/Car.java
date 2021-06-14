package db.app1;

public class Car {
    private String name;
    private Status status;

    public Car(){}

    public Car(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
