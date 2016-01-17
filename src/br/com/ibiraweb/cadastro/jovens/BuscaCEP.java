package br.com.ibiraweb.cadastro.jovens;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class BuscaCEP {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("getEndereco = "+new BuscaCEP().getEndereco("04455-180"));
		System.out.println("getBairro = "+new BuscaCEP().getBairro("04455-180"));
		System.out.println("getCidade = "+new BuscaCEP().getCidade("04455-180"));
		System.out.println("getUF = "+new BuscaCEP().getUF("04455-180"));
		System.out.println("getLatLong = "+new BuscaCEP().getLatLong("04455-180"));
		
		
	}

    public String getEndereco(String CEP) throws IOException {

        //***************************************************
        try{

        Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/"+CEP)
                  .timeout(120000)
                  .get();
        Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
        for (Element urlEndereco : urlPesquisa) {
                return urlEndereco.text();
        }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return CEP;
    }

    public String getBairro(String CEP) throws IOException {

        //***************************************************
        try{

        Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/"+CEP)
                  .timeout(120000)
                  .get();
        Elements urlPesquisa = doc.select("td:gt(1)");
        for (Element urlBairro : urlPesquisa) {
                return urlBairro.text();
        }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return CEP;
    }

    public String getCidade(String CEP) throws IOException {

        //***************************************************
        try{

        Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/"+CEP)
                  .timeout(120000)
                  .get();
        Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
        for (Element urlCidade : urlPesquisa) {
                return urlCidade.text();
        }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return CEP;
    }

    public String getUF(String CEP) throws IOException {

        //***************************************************
        try{

        Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/"+CEP)
                  .timeout(120000)
                  .get();
        Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
        for (Element urlUF : urlPesquisa) {
                return urlUF.text();
        }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return CEP;
    }
    
    public String getLatLong(String CEP) throws IOException {

        // ***************************************************
        try {

            if (CEP.contains("-")) {
                Document doc = Jsoup
                        .connect(
                                "http://maps.googleapis.com/maps/api/geocode/xml?address="
                                        + CEP + "&language=pt-BR&sensor=true")
                        .timeout(120000).get();
                Elements lat = doc.select("geometry").select("location")
                        .select("lat");
                Elements lng = doc.select("geometry").select("location")
                        .select("lng");
                for (Element Latitude : lat) {
                    for (Element Longitude : lng) {
                        return Latitude.text() + "," + Longitude.text();
                    }

                }
            } else {

                StringBuilder cepHif = new StringBuilder(CEP);  
                cepHif.insert(CEP.length() - 3, '-');

                Document doc = Jsoup
                        .connect(
                                "http://maps.googleapis.com/maps/api/geocode/xml?address="
                                        + cepHif + "&language=pt-BR&sensor=true")
                        .timeout(120000).get();
                Elements lat = doc.select("geometry").select("location")
                        .select("lat");
                Elements lng = doc.select("geometry").select("location")
                        .select("lng");
                for (Element Latitude : lat) {
                    for (Element Longitude : lng) {
                        return Latitude.text() + "," + Longitude.text();
                    }

                }
            }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return CEP;
    }
    
}