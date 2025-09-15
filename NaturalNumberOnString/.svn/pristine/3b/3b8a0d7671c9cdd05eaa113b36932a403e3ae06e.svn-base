import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    // TODO - add test cases for four constructors, multiplyBy10, divideBy10, isZero

    @Test
    public void constructorEmpty() {
        NaturalNumber ref = this.constructorRef();
        NaturalNumber test = this.constructorTest();

        assertEquals("This natural number should have been initialized as empty", ref,
                test);

    }

    @Test
    public void constructorIntArg() {
        int i = 4;
        NaturalNumber test = this.constructorTest(i);
        NaturalNumber ref = this.constructorRef(i);

        assertEquals("These natural numbers should be initialized correctly", test, ref);
    }

    @Test
    public void constructorNNArg() {
        NaturalNumber sampleNN = this.constructorRef(4);

        NaturalNumber test = this.constructorTest(sampleNN);
        NaturalNumber ref = this.constructorRef(sampleNN);

        assertEquals("This natural numbers should be intialized correctly", test, ref);
    }

    @Test
    public void constructorStringArg() {
        String sampleString = "4";
        NaturalNumber test = this.constructorTest(sampleString);
        NaturalNumber ref = this.constructorRef(sampleString);

        assertEquals("This natural numbers should be intialized correctly", test, ref);
    }

    @Test
    public void multipleBy10FromEmpty() {
        NaturalNumber test = this.constructorTest();
        NaturalNumber ref = this.constructorRef();

        test.multiplyBy10(9);
        ref.multiplyBy10(9);

        assertEquals("These natural numbers should be equal", ref, test);
    }

    @Test
    public void multiplyBy10FromExisting() {
        int preExist = 9;
        int toAdd = 9;
        NaturalNumber test = this.constructorTest(preExist);
        NaturalNumber ref = this.constructorRef(preExist);

        test.multiplyBy10(toAdd);
        ref.multiplyBy10(toAdd);

        assertEquals("These natural numbers should be equal", ref, test);

    }

    @Test
    public void multiplyBy10LeadingZero() {

        int toAdd = 0;
        NaturalNumber test = this.constructorTest();
        NaturalNumber ref = this.constructorRef();

        test.multiplyBy10(toAdd);
        ref.multiplyBy10(toAdd);

        assertEquals("These natural numbers should be equal", ref, test);
        assertEquals("The natural number should be empty", test.isZero(), true);

    }

    @Test
    public void divideBy10WithSingular() {
        NaturalNumber test = this.constructorTest();
        NaturalNumber ref = this.constructorRef();

        assertEquals("Remainder should be equal", ref.divideBy10(), test.divideBy10());
        assertEquals("Both NNs should be equal", ref, test);

    }

    @Test
    public void divideBy10WithMultiple() {
        NaturalNumber test = this.constructorTest(123);
        NaturalNumber ref = this.constructorRef(123);

        assertEquals("Remainder should be equal", ref.divideBy10(), test.divideBy10());
        assertEquals("Both NNs should be equal", ref, test);

        assertEquals("Remainder should be equal", ref.divideBy10(), test.divideBy10());
        assertEquals("Both NNs should be equal", ref, test);

    }

    @Test
    public void isZeroCheckTrue() {
        NaturalNumber test = this.constructorTest(123);
        NaturalNumber ref = this.constructorRef(123);

        assertEquals("Check if both ref and test have same outcome", test.isZero(),
                ref.isZero());
        assertEquals("Double check", test.isZero(), false);

    }

    @Test
    public void isZeroCheckFalse() {
        NaturalNumber test = this.constructorTest();
        NaturalNumber ref = this.constructorRef();

        assertEquals("Check if both ref and test have same outcome", test.isZero(),
                ref.isZero());
        assertEquals("Double check", test.isZero(), true);

    }

}
