package com.flipkart.resources;

import com.codahale.metrics.annotation.Timed;

import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.sql.*;

@Path("/SQL")
public class InsertSQL {

    private final String jdbcURL;
    private final String username_sql;
    private final String password_sql;

    public InsertSQL( String jdbcURL, String username_sql, String password_sql) {
        this.jdbcURL = jdbcURL;
        this.username_sql = username_sql;
        this.password_sql = password_sql;
    }
    @POST
    @Timed
    public String sayHello(@NotNull @QueryParam("username") String username,
                           @NotNull @QueryParam("password") String password,
                           @NotNull @QueryParam("fullname") String fullname ,
                           @NotNull @QueryParam("email") String email
        ) {

        try {
            Connection connection= DriverManager.getConnection(jdbcURL,username_sql,password_sql);
            if(connection!=null)
            {
                System.out.println("connected to database");
                String sql_insert;
                sql_insert = "INSERT INTO users (username,password,fullname,email) VALUES (?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql_insert);
                statement.setString(1,username);
                statement.setString(2,password);
                statement.setString(3,fullname);
                statement.setString(4,email);
                int rows= statement.executeUpdate();
                connection.close();
                return "successfully inserted "+rows+" rows.";
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return "error";
        }
        return "hi";

    }


}
