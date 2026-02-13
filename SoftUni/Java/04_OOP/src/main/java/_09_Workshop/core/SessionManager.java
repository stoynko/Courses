package _09_Workshop.core;

public interface SessionManager<T> {
    T getActiveSession();
    void setActiveSession(T user);
    boolean hasActiveSession();
    void terminateActiveSession();
}
