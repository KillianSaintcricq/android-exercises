package fr.android.androidexercises;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    LoginActivity activityMock;

    @InjectMocks
    LoginPresenter loginPresenter;

    @Test
    public void testCheckCredentials() throws Exception {
        // Given

        // When
        loginPresenter.checkCredentials("password");
        // Then
        Mockito.verify(activityMock).logged();
        Mockito.verify(activityMock).message(R.string.text_logged);

    }

    @Test
    public void testCheckCredentials_pwd_null() {
        // When
        loginPresenter.checkCredentials(null);
        // Then
        Mockito.verify(activityMock).notLogged();
        Mockito.verify(activityMock).message(R.string.notLogged);
    }
}