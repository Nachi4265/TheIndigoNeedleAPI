package org.yearup.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        String query = "Select category_id , name, description FROM categories;";

        try(Connection connection = super.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet results = statement.executeQuery()){

            while(results.next()){

                int categoryiD = results.getInt(1);
                String categoryName = results.getString(2);
                String description = results.getString(3);
                categories.add(new Category());
            }
        }catch (SQLException e ){
            System.out.println("Error :" + e.getMessage());
        }

        // get all categories
        return categories;

    }

    @Override
    public Category getById(int categoryId)
    {
        // get category by id
        return null;
    }

    @Override
    public Category create(Category category)
    {
        // create a new category
        return null;
    }

    @Override
    public void update(int categoryId, Category category)
    {
        // update category
    }

    @Override
    public void delete(int categoryId)
    {
        // delete category
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
