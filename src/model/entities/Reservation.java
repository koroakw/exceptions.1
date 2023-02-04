package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer RoomNumber;
    private Date CheckIn;
    private Date CheckOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Reservation(Integer roomNumber, Date CheckIn, Date CheckOut) {
        this.RoomNumber = roomNumber;
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return CheckIn;
    }


    public Date getCheckOut() {
        return CheckOut;
    }

    public long duration() {// calcula a duração em dias a partir da data de checkount e checkin
        long diff = CheckOut.getTime() - CheckIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//converte o valor que estava em milisegundos para dias
    }

    public String UpdateDates(Date CheckIn, Date CheckOut) {
        Date now = new Date();//pega a data atual

        if (CheckIn.before(now) || CheckOut.before(now)) {// põe a lógica que as datas de atualização não podem ser anteriores as datas atuais
            return "Error in reservation: Reservation dates for update must be future dates";

        } if (!CheckOut.after(CheckIn)) {
            return"Error in reservation: Check-out date must be after check-in date";
        }

        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
        return null;//ele indica que a operação não deu nenhum erro
    }


    @Override
    public String toString(){
        return "Room " + RoomNumber + ", check-in: " + sdf.format(CheckIn) + ", check-out: " + sdf.format(CheckOut) + ", " + duration() + " nights.";
    }
}



