package org.login.com.flagapp;

import org.login.com.flagapp.model.Country;

public interface ICallback {
    void replaceCountryListFragment();
    void replaceCountryDetailsFragment(Country country);

}
