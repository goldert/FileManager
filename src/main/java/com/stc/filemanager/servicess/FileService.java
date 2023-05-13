package com.stc.filemanager.servicess;

import com.stc.filemanager.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public byte[] getFile(Long fileId) {
        byte[] file = fileRepository.findById(fileId).get().getBinary();
        return file;
    }
}
