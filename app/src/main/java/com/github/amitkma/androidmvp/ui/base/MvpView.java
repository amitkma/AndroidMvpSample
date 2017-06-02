package com.github.amitkma.androidmvp.ui.base;

/**
 * Created by amit on 1/6/17.
 */

public interface MvpView<T extends MvpPresenter> {

    void setPresenter(T presenter);

    void showProgress();

    void hideProgress();

}
