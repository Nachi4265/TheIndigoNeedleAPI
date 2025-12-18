package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.models.Profile;
import org.yearup.data.ProfileDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlProfileDao extends MySqlDaoBase implements ProfileDao
{
    public MySqlProfileDao(DataSource dataSource)
    {
        super(dataSource);
    }



    public Profile getProfile(int id) {

        String sql = " SELECT * FROM profiles Where user_id = ? " ;

        Profile profile = null;

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {

                int userID = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String email = resultSet.getString(5);
                String address = resultSet.getString(6);
                String city = resultSet.getString(7);
                String state = resultSet.getString(8);
                String zip = resultSet.getString(9);

                return profile = new Profile(userID,firstName,lastName,phone,email,address,city,state,zip);

            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return profile;
    }

    @Override
    public Profile create(Profile profile) {
        return null;
    }


}
