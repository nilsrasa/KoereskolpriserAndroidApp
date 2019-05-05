package dk.gruppe5.koerskolepriser;

import java.util.List;

import dk.gruppe5.koerskolepriser.objekter.TilbudTest;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApiTest {

    @GET("webresources/generic/getAlleTilbud")
    Call<List<TilbudTest>> getAlleTilbud();

}
