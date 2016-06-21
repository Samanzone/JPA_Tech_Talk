package techtalk;

import com.saman.techtalk.model.Customer;
import com.saman.techtalk.model.Item;
import com.saman.techtalk.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by saman on 9/11/14.
 */
public class Ctrl {


    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = factory.createEntityManager();

        //Query q = em.createQuery("select new Item (t.itemId) from Item t");
        Query q = em.createQuery("select  t from Item t");
        List<Item> todoList = q.getResultList();
        for (Item todo : todoList) {
            System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());


        em.getTransaction().begin();
        Item todo = new Item();
        todo.setItemDescription("This is a test");
        todo.setItemName("This is a test");
        em.persist(todo);

        Person c = new Customer();
        c.setFirstName("This is a Customer");
        c.setLastName("This is a Customer");
        em.persist(c);


        em.getTransaction().commit();

        em.close();

    }


//        String b="select%20*%20from%20news".replaceAll("%20"," ");
//        System.out.print(b);
//        try {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//
//        Date date1 =dateFormat.parse("2014-10-30 1:0");
//        Date date2 =dateFormat.parse("2014-11-05 1:1");
//        Calendar calStart = new GregorianCalendar();
//        calStart.setTime(date2);
//        calStart.set(Calendar.MINUTE, 0);
//
//
//
//        Calendar calEnd = new GregorianCalendar();
//        calEnd.setTime(date1);
//        calEnd.set(Calendar.MINUTE, 0);
//
//        long diff = calStart.getTimeInMillis()
//                - calEnd.getTimeInMillis();
//        long hours = diff / (1000 * 60 * 60);
//
//
//
//
//
//            hours  = getHours(calStart.getTime(),calEnd.getTime(),hours,true);
//            System.out.println("hours" + hours);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    private static long getHours(Date date, Date newDate, long hours, boolean forward) {
//        TimeZone defaultTimeZone = TimeZone.getDefault();
//        if(defaultTimeZone.inDaylightTime(date)){
//            System.out.println("Before add time in DST region");
//        }else {
//            System.out.println("Before add time not in DST region");
//        }
//        if(defaultTimeZone.inDaylightTime(newDate)){
//            System.out.println("After add time in DST region");
//        }else {
//            System.out.println("After add time not in DST region");
//        }
//
//        if (forward) {
//            if (!defaultTimeZone.inDaylightTime(date) && defaultTimeZone.inDaylightTime(newDate)) {
//                System.out.println("forward time reduced");
//                return --hours;
//            }
//
//            if (defaultTimeZone.inDaylightTime(date) && !defaultTimeZone.inDaylightTime(newDate)) {
//                System.out.println("forward time increase");
//                return ++hours;
//            }
//
//        }else {
//            if (!defaultTimeZone.inDaylightTime(date) && defaultTimeZone.inDaylightTime(newDate)) {
//                System.out.println("backward time increase");
//                return ++hours;
//            }
//
//            if (defaultTimeZone.inDaylightTime(date) && !defaultTimeZone.inDaylightTime(newDate)) {
//                System.out.println("backward time reduced");
//                return --hours;
//
//            }
//        }
//
//        return hours;
//    }


}
