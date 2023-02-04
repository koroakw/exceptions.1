package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer RoomNumber;
    private Date CheckIn;
    private Date CheckOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Reservation(Integer roomNumber, Date CheckIn, Date CheckOut) throws DomainException {//caso haja erro na instanciação
        //do construtir, será impresso a mensagem de erro da exceção
    if (!CheckOut.after(CheckIn)) {
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }
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

    public void UpdateDates(Date CheckIn, Date CheckOut) throws DomainException{
        Date now = new Date();//pega a data atual

        if (CheckIn.before(now) || CheckOut.before(now))  {// põe a lógica que as datas de atualização não podem ser anteriores as datas atuais
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
           //essa exceção é usada quando os argumentos passados para o método são inválidos e contém erros

            }if (!CheckOut.after(CheckIn)){
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }

        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;

    }


    @Override
    public String toString(){
        return "Room " + RoomNumber + ", check-in: " + sdf.format(CheckIn) + ", check-out: " + sdf.format(CheckOut) + ", " + duration() + " nights.";
    }
}



