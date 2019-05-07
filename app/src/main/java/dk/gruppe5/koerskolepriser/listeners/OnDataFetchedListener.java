package dk.gruppe5.koerskolepriser.listeners;

import dk.gruppe5.koerskolepriser.objekter.PakkeTilbud;

public interface OnDataFetchedListener {

    void onSuccess(PakkeTilbud[] pakkeTilbud);

    void onError(Throwable e);
}
