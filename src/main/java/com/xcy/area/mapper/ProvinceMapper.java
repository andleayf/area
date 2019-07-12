package com.xcy.area.mapper;

import com.xcy.area.pojo.Province;

import java.util.List;

public interface ProvinceMapper {
    List<Province> getProvince();

    List<Province> getChildCity(int id);
}
