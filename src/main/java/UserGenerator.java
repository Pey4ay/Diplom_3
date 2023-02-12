import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static final String name = "Dima";
    public static final String email = "dima-test@yandex.ru";
    public static final String password = "123456";
    public static final String incorrectName = "Dima2";
    public static final String incorrectEmail = "dima2-test@yandex.ru";
    public static final String incorrectPassword = "12345";

    public static final String nameRandom = RandomStringUtils.randomAlphabetic(4);
    public static final String emailRandom = RandomStringUtils.randomAlphanumeric(10) + "@mail.com";
    public static final String passwordRandom = RandomStringUtils.randomAlphabetic(6);
}
