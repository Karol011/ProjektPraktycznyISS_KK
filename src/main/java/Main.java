import external.client.PeopleClient;
import external.client.PeopleDto;
import external.connection.HibernateUtil;
import external.dao.PeopleDao;
import external.entity.Station;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Station station = new Station();
    private static PeopleClient peopleClient = new PeopleClient();
    private static PeopleDto peopleDto = new PeopleDto();
    private static PeopleDao peopleDao = new PeopleDao();

    public static void main(String[] args) {
        peopleDto = peopleClient.getAstronautsForADate();
        peopleDao.saveAll(peopleDto.getPeople());
        station.setId(1);
        station.setName("namaaaaeee");

        System.out.println(
                peopleDto);


        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(station);
            transaction.commit();
        } catch (HibernateException hibernateException) {
            transaction.rollback();
        }

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
                Arrays.stream(peopleDto.getPeople())
                .forEach(System.out::println);
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
