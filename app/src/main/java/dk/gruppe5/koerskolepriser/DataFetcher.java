package dk.gruppe5.koerskolepriser;

import java.util.ArrayList;
import java.util.List;

import dk.gruppe5.koerskolepriser.objekter.PakkeTilbud;
import dk.gruppe5.koerskolepriser.objekter.Soegning;
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

    public void hentAlleTilbud(final OnDataListener listener) {
        Single<PakkeTilbud[]> tilbud = apiService.getAlleTilbudData();

        tilbud.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<PakkeTilbud[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(PakkeTilbud[] pakker) {
                        listener.onSuccess(pakker);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e);
                    }
                });
    }

    public void søgEfterTilbud(final Soegning søgning, final OnDataListener listener){
        Single<PakkeTilbud[]> tilbud = apiService.getAlleTilbudData();

        tilbud.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<PakkeTilbud[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(PakkeTilbud[] pakker) {
                        List<PakkeTilbud> matchs = new ArrayList<>();

                        if (pakker != null){
                            for (PakkeTilbud pakke:pakker){
                                if (søgning.matcher(pakke))
                                    matchs.add(pakke);
                            }
                        }

                        listener.onSuccess(matchs.toArray(new PakkeTilbud[0]));
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e);
                    }
                });
    }
}
