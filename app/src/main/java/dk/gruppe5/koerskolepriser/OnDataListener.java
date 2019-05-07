package dk.gruppe5.koerskolepriser;

import dk.gruppe5.koerskolepriser.objekter.PakkeTilbud;

public interface OnDataListener {

    void onSuccess(PakkeTilbud[] pakkeTilbud);

    void onError(Throwable e);
}
