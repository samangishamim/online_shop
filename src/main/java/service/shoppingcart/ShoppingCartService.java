package service.shoppingcart;

import Base.Service.BaseService;
import model.ShoppingCart;
import model.Users;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ShoppingCartService extends BaseService<Integer, ShoppingCart> {
    public void addShoppingCart(int userId) throws SQLException;

    /*
    show list of shopping cart
    edit: get product id  from user to edit
    product quantity from shoppingCart exist : quantity
    get new quantity from user : newQuantity
    different = newQuantity - quantity
    different  > 0:
    example:
    productStockQuantity =15
    userQuantity =5
    productStockQuantity = 10
    newUserQuantity=7
    different =7-5=2
    10>2 == true
    so we should subtract 2 from product table

    checkProductQuantity (different)
    updateProductStockQuantity (different)-add false
    updateShoppingCart with new userQuantity

    if differenet <0
     updateProductStockQuantity (different)-add true
     updateShoppingCart with new userQuantity
     */



    public void removeShoppingCart(int userId) throws SQLException;
    public ArrayList<ShoppingCart> listOfShoppingCart() throws SQLException;
    public void deleteByProductIdUserId(int productId,int userId) throws SQLException;
    public  ArrayList<ShoppingCart> listByUserId(int userId) throws SQLException;
    public ShoppingCart findByProductIdUserId(int productId,int userId) throws SQLException;
    public ShoppingCart userShoppingCartReport(int userId) throws SQLException;

    public ArrayList<String> sumOfTotalAmountOfItems() throws SQLException;
    public ArrayList<String> sumOfTotalAmountOfItems(int userId) throws SQLException;
}
