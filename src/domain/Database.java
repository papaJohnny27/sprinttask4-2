package domain;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import domain.user.User;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/javaee_sprint4_2";
    private static final String USER = "postgres";
    private static final String PASSWORD = "eldos";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
                connection = DriverManager.getConnection(URL,props);

            System.out.println("Successfully connected to database");
        }catch (Exception e){
            System.out.println("Failed to connect to database");
        }
    }

    public static List<Item> getallItems(){
        List<Item> items = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM items"
            );

            ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Integer id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    Double price = resultSet.getDouble("price");

                    items.add(new Item(id,name,description,price));
                }

                preparedStatement.close();
        }catch (Exception e){
            System.out.println("Failed to get all items");
        }
        return items;
    }

    public static List<User> getAllUser(){
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users"
            );

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");

                users.add(new User(id,email,password,fullName));
            }

            preparedStatement.close();
        }catch (Exception e){
            System.out.println("Failed to get all users");
        }
        return users;
    }

    public static User getByUserId(Integer id){
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id = ?"
            );

            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer userId = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");

                preparedStatement.close();
                users.add(new User(userId,email,password,fullName));
            }

            preparedStatement.close();
            return null;

        }catch (Exception e){
            System.out.println("Failed to get all users");
            return null;
        }

    }
}
