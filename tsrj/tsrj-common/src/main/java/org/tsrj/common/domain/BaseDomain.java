package org.tsrj.common.domain;

import java.util.Date;

/**
 *
 * Author: hqm
 * Date: 15-6-26 下午1:44
 *
 * @Description:
 */
public abstract class BaseDomain<T>  {
    /**
     * 数据库主键id获取
     *
     * @return
     */
    public abstract T getId();

    /**
     * 设置数据库主键id
     *
     * @param id
     */
    public abstract void setId(T id);

    /**
     * 设置创建时间
     *
     * @param createTime
     */
    public abstract void setCreateTime(Date createTime);

    /**
     * 设置修改时间
     *
     * @param updateTime
     */
    public abstract void setUpdateTime(Date updateTime);
}

