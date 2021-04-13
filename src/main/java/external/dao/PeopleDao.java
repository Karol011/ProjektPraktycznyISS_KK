package external.dao;


import external.connection.HibernateUtil;
import external.entity.People;
import lombok.ToString;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.stream.Collectors;

import java.util.Set;

@ToString
public class PeopleDao {

    public Set<People> findByName(String name) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String query = "FROM People p  WHERE p.name = :name";

            Set<People> people = (Set<People>) session.createQuery(query)
                    .setParameter("name", name)
                    .getResultList();
            transaction.commit();

            return people;

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

        }
        return null;
    }

    public Set<People> findAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String query = "FROM People";

            Set<People> people = (Set<People>) session.createQuery(query)
                    .getResultStream()
                    .collect(Collectors.toSet());
            transaction.commit();

            return people;

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

        }
        return null;
    }

    public void save(People people) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(people);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

        }
    }

    public void saveAll(People[] people) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            for (int i = 0; i < people.length - 1; i++) {
                session.save(people[i]);
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

        }
    }

    public void delete(People people) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(people);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();

        }
    }


}
