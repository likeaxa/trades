package com.zsc.trade.service;

import com.zsc.trade.bean.Image;

import java.util.List;

public interface ImageService {

    Image getImage(Integer id);

    List<Image> getImageByPid(Integer pid);

    int insert(Image image);

    void update(Image image);

    void delete(Integer id);
}
