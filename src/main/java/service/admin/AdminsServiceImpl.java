package service.admin;

import Base.Service.BaseServiceImpl;
import model.Admins;
import repository.admin.AdminsRepository;

public class AdminsServiceImpl extends BaseServiceImpl<String, Admins, AdminsRepository> implements AdminsService{
    public AdminsServiceImpl(AdminsRepository repository) {
        super(repository);
    }
}
