package com.dsite.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.dsite.service.intf.DateTimeRetriever;

/**
 * Created by josediaz on 28/10/2016.
 */
@Service
public class DateTimeRetrieverImpl implements DateTimeRetriever {

    @Override
    public Date currentTime() {
        return new Timestamp(System.currentTimeMillis()); //TODO JCM implement ofr time sync betwen servers
    }
}
