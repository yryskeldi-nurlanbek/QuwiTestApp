package com.chyngyz.quwitestapp.common.mvp;

import androidx.annotation.CallSuper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    protected V view;
    protected CompositeDisposable disposable = new CompositeDisposable();

    protected void unsubscribeOnDestroy(Disposable d) {
        this.disposable.add(d);
    }

    @CallSuper
    @Override
    public void attach(V view) {
        this.view = view;
    }

    @CallSuper
    @Override
    public void detach() {
        view = null;
        disposable.clear();
    }
}