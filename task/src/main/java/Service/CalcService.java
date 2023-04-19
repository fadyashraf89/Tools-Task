import java.util.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.*;
import javax.ws.*;

import Calculation.Calculation;
import Data.CalculationList;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/")
public class CalcService {
    @Inject
    private CalculationList L;

    public CalcService() {
    }

    @Path("calc")
    @POST
    public Result calculate(Calculation calculation) {
        int result;
        switch (calculation.getOpern()) {
            case "+":
                result = calculation.getFirstNum() + calculation.getSecondNumber();
                break;
            case "-":
                result = calculation.getFirstNum() - calculation.getSecondNumber();
                break;
            case "*":
                result = calculation.getFirstNum() * calculation.getSecondNumber();
                break;
            case "/": {
                if (calculation.getSecondNum() == 0)
                    throw new IllegalArgumentException("Can't divide by zero");
                result = calculation.getFirstNum() / calculation.getSecondNumber();
                break;
            }
            default:
                throw new IllegalArgumentException("Unsupported operation");
        }
        L.insert(calculation);
        return new Result(result);
    }

    @Path("calculations")
    @GET
    public List<Calculation> getAllCalculations() {
        return L.selectAll();
    }

    @Path("/")
    @GET
    public String getHealth() {
        return "Up and running";
    }
}