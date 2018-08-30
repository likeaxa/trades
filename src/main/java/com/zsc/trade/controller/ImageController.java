package com.zsc.trade.controller;

import com.zsc.trade.bean.Image;
import com.zsc.trade.common.FileUtil;
import com.zsc.trade.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping("/image")
    public List<Image> getImage(@RequestParam(value = "pid", defaultValue = "-1") int pid) {

        if (pid == -1) {
            return null;
        }
        return imageService.getImageByPid(pid);

    }

    @DeleteMapping("/image")
    public String deleteImage(@RequestParam(value = "ImageId", defaultValue = "-1") int ImageId) {
        if (ImageId == -1) {
            return "删除失败";
        }
        Image img = imageService.getImage(ImageId);

        String deletePath = img.getLink();
        if (deletePath == null) {
            return "文件路径不存在";
        }
        /**
         * 1 删除数据库里面的字段
         * 2 删除这个路径下的文件
         */
        imageService.delete(ImageId);
        //return "ok";
        //
        //上传服务器时释放
        File file = new File(deletePath);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return "ok";
            } else {
                return "删除失败";
            }
        }
        return "删除失败";
    }


    /**
     * 多文件上传的实现
     *
     * @param request 通过这个参数拿客户端过来的file件
     * @param pid     图片所对应的产品的id
     * @return 对应的返回类型
     */
    @PostMapping("/image")
    @ResponseBody
    public String uploadImg(HttpServletRequest request, @RequestParam(value = "pid", required = false) String pid) {

        /**
         * 从request中拿出来所以的file并强制转换成MultiparFile类型
         */
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

        /**
         * 文件不为空 进行遍历操作
         */
        if (!files.isEmpty()) {
            for (MultipartFile file : files) {
                pid = "1";
                /**
                 * 不知道为什么file.getOriginalFilename()这个方法返回的是客户端的全路径名
                 * 但是我们需要的只有文件名，所以这里进行了一个new一个文件，然后获取文件名字
                 * 来获取文件名
                 * 真正的文件名是由用户id和当前系统的时间和对应的文件名组成，避免文件重复
                 */
                String fileName = file.getOriginalFilename();
                File file1 = new File(fileName);
                fileName = file1.getName();
                fileName = pid + "_" + System.currentTimeMillis() + fileName;

                /**
                 * 第一个路径是服务器的路径 部署的时候需要
                 * 第二个路径是本地项目的地址
                 */
                //String filePath = "/home/jerrysheh/www/picture/";
                String filePath = request.getSession().getServletContext().getRealPath("/image/");
                try {
                    /**
                     * 创建文件需要的3个参数，文件内容，文件路径，文件名
                     */
                    FileUtil.uploadFile(file.getBytes(), filePath, fileName);
                    /**
                     *
                     以下路径是存入数据库的 因为后台不需要这个功能 这里不进行实现
                     */
                    String datasourPath = filePath + fileName;

                } catch (Exception e) {
                    //
                    return "部分文件上传失败";
                }
            }

        } else {
            return "上传文件为空";
        }
        //返回json
        return "上传成功";
    }

}
