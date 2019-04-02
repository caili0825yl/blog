package com.blog.Service;

import com.blog.POJO.DO.EssayDO;

import java.util.ArrayList;
import java.util.List;

public interface BlogService {
   void  write(EssayDO essayDO);
    EssayDO read(Long id);
    List<EssayDO> getEssayList(String username);
    void edit(EssayDO essayDO);
    void delete(Long id);
}
