package br.usjt.deswebmob.aula3_navigation.view;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.usjt.deswebmob.aula3_navigation.R;

/**
 * @author Lucas Nagaoka | RA: 81513916
 * CCP3AN-MCA
 */

public class DetalhePaisFragment extends Fragment {


    public DetalhePaisFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detalhe_pais, container, false);
    }

}
