package lan.news.www.service;

import lan.news.www.model.Category;
import lan.news.www.model.News;
import java.util.List;

public interface ICategoryService {

    void addCategory(Category category);

    void removeCategory(int id);

    Category getCategoryById(int id);

    List<Category> listCategory();

    List<News> listNewsByCategory(int id);

}
