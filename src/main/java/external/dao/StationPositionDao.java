package external.dao;

import external.client.StationPositionNotFoundException;
import external.connection.HibernateUtil;
import external.entity.StationPosition;
import lombok.ToString;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

@ToString
public class StationPositionDao {


    public void save(StationPosition position) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(position);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

        }
    }


    public Optional<StationPosition> findById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String query = "FROM StationPosition p  WHERE p.station_position_id = :station_position_id";
            Optional position = session.createQuery(query)
                    .setParameter("station_position_id", id)
                    .uniqueResultOptional();
            transaction.commit();

            return (Optional<StationPosition>) position.orElseThrow(StationPositionNotFoundException::new);

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

        } catch (Throwable throwable) {

            throwable.printStackTrace();
        }
        return Optional.empty();
    }
}
