package com.garagesale.gapp.garagesale.network;

import com.garagesale.gapp.garagesale.fragment.JoinFragment;
import com.garagesale.gapp.garagesale.fragment.LoginFragment;
import com.garagesale.gapp.garagesale.fragment.MainFragment;
import com.garagesale.gapp.garagesale.fragment.PickCategoryFragment;
import com.garagesale.gapp.garagesale.fragment.PickPlanetFragment;
import com.garagesale.gapp.garagesale.fragment.PlanetListFragment;
import com.garagesale.gapp.garagesale.fragment.PractiveMainFragment;
import com.garagesale.gapp.garagesale.fragment.ProductFragment;
import com.garagesale.gapp.garagesale.fragment.ProfileFragment;
import com.garagesale.gapp.garagesale.fragment.SettingFragment;
import com.garagesale.gapp.garagesale.fragment.StoreFragment;
import com.garagesale.gapp.garagesale.fragment.TutorialFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gimbyeongjin on 2017. 6. 22..
 * 네트워크 모듈이 어느 프레그먼트에 주입될지 정의
 */
@Singleton
@Component(modules = {NetworkModule.class,})
public interface NetworkComponent {
    void inject(JoinFragment fragment);

    void inject(LoginFragment fragment);

    void inject(MainFragment fragment);

    void inject(ProfileFragment fragment);

    void inject(SettingFragment fragment);

    void inject(StoreFragment fragment);

    void inject(ProductFragment fragment);

    void inject(PlanetListFragment fragment);

    void inject(PractiveMainFragment fragment);

    void inject(PickCategoryFragment fragment);

    void inject(PickPlanetFragment fragment);

    void inject(TutorialFragment fragment);
}
