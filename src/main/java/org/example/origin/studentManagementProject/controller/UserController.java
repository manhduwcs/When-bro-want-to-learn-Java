package org.example.origin.studentManagementProject.controller;

import org.example.origin.studentManagementProject.model.User;
import org.example.origin.studentManagementProject.view.UserView;

public class UserController {
    private UserView userView;
    private User user;

    public UserController(UserView userView, User user) {
        this.userView = userView;
        this.user = user;
        stopUserShow();
        userView.showUserButton().addActionListener(e -> showUser());
        userView.stopUserShowingButton().addActionListener(e -> stopUserShow());
        userView.confirmEditButton().addActionListener(e -> confirmEditUser());
        userView.resetEditButton().addActionListener(e -> resetEditUser());
    }

    public void showUser() {
        userView.showName().setText(user.name());
        userView.showAge().setText(String.valueOf(user.age()));
    }

    public void stopUserShow() {
        userView.showName().setText("");
        userView.showAge().setText("");
    }

    public void confirmEditUser() {
        String newName = userView.editUserNameTextField().getText();
        if (!newName.isBlank()) {
            user.setName(newName);
            showUser();
        }
        String newAge = userView.editUserAgeTextField().getText();

        if (!newAge.isBlank() && newAge.matches("\\d+")) {
            user.setAge(Integer.parseInt(newAge));
            showUser();
        }
    }

    public void resetEditUser() {
        userView.editUserAgeTextField().setText("");
        userView.editUserNameTextField().setText("");
    }

    public UserView userView() {
        return userView;
    }

    public UserController setUserView(UserView userView) {
        this.userView = userView;
        return this;
    }

    public User userModel() {
        return user;
    }

    public UserController setUserModel(User user) {
        this.user = user;
        return this;
    }
}
