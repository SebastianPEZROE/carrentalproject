package com.mxtc.carrentalproject.DBC;

import com.mxtc.carrentalproject.models.Car;
import com.mxtc.carrentalproject.models.rents;
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
public class carsdbc {
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

    public List<Car> getAllCars() {
        String sqlStatement = "SELECT car_id, model,priceperhour FROM cars";
        List<Car> cars =jdbcTemplate.query(sqlStatement, new carRowMapper());
        return cars;
    }

    public List<Car> getAvailableCars(String sqlStatement){
        List<Car> cars =jdbcTemplate.query(sqlStatement, new carRowMapper());
        return cars;
    }

}
