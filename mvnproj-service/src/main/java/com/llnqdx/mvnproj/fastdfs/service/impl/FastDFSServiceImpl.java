package com.llnqdx.mvnproj.fastdfs.service.impl;

import com.llnqdx.mvnproj.enums.DeleteFlagEnum;
import com.llnqdx.mvnproj.fastdfs.client.FastDFSClient;
import com.llnqdx.mvnproj.constant.Constant;
import com.llnqdx.mvnproj.fastdfs.model.FdfsFileInfo;
import com.llnqdx.mvnproj.fastdfs.service.FastDFSService;
import com.llnqdx.mvnproj.mapper.FdfsFileTblMapper;
import com.llnqdx.mvnproj.model.FdfsFileTbl;
import com.llnqdx.mvnproj.model.FdfsFileTblCriteria;
import com.llnqdx.mvnproj.utils.RandomUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Auther: marvinmao
 * @Date: 2018/12/8
 */
@Service(value = "FastDFSService")
public class FastDFSServiceImpl implements FastDFSService {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${fastdfs_file_path_prifix}")
    private String filePrifix;

    @Autowired
    private FdfsFileTblMapper fdfsFileTblMapper;

    @Override
    public FdfsFileInfo saveFile(MultipartFile file) {
        try {
            FdfsFileInfo fdfsFileInfo = FastDFSClient.saveFile(file);
            //need judge file upload success or faild
            FdfsFileTbl fdfsFileTbl = new FdfsFileTbl();
            BeanUtils.copyProperties(fdfsFileInfo, fdfsFileTbl);
            fdfsFileTbl.setUuid(RandomUtils.createUUID());
            fdfsFileTbl.setCreateTime(new Date());
            fdfsFileTbl.setUpdateTime(new Date());
            fdfsFileTbl.setDeleteFlag(DeleteFlagEnum.FALSE.getKey().shortValue());
            fdfsFileTblMapper.insert(fdfsFileTbl);
            StringBuilder sb = new StringBuilder(fdfsFileInfo.getFileUrl());
            fdfsFileInfo.setFileUrl(sb.insert(0, filePrifix).toString());
            return fdfsFileInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteFile(String filePath) {
        filePath = filePath.replace(filePrifix, "");
        String[] split = filePath.split("/");
        List<String> list = Arrays.asList(split);
        if (CollectionUtils.isEmpty(list)) {
            logger.error("singleFileDelete error filePath is validate");
            return null;
        }
        String groupName = list.get(0);
        String remoteFileName = filePath.replace(groupName + "/", "");
        try {
            String deleteMsg = "";
            int deleteFile = FastDFSClient.deleteFile(groupName, remoteFileName);
            if (deleteFile == 0) {
                logger.info("----------- file delete success, start update db -----------");
                FdfsFileTblCriteria criteria = new FdfsFileTblCriteria();
                FdfsFileTblCriteria.Criteria updateCriteria = criteria.createCriteria();
                updateCriteria.andFileUrlEqualTo(filePath);
                FdfsFileTbl fdfsFileTbl = new FdfsFileTbl();
                fdfsFileTbl.setDeleteFlag(DeleteFlagEnum.TRUE.getKey().shortValue());
                int updateByExampleSelective = fdfsFileTblMapper.updateByExampleSelective(fdfsFileTbl, criteria);
                logger.info("updateByExampleSelective [{}]", updateByExampleSelective);
            }
            switch (deleteFile) {
                case Constant.DELETE_FAILD:
                    deleteMsg = Constant.DELETE_FAILD_MSG;
                    break;
                case Constant.DELETE_SUCCESS:
                    deleteMsg = Constant.DELETE_SUCCESS_MSG;
                    break;
                case Constant.DELETE_NOT_EXIST:
                    deleteMsg = Constant.DELETE_NOT_EXIST_MSG;
                    break;
                default:
                    break;
            }
            logger.info("singleFileDelete end deleteMsg [{}]", deleteMsg);
            return deleteMsg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String downloadFile(String uuid) {
        FdfsFileTblCriteria criteria = new FdfsFileTblCriteria();
        FdfsFileTblCriteria.Criteria queryCriteria = criteria.createCriteria();
        queryCriteria.andUuidEqualTo(uuid);
        List<FdfsFileTbl> list = fdfsFileTblMapper.selectByExample(criteria);
        if (!CollectionUtils.isEmpty(list)) {
            StringBuilder sb = new StringBuilder(list.get(0).getFileUrl());
            return sb.insert(0, filePrifix).append("?attname=" + list.get(0).getFileName()).toString();
        }
        return null;
    }
}
