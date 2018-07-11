package org.login.com.flagapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.login.com.flagapp.ICallback;
import org.login.com.flagapp.R;
import org.login.com.flagapp.adapter.MyAdapter;
import org.login.com.flagapp.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryListFragment extends Fragment implements MyAdapter.OnItemClick {

    List<Country> countries = new ArrayList<>();
    RecyclerView mRvCountryList;
    static ICallback mICallback;

    @SuppressLint("ValidFragment")
    private CountryListFragment()
    {

    }

    public  static  CountryListFragment newInstant(ICallback iCallback)
    {
        mICallback = iCallback;
        return  new CountryListFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_country_details, viewGroup, false);
        countries.clear();
        countries.add(new Country("Bangladesh","16 crore"));
        countries.add(new Country("India","32 crore"));
        countries.add(new Country("Pakistan","17 crore"));
        countries.add(new Country("Sri Lanka","0.56 crore"));
        countries.add(new Country("Nepal","1.56 crore"));
        countries.add(new Country("Bhutan","0.60 crore"));
        init(view);
        return view;


    }

    private void init(View view) {
        mRvCountryList = view.findViewById(R.id.rv_country_list);
        mRvCountryList.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvCountryList.setAdapter(new MyAdapter(countries, CountryListFragment.this));
    }

    @Override
    public void onItemClick(Country country) {
        mICallback.replaceCountryDetailsFragment(country);
          }
}
