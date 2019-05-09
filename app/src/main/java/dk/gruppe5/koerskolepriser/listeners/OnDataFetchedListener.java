package dk.gruppe5.koerskolepriser.listeners;

import dk.gruppe5.koerskolepriser.objekter.TilbudTilBruger;

public interface OnDataFetchedListener {

    void onSuccess(TilbudTilBruger[] tilbudTilBruger);

    void onError(Throwable e);
}
