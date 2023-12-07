/*
Copyright [2020] [https://www.xiaonuo.vip]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改Snowy源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/xiaonuobase/snowy-layui
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/xiaonuobase/snowy-layui
6.若您的项目无法满足以上几点，可申请商业授权，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package vip.xiaonuo.modular.videoinformation.param;

import vip.xiaonuo.core.pojo.base.param.BaseParam;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import java.util.*;

/**
* 视频信息参数类
 *
 * @author sisterofdc
 * @date 2023-12-07 15:09:55
*/
@Data
public class VideoInformationParam extends BaseParam {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空，请检查id参数", groups = {edit.class, delete.class, detail.class})
    private Long id;

    /**
     * 视频名字
     */
    @NotBlank(message = "视频名字不能为空，请检查videoName参数", groups = {add.class, edit.class})
    private String videoName;

    /**
     * 视频类型
     */
    @NotBlank(message = "视频类型不能为空，请检查videoType参数", groups = {add.class, edit.class})
    private String videoType;

    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空，请检查remark参数", groups = {add.class, edit.class})
    private String remark;

    /**
     * 视频上传时间
     */
    @NotNull(message = "视频上传时间不能为空，请检查videoUploadDate参数", groups = {add.class, edit.class})
    private String videoUploadDate;

    /**
     * 视频保存路径
     */
    @NotBlank(message = "视频保存路径不能为空，请检查videoStoragePath参数", groups = {add.class, edit.class})
    private String videoStoragePath;

    /**
     * 视频大小
     */
    @NotBlank(message = "视频大小不能为空，请检查videoSize参数", groups = {add.class, edit.class})
    private String videoSize;

    /**
     * 视频额外属性
     */
    @NotBlank(message = "视频额外属性不能为空，请检查videoExtraProperties参数", groups = {add.class, edit.class})
    private String videoExtraProperties;

    /**
     * 视频访问次数
     */
    @NotNull(message = "视频访问次数不能为空，请检查videoPlayTimes参数", groups = {add.class, edit.class})
    private Long videoPlayTimes;

    /**
     * 视频状态
     */
    @NotBlank(message = "视频状态不能为空，请检查videoStatus参数", groups = {add.class, edit.class})
    private String videoStatus;

}
