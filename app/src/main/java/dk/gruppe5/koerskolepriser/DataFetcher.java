package dk.gruppe5.koerskolepriser;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import dk.gruppe5.koerskolepriser.listeners.OnDataFetchedListener;
import dk.gruppe5.koerskolepriser.listeners.OnDataSentListener;
import dk.gruppe5.koerskolepriser.objekter.TilbudTilBruger;
import dk.gruppe5.koerskolepriser.objekter.Soegning;
import dk.gruppe5.koerskolepriser.objekter.Tilbud;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DataFetcher {
    private static final DataFetcher INSTANCE = new DataFetcher();
    private final APIService apiService;

    public static DataFetcher getInstance(){
        return INSTANCE;
    }

    private DataFetcher(){
        apiService = APIKlient.getKlient().create(APIService.class);
    }

    public void hentAlleTilbud(final OnDataFetchedListener listener) {
        Single<TilbudTilBruger[]> tilbud = apiService.getAlleTilbudData();

        tilbud.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<TilbudTilBruger[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(TilbudTilBruger[] pakker) {
                        listener.onSuccess(pakker);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e);
                    }
                });
    }

    public void søgEfterTilbud(final Soegning søgning, final OnDataFetchedListener listener){
        Single<TilbudTilBruger[]> tilbud = apiService.getAlleTilbudData();

        tilbud.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<TilbudTilBruger[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(TilbudTilBruger[] pakker) {
                        List<TilbudTilBruger> matchs = new ArrayList<>();

                        if (pakker != null){
                            for (TilbudTilBruger pakke:pakker){
                                if (søgning.matcher(pakke))
                                    matchs.add(pakke);
                            }
                        }

                        listener.onSuccess(matchs.toArray(new TilbudTilBruger[0]));
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e);
                    }
                });
    }

    public void opretTilbud(Tilbud tilbud, String brugernavn,
                            String password, final OnDataSentListener listener){
        String json = new Gson().toJson(tilbud);
        String[] a = new String[] {brugernavn, password, json};
        Single<String[]> single = apiService.opretTilbud(a);

        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String[] strings) {
                        listener.onSuccess(strings);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e);
                    }
                });
    }
}
