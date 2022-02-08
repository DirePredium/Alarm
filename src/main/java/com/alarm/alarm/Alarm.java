package com.alarm.alarm;

import javafx.scene.layout.TilePane;

import java.time.LocalDate;
import java.util.Date;

public class Alarm {

    private Date alarmDate;
    private static int globalId = 0;
    private int id;
    private TilePane tilePane;

    Alarm(Date alarmDate){
        this.alarmDate = alarmDate;
        this.id = globalId;
        globalId++;
    }

    public long getTimeEnd(Date today){
        long result =  alarmDate.getTime()-today.getTime();
        return result;
    }

    public void setDateNull(){
        this.alarmDate = null;
    }

    public boolean getIsWork(){
        if(alarmDate != null){
            return true;
        }
        return false;
    }
}
