package com.dsite.jpa;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dsite.domain.model.base.BaseEntity;
import com.dsite.service.intf.DateTimeRetriever;
import com.dsite.support.LogContext;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/***
 * Clase interceptor para grabar los campos de auditoria
 * @author bonfe
 *
 */
@Component
public class DsiteEntityInterceptorImpl extends EmptyInterceptor implements DsiteEntityInterceptor {
    @Autowired
    DateTimeRetriever dateTimeRetriever;


    /***
     * Se ejecuta al guardar una entidad
     */
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

        if (entity instanceof BaseEntity) {

            for (int i = 0; i < propertyNames.length; i++) {
                String propertyName = propertyNames[i];

                if (propertyName.equals("usuarioCreacion")) {
                    state[i] = LogContext.getUserIdSafe();
                } else if (propertyName.equals("fechaCreacion")) {
                    state[i] = currentTime();
                }
            }
        }
        return true; //super.onSave(entity, id, state, propertyNames, types);
    }

    private Date currentTime() {
        if (dateTimeRetriever == null) return new Timestamp(System.currentTimeMillis());
        Date date = dateTimeRetriever.currentTime();
        return date;
    }

	/***
	 * Se ejecuta al actualizar una entidad
	 */
    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        if (entity instanceof BaseEntity) {


            for (int i = 0; i < propertyNames.length; i++) {
                String propertyName = propertyNames[i];

                if (propertyName.equals("actualizador")) {
                    currentState[i] = LogContext.getUserIdSafe();
                } else if (propertyName.equals("fechaActualizacion")) {
                    currentState[i] = currentTime();
                }
            }

        }


        return true;
    }
}