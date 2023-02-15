package com.chyngyz.quwitestapp.common.mvp;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    @Nullable
    protected V view;

    @CallSuper
    @Override
    public void attach(V view) {
        this.view = view;
    }

    @CallSuper
    @Override
    public void detach() {
        view = null;
    }
}

