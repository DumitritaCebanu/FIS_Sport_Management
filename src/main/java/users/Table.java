package users;

import javafx.beans.property.SimpleStringProperty;


public class Table {
    private SimpleStringProperty day;
    private SimpleStringProperty trainings;
    private SimpleStringProperty time;

    public Table(String day, String trainings, String time) {
        this.day = new SimpleStringProperty(day);
        this.trainings =  new SimpleStringProperty(trainings);
        this.time = new SimpleStringProperty(time);
    }

    public String getDay() {
        return day.get();
    }

    public void setDay(String day) {
        this.day = new SimpleStringProperty(day);
    }

    public String getTrainings() {
        return trainings.get();
    }

    public void setTrainings(String trainings) {
        this.trainings = new SimpleStringProperty(trainings);
    }

    public String getTime() { return time.get(); }

    public void setTime(String time) {
        this.time.set(time);
    }

    @Override
    public String toString() {
        return "Table{" +
                "day=" + day +
                ", trainings=" + trainings +
                ", time=" + time +
                '}';
    }
}

