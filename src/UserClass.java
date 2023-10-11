import dataStructures.*;
public class UserClass implements User{
    private int age;
    private String name;
    private String login;
    private String email;


    public UserClass(int age, String name, String login, String email) {
        this.age = age;
        this.name = name;
        this.login = login;
        this.email = email;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
