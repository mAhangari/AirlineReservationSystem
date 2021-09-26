package ir.airline.service.impl;

import ir.airline.domain.User;
import ir.airline.repository.BaseUserRepository;
import ir.airline.service.BaseUserService;
import ir.baseCRUD.base.service.impl.BaseEntityServiceImpl;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class BaseUserServiceImpl<E extends User, UT, PT>
        extends BaseEntityServiceImpl<E, Long, BaseUserRepository<E, UT, PT>>
        implements BaseUserService<E, UT, PT> {

    public BaseUserServiceImpl(BaseUserRepository<E, UT, PT> repository) {
        super(repository);
    }

    @Override
    public Boolean existsByUsername(UT username) {
        EntityManager em = repository.getEntityManager();
        try {
            return repository.existsByUsername(username);
        } catch (NoResultException e) {
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public E findUserByUsername(UT username) {
        EntityManager em = repository.getEntityManager();
        try {
            return repository.findUserByUsername(username);
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Boolean existsByUsernameAndPassword(UT username, PT password) {
        EntityManager em = repository.getEntityManager();
        try {
            return repository.existsByUsernameAndPassword(username, password);
        } catch (NoResultException e) {
            return false;
        } finally {
            em.close();
        }
    }

}
