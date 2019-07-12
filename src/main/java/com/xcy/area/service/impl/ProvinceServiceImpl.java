package com.xcy.area.service.impl;

import com.xcy.area.mapper.ProvinceMapper;
import com.xcy.area.pojo.Province;
import com.xcy.area.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceMapper provinceMapper;

    @Override
    public List<Province> getProvince() {
        return provinceMapper.getProvince();
    }

    @Override
    public List<Province> getChildCity(int id) {
        return provinceMapper.getChildCity(id);
    }
}
