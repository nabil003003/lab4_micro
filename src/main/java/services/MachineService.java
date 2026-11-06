package services;

import dao.IDao;
import dao.MachineDao;
import entities.Machine;
import java.util.List;

public class MachineService implements IDao<Machine> {
    private final MachineDao machineDao = new MachineDao();
    @Override public boolean create(Machine machine) { return machineDao.create(machine); }
    @Override public boolean delete(Machine machine) { return machineDao.delete(machine); }
    @Override public boolean update(Machine machine) { return machineDao.update(machine); }
    @Override public Machine getById(int id) { return machineDao.getById(id); }
    @Override public List<Machine> getAll() { return machineDao.getAll(); }
    public List<Machine> findByMarque(String marque) { return machineDao.findByMarque(marque); }
}
