package com.flipkart.resources;

import com.codahale.metrics.annotation.Timed;

import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import com.flipkart.db.Inserting;

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
    public String inserted (@NotNull @QueryParam("username") String username,
                           @NotNull @QueryParam("password") String password,
                           @NotNull @QueryParam("fullname") String fullname ,
                           @NotNull @QueryParam("email") String email
        ) {
        Inserting sql = new Inserting();
        return sql.sayHello(username,password,fullname,email,jdbcURL,username_sql,password_sql) ;

    }


}
