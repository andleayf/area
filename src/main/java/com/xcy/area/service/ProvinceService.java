package com.xcy.area.service;

import com.xcy.area.pojo.Province;

import java.util.List;

public interface ProvinceService {

    List<Province> getProvince();

    List<Province> getChildCity(int id);
}
