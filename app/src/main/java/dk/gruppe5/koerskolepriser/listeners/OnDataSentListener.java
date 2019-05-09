package dk.gruppe5.koerskolepriser.listeners;

public interface OnDataSentListener {

    void onSuccess(String[] strings);

    void onError(Throwable e);
}
