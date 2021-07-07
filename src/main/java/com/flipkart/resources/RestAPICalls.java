package com.flipkart.resources;

import com.codahale.metrics.annotation.Timed;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import com.flipkart.api.Get;
import com.flipkart.api.Post;

@Path("/RestAPICalls")
public class RestAPICalls {

    private final String USER_AGENT;
    private final String GET_URL;
    private final String POST_URL;
    public RestAPICalls( String USER_AGENT, String GET_URL,String POST_URL) {
        this.GET_URL=GET_URL;
        this.USER_AGENT=USER_AGENT;
        this.POST_URL=POST_URL;
    }
    @GET
    @Timed
    public void RestGet() throws IOException {
        Get temp_get =new Get(USER_AGENT,GET_URL);
//        Get temp_get =new Get();
        temp_get.sendHttpGETRequest();
    }

    @POST
    @Timed
    public void RestPost(@NotNull @QueryParam("name") String name,
                         @NotNull @QueryParam("age") String age,
                         @NotNull @QueryParam("salary") String salary
                         ) throws IOException {
        Post.POST_PARAMS ="name="+name+"&salary="+salary+"&age="+age;
        Post.POST_URL =POST_URL;
        Post.USER_AGENT =USER_AGENT;
        Post.sendPOST();
    }
}
