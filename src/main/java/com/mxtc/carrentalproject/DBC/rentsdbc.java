package com.mxtc.carrentalproject.DBC;



import com.mxtc.carrentalproject.models.rents;
import javafx.beans.value.ObservableObjectValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is use to interact with the database
 * specially with the rents table
 */
@Repository("rentsDB")
public class rentsdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class rentRowMapper implements RowMapper<rents> {
        @Override
        public rents mapRow(ResultSet resultSet, int i) throws SQLException {
            rents rent = new rents();
            rent.setNumberOfRent(resultSet.getInt("rent_id"));
            rent.setCarId(resultSet.getInt("car_id"));
            rent.setClientName(resultSet.getString("client_name"));
            rent.setClientLastname(resultSet.getString("client_lastname"));
            rent.setStartTime(resultSet.getTimestamp("start_time").toLocalDateTime());
            rent.setEndTime(resultSet.getTimestamp("end_time").toLocalDateTime());
            return rent;
        }
    }


    public List<rents> getAllRents (){
        String sql = "SELECT * FROM rents;";
        List<rents> rents = jdbcTemplate.query(sql, new rentRowMapper());
        return rents;
    }

    public rents getRentById(int id){
        //lanzar exepcio si no existe el id!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String sqlStatement = "SELECT * FROM rents WHERE rent_id = ?";
        rents rent =  jdbcTemplate.queryForObject(sqlStatement, new rentRowMapper(),id);
        return rent;
    }

    public rents insertRent(rents rent){
        //si lo datos no son correctos hay que manejar el error!!!!!!
        String sqlStatement = " INSERT INTO rents(car_id, client_name, client_lastname, start_time, end_time) VALUES(?,?,?,?,?) ";
        int car_id = rent.getCarId();
        String client_name = rent.getClientName();
        String client_lastname = rent.getClientLastname();
        LocalDateTime start_time = rent.getStartTime();
        LocalDateTime end_time = rent.getEndTime();
        jdbcTemplate.update(sqlStatement, new Object[] {car_id, client_name,client_lastname,start_time,end_time});
        return getIdBYBody(car_id, client_name,client_lastname,start_time,end_time);
    }

    private rents getIdBYBody(int car_id, String clientName, String clientLastname, LocalDateTime start, LocalDateTime end){
        String sql = "SELECT * FROM rents WHERE car_id = ? AND client_name = ? AND client_lastname = ? AND start_time = ? AND end_time =? ";
        rents rent = jdbcTemplate.queryForObject(sql, new rentRowMapper(), new Object[]{car_id,clientName,clientLastname,start,end});
        return rent;
    }

    public void updateRent(rents rent){
        String sql = "UPDATE rents SET car_id = ?, client_name = ?, client_lastname =?, start_time =?, end_time = ? WHERE rent_id = ?";
        int id = rent.getNumberOfRent();
        int car_id = rent.getCarId();
        String client_name = rent.getClientName();
        String client_lastname = rent.getClientLastname();
        LocalDateTime start_time = rent.getStartTime();
        LocalDateTime end_time = rent.getEndTime();
        jdbcTemplate.update(sql, new Object[] {car_id, client_name,client_lastname,start_time,end_time, id});
    }

    public void deleteRent(int id){
        String sql = " DELETE FROM rents WHERE rent_id  = ?";
        jdbcTemplate.update(sql,id);
    }

    public List<rents> getUnavailableCars(Timestamp startTime, Timestamp endTime){
        String sql = "SELECT * FROM rents WHERE start_time < ? AND end_time > ? ";
        List<rents> notAvailableCars = jdbcTemplate.query(sql,new rentRowMapper(),new Object[]{endTime, startTime});
        return notAvailableCars;
    }

}
