package dk.gruppe5.koerskolepriser;

import dk.gruppe5.koerskolepriser.objekter.Tilbud;
import dk.gruppe5.koerskolepriser.objekter.TilbudTilBruger;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("webresources/generic/getAlleTilbud")
    Single<TilbudTilBruger> getAlleTilbudData();

    @POST("webresources/generic/tilbudMedGiventPostnummer/{postnummer}")
    Single<TilbudTilBruger> hentTilbudMedPostnummer(@Path("postnummer") int postnummer);

}
