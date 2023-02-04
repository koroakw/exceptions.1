package aplication;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
                System.out.print("Room Number: ");
                int number = sc.nextInt();
                System.out.print("Check-in date (dd/MM/yyyy): ");
                Date CheckIn = sdf.parse(sc.next());//ele cria a variável DATE
                System.out.print("Check-out date (dd/MM/yyyy): ");
                Date CheckOut = sdf.parse(sc.next());
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


                reservation.UpdateDates(CheckIn, CheckOut);// esse método atualiza as datas
                System.out.println("Reservation: " + reservation);

        }catch (ParseException e){//faz o tratamento da exceção
            System.out.println();
            System.out.println("Invalid date format");
        }catch (DomainException e){
            System.out.println();
            System.out.println("Error in reservation: " + e.getMessage());//captura a mensagem usada na hora de instanciar a aexceção
        }catch (RuntimeException e){//trata qualquer exceção genérica do tipo runtimeexception
            System.out.println();
            System.out.println("Unexpected error");
        }
        sc.next();
    }

}



