package top.simba1949.common;

import lombok.Data;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/14 15:37
 */
@Data
public class UserCommon extends BaseCommon{
    /**主键*/
    private Integer id;
    /**用户名*/
    private String username;
}
