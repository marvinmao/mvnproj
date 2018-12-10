drop table if exists fdfs_file_tbl;

CREATE TABLE `fdfs_file_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(32) DEFAULT NULL,
  `file_url` varchar(128) NOT NULL,
  `file_length` int(11) DEFAULT NULL,
  `used_time` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_flag` smallint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;