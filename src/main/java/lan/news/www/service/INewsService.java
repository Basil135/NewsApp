package lan.news.www.service;

import lan.news.www.model.News;
import java.util.List;

public interface INewsService {

    void addNews(News news);

    void updateNews(News news);

    void removeNews(int id);

    News getNewsById(int id);

    List<News> listNews();

}
