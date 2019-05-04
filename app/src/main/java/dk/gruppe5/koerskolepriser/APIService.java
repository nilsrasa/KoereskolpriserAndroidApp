package dk.gruppe5.koerskolepriser;

import dk.gruppe5.koerskolepriser.objekter.Tilbud;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("tilbudTilBruger/{koreskole_id}")
    Single<Tilbud> getTilbudData(@Path("koreskole_id") int tilbudId,
                                 @Query("api_key") String apiKey);

}
