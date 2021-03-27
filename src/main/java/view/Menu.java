package view;

import external.entity.Station;
import service.PeopleService;

import java.util.Scanner;

public class Menu {
    private Station station = new Station();
    private static PeopleService peopleService = new PeopleService();

    public static void main(String[] args) {


        greetUser();

    }

    public static void greetUser() {
        System.out.println("Witaj w projekcie prezentujacym wybrane dane i statystyki na podstawie open-notify.org API\n" +
                " wybierz operacje:\n" +
                "1. oblicz predkosc ISS\n" +
                "2. Zwracanie listy nadchodzących przebiegów ISS dla określonej lokalizacji\n" +
                "3. Zwracanie liczby osób przebywających w kosmosie w ramach ISS\n" +
                "4. Zwracanie średniej prędkości w określonym fragmencie czasu, np. miesiąc, rok\n" +
                "5. ile razy ISS znajdowało się nad daną lokalizacją w przedziale czasu\n" +
                "6. liczbę osób przebywających w ramach misji kosmicznej na ISS\n" +
                "0. wyjscie z aplikacji\n");
        displayMenu();
    }

    private static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);
        while (!Character.isDigit(choice)) {
            System.out.println("Niewlasciwy wybor, prosze uzyc odpowiedniej cyfry");
            greetUser();
        }
        switch (choice) {
            case '1':
                System.out.println("W trakcie tworzenia...");
                break;
            case '2':
                System.out.println("W trakcie tworzenia...");
                break;
            case '3':
                peopleService.getCurrentPeopleInSpace().forEach(System.out::println);
                break;
            case '4':
                System.out.println("W trakcie tworzenia...");
                break;
            case '5':
                System.out.println("W trakcie tworzenia...");
                break;
            case '6':
                System.out.println("W trakcie tworzenia...");
                break;
            case '0':


        }
    }

}
