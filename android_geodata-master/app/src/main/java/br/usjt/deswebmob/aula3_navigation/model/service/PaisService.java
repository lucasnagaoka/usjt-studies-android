package br.usjt.deswebmob.aula3_navigation.model.service;

import java.io.IOException;

import br.usjt.deswebmob.aula3_navigation.model.dao.PaisDAO;
import br.usjt.deswebmob.aula3_navigation.model.dao.PaisDAOFactory;
import br.usjt.deswebmob.aula3_navigation.model.entity.Pais;

/**
 * @author Lucas Nagaoka | RA: 81513916
 * CCP3AN-MCA
 */
public class PaisService {
    PaisDAO dao;

    public PaisService(boolean onLine) {
        dao = PaisDAOFactory.getPaisDAO(onLine);
    }

    public Pais[] buscarPaises(String url, String regiao) throws IOException {
        return dao.buscarPaises(url, regiao);
    }
}
