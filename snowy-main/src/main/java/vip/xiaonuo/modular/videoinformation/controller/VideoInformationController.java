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
package vip.xiaonuo.modular.videoinformation.controller;

import vip.xiaonuo.core.annotion.BusinessLog;
import vip.xiaonuo.core.annotion.Permission;
import vip.xiaonuo.core.enums.LogAnnotionOpTypeEnum;
import vip.xiaonuo.core.pojo.page.PageResult;
import vip.xiaonuo.core.pojo.response.ResponseData;
import vip.xiaonuo.core.pojo.response.SuccessResponseData;
import vip.xiaonuo.modular.videoinformation.entity.VideoInformation;
import vip.xiaonuo.modular.videoinformation.param.VideoInformationParam;
import vip.xiaonuo.modular.videoinformation.service.VideoInformationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

/**
 * 视频信息控制器
 *
 * @author sisterofdc
 * @date 2023-12-07 15:09:55
 */
@Controller
public class VideoInformationController {

    private String PATH_PREFIX = "videoInformation/";

    @Resource
    private VideoInformationService videoInformationService;

    /**
     * 视频信息页面
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    @Permission
    @GetMapping("/videoInformation/index")
    public String index() {
        return PATH_PREFIX + "index.html";
    }

    /**
     * 视频信息表单页面
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    @GetMapping("/videoInformation/form")
    public String form() {
        return PATH_PREFIX + "form.html";
    }

    /**
     * 查询视频信息
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    @Permission
    @ResponseBody
    @GetMapping("/videoInformation/page")
    @BusinessLog(title = "视频信息_查询", opType = LogAnnotionOpTypeEnum.QUERY)
    public PageResult<VideoInformation> page(VideoInformationParam videoInformationParam) {
        return videoInformationService.page(videoInformationParam);
    }

    /**
     * 添加视频信息
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    @Permission
    @ResponseBody
    @PostMapping("/videoInformation/add")
    @BusinessLog(title = "视频信息_增加", opType = LogAnnotionOpTypeEnum.ADD)
    public ResponseData add(@RequestBody @Validated(VideoInformationParam.add.class) VideoInformationParam videoInformationParam) {
        videoInformationService.add(videoInformationParam);
        return new SuccessResponseData();
    }

    /**
     * 删除视频信息
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    @Permission
    @ResponseBody
    @PostMapping("/videoInformation/delete")
    @BusinessLog(title = "视频信息_删除", opType = LogAnnotionOpTypeEnum.DELETE)
    public ResponseData delete(@RequestBody @Validated(VideoInformationParam.delete.class) List<VideoInformationParam> videoInformationParamList) {
        videoInformationService.delete(videoInformationParamList);
        return new SuccessResponseData();
    }

    /**
     * 编辑视频信息
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    @Permission
    @ResponseBody
    @PostMapping("/videoInformation/edit")
    @BusinessLog(title = "视频信息_编辑", opType = LogAnnotionOpTypeEnum.EDIT)
    public ResponseData edit(@RequestBody @Validated(VideoInformationParam.edit.class) VideoInformationParam videoInformationParam) {
        videoInformationService.edit(videoInformationParam);
        return new SuccessResponseData();
    }

    /**
     * 查看视频信息
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    @Permission
    @ResponseBody
    @GetMapping("/videoInformation/detail")
    @BusinessLog(title = "视频信息_查看", opType = LogAnnotionOpTypeEnum.DETAIL)
    public ResponseData detail(@Validated(VideoInformationParam.detail.class) VideoInformationParam videoInformationParam) {
        return new SuccessResponseData(videoInformationService.detail(videoInformationParam));
    }

    /**
     * 视频信息列表
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    @Permission
    @ResponseBody
    @GetMapping("/videoInformation/list")
    @BusinessLog(title = "视频信息_列表", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData list(VideoInformationParam videoInformationParam) {
        return new SuccessResponseData(videoInformationService.list(videoInformationParam));
    }

}
