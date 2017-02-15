package lan.news.www.dao;

import lan.news.www.model.News;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class NewsDAO implements INewsDAO{

    SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(NewsDAO.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNews(News news) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(news);
        logger.info("The news added. News details " + news);
    }

    public void updateNews(News news) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(news);
        logger.info("The news updated. News details " + news);
    }

    public void removeNews(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        News news = (News) session.load(News.class, new Integer(id));
        if (news != null){
            session.delete(news);
        }
        logger.info("The news removed. News details " + news);
    }

    public News getNewsById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        News news = (News) session.load(News.class, new Integer(id));
        logger.info("The news loaded. News details: " + news);
        return news;
    }

    public List<News> listNews() {
        Session session = this.sessionFactory.getCurrentSession();
        List<News> newsList = session.createQuery("from news").list();
        for (News news: newsList) {
            logger.info("News list:" + news);
        }
        return newsList;
    }

}
