package org.login.com.flagapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.login.com.flagapp.fragment.CountryDetailsFragment;
import org.login.com.flagapp.fragment.CountryListFragment;
import org.login.com.flagapp.model.Country;

public class MainActivity extends AppCompatActivity implements ICallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment(CountryListFragment.newInstant(this));
    }


    public  void initFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
    }

    @Override
    public void replaceCountryListFragment() {
        initFragment(CountryListFragment.newInstant(this));
    }

    @Override
    public void replaceCountryDetailsFragment(Country country) {
        initFragment(CountryDetailsFragment.newInstant(country));
    }
}
