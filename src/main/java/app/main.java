/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import dto.CompanyaAerea;
import java.util.List;
import logica.Logica;
import ui.Principal;

/**
 *
 * @author laura
 */
public class main {
    private static Principal pInstance; 

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
     Inicializaciones.getInstance();//esto en teoria inicia los hasmap y los lectores
      if (pInstance == null) {
            // Si no hay, crea una nueva instancia y la guarda
            pInstance = new Principal();
        }

        // Hace visible la instancia actual
        pInstance.setVisible(true);  
        
   /*  CompanyaAerea c1 = new CompanyaAerea(75,
    "IB",
    "iberia Lineas Aereas de España",
    "C/Marques s/n",
            "29079",
        //
            "91-345-32-11",
            "900-100-192"
    );
    
    Logica.addCompanyaAerea(c1);
    List<CompanyaAerea> lista2 = Logica.getAllCompanyas();
    
    CompanyaAerea c2 = new CompanyaAerea
        (75,
    "IB",
    "iberia Express",
    "C/Marques s/n",
            "28079",
            "91-345-32-11",
            "900-100-192"
    );
    Logica.addCompanyaAerea(c2);
    //LogicaNegocio.addVueloBase(new VueloBase("IB123",3,new Date(),new Date(),new Date(), "LNV",LogicaNegocio.aeropuertoBase.getCodigoIATA(), "ABC"));
    List<CompanyaAerea> lista = Logica.getAllCompanyas();*/
    }
}
