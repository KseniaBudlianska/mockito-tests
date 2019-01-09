public class AuthenticatorApplication {

    private AuthenticatorInterface authenticator;

    public AuthenticatorApplication(AuthenticatorInterface authenticator) {
        this.authenticator = authenticator;
    }

    public boolean authenticateUser(String username, String password) throws EmptyCredentialsException {
        boolean authenticated;

        authenticated = this.authenticator.authenticateUser(username, password);
        return authenticated;
    }
}
