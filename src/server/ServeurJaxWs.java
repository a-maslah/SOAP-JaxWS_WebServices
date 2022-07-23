package server;

import ws.BanqueService;

import javax.xml.ws.Endpoint;

public class ServeurJaxWs {
    public static void main(String[] args) {
        String url="http://0.0.0.0:8585/";
        Endpoint.publish(url,new BanqueService());
        System.out.println("Webservices deploye sur l'adresse:"+url);
    }
}
