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
package vip.xiaonuo.modular.videoinformation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import vip.xiaonuo.core.pojo.page.PageResult;
import vip.xiaonuo.modular.videoinformation.entity.VideoInformation;
import vip.xiaonuo.modular.videoinformation.param.VideoInformationParam;
import java.util.List;

/**
 * 视频信息service接口
 *
 * @author sisterofdc
 * @date 2023-12-07 15:09:55
 */
public interface VideoInformationService extends IService<VideoInformation> {

    /**
     * 查询视频信息
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    PageResult<VideoInformation> page(VideoInformationParam videoInformationParam);

    /**
     * 视频信息列表
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    List<VideoInformation> list(VideoInformationParam videoInformationParam);

    /**
     * 添加视频信息
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    void add(VideoInformationParam videoInformationParam);

    /**
     * 删除视频信息
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    void delete(List<VideoInformationParam> videoInformationParamList);

    /**
     * 编辑视频信息
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    void edit(VideoInformationParam videoInformationParam);

    /**
     * 查看视频信息
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
     VideoInformation detail(VideoInformationParam videoInformationParam);
}
