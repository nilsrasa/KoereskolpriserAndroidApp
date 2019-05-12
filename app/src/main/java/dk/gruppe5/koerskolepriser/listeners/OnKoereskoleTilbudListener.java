package dk.gruppe5.koerskolepriser.listeners;

import dk.gruppe5.koerskolepriser.objekter.Tilbud;

public interface OnKoereskoleTilbudListener {
    void onSuccess(Tilbud[] tilbuds);
    void onError(Throwable e);
}
