package com.example.accountsystem;

import com.example.accountsystem.models.User;
import com.example.accountsystem.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
//        User first = new User("Qna", 22);
//        userService.registerUser(first);
//
//        User second = new User("Mityo", 24);
//        userService.registerUser(second);

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            User user = new User(name, age);
            userService.registerUser(user);

            input = scan.nextLine();
        }
    }
}
