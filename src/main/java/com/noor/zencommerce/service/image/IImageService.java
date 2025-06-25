package com.noor.zencommerce.service.image;

import org.springframework.web.multipart.MultipartFile;

import com.noor.zencommerce.dto.ImageDto;
import com.noor.zencommerce.model.Image;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(Long productId, List<MultipartFile> files);
    void updateImage(MultipartFile file,  Long imageId);
}
