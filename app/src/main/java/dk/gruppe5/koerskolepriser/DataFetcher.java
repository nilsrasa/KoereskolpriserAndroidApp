package dk.gruppe5.koerskolepriser;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import dk.gruppe5.koerskolepriser.listeners.OnBrugerTilbudListener;
import dk.gruppe5.koerskolepriser.listeners.OnDataSentListener;
import dk.gruppe5.koerskolepriser.listeners.OnKoereskoleTilbudListener;
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

    public void hentAlleTilbud(final OnBrugerTilbudListener listener) {
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
                        e.printStackTrace();
                    }
                });
    }

    public void søgEfterTilbud(final Soegning søgning, final OnBrugerTilbudListener listener){
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

    public void  login(String brugernavn, String password, final OnDataSentListener listener){
        String s = brugernavn+" "+password;
        final Single<String> single = apiService.login(s);

        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String string) {
                        Log.d("HAHA", string);
                        listener.onSuccess(new String[]{string});
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e);
                    }
                });
    }

    public void  hentKøreskoleTilbud(String brugernavn, String password, final OnKoereskoleTilbudListener listener){
        String s = brugernavn+" "+password;
        final Single<Tilbud[]> single = apiService.getKøreskoleTilbud(s);

        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Tilbud[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Tilbud[] tilbuds) {
                        listener.onSuccess(tilbuds);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e);
                    }
                });
    }
}
