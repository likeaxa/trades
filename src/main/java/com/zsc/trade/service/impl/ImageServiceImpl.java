package com.zsc.trade.service.impl;


import com.zsc.trade.bean.Image;
import com.zsc.trade.mapper.ImageMapper;
import com.zsc.trade.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageMapper imageMapper;

    @Override
    public Image getImage(Integer id) {
        return imageMapper.getImage(id);
    }

    @Override
    public List<Image> getImageByPid(Integer pid) {
        return imageMapper.getImageByPid(pid);
    }

    @Override
    public int insert(Image image) {
        return imageMapper.insert(image);
    }

    @Override
    public void update(Image image) {
        imageMapper.update(image);
    }

    @Override
    public void delete(Integer id) {
        imageMapper.delete(id);
    }
}
