package top.simba1949.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/14 16:21
 */
@Data
public class BaseCommon implements Serializable {
    /**
     * 创建者
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 修改时间
     */
    private Date modifierTime;

}
