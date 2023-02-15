package com.chyngyz.quwitestapp.common.mvp;

public interface MvpPresenter<V extends MvpView> {

    void attach(V view);

    void detach();

}

