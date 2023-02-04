package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer RoomNumber;
    private Date Checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.RoomNumber = roomNumber;
        this.Checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }

    public Date getCheckin() {
        return Checkin;
    }


    public Date getCheckout() {
        return checkout;
    }

    public long duration() {// calcula a duração em dias a partir da data de checkount e checkin
        long diff = checkout.getTime() - getCheckin().getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//converte o valor que estava em milisegundos para dias
    }

    public void UpdateDates(Date checkin, Date checkout) {
        this.Checkin = checkin;
        this.checkout = checkout;

    }
    @Override
    public String toString(){
        return "Room " + RoomNumber + ", check-in: " + sdf.format(Checkin) + ", check-out: " + sdf.format(checkout) + ", " + duration() + " nights.";
    }
}



