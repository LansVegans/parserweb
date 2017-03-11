package onliner;

import net.parser.entities.Notebook;
import net.parser.persistence.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by LansVegans on 03.03.2017.
 */

public class sqlQuery {

    Session session = HibernateUtil.getSessionFactory().openSession();
    @Test
    @SuppressWarnings("unchecked")
    public void getNote() {
    session.beginTransaction();
    List<Notebook> list = session.createQuery("from Notebook").list();
        System.out.println(list);

    }
}
