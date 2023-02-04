package aplication;

import model.entities.Reservation;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class program {
    public static void main (String [] args) throws ParseException {//possibilita o uso da chamada parse para ler a variável date
        //pois o parse pode invocar uma excessão, e o main normalmente não invoca excessão nenhuma
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date CheckIn = sdf.parse(sc.next());//ele cria a variável DATE
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date CheckOut = sdf.parse(sc.next());
        if (!CheckOut.after(CheckIn)){//essa chamada indica que se o checkout não for depois do checkin, ocorrerá um erro
            System.out.println("Error in reservation: Check-out date must be after Check-in date.");
        }else{
            Reservation reservation = new Reservation(number, CheckIn, CheckOut);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println();

            System.out.println("Update date: ");
            System.out.println("Enter data to update the reservation ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            CheckIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            CheckOut = sdf.parse(sc.next());
            System.out.println();

            Date now = new Date();//pega a data atual

            if (CheckIn.before(now) || CheckOut.before(now)){// põe a lógica que as datas de atualização não podem ser anteriores as datas atuais
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if(!CheckOut.after(CheckIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else{
                reservation.UpdateDates(CheckIn, CheckOut);// esse método atualiza as datas
                System.out.println("Reservation: " + reservation);

            }


        }




        sc.next();
    }
}
