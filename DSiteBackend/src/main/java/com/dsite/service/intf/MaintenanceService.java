package com.dsite.service.intf;

import java.io.Serializable;
import java.util.List;

public interface MaintenanceService<F, R, M, N, ID extends Serializable> {

    List<R> search(F filterViewModel);
    M findOne(ID id);
    N create(M manteinanceViewModel);
    N update(M manteinanceViewModel);
    N delete(ID id);
}
