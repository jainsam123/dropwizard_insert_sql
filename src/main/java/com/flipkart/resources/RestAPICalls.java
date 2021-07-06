package com.flipkart.resources;

import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;
import com.flipkart.api.Get;
import com.flipkart.api.Post;

@Path("/RestAPICalls")
public class RestAPICalls {

    private final String USER_AGENT;
    private final String GET_URL;
    private final String POST_URL;
    private final String POST_PARAMS;
    public RestAPICalls( String USER_AGENT, String GET_URL,String POST_URL,String POST_PARAMS) {
        this.GET_URL=GET_URL;
        this.USER_AGENT=USER_AGENT;
        this.POST_PARAMS=POST_PARAMS;
        this.POST_URL=POST_URL;
    }
    @GET
    @Timed
    public void RestGet() throws IOException {
        Get temp_get =new Get(USER_AGENT,GET_URL);
        temp_get.sendHttpGETRequest();
    }

    @POST
    @Timed
    public void RestPost() throws IOException {
        Post temp_post = new Post(USER_AGENT,POST_URL,POST_PARAMS);
        temp_post.sendPost();
    }
}
