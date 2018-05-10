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
 * Created by User on 08.05.2018.
 */

public class RecoverFragment extends Fragment {

    private IAuthListener listener;

    public RecoverFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public RecoverFragment(IAuthListener listener){
        this.listener = listener;
    }

    public static RecoverFragment newInstance(IAuthListener listener) {
        RecoverFragment fragment = new RecoverFragment(listener);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recover, container, false);
        return v;
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