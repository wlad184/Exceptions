public class Main {
    public static void main(String[] args) {
        String login = "sdek7_sp";
        String password = "SSD7asd_S8";
        String confirmPassword = "SSD7asd_S8";
        examination(login, password, confirmPassword);
        System.out.println("OK");
    }

    public static boolean examination(String login, String password, String confirmPassword) {

        try {
            if (login.length() > 20 || compare(login)) {
                throw new WrongLoginException();
            }
            if (password.length() > 19 || compare(password)) {
                throw new WrongPasswordException();
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }
            System.out.println("return true");
            return true;

        } catch (WrongLoginException ex) {
            System.out.println("Логин больше 20 символовю. Введите корректный логин");

        } catch (WrongPasswordException e) {
            System.out.println("Пароль больше 20 символовю. Введите корректный пароль");

        } finally {
            System.out.println("Проверка завершена");
        }

        System.out.println("return false;");
        return false;
    }

    public static boolean compare(String name) {
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = chars[i];
            if (!((j >= 48 && j <= 57) || (j >= 65 && j <= 90) || (j >= 97 && j <= 122) || j == 95)) {
                return true;
            }
        }
        return false;
    }
}