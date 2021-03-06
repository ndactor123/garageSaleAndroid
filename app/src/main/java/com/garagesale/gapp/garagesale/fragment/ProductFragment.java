package com.garagesale.gapp.garagesale.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.garagesale.gapp.garagesale.BaseFragment;
import com.garagesale.gapp.garagesale.R;
import com.garagesale.gapp.garagesale.databinding.FragmentProductBinding;
import com.garagesale.gapp.garagesale.response.ProductResponse;
import com.garagesale.gapp.garagesale.service.ProductService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductFragment extends BaseFragment {

    // 싱글톤 패턴
    @SuppressLint("StaticFieldLeak")
    private static ProductFragment mInstance;
    public static ProductFragment getInstance(){
        if(mInstance == null) mInstance = new ProductFragment();
        return mInstance;
    }


    private FragmentProductBinding binding;
    @Inject
    public Retrofit retrofit;  // retrofit

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding = FragmentProductBinding.bind(getView());   // bind view
        binding.setProductFragment(this);   // set fragment xml
        getNetworkComponent().inject(this); // retrofit 객체 주입

    }

    public void onCreateButtonClick(View view){
        if(binding.nameEditText.getText().toString().equals("")) {
            if(getActivity() != null) Toast.makeText(getActivity(), "Name 입력하시오", Toast.LENGTH_SHORT).show();
            return;
        } else if(binding.priceEditText.getText().toString().equals("")) {
            if(getActivity() != null) Toast.makeText(getActivity(), "Price 입력하시오", Toast.LENGTH_SHORT).show();
            return;
        }

        retrofit.create(ProductService.class).createProduct(

                binding.nameEditText.getText().toString(),
                binding.descriptionEditText.getText().toString(),
                Integer.parseInt(binding.priceEditText.getText().toString())

        ).enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                // Error Handle
                if(!response.isSuccessful()){
                    if(getActivity() != null) Toast.makeText(getActivity(), response.message(),Toast.LENGTH_SHORT).show();
                    return;
                }

                if(getActivity() != null) Toast.makeText(getActivity(), "물건 생성 성공, 물건 이름 : " + response.body().getProduct().getName(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public String getTitle() {
        return "Product";
    }

}
