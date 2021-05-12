package com.mxtc.carrentalproject.DBC;

import com.mxtc.carrentalproject.models.Car;
import com.mxtc.carrentalproject.models.Rents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * this class is use to interact with the database
 * specially with the cars table
 */
@Repository("carsDB")
public class CarsDBC {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class carRowMapper implements RowMapper<Car>{

        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            Car car = new Car();
            car.setCar_id(resultSet.getInt("car_id"));
            car.setModel(resultSet.getString("model"));
            car.setPricePerHour(resultSet.getInt("priceperhour"));
            car.setType(resultSet.getString("type"));
            return car;
        }
    }

    public List<Car> getAvailableCars(String start, String end, String type, String order, boolean asc){
        String sqlStatement = "SELECT * FROM cars WHERE cars.car_id NOT IN(" +
                "SELECT rents.car_id FROM rents WHERE start_time < ? AND end_time > ? AND reserved = true) ";
        if (!type.equals(""))
            sqlStatement = sqlStatement +" AND type = '" + type + "' ";

        if (order.equals("type") && asc)
            sqlStatement = sqlStatement + "ORDER BY type ";
        else if (order.equals("price") && asc)
            sqlStatement = sqlStatement + "ORDER BY priceperhour ";
        else if (order.equals("type") && !asc)
            sqlStatement = sqlStatement + "ORDER BY type DESC ;";
        else if (order.equals("price") && !asc)
            sqlStatement = sqlStatement + "ORDER BY priceperhour DESC ;";
        else if (order.equals("") && asc)
            sqlStatement = sqlStatement + "ORDER BY model;";
        else
            sqlStatement = sqlStatement + "ORDER BY model DESC";

        System.out.println(sqlStatement);

        List<Car> cars =jdbcTemplate.query(sqlStatement, new carRowMapper(), new Object[]{end, start});
        return cars;
    }

}
