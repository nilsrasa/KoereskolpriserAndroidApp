package dk.gruppe5.koerskolepriser.listeners;

import dk.gruppe5.koerskolepriser.objekter.TilbudTilBruger;

public interface OnBrugerTilbudListener {

    void onSuccess(TilbudTilBruger[] tilbudTilBruger);

    void onError(Throwable e);
}
