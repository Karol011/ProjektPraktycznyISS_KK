import external.client.PeopleClient;
import external.client.PeopleDto;
import external.connection.HibernateUtil;
import external.dao.PeopleDao;
import external.entity.Station;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.PeopleService;

public class Main {
    public static void main(String[] args) {
        PeopleService peopleService = new PeopleService();
        peopleService.getCurrentPeopleInSpace().forEach(System.out::println);
    }

}
