package ru.gb.SpringContext.ClassWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class OrderService {

//    @Autowired
    private ProductService productService;
    private FileOutputStream outputStream;
    @Autowired
    public OrderService(ProductService productService, FileOutputStream outputStream) {
        this.productService = productService;
        this.outputStream = outputStream;
    }

    public void createOrderFromProduct(Long id){
        System.out.println("Заказ создан:");
        System.out.println(productService.getTitleById(id));
        try {
            outputStream.write("Done\n".getBytes());
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
