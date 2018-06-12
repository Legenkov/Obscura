package com.example.user.authmodule.presenters;

import com.example.user.authmodule.common.IBaseView;
import com.example.user.authmodule.interactors.IBaseInteractor;

/**
 * Created by User on 22.05.2018.
 */

public class DetailPresenterImpl extends BasePresenter<IBaseView.IDetailView, IBaseInteractor.IInteractor> implements IPresenterContract.IDetailPresenter {
    @Override
    public void doUploadUserImage() {

    }

    @Override
    public void doGetCountriesList(Integer limit, Integer offset) {

    }

    @Override
    public void doGetStatesList(Integer country_id, Integer limit, Integer offset) {

    }

    @Override
    public void doGetCitiesList(Integer state_id, Integer limit, Integer offset) {

    }
}
