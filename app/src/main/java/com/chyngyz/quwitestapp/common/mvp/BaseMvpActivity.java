package com.chyngyz.quwitestapp.common.mvp;

import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


abstract class BaseMvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends
        AppCompatActivity implements MvpView {

    protected P presenter;

    abstract P setPresenter(P presenter);
    
    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.attach((V) this);
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
