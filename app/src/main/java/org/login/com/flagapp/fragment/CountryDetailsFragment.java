package org.login.com.flagapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.login.com.flagapp.ICallback;
import org.login.com.flagapp.R;
import org.login.com.flagapp.model.Country;

public class CountryDetailsFragment extends Fragment {


    static Country mCountry;

    TextView mTvCountryName;
    TextView mTvCountryPopulation;

    @SuppressLint("ValidFragment")
    private CountryDetailsFragment()
    {

    }
    public  static  CountryDetailsFragment newInstant(Country country)
    {
        mCountry = country;
        return  new CountryDetailsFragment();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_details, viewGroup, false);
        init(view);
        return view;


    }

    private void init(View view)
    {
        mTvCountryName = view.findViewById(R.id.tv_name);
        mTvCountryPopulation = view.findViewById(R.id.tv_population);

        mTvCountryName.setText(mCountry.getName());
        mTvCountryPopulation.setText(mCountry.getPopulation());
    }
}
