import external.client.PeopleClient;
import external.client.PeopleDto;
import external.connection.HibernateUtil;
import external.dao.PeopleDao;
import external.entity.Station;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {


        PeopleClient peopleClient = new PeopleClient();
        PeopleDto peopleDto = peopleClient.getAstronautsForADate();
        PeopleDao peopleDao = new PeopleDao();
        peopleDao.saveAll(peopleDto.getPeople());

        Station station = new Station();
        station.setId(1);
        station.setName("namaaaaeee");


        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(station);
            transaction.commit();
        } catch (HibernateException hibernateException) {
            transaction.rollback();
        }

    }

}
