package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {

    public MySqlShoppingCartDao(DataSource dataSource){
        super(dataSource);
    }


    @Override
    public ShoppingCart getByUserId(int userId) {

        ShoppingCart shoppingCart = null;

        //Logic for getting the users cart.
        String sql = "Select * FROM shopping_cart Where user_id = ?";

        try(Connection connection = super.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1,userId);

            try (ResultSet result = statement.executeQuery()){
                if(result.next()){

                    int userID = result.getInt(1);
                    int productID = result.getInt(2);
                    int quantity = result.getInt(3);

                    //shoppingCart.contains(productID);


                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void addItem(ShoppingCartItem shoppingCartItem) {

    }

    @Override
    public void updateItem(ShoppingCartItem shoppingCartItem) {

    }

    @Override
    public void deleteAllItems(ShoppingCartItem shoppingCartItems) {

    }

}
