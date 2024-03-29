package dk.gruppe5.koerskolepriser;

import dk.gruppe5.koerskolepriser.objekter.Tilbud;
import dk.gruppe5.koerskolepriser.objekter.TilbudTilBruger;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {

    @GET("webresources/generic/alleTilbud")
    Single<TilbudTilBruger[]> getAlleTilbudData();

    @POST("webresources/generic/tilbudMedGiventPostnummer/{postnummer}")
    Single<Tilbud[]> hentTilbudMedPostnummer(@Path("postnummer") int postnummer);

    @POST("webresources/generic/opretTilbud")
    Single<String[]> opretTilbud(@Body String[] string);

    @PUT("webresources/generic/opretTilbud")
    Single<Tilbud> opdaterTilbud(@Body String[] string);

    @POST("webresources/generic/login")
    Single<String> login(@Body String string);

    @POST("webresources/generic/tilbudKoreskole")
    Single<Tilbud[]> getKøreskoleTilbud(@Body String string);
}
