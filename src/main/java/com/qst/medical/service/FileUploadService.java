package com.qst.medical.service;

import com.qst.medical.util.Msg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Service
public class FileUploadService {
    @Value("${myApplication.listingFolder}")
    String path;
    public Msg upload(MultipartFile file) throws IOException {
        OutputStream os = null;
        InputStream inputStream = null;
        String fileName = null;
        int len;
        try {
            inputStream = file.getInputStream();
            fileName = UUID.randomUUID()+file.getOriginalFilename();
            byte[] bs = new byte[1024];
            File tmpFile=new File(path);
            if (!tmpFile.exists()) {
                tmpFile.mkdirs();
            }
            os =new FileOutputStream(tmpFile.getPath()+File.separator+fileName);
            while((len=inputStream.read(bs))!=-1){
                os.write(bs,0,len);
            }

        } catch (IOException e) {
            return Msg.fail().mess("上传失败");
        }
        finally {
            os.close();
            inputStream.close();

        }
        String url = "http://localhost:10001/image/"+fileName;
        return Msg.success().mess("上传成功").data("url",url);

    }

}