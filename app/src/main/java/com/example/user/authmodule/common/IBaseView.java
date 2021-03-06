package com.example.user.authmodule.common;

/**
 * Created by User on 1/20/2018.
 */

public interface IBaseView {
    void showMessage(String s);
    void showError(String s);
    void showProgressBar();
    void hideProgressBar();


    interface IAuthView extends IBaseView {
        void openMain(String token);
    }
    interface IMainView extends IBaseView {
        void doneLogout(String token, int type);
        void closeMain();
    }

    interface ISplashView extends IBaseView {
        void checkUserData(boolean is);
    }
    interface IDetailView extends IBaseView{
    }

 /* Сделать интерфейс отдельным классом *
    IMainPresenter {
        doLogout(Token, Type);
    }
 /*                                     */
  /*
    Создать MainPresenterImpl() implements IPresenterContract.IMainPresenter {
        Добавить dissmis() и init()
    }
    В новой MainActivity добавить 3 инконки и сделать по ним logout.
    */
}
