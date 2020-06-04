package com.matigou.ucenter.service.impl;

import com.matigou.ucenter.domain.MtgUser;
import com.matigou.ucenter.dao.MtgUserDao;
import com.matigou.ucenter.service.MtgUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MtgUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-04 12:54:45
 */
@Service("mtgUserService")
public class MtgUserServiceImpl implements MtgUserService {
    @Resource
    private MtgUserDao mtgUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MtgUser queryById(Long id) {
        return this.mtgUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MtgUser> queryAllByLimit(int offset, int limit) {
        return this.mtgUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mtgUser 实例对象
     * @return 实例对象
     */
    @Override
    public MtgUser insert(MtgUser mtgUser) {
        this.mtgUserDao.insert(mtgUser);
        return mtgUser;
    }

    /**
     * 修改数据
     *
     * @param mtgUser 实例对象
     * @return 实例对象
     */
    @Override
    public MtgUser update(MtgUser mtgUser) {
        this.mtgUserDao.update(mtgUser);
        return this.queryById(mtgUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.mtgUserDao.deleteById(id) > 0;
    }
}