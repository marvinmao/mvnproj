drop table if exists fdfs_file_tbl;

CREATE TABLE `fdfs_file_tbl` (
  `uuid` varchar(32) NOT NULL,
  `file_name` varchar(32) DEFAULT NULL,
  `file_url` varchar(128) NOT NULL,
  `file_md5` varchar(32) DEFAULT NULL,
  `file_length` int(11) DEFAULT NULL,
  `file_size` int(11) DEFAULT NULL COMMENT 'byte',
  `used_time` int(11) DEFAULT NULL COMMENT 'ms',
  `avg_upload_spleed` double(20,2) DEFAULT NULL COMMENT 'kb/s',
  `img_width` int(11) DEFAULT NULL COMMENT 'px',
  `img_height` int(11) DEFAULT NULL COMMENT 'px',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_flag` smallint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;