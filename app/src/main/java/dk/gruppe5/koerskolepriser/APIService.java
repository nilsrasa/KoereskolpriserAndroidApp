package dk.gruppe5.koerskolepriser;

import dk.gruppe5.koerskolepriser.objekter.PakkeTilbud;
import dk.gruppe5.koerskolepriser.objekter.Tilbud;
import dk.gruppe5.koerskolepriser.objekter.TilbudTilBruger;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

    @GET("webresources/generic/getAlleTilbud")
    Single<PakkeTilbud[]> getAlleTilbudData();

    @POST("webresources/generic/tilbudMedGiventPostnummer/{postnummer}")
    Single<TilbudTilBruger[]> hentTilbudMedPostnummer(@Path("postnummer") int postnummer);

    @POST("webresources/generic/opretTilbud")
    Call<TilbudTilBruger> opretTilbud(String brugernavn, String password, @Body TilbudTilBruger tilbudTilBruger);

}
