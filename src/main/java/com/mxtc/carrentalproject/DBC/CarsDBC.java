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

    public List<Car> getAvailableCars(List<Rents> notAvailableCars, String type, String order, boolean asc){
        String sqlStatement = "SELECT * FROM cars ";
        if(notAvailableCars.size() > 0 || !type.equals("")){
            sqlStatement = sqlStatement + "WHERE ";
            if(notAvailableCars.size() > 0){
                for(Rents element: notAvailableCars){
                    sqlStatement = sqlStatement + "car_id != " + String.valueOf(element.getCarId()) + " AND ";
                }
            }
            if(!type.equals("")){
                sqlStatement = sqlStatement + " type = '" + type + "' AND ";
            }
            sqlStatement = sqlStatement.substring(0, sqlStatement.length() - 4);
        }
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
        List<Car> cars =jdbcTemplate.query(sqlStatement, new carRowMapper());
        return cars;
    }

}
