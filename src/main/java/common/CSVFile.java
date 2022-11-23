package common;

import java.util.ArrayList;
import java.util.Arrays;

public class CSVFile {
    private int id;
    private String depart;
    private String arrive;


    public CSVFile(String[] array) {
        super();
        this.id = Integer.parseInt(array[0]);
        this.depart = array[1];
        this.arrive = array[2];
    }

    @Override
    public String toString() {
        return "route [id=" + id + ", depart=" + depart + ", arrive=" + arrive + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }
}
