package god.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath*:egovframework/spring/com/**/context-*.xml")
@ActiveProfiles({ "mysql", "dummy" })
public abstract class GodTestAbstract {

	protected Logger egovLogger = LoggerFactory.getLogger(GodTestAbstract.class);

	public abstract void test();

}
