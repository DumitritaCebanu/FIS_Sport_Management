package users;

import javafx.beans.property.SimpleStringProperty;

public class BSchedule {
    private SimpleStringProperty Time , Luni , Marti , Miercuri , Joi, Vineri , Sambata , Duminica;

    public BSchedule(String time, String luni, String marti, String miercuri, String joi,
                    String vineri, String sambata, String duminica) {
        Time = new SimpleStringProperty(time);
        Luni = new SimpleStringProperty( luni);
        Marti = new SimpleStringProperty( marti);
        Miercuri = new SimpleStringProperty( miercuri);
        Joi = new SimpleStringProperty(joi);
        Vineri = new SimpleStringProperty( vineri);
        Sambata = new SimpleStringProperty( sambata);
        Duminica = new SimpleStringProperty( duminica);
    }

    public String getTime() {
        return Time.get();
    }

    public SimpleStringProperty timeProperty() {
        return Time;
    }

    public void setTime(String time) {
        //this.Time.set(time);
        this.Time= new SimpleStringProperty(time);
    }

    public String getLuni() {
        return Luni.get();
    }

    public SimpleStringProperty luniProperty() {
        return Luni;
    }

    public void setLuni(String luni) {
        //this.Luni.set(luni);
        this.Luni= new SimpleStringProperty(luni);
    }

    public String getMarti() {
        return Marti.get();
    }

    public SimpleStringProperty martiProperty() {
        return Marti;
    }

    public void setMarti(String marti) {
        // this.Marti.set(marti);
        this.Marti= new SimpleStringProperty(marti);
    }

    public String getMiercuri() {
        return Miercuri.get();
    }

    public SimpleStringProperty miercuriProperty() {
        return Miercuri;
    }

    public void setMiercuri(String miercuri) {
        //this.Miercuri.set(miercuri);
        this.Miercuri= new SimpleStringProperty(miercuri);
    }

    public String getJoi() {
        return Joi.get();
    }

    public SimpleStringProperty joiProperty() {
        return Joi;
    }

    public void setJoi(String joi) {
        //this.Joi.set(joi);
        this.Joi= new SimpleStringProperty(joi);
    }

    public String getVineri() {
        return Vineri.get();
    }

    public SimpleStringProperty vineriProperty() {
        return Vineri;
    }

    public void setVineri(String vineri) {
        //this.Vineri.set(vineri);
        this.Vineri= new SimpleStringProperty(vineri);
    }

    public String getSambata() {
        return Sambata.get();
    }

    public SimpleStringProperty sambataProperty() {
        return Sambata;
    }

    public void setSambata(String sambata) {
        //this.Sambata.set(sambata);
        this.Sambata= new SimpleStringProperty(sambata);
    }

    public String getDuminica() {
        return Duminica.get();
    }

    public SimpleStringProperty duminicaProperty() {
        return Duminica;
    }

    public void setDuminica(String duminica) {
        //this.Duminica.set(duminica);
        this.Duminica= new SimpleStringProperty(duminica);
    }
}

