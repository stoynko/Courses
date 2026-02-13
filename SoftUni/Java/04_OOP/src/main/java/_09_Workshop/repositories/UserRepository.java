package _09_Workshop.repositories;

import _09_Workshop.entities.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserRepository implements Repository<User, UUID> {

    private Map<UUID, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    @Override
    public void save(UUID id, User user) {
        this.users.put(id, user);
    }

    @Override
    public User getById(UUID id) {
        return this.users.get(id);
    }

    @Override
    public List<User> getAll() {
        return this.users.values().stream().toList();
    }
}
