package com.blog.Service.Imp;

import com.blog.Dao.EssayDOMapper;
import com.blog.POJO.DO.EssayDO;
import com.blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImp implements BlogService {
    @Autowired(required = false)
    private EssayDOMapper essayDOMapper;

    @Override
    public void write(EssayDO essayDO) {
        essayDOMapper.insert(essayDO);
    }

    @Override
    public EssayDO read(Long id) {
       EssayDO essayDO=essayDOMapper.selectByPrimaryKey(id);
       return essayDO;
    }

    @Override
    public List<EssayDO> getEssayList(String username) {
        List<EssayDO> essayList=essayDOMapper.selectByUsername(username);
        return essayList;
    }

    @Override
    public void edit(EssayDO essayDO) {
        essayDOMapper.updateById(essayDO);
        return;
    }

    @Override
    public void delete(Long id) {
        essayDOMapper.deleteByPrimaryKey(id);
        return;
    }
}
