package dk.gruppe5.koerskolepriser.listeners;

import dk.gruppe5.koerskolepriser.objekter.PakkeTilbud;

public interface OnDataSentListener {

    void onSuccess(PakkeTilbud[] pakkeTilbud);

    void onError(Throwable e);
}
