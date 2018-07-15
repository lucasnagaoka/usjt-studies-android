package br.usjt.deswebmob.aula3_navigation.model.dao;

import java.io.IOException;

import br.usjt.deswebmob.aula3_navigation.model.entity.Pais;
import br.usjt.deswebmob.aula3_navigation.model.entity.Regiao;

/**
 * @author Lucas Nagaoka | RA: 81513916
 * CCP3AN-MCA
 */
public interface PaisDAO {
    Pais[] buscarPaises(String url, String regiao) throws IOException;
}
