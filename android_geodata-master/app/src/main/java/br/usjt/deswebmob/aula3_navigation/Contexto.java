package br.usjt.deswebmob.aula3_navigation;

import android.content.Context;

/**
 * @author Lucas Nagaoka | RA: 81513916
 */

public class Contexto {
    private static Context contexto;

    public static Context getValue() {
        return contexto;
    }

    public static void setValue(Context c) {
        contexto = c;
    }
}
