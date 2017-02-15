package lan.news.www.dao;

import lan.news.www.model.News;

import java.util.List;

public interface INewsDAO {

    void addNews(News news);

    void updateNews(News news);

    void removeNews(int id);

    News getNewsById(int id);

    List<News> listNews();

}
