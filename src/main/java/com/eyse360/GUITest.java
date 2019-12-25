package com.eyse360;

import com.eyse360.controllers.BarDAO;
import com.eyse360.controllers.CategoryDAO;
import com.eyse360.controllers.ProductDAO;
import com.eyse360.models.Bar;
import com.eyse360.models.Category;
import com.eyse360.models.Food;
import com.eyse360.models.Product;
import com.eyse360.tools.Tools;

import java.util.List;

public class GUITest {
    public static DBConnection conn;
    private static BarDAO barDao;
    private static CategoryDAO catDao;
    private static ProductDAO productDAO;
    public static Bar bar;
    static List<Category> categories;

    public static void main(String[] args) {
        conn = new DBConnection();
        barDao = new BarDAO();
        catDao = new CategoryDAO();
        productDAO = new ProductDAO();
        bar = barDao.getById(1);

        categories = catDao.getAllByBar(bar);

        for (Category category: categories) {
            category.setProducts(productDAO.getAllByBarAndCategory(bar, category));
        }

//        Category category = new Category();
//        category.setName("Pizza");
//        category.setDescription("Özenle hazırlanmış müthiş pizzalarımız");
//        category.setType("food");
//        category.setBar(bars.get(0));
//        category.setId(catDao.save(category));

//        Category cat = categories.get(0);
//        System.out.println(cat);
//        Food food = new Food();
//        food.setName("Sucuklu Pizza");
//        food.setDescription("Özel pizza sosu, tavuk parçaları, mantar ve mozarella");
//        food.setPrice(20.00);
//        food.setCategory(cat);
//        food.setBar(bar);
//        food.setId(productDAO.save(food));

//        System.out.println(food);

//        Bar newBar = new Bar();
//        newBar.setName("asd");
//        newBar.setCity("izmir");
//        newBar.setAlcoholPermission(false);
//        newBar.setId(barDao.save(newBar));
//
//        bars.get(0).setName("asdasdsadadsa");
//        barDao.update(bars.get(0));
//
//        bars = barDao.getAll();
//        System.out.println(bars);
    }
}
