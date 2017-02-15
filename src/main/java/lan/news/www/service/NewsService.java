package lan.news.www.service;

import lan.news.www.model.News;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lan.news.www.dao.*;
import java.util.List;

@Service
public class NewsService implements INewsService {

    private NewsDAO newsDAO;

    public void setNewsDao(NewsDAO newsDao) {
        this.newsDAO = newsDao;
    }

    @Transactional
    public void addNews(News news) {
        this.newsDAO.addNews(news);
    }

    @Transactional
    public void updateNews(News news) {
        this.newsDAO.updateNews(news);
    }

    @Transactional
    public void removeNews(int id) {
        this.newsDAO.removeNews(id);
    }

    @Transactional
    public News getNewsById(int id) {
        return this.newsDAO.getNewsById(id);
    }

    @Transactional
    public List<News> listNews() {
        return this.newsDAO.listNews();
    }

}
