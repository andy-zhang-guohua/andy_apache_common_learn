import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.MathArithmeticException;

/**
 * Created by ZhangGuohua on 2017/7/18.
 */
public class InterpolationTest {
    public static void main(String[] args) {
        polynomialsInterpolation();
        System.out.println("-------------------------------------------");
        interpolation();
    }

    private static void interpolation() {
        // double x[] = { 0.0, 0.5, 1.0 };
        // double y[] = { 0.0, 0.5, 1.0 };
        double x[] = {0.0, Math.PI / 6d, Math.PI / 2d, 5d * Math.PI / 6d,
                Math.PI, 7d * Math.PI / 6d, 3d * Math.PI / 2d,
                11d * Math.PI / 6d, 2.d * Math.PI};
        double y[] = {0d, 0.5d, 1d, 0.5d, 0d, -0.5d, -1d, -0.5d, 0d};
        UnivariateInterpolator i = new SplineInterpolator();
        UnivariateFunction f = null;
        // interpolate y when x = 0.5
        try {
            f = i.interpolate(x, y);
            System.out.println("when x = 0.5, y = " + f.value(0.5));
        } catch (MathArithmeticException e) {
            e.printStackTrace();
        }

        // check polynomials functions
        PolynomialFunction polynomials[] = ((PolynomialSplineFunction) f)
                .getPolynomials();
        for (int j = 0; j < polynomials.length; j++) {
            System.out
                    .println("cubic spline:f" + j + "(x) = " + polynomials[j]);
        }
    }

    private static void polynomialsInterpolation() {
        double x[] = {0.0, -1.0, 0.5};
        double y[] = {-3.0, -6.0, 0.0};
        PolynomialFunctionLagrangeForm p = new PolynomialFunctionLagrangeForm(
                x, y);
        // output directly
        System.out.println("ugly output is " + p);
        // interpolate y when x = 1.0
        try {
            System.out.println("when x = 1.0, y = " + p.value(1.0));
        } catch (MathArithmeticException e) {
            e.printStackTrace();
        }
        // degree
        System.out.println("polynomial degree is " + p.degree());
        // coefficients
        for (int i = 0; i < p.getCoefficients().length; i++) {
            System.out.println("coeff[" + i + "] is " + p.getCoefficients()[i]);
        }
        //
    }
}
