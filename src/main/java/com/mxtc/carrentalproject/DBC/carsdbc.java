package com.mxtc.carrentalproject.DBC;

import com.mxtc.carrentalproject.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("mysql")
public class carsdbc {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class carRowMapper implements RowMapper<Car>{

        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            Car car = new Car();
            car.setModel(resultSet.getString("model"));
            car.setNumberOfCars(resultSet.getInt("numberofcars"));
            car.setAvailable(resultSet.getBoolean("available"));
            car.setPricePerHour(resultSet.getInt("priceperhour"));
            return car;
        }
    }

    public List<Car> getAllCars() {
        String sqlStatement = "SELECT model,numberofcars,available,priceperhour FROM car";
        List<Car> cars =jdbcTemplate.query(sqlStatement, new carRowMapper());
        return cars;
    }

}
