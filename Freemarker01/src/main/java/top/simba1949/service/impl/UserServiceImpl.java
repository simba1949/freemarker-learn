package top.simba1949.service.impl;

import org.springframework.stereotype.Service;
import top.simba1949.common.UserCommon;
import top.simba1949.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/14 16:27
 */
@Service
public class UserServiceImpl implements UserService {

    private Map<Integer, UserCommon> map;

    @PostConstruct
    public void init(){
        map = new HashMap<>();
        for (int i = 0; i < 20; i++){
            UserCommon userCommon = new UserCommon();
            userCommon.setId( i);
            userCommon.setUsername("李白" + i);
            map.put(i,userCommon);
        }
    }

    @Override
    public List<UserCommon> getUsersNoCondition() {
        List<UserCommon> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            list.add(map.get(integer));
        }

        return list;
    }

    @Override
    public UserCommon getUesr(UserCommon userCommon){
        return map.get(userCommon.getId());
    }

    @Override
    public List<UserCommon> getUsers(List<Integer> id){
        List<UserCommon> list = new ArrayList<>();
        for (Integer integer : id) {
            list.add(map.get(integer));
        }

        return list;
    }

    @Override
    public void delete(UserCommon userCommon){
        map.remove(userCommon.getId());
    }

    @Override
    public void update(UserCommon userCommon){
        map.put(userCommon.getId(),userCommon);
    }

    @Override
    public void insert(UserCommon userCommon){
        map.put(map.size() + 1, userCommon);
    }
}
