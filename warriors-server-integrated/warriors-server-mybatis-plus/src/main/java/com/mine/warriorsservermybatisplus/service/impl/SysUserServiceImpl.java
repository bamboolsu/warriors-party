package com.mine.warriorsservermybatisplus.service.impl;

import com.mine.warriorsservercommon.pojo.ResultVO;
import com.mine.warriorsservercommon.utils.BeanCopyUtil;
import com.mine.warriorsservercommon.utils.ResultVOUtil;
import com.mine.warriorsservermybatisplus.entity.SysUser;
import com.mine.warriorsservermybatisplus.mapper.SysUserMapper;
import com.mine.warriorsservermybatisplus.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.mine.warriorsservermybatisplus.dto.SysUserDTO;

/**
 * @description: 【用户】实现层
 * @author: Generated by Mine.Lee
 * @create: 2019-01-15
 * @version: v1.0
 */
@Slf4j
@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public ResultVO<?> searchSysUserList(SysUserDTO dto){
        SysUser entity=new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
        EntityWrapper<SysUser> entityWrapper=new EntityWrapper<>();
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(sysUserMapper.selectList(entityWrapper));
    }

    @Override
    public ResultVO<?> searchSysUserListPage(SysUserDTO dto){
        Page<SysUser> page=new Page<SysUser>();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getCurrent());
        SysUser entity=new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
        EntityWrapper<SysUser> entityWrapper=new EntityWrapper<>();
        entityWrapper.setEntity(entity);
        return ResultVOUtil.returnSuccess(page.setRecords(sysUserMapper.selectPage(page,entityWrapper)));
    }

    @Override
    public ResultVO<?> searchSysUserOne(SysUserDTO dto){
        SysUser entity=new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
   	    return ResultVOUtil.returnSuccess(sysUserMapper.selectOne(entity));
    }

    @Override
    public ResultVO<?> addSysUser(SysUserDTO dto){
        SysUser entity=new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
        // entity.setXXX();  根据业务来做
        sysUserMapper.insert(entity);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> updateSysUser(SysUserDTO dto){
        SysUser entity = new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
        SysUser result = sysUserMapper.selectOne(entity);
        sysUserMapper.updateById(result);
        return ResultVOUtil.returnSuccess();
    }

    @Override
    public ResultVO<?> deleteSysUser(SysUserDTO dto){
        SysUser entity=new SysUser();
        BeanCopyUtil.copyPropertiesIgnoreNull(dto,entity);
        EntityWrapper<SysUser> entityWrapper=new EntityWrapper<>();
        entityWrapper.setEntity(entity);
        sysUserMapper.delete(entityWrapper);
        return ResultVOUtil.returnSuccess();
    }

}
