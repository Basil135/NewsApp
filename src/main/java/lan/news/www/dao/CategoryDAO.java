package lan.news.www.dao;

import lan.news.www.model.Category;
import lan.news.www.model.News;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CategoryDAO implements ICategoryDAO{

    private static final Logger logger = Logger.getLogger(CategoryDAO.class);

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCategory(Category category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(category);
        logger.info("Category added: " + category);
    }

    public void removeCategory(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        Category category = (Category) session.load(Category.class, new Integer(id));

        if (category != null) {
            List<News> listNews = this.listNewsByCategory(id);
            for (News news: listNews){
                session.delete(news);
            }
            session.delete(category);
        }
        logger.info("Category removed: " + category);

    }

    public Category getCategoryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Category category = session.load(Category.class, new Integer(id));
        logger.info("Category loaded: " + category);
        return category;
    }

    public List<Category> listCategory() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Category> categoryList = session.createQuery("from categories").list();
        for (Category category: categoryList){
            logger.info("List category: " + category);
        }
        return categoryList;
    }

    public List<News> listNewsByCategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        List<News> newsList = session.createQuery("select * from news where category_id = " + id).list();
        for (News news: newsList){
            logger.info("List news of category " + id + " : " + news);
        }
        return newsList;
    }

}
