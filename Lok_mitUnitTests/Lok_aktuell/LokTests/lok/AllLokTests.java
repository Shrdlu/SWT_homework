package lok;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestGueterwaggon.class, TestKippwaggon.class,
		TestKuehlwaggon.class, TestLokomotive.class, TestPersonenwaggon.class,
		TestViehwaggon.class, TestWaggon.class, TestZugSchmiede.class })
public class AllLokTests {

}
