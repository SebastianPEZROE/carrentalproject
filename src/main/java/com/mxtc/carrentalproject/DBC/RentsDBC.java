package com.mxtc.carrentalproject.DBC;



import com.mxtc.carrentalproject.models.Rents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * this class is use to interact with the database
 * specially with the rents table
 */
@Repository("rentsDB")
public class RentsDBC {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class rentRowMapper implements RowMapper<Rents> {
        @Override
        public Rents mapRow(ResultSet resultSet, int i) throws SQLException {
            Rents rent = new Rents();
            rent.setNumberOfRent(resultSet.getInt("rent_id"));
            rent.setCarId(resultSet.getInt("car_id"));
            rent.setClientName(resultSet.getString("client_name"));
            rent.setClientLastname(resultSet.getString("client_lastname"));
            rent.setStartTime(resultSet.getTimestamp("start_time").toLocalDateTime());
            rent.setEndTime(resultSet.getTimestamp("end_time").toLocalDateTime());
            rent.setReserved(resultSet.getBoolean("reserved"));
            return rent;
        }
    }

    public Rents getRentById(int id){
        //lanzar exepcion si no existe el id!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String sqlStatement = "SELECT * FROM rents WHERE rent_id = ?";
        Rents rent =  jdbcTemplate.queryForObject(sqlStatement, new rentRowMapper(),id);
        return rent;
    }

    public Rents insertRent(Rents rent){
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

    private Rents getIdBYBody(int car_id, String clientName, String clientLastname, LocalDateTime start, LocalDateTime end){
        String sql = "SELECT * FROM rents WHERE car_id = ? AND client_name = ? AND client_lastname = ? AND start_time = ? AND end_time =? ";
        Rents rent = jdbcTemplate.queryForObject(sql, new rentRowMapper(), new Object[]{car_id,clientName,clientLastname,start,end});
        return rent;
    }

    public void updateRent(Rents rent){
        String sql = "UPDATE rents SET car_id = ?, client_name = ?, client_lastname =?, start_time =?, end_time = ? WHERE rent_id = ?";
        int id = rent.getNumberOfRent();
        int car_id = rent.getCarId();
        String client_name = rent.getClientName();
        String client_lastname = rent.getClientLastname();
        LocalDateTime start_time = rent.getStartTime();
        LocalDateTime end_time = rent.getEndTime();
        jdbcTemplate.update(sql, new Object[] {car_id, client_name,client_lastname,start_time,end_time, id});
    }

    public void cancelRent(int id){
        String sql = "UPDATE rents SET reserved = false WHERE rent_id = ?";
        jdbcTemplate.update(sql, id);
    }

}
