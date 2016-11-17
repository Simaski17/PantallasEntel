package com.rinno.simaski.pantallasentel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class HuaweiMateOchoDosFragment extends Fragment {


    @BindView(R.id.mate8)
    ImageView mate8;
    @BindView(R.id.mate88)
    ImageView mate88;

    public HuaweiMateOchoDosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_huawei_mate_ocho_dos, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

}
