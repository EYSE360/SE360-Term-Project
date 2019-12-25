package com.eyse360;

import com.eyse360.controllers.BarDAO;
import com.eyse360.controllers.BarUserDAO;
import com.eyse360.controllers.CategoryDAO;
import com.eyse360.controllers.ProductDAO;
import com.eyse360.models.*;
import com.eyse360.tools.Tools;

import java.util.List;

public class GUITest {
    public static DBConnection conn;
    private static BarDAO barDao;
    private static CategoryDAO catDao;
    private static ProductDAO productDAO;
    private static BarUserDAO barUserDAO;
    public static Bar bar;
    static List<Category> categories;

    public static void main(String[] args) {
        conn = new DBConnection();
        barDao = new BarDAO();
        catDao = new CategoryDAO();
        productDAO = new ProductDAO();
        barUserDAO = new BarUserDAO();
        bar = barDao.getById(1);
        Category category = catDao.getById(1);
        System.out.println(category);

        category.setName("Bira");
        category.setDescription("Biralar");
        category.setType("beverage");

        catDao.update(category);

        category = catDao.getById(1);

        System.out.println(category);

/*        List<BarUser> barUsers = barUserDAO.getAllByBar(bar);

        System.out.println(barUsers);*/

        /*categories = catDao.getAllByBar(bar);

        for (Category category: categories) {
            category.setProducts(productDAO.getAllByBarAndCategory(bar, category));
        }

        System.out.println(categories);*/

/*        BarManager manager1 = new BarManager();
        manager1.setUserName("smguy9");
        manager1.setPassword("mybeteth");
        manager1.setSSN("15847749746");
        manager1.setFullName("Yağızcan Arslan");
        manager1.setPhoneNumber("05071223053");
        barUserDAO.save(manager1);*/

/*        Waiter waiter1 = new Waiter();
        waiter1.setUserName("eray");
        waiter1.setPassword("123456");
        waiter1.setSSN("12312312312");
        waiter1.setFullName("Eray Aslan");
        waiter1.setPhoneNumber("05551231212");
        barUserDAO.save(waiter1);*/

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
