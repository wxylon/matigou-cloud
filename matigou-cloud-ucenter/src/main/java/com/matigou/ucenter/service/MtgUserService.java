package com.matigou.ucenter.service;

import com.matigou.ucenter.domain.MtgUser;
import java.util.List;

/**
 * (MtgUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-04 12:54:40
 */
public interface MtgUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MtgUser queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MtgUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mtgUser 实例对象
     * @return 实例对象
     */
    MtgUser insert(MtgUser mtgUser);

    /**
     * 修改数据
     *
     * @param mtgUser 实例对象
     * @return 实例对象
     */
    MtgUser update(MtgUser mtgUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}