public interface Repository<T, ID> {
    void save(T entity);
    T findById(ID id);
}

class UserRepository implements Repository<User, Long> {
    @Override
    public void save(User entity) {}

    @Override
    public User findById(Long id) { 
        return new User(); 
    }
}

class User {}