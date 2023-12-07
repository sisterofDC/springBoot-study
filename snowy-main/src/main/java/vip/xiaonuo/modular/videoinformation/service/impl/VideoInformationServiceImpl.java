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
package vip.xiaonuo.modular.videoinformation.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import vip.xiaonuo.core.consts.CommonConstant;
import vip.xiaonuo.core.enums.CommonStatusEnum;
import vip.xiaonuo.core.exception.ServiceException;
import vip.xiaonuo.core.factory.PageFactory;
import vip.xiaonuo.core.pojo.page.PageResult;
import vip.xiaonuo.modular.videoinformation.entity.VideoInformation;
import vip.xiaonuo.modular.videoinformation.enums.VideoInformationExceptionEnum;
import vip.xiaonuo.modular.videoinformation.mapper.VideoInformationMapper;
import vip.xiaonuo.modular.videoinformation.param.VideoInformationParam;
import vip.xiaonuo.modular.videoinformation.service.VideoInformationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * 视频信息service接口实现类
 *
 * @author sisterofdc
 * @date 2023-12-07 15:09:55
 */
@Service
public class VideoInformationServiceImpl extends ServiceImpl<VideoInformationMapper, VideoInformation> implements VideoInformationService {

    @Override
    public PageResult<VideoInformation> page(VideoInformationParam videoInformationParam) {
        QueryWrapper<VideoInformation> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotNull(videoInformationParam)) {

            // 根据视频名字 查询
            if (ObjectUtil.isNotEmpty(videoInformationParam.getVideoName())) {
                queryWrapper.lambda().eq(VideoInformation::getVideoName, videoInformationParam.getVideoName());
            }
            // 根据视频类型 查询
            if (ObjectUtil.isNotEmpty(videoInformationParam.getVideoType())) {
                queryWrapper.lambda().eq(VideoInformation::getVideoType, videoInformationParam.getVideoType());
            }
            // 根据备注 查询
            if (ObjectUtil.isNotEmpty(videoInformationParam.getRemark())) {
                queryWrapper.lambda().eq(VideoInformation::getRemark, videoInformationParam.getRemark());
            }
            // 根据视频上传时间 查询
            if (ObjectUtil.isNotEmpty(videoInformationParam.getVideoUploadDate())) {
                queryWrapper.lambda().eq(VideoInformation::getVideoUploadDate, videoInformationParam.getVideoUploadDate());
            }
            // 根据视频保存路径 查询
            if (ObjectUtil.isNotEmpty(videoInformationParam.getVideoStoragePath())) {
                queryWrapper.lambda().eq(VideoInformation::getVideoStoragePath, videoInformationParam.getVideoStoragePath());
            }
            // 根据视频大小 查询
            if (ObjectUtil.isNotEmpty(videoInformationParam.getVideoSize())) {
                queryWrapper.lambda().eq(VideoInformation::getVideoSize, videoInformationParam.getVideoSize());
            }
            // 根据视频额外属性 查询
            if (ObjectUtil.isNotEmpty(videoInformationParam.getVideoExtraProperties())) {
                queryWrapper.lambda().eq(VideoInformation::getVideoExtraProperties, videoInformationParam.getVideoExtraProperties());
            }
            // 根据视频访问次数 查询
            if (ObjectUtil.isNotEmpty(videoInformationParam.getVideoPlayTimes())) {
                queryWrapper.lambda().eq(VideoInformation::getVideoPlayTimes, videoInformationParam.getVideoPlayTimes());
            }
            // 根据视频状态 查询
            if (ObjectUtil.isNotEmpty(videoInformationParam.getVideoStatus())) {
                queryWrapper.lambda().eq(VideoInformation::getVideoStatus, videoInformationParam.getVideoStatus());
            }
        }
        return new PageResult<>(this.page(PageFactory.defaultPage(), queryWrapper));
    }

    @Override
    public List<VideoInformation> list(VideoInformationParam videoInformationParam) {
        return this.list();
    }

    @Override
    public void add(VideoInformationParam videoInformationParam) {
        VideoInformation videoInformation = new VideoInformation();
        BeanUtil.copyProperties(videoInformationParam, videoInformation);
        this.save(videoInformation);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<VideoInformationParam> videoInformationParamList) {
        videoInformationParamList.forEach(videoInformationParam -> {
        VideoInformation videoInformation = this.queryVideoInformation(videoInformationParam);
            this.removeById(videoInformation.getId());
        });
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(VideoInformationParam videoInformationParam) {
        VideoInformation videoInformation = this.queryVideoInformation(videoInformationParam);
        BeanUtil.copyProperties(videoInformationParam, videoInformation);
        this.updateById(videoInformation);
    }

    @Override
    public VideoInformation detail(VideoInformationParam videoInformationParam) {
        return this.queryVideoInformation(videoInformationParam);
    }

    /**
     * 获取视频信息
     *
     * @author sisterofdc
     * @date 2023-12-07 15:09:55
     */
    private VideoInformation queryVideoInformation(VideoInformationParam videoInformationParam) {
        VideoInformation videoInformation = this.getById(videoInformationParam.getId());
        if (ObjectUtil.isNull(videoInformation)) {
            throw new ServiceException(VideoInformationExceptionEnum.NOT_EXIST);
        }
        return videoInformation;
    }
}
