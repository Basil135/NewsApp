package lan.news.www.service;

import lan.news.www.dao.CategoryDAO;
import lan.news.www.model.Category;
import lan.news.www.model.News;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private CategoryDAO categoryDAO;

    public void setCategoryDao(CategoryDAO categoryDao) {
        this.categoryDAO = categoryDao;
    }

    @Transactional
    public void addCategory(Category category) {
        this.categoryDAO.addCategory(category);
    }

    @Transactional
    public void removeCategory(int id) {
        this.categoryDAO.removeCategory(id);
    }

    @Transactional
    public Category getCategoryById(int id) {
        return this.categoryDAO.getCategoryById(id);
    }

    @Transactional
    public List<Category> listCategory() {
        return this.categoryDAO.listCategory();
    }

    @Transactional
    public List<News> listNewsByCategory(int id) {
        return this.categoryDAO.listNewsByCategory(id);
    }

}
