package com.blog.Service;

import com.blog.POJO.DO.EssayDO;

import java.util.ArrayList;
import java.util.List;

public interface BlogService {
   void  write(EssayDO essayDO);//写日志
    EssayDO read(Long id);//阅读日志
    List<EssayDO> getEssayList(String username);//获取日志列表
    void edit(EssayDO essayDO);//编辑日志
    void delete(Long id);//删除日志
}
