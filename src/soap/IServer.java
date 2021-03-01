package soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IServer {

    @WebMethod
    public Result solve(double x, double secondArg);
}
