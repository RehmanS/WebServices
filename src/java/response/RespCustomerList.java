package response;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RespCustomerList {

    private List<RespCustomer> respCustomerList;
    private RespStatus status;

    public List<RespCustomer> getRespCustomerList() {
        return respCustomerList;
    }

    public void setRespCustomerList(List<RespCustomer> respCustomerList) {
        this.respCustomerList = respCustomerList;
    }

    public RespStatus getStatus() {
        return status;
    }

    public void setStatus(RespStatus status) {
        this.status = status;
    }

}
