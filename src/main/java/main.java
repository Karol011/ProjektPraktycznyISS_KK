import external.client.AstronautClient;
import external.connection.HibernateUtil;
import external.entity.Station;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

public class main {
    public static void main(String[] args) {


        AstronautClient astronautClient = new AstronautClient();
        System.out.println(astronautClient.getAstronautsForADate());


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
