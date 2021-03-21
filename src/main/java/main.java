import external.connection.HibernateUtil;
import external.entity.Station;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class main {
    public static void main(String[] args) {

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
