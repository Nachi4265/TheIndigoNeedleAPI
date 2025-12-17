package org.yearup.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{
    @Autowired
    public MySqlCategoryDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories()
    {

        List<Category> categories = new ArrayList<>();

        String query = "Select category_id , name, description FROM categories";

        try(Connection connection = super.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet results = statement.executeQuery()){

            while(results.next()){
                categories.add(mapRow(results));
            }
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }

        // get all categories
        return categories;
    }

    @Override
    public Category getById(int categoryId)
    {

        Category categoryByID = null;

        String idQuery = "Select category_id , name, description FROM categories Where category_id = ? ";

        try(Connection connection = super.getConnection();
            PreparedStatement statement = connection.prepareStatement(idQuery);
        ){
            // get category by id
            statement.setInt(1,categoryId);

            try(ResultSet results = statement.executeQuery()){

                if(results.next()){
                    categoryByID = mapRow(results);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categoryByID;

    }

    @Override
    public Category create(Category category)
    {
        // create a new category
        String query = "INSERT INTO categories ( name , description ) Values ( ? , ? )";

        try(Connection connection = super.getConnection();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ){

            statement.setString(1,category.getName());
            statement.setString(2,category.getDescription());

            int rows = statement.executeUpdate();

            try(ResultSet keys = statement.getGeneratedKeys()){

                if(keys.next()){
                    int categoryID = keys.getInt(1);
                    category.setCategoryId(categoryID);
                    return category;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return category;
    }

    @Override
    public void update(int categoryId, Category category)
    {
        // update category
        String query = "UPDATE categories SET `name` = ?  WHERE category_id = ?";

        try(Connection connection = super.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ){
            statement.setString(1 , category.getName());
            statement.setInt(2 , categoryId);

            int rows  = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int categoryId)
    {
        // delete category
        String query = """
                DELETE FROM categories
                WHERE category_id = ?""";

        try(Connection connection = super.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, categoryId);

            int rows = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
