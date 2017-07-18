import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Sin;
import org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.exception.ConvergenceException;

/**
 * 函数积分
 * Created by ZhangGuohua on 2017/7/18.
 */
public class IntegrationTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        integration();
    }

    private static void integration() {
        UnivariateFunction f = new Sin();
        BaseAbstractUnivariateIntegrator integrator = new SimpsonIntegrator();

        // integrate
        System.out.println("f(x)=sin(x)");
        try {
            System.out.println("integration of f(x) from 0 to Pi is "
                    + integrator.integrate(100,f, 0, Math.PI));
        } catch (ConvergenceException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
