package degea9.movies.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DomainTest {
    @Before
    public void setUp(){
    }

    @Test
    public void test1() {
        String test = Domain.test();
        assertEquals("Domain2",test);
    }

}
