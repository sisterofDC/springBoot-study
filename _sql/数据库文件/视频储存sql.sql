DROP TABLE IF EXISTS `video_information`;
CREATE TABLE IF NOT EXISTS `video_information` (
`id` bigint(20) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`video_name` varchar(255) NULL DEFAULT NULL COMMENT '视频名字' ,
`video_type` varchar(255) NULL DEFAULT NULL COMMENT '视频类型' ,
`remark` varchar(500) NULL DEFAULT NULL COMMENT '备注' ,
`video_upload_date` date NULL DEFAULT NULL COMMENT '视频上传时间' ,
`video_storage_path` varchar(255) NULL DEFAULT NULL COMMENT '视频保存路径' ,
`video_size`  varchar(255) NULL DEFAULT NULL COMMENT '视频大小' ,
`video_extra_properties` varchar(255) NULL DEFAULT NULL COMMENT '视频额外属性' ,
`video_play_times` bigint(20) NULL DEFAULT NULL COMMENT '视频访问次数' ,
`video_status` varchar(255) NULL DEFAULT NULL COMMENT '视频状态',
`create_time` datetime NULL DEFAULT NULL,
`create_user` varchar(255) NULL DEFAULT NULL,
`update_time` datetime NULL DEFAULT NULL,
`update_user` varchar(255) NULL DEFAULT NULL
 ) ENGINE = InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;