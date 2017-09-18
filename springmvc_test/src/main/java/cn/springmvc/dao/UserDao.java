package cn.springmvc.dao;

import cn.springmvc.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
@Repository
@Transactional
public interface UserDao {

    public User getUser(User user);

    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);
}
