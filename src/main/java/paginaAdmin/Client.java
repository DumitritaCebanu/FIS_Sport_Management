package paginaAdmin;

import javafx.beans.property.SimpleStringProperty;
public class Client {
    private SimpleStringProperty ClientName , SportType , Weekday , ClientTime;

    public Client(String clientName, String sportType , String weekday , String clientTime ) {
        ClientName = new SimpleStringProperty( clientName);
        SportType = new SimpleStringProperty( sportType);
        Weekday = new SimpleStringProperty(weekday);
        ClientTime = new SimpleStringProperty(clientTime);
    }

    public String getClientTime() {
        return ClientTime.get();
    }

    public SimpleStringProperty clientTimeProperty() {
        return ClientTime;
    }

    public void setClientTime(String clientTime) {
        //this.ClientTime.set(clientTime);
        this.ClientTime= new SimpleStringProperty(clientTime);
    }

    public String getClientName() {
        return ClientName.get();
    }

    public SimpleStringProperty clientNameProperty() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        //this.ClientName.set(clientName);
        this.ClientName = new SimpleStringProperty(clientName);
    }

    public String getSportType() {
        return SportType.get();
    }

    public SimpleStringProperty sportTypeProperty() {
        return SportType;
    }

    public void setSportType(String sportType) {
        // this.SportType.set(sportType);
        this.SportType = new SimpleStringProperty(sportType);
    }

    public String getWeekday() {
        return Weekday.get();
    }

    public SimpleStringProperty weekdayProperty() {
        return Weekday;
    }

    public void setWeekday(String weekday) {
        // this.Weekday.set(weekday);
        this.Weekday = new SimpleStringProperty(weekday);
    }
}
