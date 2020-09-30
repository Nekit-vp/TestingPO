package test;

import SignIN.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("Initial setup...");
        System.out.println("Code executes only once");
        User.addAllUsers();
    }

    @Test
    public void checkCorrectLogin() {
        boolean isSignIN = User.check("admin", "123456");
        assertTrue(isSignIN);
    }

    @Test
    public void checkInCorrectLogin() {
        boolean isSignIN = User.check("a", "123456");
        assertFalse(isSignIN);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tests finished");
    }


}