package kosa.ip;

import javax.management.MXBean;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by JF194405 on 26.06.2017.
 */
public class ServiceConnection {

    public IpParameteres ipParameteres;

    private static String resp = "";

    public String getResp() {
        return resp;
    }

    public ServiceConnection() {

    }

    public void sendGet(String ip) throws IOException, JAXBException {
        URL obj = new URL(getUrl(ip));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code: " + responseCode);
        if(responseCode == HttpURLConnection.HTTP_OK) {
            /*
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            resp = response.toString();
            System.out.println(response.toString());
            */
            InputStream in = con.getInputStream();
            JAXBContext jaxbContext = JAXBContext.newInstance(IpParameteres.class);
            //JAXBContext jaxbContext = JAXBContext
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            //ipParameteres = (IpParameteres) jaxbUnmarshaller.unmarshal(in);
            ipParameteres = (IpParameteres) jaxbUnmarshaller.unmarshal(in);
            //System.out.println(ipParameteres.getCountryName());



        } else {
            resp = "GET request not worked";
            System.out.println("GET request not worked");
        }
    }

    private static String getUrl(String ip) {
        return "http://www.webservicex.net/geoipservice.asmx/GetGeoIP?IPAddress=" + ip;
    }
}
