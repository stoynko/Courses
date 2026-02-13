package _09_Workshop.core;

import _09_Workshop.entities.user.User;

public class UserSessionManager implements SessionManager<User> {

    private User currentActiveUser;

    public UserSessionManager() {
        this.currentActiveUser = null;
    }

    @Override
    public User getActiveSession() {
        return this.currentActiveUser;
    }

    @Override
    public void setActiveSession(User user) {
        this.currentActiveUser = user;
    }

    @Override
    public boolean hasActiveSession() {
        return this.currentActiveUser != null;
    }

    @Override
    public void terminateActiveSession() {
        this.currentActiveUser = null;
    }
}
