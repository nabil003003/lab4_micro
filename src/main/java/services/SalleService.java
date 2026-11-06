package services;

import dao.IDao;
import dao.SalleDao;
import entities.Salle;
import java.util.List;

public class SalleService implements IDao<Salle> {
    private final IDao<Salle> salleDao = new SalleDao();
    @Override public boolean create(Salle salle) { return salleDao.create(salle); }
    @Override public boolean delete(Salle salle) { return salleDao.delete(salle); }
    @Override public boolean update(Salle salle) { return salleDao.update(salle); }
    @Override public Salle getById(int id) { return salleDao.getById(id); }
    @Override public List<Salle> getAll() { return salleDao.getAll(); }
}
