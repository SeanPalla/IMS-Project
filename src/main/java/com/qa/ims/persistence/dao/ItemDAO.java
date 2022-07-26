package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item> {

    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("item_id");
        String itemName = resultSet.getString("item_name");
        double price = resultSet.getDouble("price");
        Integer stock = resultSet.getInt("stock");
        return new Item(id, itemName, price, stock);
    }

    public Item readLatest() {
        try (Connection connection = DBUtils.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY item_id DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * Creates a item in the database
     * 
     * @param item - takes in a item object. id will be ignored
     */
    @Override
    public Item create(Item item) {
        try (Connection connection = DBUtils.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO items(item_name, price, stock) VALUES (?, ?, ?)");) {
            statement.setString(1, item.getItemName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getStock());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * Reads all items from the database
     * 
     * @return A list of customers
     */
    @Override
    public List<Item> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM items");) {
            List<Item> customers = new ArrayList<>();
            while (resultSet.next()) {
                customers.add(modelFromResultSet(resultSet));
            }
            return customers;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * Reads a single item from the items database
     * 
     * @return A list of items matching the id
     */
    @Override
    public Item read(Long id) {
        try (Connection connection = DBUtils.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?");) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                resultSet.next();
                return modelFromResultSet(resultSet);
            }
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Item update(Item t) {
        return null;
    }

    @Override
    public int delete(long id) {
        return 0;
    }

}
