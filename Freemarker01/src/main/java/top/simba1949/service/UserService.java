package top.simba1949.service;

import top.simba1949.common.UserCommon;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/14 16:27
 */
public interface UserService {

    List<UserCommon> getUsersNoCondition();

    UserCommon getUesr(UserCommon userCommon);

    List<UserCommon> getUsers(List<Integer> id);

    void delete(UserCommon userCommon);

    void update(UserCommon userCommon);

    void insert(UserCommon userCommon);
}
