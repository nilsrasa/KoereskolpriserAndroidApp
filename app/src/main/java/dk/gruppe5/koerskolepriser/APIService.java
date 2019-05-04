package dk.gruppe5.koerskolepriser;

import dk.gruppe5.koerskolepriser.objekter.Tilbud;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("webresources/generic/getAlleTilbud")
    Single<Tilbud> getAlleTilbudData();

    @POST("webresources/generic/tilbudMedGiventPostnummer/{postnummer}")
    Single<Tilbud> hentTilbudMedPostnummer(@Path("postnummer") int postnummer);

}
