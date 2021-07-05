package com.flipkart.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.sql.*;
import java.util.Optional;

@Path("/SQL")
public class InsertSQL {
    private final String dusername;
    private final String dpassword;
    private final String dfullname;
    private final String demail;
    private final String jdbcURL;
    private final String username_sql;
    private final String password_sql;

    public InsertSQL(String username, String password, String fullname, String email, String jdbcURL, String username_sql, String password_sql) {
        this.dusername = username;
        this.dpassword = password;
        this.dfullname = fullname;
        this.demail = email;
        this.jdbcURL = jdbcURL;
        this.username_sql = username_sql;
        this.password_sql = password_sql;
    }
    @POST
    @Timed
    public String sayHello(@QueryParam("username") Optional<String> username,
                           @QueryParam("password") Optional<String> password,
                           @QueryParam("fullname") Optional<String> fullname ,
                           @QueryParam("email") Optional<String> email
        ) {
//        String jdbcURL="jdbc:mysql://192.168.0.106:3306/sampledb";
//        String username_sql="root";
//        String password_sql="root";

        try {
            Connection connection= DriverManager.getConnection(jdbcURL,username_sql,password_sql);
            if(connection!=null)
            {
                System.out.println("connected to database");
                String sql_insert;
                sql_insert = "INSERT INTO users (username,password,fullname,email) VALUES (?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql_insert);
                statement.setString(1,username.orElse(dusername));
                statement.setString(2,password.orElse(dpassword));
                statement.setString(3,fullname.orElse(dfullname));
                statement.setString(4,email.orElse(demail));
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
