package chainOfResponsability;
public class Request implements RequestInterface{
    String requestTypeString;
    public Request(RequestType requestType) {
        this.requestTypeString = requestType.name();
    }
    @Override
    public String getType() {
        return requestTypeString;
    }
}
