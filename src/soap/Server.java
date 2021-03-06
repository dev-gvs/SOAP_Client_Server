package soap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = Style.RPC)
public class Server implements IServer {

    @Override
    public Result solve(double x, double secondArg) {
        double y;
        try {
            System.out.println("Got (" + x + ", " + secondArg + ")");
            if (x <= 4) {
                double a = secondArg;
                y = ((a * a) / (x * x)) + (6 * x);
            } else {
                double b = secondArg;
                y = (b * b) * ((4 + x) * (4 + x));  
            }
            if ((Double.isNaN(y)) || Double.isInfinite(y)) {
                return null;
            } else {
                Result res = new Result();
                res.setY(y);
                return res;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String... args) throws MalformedURLException, IOException, InterruptedException {
        System.out.println("Starting server...");

        URL url = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String ip = in.readLine();

        //System.setProperty("jetty.host", "0.0.0.0");
        Endpoint ep = Endpoint.create(new Server());
        ep.publish("http://" + "0.0.0.0" + ":1099/soap");

        System.out.println("Started server at http://" + ip + ":1099/soap");

        while (true) {
            Thread.sleep(100);
        }
    }

}
