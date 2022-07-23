package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//POJO : plain old java Object
@WebService(serviceName = "BanqueWS")
public class BanqueService {

    @WebMethod(operationName = "ConversionEuroToDH")
    public double conversion(@WebParam(name = "montant") double mt){
        return mt*11.3;
    }
    @WebMethod
    public Compte getCompte(@WebParam(name = "code") Long code){
        return new Compte(code,Math.random()*80000,new Date(),true);
    }
    @WebMethod
    public List<Compte> listeComptes(){
        List<Compte> comptes = new ArrayList<>();
        comptes.add(new Compte(1L,Math.random()*80000,new Date(),true));
        comptes.add(new Compte(2L,Math.random()*80000,new Date(),true));
        comptes.add(new Compte(3L,Math.random()*80000,new Date(),true));

        return comptes;
    }
}
