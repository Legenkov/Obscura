package com.example.user.authmodule.auth_operation.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.authmodule.R;
import com.example.user.authmodule.common.IAuthListener;

/**
 * Created by User on 18.01.2018.
 */

public class SignUpFragment extends Fragment {

    private IAuthListener onAuthListener;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public SignUpFragment(IAuthListener onAuthListener){
        this.onAuthListener = onAuthListener;
    }

    public static SignUpFragment newInstance(IAuthListener onAuthListener) {
        SignUpFragment fragment = new SignUpFragment(onAuthListener);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.sign_up, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}