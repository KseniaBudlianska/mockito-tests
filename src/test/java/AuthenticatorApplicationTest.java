import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AuthenticatorApplicationTest {

    @Test
    public void testAuthenticateFalse() throws EmptyCredentialsException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;
        String username = "JavaCodeGeeks";
        String password = "unsafePassword";

        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);

        verify(authenticatorMock, never()).authenticateUser(username, password);

        when(authenticatorMock.authenticateUser(username, password))
            .thenReturn(false);

        boolean actual = authenticator.authenticateUser(username, password);

        assertFalse(actual);
        verify(authenticatorMock, times(1)).authenticateUser(username, password);
    }

    @Test
    public void testAuthenticateTrue() throws EmptyCredentialsException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;
        String username = "javacodegeeks";
        String password = "save password397902u8";

        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);


        when(authenticatorMock.authenticateUser(username, password))
            .thenReturn(true);

        boolean actual = authenticator.authenticateUser(username, password);

        assertTrue(actual);
    }


    @Test (expected = EmptyCredentialsException.class)
    public void testAuthenticateEmptyCredentialsException() throws EmptyCredentialsException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;

        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);

        when(authenticatorMock.authenticateUser("", ""))
            .thenThrow(new EmptyCredentialsException());

        authenticator.authenticateUser("", "");
    }

}
