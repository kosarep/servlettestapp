package kosa.ip;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by JF194405 on 26.06.2017.
 */

@XmlRootElement(name = "GeoIP", namespace = "http://www.webservicex.net/")
public class IpParameteres {
    private String reqIpAddress;
    private int returnCode;
    private String respIpAddress;
    private String returnCodeDetails;
    private String countryName;
    private String countryCode;

    public String getReqIpAddress() {
        return reqIpAddress;
    }

    public void setReqIpAddress(String reqIpAddress) {
        this.reqIpAddress = reqIpAddress;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getRespIpAddress() {
        return respIpAddress;
    }

    public void setRespIpAddress(String respIpAddress) {
        this.respIpAddress = respIpAddress;
    }

    public String getReturnCodeDetails() {
        return returnCodeDetails;
    }

    public void setReturnCodeDetails(String returnCodeDetails) {
        this.returnCodeDetails = returnCodeDetails;
    }

    public String getCountryName() {
        return countryName;
    }

    @XmlElement(name = "CountryName", namespace = "http://www.webservicex.net/")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
