package dk.gruppe5.koerskolepriser;

import java.util.List;

import dk.gruppe5.koerskolepriser.objekter.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

}
